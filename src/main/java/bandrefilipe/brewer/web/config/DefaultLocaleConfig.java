package bandrefilipe.brewer.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Configures the default locale, as returned by {@link Locale#getDefault()}.
 */
@Slf4j
@Configuration
class DefaultLocaleConfig {

    @Value("${locale.default}")
    private String defaultLocale;

    private final Map<String, Locale> validLocales;

    DefaultLocaleConfig() {
        validLocales = new HashMap<>();
        validLocales.put("en_US", Locale.US);
        validLocales.put("es", new Locale("es"));
        validLocales.put("pt_BR", new Locale("pt", "BR"));
    }

    @Bean
    Locale defaultLocale() {
        log.debug("Configuring default locale");
        Locale.setDefault(validLocales.getOrDefault(defaultLocale, Locale.US));
        final var locale = Locale.getDefault();
        log.debug("Default locale set to {}", locale);
        return locale;
    }
}
