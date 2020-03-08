package bandrefilipe.brewer.web.core;

import java.util.Locale;

/**
 * Provides a more granular API than {@link org.springframework.context.MessageSource}.
 */
public interface MessageSource {

    void setLocale(Locale locale);
    String getMessage(String messageKey);
    String getMessage(String messageKey, Object[] args);
    String getMessage(String messageKey, Object[] args, Locale locale);
    String getMessage(String messageKey, String defaultMessage);
    String getMessage(String messageKey, String defaultMessage, Locale locale);
    String getMessage(String messageKey, Object[] args, String defaultMessage, Locale locale);
}
