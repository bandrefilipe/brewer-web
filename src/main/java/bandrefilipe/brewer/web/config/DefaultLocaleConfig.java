package bandrefilipe.brewer.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static bandrefilipe.brewer.web.GlobalConstants.LOCALE_EN_US;
import static bandrefilipe.brewer.web.GlobalConstants.LOCALE_ES;
import static bandrefilipe.brewer.web.GlobalConstants.LOCALE_PT_BR;

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
        validLocales.put("en_US", LOCALE_EN_US);
        validLocales.put("es", LOCALE_ES);
        validLocales.put("pt_BR", LOCALE_PT_BR);
    }

    @Bean
    Locale defaultLocale() {
        log.debug("Configuring default locale");
        Locale.setDefault(validLocales.getOrDefault(defaultLocale, LOCALE_EN_US));
        final var locale = Locale.getDefault();
        log.debug("Default locale set to {}", locale);
        return locale;
    }
}
