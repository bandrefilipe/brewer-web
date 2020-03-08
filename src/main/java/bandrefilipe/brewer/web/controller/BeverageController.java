package bandrefilipe.brewer.web.controller;

import bandrefilipe.brewer.web.core.MessageSource;
import bandrefilipe.brewer.web.model.Beverage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Slf4j
@Controller
@RequestMapping(
        path = API.BEVERAGES,
        produces = MediaType.TEXT_HTML_VALUE)
class BeverageController {

    private final MessageSource messageSource;

    @Autowired
    BeverageController(final MessageSource messageSource) {
        super();
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/new")
    public String newBeverageRegistration(final Beverage beverage) {
        log.trace("M=newBeverageRegistration");
        return View.BEVERAGE_REGISTRATION;
    }

    @PostMapping(path = "/new")
    public String newBeverageRegistration(@Valid final Beverage beverage,
                                          final Errors validation,
                                          final RedirectAttributes redirectAttributes) {
        if (validation.hasErrors()) {
            log.debug("M=newBeverageRegistration: beverage={}, messages={}", beverage, getMessages(validation));
            return newBeverageRegistration(beverage);
        }
        log.debug("M=newBeverageRegistration: beverage={}", beverage);
        redirectAttributes.addFlashAttribute("message", messageSource.getMessage("new.beverage.registration.success"));
        return Redirect.BEVERAGES_NEW;
    }

    private Set<String> getMessages(final Errors validation) {
        return validation.getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(toSet());
    }
}
