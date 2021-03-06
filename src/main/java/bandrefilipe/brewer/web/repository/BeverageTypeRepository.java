package bandrefilipe.brewer.web.repository;

import bandrefilipe.brewer.web.core.model.BeverageType;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface BeverageTypeRepository {

    CompletableFuture<List<BeverageType>> asyncGetAllBeverageTypes();
}
