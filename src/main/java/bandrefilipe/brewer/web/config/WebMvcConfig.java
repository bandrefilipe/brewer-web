package bandrefilipe.brewer.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configures customizations to the Spring Web MVC framework.
 */
@Slf4j
@EnableWebMvc
@Configuration
class WebMvcConfig implements WebMvcConfigurer {

    private final MessageSource messageSource;

    @Autowired
    WebMvcConfig(final MessageSource messageSource) {
        super();
        this.messageSource = messageSource;
    }

    /**
     * To use custom name {@code messages} in a properties file we need to define a
     * {@link LocalValidatorFactoryBean} and register the {@link MessageSource}.
     * <p>
     * However, note that because we had already extended the {@link WebMvcConfigurer}, to avoid
     * having the custom validator ignored, we'd have to set the validator by overriding the
     * {@link WebMvcConfigurer#getValidator()} method in this class.
     *
     * @see <a href="https://www.baeldung.com/spring-custom-validation-message-source">
     *     https://www.baeldung.com</a>
     */
    @Override
    public Validator getValidator() {
        log.debug("Creating LocalValidationFactoryBean");
        final var localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource);
        return localValidatorFactoryBean;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        log.debug("Adding resource handler for static content");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
