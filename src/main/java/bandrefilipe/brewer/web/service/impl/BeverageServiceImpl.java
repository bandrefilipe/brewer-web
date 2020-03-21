package bandrefilipe.brewer.web.service.impl;

import bandrefilipe.brewer.web.integration.BrewerPersistenceClient;
import bandrefilipe.brewer.web.model.BeverageFlavor;
import bandrefilipe.brewer.web.model.Origin;
import bandrefilipe.brewer.web.service.BeverageService;
import bandrefilipe.brewer.web.service.model.BeverageRegistrationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;

@Service
class BeverageServiceImpl implements BeverageService {

    private final BeverageServiceTranslator serviceTranslator;
    private final BrewerPersistenceClient brewerPersistenceClient;

    @Autowired
    BeverageServiceImpl(final BeverageServiceTranslator serviceTranslator,
                        final BrewerPersistenceClient brewerPersistenceClient) {
        super();
        this.serviceTranslator = serviceTranslator;
        this.brewerPersistenceClient = brewerPersistenceClient;
    }

    @Override
    public BeverageRegistrationData getBeverageRegistrationData() {
        return BeverageRegistrationData.builder()
                .beverageFlavors(asList(BeverageFlavor.values()))
                .beverageTypes(serviceTranslator.translate(brewerPersistenceClient.getAllBeverageTypes()))
                .origins(asList(Origin.values()))
                .build();
    }
}
