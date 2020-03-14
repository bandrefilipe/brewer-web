package bandrefilipe.brewer.web.controller;

import bandrefilipe.brewer.web.core.MessageSource;
import bandrefilipe.brewer.web.core.ValidationErrors;
import bandrefilipe.brewer.web.model.Beverage;
import bandrefilipe.brewer.web.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping(
        path = API.CLIENTS,
        produces = MediaType.TEXT_HTML_VALUE)
class ClientController {

    private final MessageSource messageSource;
    private final ValidationErrors validationErrors;

    @Autowired
    ClientController(final MessageSource messageSource,
                     final ValidationErrors validationErrors) {
        super();
        log.debug("Creating bean {}", ClientController.class.getSimpleName());
        this.messageSource = messageSource;
        this.validationErrors = validationErrors;
    }

    @GetMapping(path = "/new")
    public String newClientRegistration(final Client beverage) {
        log.trace("M=newClientRegistration");
        return View.CLIENT_REGISTRATION;
    }

    @PostMapping(path = "/new")
    public String newClientRegistration(@Valid final Client client,
                                        final Errors validation,
                                        final RedirectAttributes redirectAttributes) {
        if (validation.hasErrors()) {
            log.debug("M=newClientRegistration: client={}, messages={}",
                    client, validationErrors.getMessages(validation));
            return newClientRegistration(client);
        }
        log.debug("M=newClientRegistration: client={}", client);
        redirectAttributes.addFlashAttribute("message", messageSource.getMessage("new.client.registration.success"));
        return Redirect.CLIENTS_NEW;
    }
}
