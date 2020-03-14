package bandrefilipe.brewer.web.controller;

import bandrefilipe.brewer.web.core.MessageSource;
import bandrefilipe.brewer.web.core.ValidationErrors;
import bandrefilipe.brewer.web.model.Beverage;
import bandrefilipe.brewer.web.model.BeverageType;
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
        path = API.BEVERAGES,
        produces = MediaType.TEXT_HTML_VALUE)
class BeverageController {

    private final MessageSource messageSource;
    private final ValidationErrors validationErrors;

    @Autowired
    BeverageController(final MessageSource messageSource,
                       final ValidationErrors validationErrors) {
        super();
        log.debug("Creating bean {}", BeverageController.class.getSimpleName());
        this.messageSource = messageSource;
        this.validationErrors = validationErrors;
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
            log.debug("M=newBeverageRegistration: beverage={}, messages={}",
                    beverage, validationErrors.getMessages(validation));
            return newBeverageRegistration(beverage);
        }
        log.debug("M=newBeverageRegistration: beverage={}", beverage);
        redirectAttributes.addFlashAttribute("message", messageSource.getMessage("new.beverage.registration.success"));
        return Redirect.BEVERAGES_NEW;
    }

    @GetMapping(path = "/types/new")
    public String newBeverageTypeRegistration(final BeverageType beverageType) {
        log.trace("M=newBeverageTypeRegistration");
        return View.BEVERAGE_TYPE_REGISTRATION;
    }

    @PostMapping(path = "/types/new")
    public String newBeverageTypeRegistration(@Valid final BeverageType beverageType,
                                              final Errors validation,
                                              final RedirectAttributes redirectAttributes) {
        if (validation.hasErrors()) {
            log.debug("M=newBeverageTypeRegistration: beverageType={} messages={}",
                    beverageType, validationErrors.getMessages(validation));
            return newBeverageTypeRegistration(beverageType);
        }
        log.debug("M=newBeverageTypeRegistration: beverageType={}", beverageType);
        redirectAttributes.addFlashAttribute("message",
                messageSource.getMessage("new.beverage.type.registration.success"));
        return Redirect.BEVERAGES_TYPES_NEW;
    }
}
