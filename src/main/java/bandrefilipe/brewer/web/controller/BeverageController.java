package bandrefilipe.brewer.web.controller;

import bandrefilipe.brewer.web.core.MessageSource;
import bandrefilipe.brewer.web.core.ValidationErrors;
import bandrefilipe.brewer.web.model.Beverage;
import bandrefilipe.brewer.web.model.BeverageType;
import bandrefilipe.brewer.web.service.BeverageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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
    private final BeverageService beverageService;

    @Autowired
    BeverageController(final MessageSource messageSource,
                       final ValidationErrors validationErrors,
                       final BeverageService beverageService) {
        super();
        log.debug("Creating bean {}", BeverageController.class.getSimpleName());
        this.messageSource = messageSource;
        this.validationErrors = validationErrors;
        this.beverageService = beverageService;
    }

    @GetMapping(path = "/new")
    public ModelAndView newBeverageRegistration(final Beverage beverage) {
        log.trace("M=newBeverageRegistration");
        final var modelAndView = new ModelAndView(View.BEVERAGE_REGISTRATION);
        final var beverageRegistrationData = beverageService.asyncGetBeverageRegistrationData();
        modelAndView.addObject("flavors", beverageRegistrationData.getBeverageFlavors());
        modelAndView.addObject("types", beverageRegistrationData.getBeverageTypes());
        modelAndView.addObject("origins", beverageRegistrationData.getOrigins());
        return modelAndView;
    }

    @PostMapping(path = "/new")
    public ModelAndView newBeverageRegistration(@Valid final Beverage beverage,
                                                final Errors validation,
                                                final RedirectAttributes redirectAttributes) {
        if (validation.hasErrors()) {
            log.debug("M=newBeverageRegistration: beverage={}, messages={}",
                    beverage, validationErrors.getMessages(validation));
            return newBeverageRegistration(beverage);
        }
        log.debug("M=newBeverageRegistration: beverage={}", beverage);
        redirectAttributes.addFlashAttribute("message", messageSource.getMessage("new.beverage.registration.success"));
        return new ModelAndView(Redirect.BEVERAGES_NEW);
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
