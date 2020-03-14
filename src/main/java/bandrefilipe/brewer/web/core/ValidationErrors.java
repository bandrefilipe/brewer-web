package bandrefilipe.brewer.web.core;

import org.springframework.validation.Errors;

import java.util.Set;

public interface ValidationErrors {

    Set<String> getMessages(Errors errors);
}
