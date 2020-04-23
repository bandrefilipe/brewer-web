package bandrefilipe.brewer.web.core.model;

import lombok.Data;

@Data
public final class BeverageType {

    private final Long id;
    private final String name;

    public static BeverageType withId(final Long id) {
        return new BeverageType(id, null);
    }
}
