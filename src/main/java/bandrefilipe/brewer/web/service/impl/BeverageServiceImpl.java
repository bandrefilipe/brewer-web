package bandrefilipe.brewer.web.service.impl;

import bandrefilipe.brewer.web.model.BeverageFlavor;
import bandrefilipe.brewer.web.model.Origin;
import bandrefilipe.brewer.web.repository.BeverageTypeRepository;
import bandrefilipe.brewer.web.service.BeverageService;
import bandrefilipe.brewer.web.service.model.BeverageRegistrationData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;

@Slf4j
@Service
class BeverageServiceImpl implements BeverageService {

    private BeverageTypeRepository beverageTypeRepository;

    @Autowired
    BeverageServiceImpl(final BeverageTypeRepository beverageTypeRepository) {
        super();
        this.beverageTypeRepository = beverageTypeRepository;
    }

    @Override
    public BeverageRegistrationData getBeverageRegistrationData() {
        return BeverageRegistrationData.builder()
                .beverageFlavors(asList(BeverageFlavor.values()))
                .beverageTypes(beverageTypeRepository.getAllBeverageTypes())
                .origins(asList(Origin.values()))
                .build();
    }

    @Override
    public BeverageRegistrationData asyncGetBeverageRegistrationData() {
        final var futureAllBeverageTypes = beverageTypeRepository.asyncGetAllBeverageTypes();
        final var builder = BeverageRegistrationData.builder()
                .beverageFlavors(asList(BeverageFlavor.values()))
                .origins(asList(Origin.values()));
        final var allBeverageTypes = futureAllBeverageTypes.join();
        return builder.beverageTypes(allBeverageTypes)
                .build();
    }
}
