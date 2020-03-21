package bandrefilipe.brewer.web.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum BeverageFlavor {

    BITTER("B", "Bitter"),
    FRUITY("F", "Fruity"),
    SOFT  ("S", "Soft"),
    STRONG("T", "Strong"),
    SWEET ("W", "Sweet");

    private final String code;
    private final String description;

    @Override
    public String toString() {
        return description;
    }
}
