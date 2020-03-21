package bandrefilipe.brewer.web.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Origin {

    NATIONAL("N", "National"),
    INTERNATIONAL("I", "International");

    private final String code;
    private final String description;

    @Override
    public String toString() {
        return description;
    }
}
