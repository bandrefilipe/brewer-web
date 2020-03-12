package bandrefilipe.brewer.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;

/**
 * Configures the resource bundle: 'messages.properties'.
 */
@Slf4j
@Configuration
class MessageSourceConfig {

    /**
     * An application context delegates the message resolution to a bean with the exact name
     * {@code messageSource}.
     * <p>
     * {@link ReloadableResourceBundleMessageSource} is the most common {@link MessageSource}
     * implementation that resolves messages from resource bundles for different locales.
     * <p>
     * Here, it's important to provide the basename as locale-specific file names will be resolved
     * based on the name provided.
     *
     * @see <a href="https://www.baeldung.com/spring-custom-validation-message-source">
     *     https://www.baeldung.com</a>
     */
    @Bean
    MessageSource messageSource() {
        log.debug("Creating bean MessageSource");
        final var messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        return messageSource;
    }
}
