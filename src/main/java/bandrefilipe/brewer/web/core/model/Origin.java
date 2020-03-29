package bandrefilipe.brewer.web.core.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toUnmodifiableMap;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Origin {

    NATIONAL("N", "National"),
    INTERNATIONAL("I", "International");

    private static final Map<Object, Origin> ORIGINS_BY_CODE = Stream.of(Origin.values())
            .collect(toUnmodifiableMap(Origin::getCode, Function.identity()));

    private final String code;
    private final String description;

    public static Origin from(final Object code) {
        return ORIGINS_BY_CODE.get(code);
    }

    @Override
    public String toString() {
        return description;
    }
}
