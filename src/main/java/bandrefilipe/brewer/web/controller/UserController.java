package bandrefilipe.brewer.web.controller;

import bandrefilipe.brewer.web.core.MessageSource;
import bandrefilipe.brewer.web.core.ValidationErrors;
import bandrefilipe.brewer.web.model.User;
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
        path = API.USERS,
        produces = MediaType.TEXT_HTML_VALUE
)
class UserController {

    private final MessageSource messageSource;
    private final ValidationErrors validationErrors;

    @Autowired
    UserController(final MessageSource messageSource,
                   final ValidationErrors validationErrors) {
        super();
        log.debug("Creating bean {}", UserController.class.getSimpleName());
        this.messageSource = messageSource;
        this.validationErrors = validationErrors;
    }

    @GetMapping(path = "/new")
    public String newUserRegistration(final User user) {
        log.trace("M=newUserRegistration");
        return View.USER_REGISTRATION;
    }

    @PostMapping(path = "/new")
    public String newUserRegistration(@Valid final User user,
                                      final Errors validation,
                                      final RedirectAttributes redirectAttributes) {
        if (validation.hasErrors()) {
            log.debug("M=newUserRegistration: user={}, messages={}",
                    user, validationErrors.getMessages(validation));
            return newUserRegistration(user);
        }
        log.debug("M=newUserRegistration: user={}", user);
        redirectAttributes.addFlashAttribute("message", messageSource.getMessage("new.user.registration.success"));
        return Redirect.USERS_NEW;
    }
}
