package bandrefilipe.brewer.web.core;

import org.springframework.validation.Errors;

import java.util.Set;

/**
 * Provides helper methods to handle validation messages.
 */
public interface ValidationErrors {

    Set<String> getMessages(Errors errors);
}
