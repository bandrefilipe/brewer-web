package bandrefilipe.brewer.web.service;

import bandrefilipe.brewer.web.core.model.Beverage;
import bandrefilipe.brewer.web.integration.response.BeverageRegistrationResponse;
import bandrefilipe.brewer.web.service.model.BeverageRegistrationData;

public interface BeverageService {

    BeverageRegistrationData getBeverageRegistrationData();
    BeverageRegistrationResponse registerNewBeverage(Beverage beverage);
}
