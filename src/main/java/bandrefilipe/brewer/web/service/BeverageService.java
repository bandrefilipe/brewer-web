package bandrefilipe.brewer.web.service;

import bandrefilipe.brewer.web.service.model.BeverageRegistrationData;

public interface BeverageService {

    BeverageRegistrationData getBeverageRegistrationData();
    BeverageRegistrationData asyncGetBeverageRegistrationData();
}
