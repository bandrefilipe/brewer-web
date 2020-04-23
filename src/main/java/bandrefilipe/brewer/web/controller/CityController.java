package bandrefilipe.brewer.web.controller;

import bandrefilipe.brewer.web.core.MessageSource;
import bandrefilipe.brewer.web.core.ValidationErrors;
import bandrefilipe.brewer.web.core.model.City;
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
        path = API.CITIES,
        produces = MediaType.TEXT_HTML_VALUE)
class CityController {

    private final MessageSource messageSource;
    private final ValidationErrors validationErrors;

    @Autowired
    CityController(final MessageSource messageSource,
                   final ValidationErrors validationErrors) {
        log.debug("Creating bean {}", CityController.class.getSimpleName());
        this.messageSource = messageSource;
        this.validationErrors = validationErrors;
    }

    @GetMapping(path = "/new")
    public String newCityRegistration(final City city) {
        log.trace("M=newCityRegistration");
        return View.CITY_REGISTRATION;
    }

    @PostMapping(path = "/new")
    public String newCityRegistration(@Valid final City city,
                                      final Errors validation,
                                      final RedirectAttributes redirectAttributes) {
        if (validation.hasErrors()) {
            log.debug("M=newCityRegistration: city={}, messages={}",
                    city, validationErrors.getMessages(validation));
            return newCityRegistration(city);
        }
        log.debug("M=newCityRegistration: city={}", city);
        redirectAttributes.addFlashAttribute("message", messageSource.getMessage("new.city.registration.success"));
        return Redirect.CITIES_NEW;
    }
}
