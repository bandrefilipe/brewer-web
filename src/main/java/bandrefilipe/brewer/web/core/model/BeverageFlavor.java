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
public enum BeverageFlavor {

    BITTER("B", "Bitter"),
    FRUITY("F", "Fruity"),
    SOFT  ("S", "Soft"),
    STRONG("T", "Strong"),
    SWEET ("W", "Sweet");

    private static final Map<String, BeverageFlavor> FLAVORS_BY_CODE = Stream.of(BeverageFlavor.values())
            .collect(toUnmodifiableMap(BeverageFlavor::getCode, Function.identity()));

    private final String code;
    private final String description;

    public static BeverageFlavor getByCode(final String code) {
        return FLAVORS_BY_CODE.get(code);
    }

    @Override
    public String toString() {
        return description;
    }
}
