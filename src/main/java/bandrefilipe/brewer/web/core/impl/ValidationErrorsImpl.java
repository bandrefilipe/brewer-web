package bandrefilipe.brewer.web.core.impl;

import bandrefilipe.brewer.web.core.ValidationErrors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Component
class ValidationErrorsImpl implements ValidationErrors {

    @Override
    public Set<String> getMessages(final Errors validation) {
        return validation.getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(toSet());
    }
}
