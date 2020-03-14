package bandrefilipe.brewer.web.core;

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
<<<<<<< HEAD
    private static final String LOG_RETURN = "M=getMessage: return={}";
=======
    private static final String LOG_RESULT = "M=getMessage: result={}";
>>>>>>> master

    private final MessageSource messageSource;
    private Locale locale;

    @Autowired
    MessageSourceImpl(final MessageSource messageSource) {
        super();
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

<<<<<<< HEAD
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
=======
        var result = defaultMessage;
        if (isNull(messageKey)) {
            log.debug(LOG_RESULT, result);
            return result;
        }

        if (isNull(locale)) {
            result = messageSource.getMessage(messageKey, args, defaultMessage, this.locale);
            log.debug(LOG_RESULT, result);
            return result;
        }

        result = messageSource.getMessage(messageKey, args, defaultMessage, locale);
        log.debug(LOG_RESULT, result);
        return result;
>>>>>>> master
    }
}
