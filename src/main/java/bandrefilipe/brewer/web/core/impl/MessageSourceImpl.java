package bandrefilipe.brewer.web.core.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;

@Slf4j
@Component
class MessageSourceImpl implements bandrefilipe.brewer.web.core.MessageSource {

    private static final String LOG_ENTRY = "M=getMessage: messageKey={} args={} defaultMessage={} locale={}";
    private static final String LOG_RETURN = "M=getMessage: return={}";

    private final MessageSource messageSource;
    private Locale locale;

    @Autowired
    MessageSourceImpl(final MessageSource messageSource) {
        this.messageSource = messageSource;
        this.locale = Locale.getDefault();
    }

    @Override
    public void setLocale(final Locale locale) {
        this.locale = ofNullable(locale)
                .orElseGet(Locale::getDefault);
    }

    @Override
    public String getMessage(final String messageKey) {
        return this.getMessage(messageKey, null, null, this.locale);
    }

    @Override
    public String getMessage(final String messageKey,
                             final Object[] args) {
        return this.getMessage(messageKey, args, null, this.locale);
    }

    @Override
    public String getMessage(final String messageKey,
                             final Object[] args,
                             final Locale locale) {
        return this.getMessage(messageKey, args, null, locale);
    }

    @Override
    public String getMessage(final String messageKey,
                             final String defaultMessage) {
        return this.getMessage(messageKey, null, defaultMessage, this.locale);
    }

    @Override
    public String getMessage(final String messageKey,
                             final String defaultMessage,
                             final Locale locale) {
        return this.getMessage(messageKey, null, defaultMessage, locale);
    }

    @Override
    public String getMessage(final String messageKey,
                             final Object[] args,
                             final String defaultMessage,
                             final Locale locale) {
        log.debug(LOG_ENTRY, messageKey, args, defaultMessage, locale);

        var message = defaultMessage;
        if (isNull(messageKey)) {
            log.debug(LOG_RETURN, message);
            return message;
        }

        if (isNull(locale)) {
            message = messageSource.getMessage(messageKey, args, defaultMessage, this.locale);
            log.debug(LOG_RETURN, message);
            return message;
        }

        message = messageSource.getMessage(messageKey, args, defaultMessage, locale);
        log.debug(LOG_RETURN, message);
        return message;
    }
}
