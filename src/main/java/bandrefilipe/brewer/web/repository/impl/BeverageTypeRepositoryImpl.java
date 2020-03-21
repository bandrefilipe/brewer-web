package bandrefilipe.brewer.web.repository.impl;

import bandrefilipe.brewer.web.integration.BrewerPersistenceClient;
import bandrefilipe.brewer.web.model.BeverageType;
import bandrefilipe.brewer.web.repository.BeverageTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.completedFuture;

@Slf4j
@Repository
class BeverageTypeRepositoryImpl implements BeverageTypeRepository {

    private final BrewerPersistenceClient brewerPersistenceClient;
    private final BeverageTranslator beverageTranslator;

    BeverageTypeRepositoryImpl(final BrewerPersistenceClient brewerPersistenceClient,
                               final BeverageTranslator beverageTranslator) {
        super();
        this.brewerPersistenceClient = brewerPersistenceClient;
        this.beverageTranslator = beverageTranslator;
    }

    @Override
    public List<BeverageType> getAllBeverageTypes() {
        log.debug("M=getAllBeverageTypes");
        final var allBeverageTypes = beverageTranslator.translate(brewerPersistenceClient.getAllBeverageTypes());
        log.debug("M=getAllBeverageTypes: return={}", allBeverageTypes);
        return allBeverageTypes;
    }

    @Async
    @Override
    public CompletableFuture<List<BeverageType>> asyncGetAllBeverageTypes() {
        log.debug("M=asyncGetAllBeverageTypes");
        final var response = brewerPersistenceClient.getAllBeverageTypes();
        final var allBeverageTypes = completedFuture(beverageTranslator.translate(response));
        log.debug("M=asyncGetAllBeverageTypes: return={}", allBeverageTypes);
        return allBeverageTypes;
    }
}