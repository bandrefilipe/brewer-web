package bandrefilipe.brewer.web.service.impl;

import bandrefilipe.brewer.web.core.model.BeverageFlavor;
import bandrefilipe.brewer.web.core.model.Origin;
import bandrefilipe.brewer.web.repository.BeverageTypeRepository;
import bandrefilipe.brewer.web.service.BeverageService;
import bandrefilipe.brewer.web.service.model.BeverageRegistrationData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        final var futureAllBeverageTypes = beverageTypeRepository.asyncGetAllBeverageTypes();
        final var builder = BeverageRegistrationData.builder()
                .beverageFlavors(BeverageFlavor.values())
                .origins(Origin.values());
        final var allBeverageTypes = futureAllBeverageTypes.join();
        return builder.beverageTypes(allBeverageTypes)
                .build();
    }
}
