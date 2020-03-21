package bandrefilipe.brewer.web.service.model;

import bandrefilipe.brewer.web.model.BeverageFlavor;
import bandrefilipe.brewer.web.model.BeverageType;
import bandrefilipe.brewer.web.model.Origin;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BeverageRegistrationData {

    private final List<BeverageFlavor> beverageFlavors;
    private final List<BeverageType> beverageTypes;
    private final List<Origin> origins;
}
