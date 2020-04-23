package bandrefilipe.brewer.web.repository.impl;

import bandrefilipe.brewer.web.integration.BrewerPersistenceClient;
import bandrefilipe.brewer.web.integration.request.BeverageRegistrationRequest;
import bandrefilipe.brewer.web.integration.response.BeverageRegistrationResponse;
import bandrefilipe.brewer.web.repository.BeverageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
class BeverageRepositoryImpl implements BeverageRepository {

    private final BrewerPersistenceClient brewerPersistenceClient;

    @Autowired
    BeverageRepositoryImpl(final BrewerPersistenceClient brewerPersistenceClient) {
        this.brewerPersistenceClient = brewerPersistenceClient;
    }

    @Override
    public BeverageRegistrationResponse persist(final BeverageRegistrationRequest beveragePayload) {
        log.debug("M=persist: beveragePayload={}", beveragePayload);
        final var response = brewerPersistenceClient.postNewBeverageRegistration(beveragePayload);
        log.debug("M=persist: return={}", response);
        return response;
    }
}
