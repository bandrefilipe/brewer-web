package bandrefilipe.brewer.web.config;

import bandrefilipe.brewer.web.core.model.BeverageFlavor;
import bandrefilipe.brewer.web.core.model.Origin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
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

    /**
     * As the view carries codes for {@link BeverageFlavor} and {@link Origin} such as {@code "S"}
     * and {@code "N"}, and the model needs to carry its actual enums, a conversion is required.<p>
     * Implementors of the {@link Converter} interface are required by the {@link FormatterRegistry}
     * so Spring Web MVC can do the conversion <em>behind the scenes</em><p>
     * Here, we take advantage of the functional aspect of the Converter interface and pass a
     * method reference to the static methods within each enum, which do the conversion instead.
     */
    @Override
    public void addFormatters(final FormatterRegistry registry) {
        log.debug("Adding formatters and converters");
        registry.addConverter(BeverageFlavor::from);
        registry.addConverter(Origin::from);
    }
}
