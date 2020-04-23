package bandrefilipe.brewer.web.config;

import bandrefilipe.brewer.web.core.model.BeverageFlavor;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

/**
 * A package-private singleton to be registered as a WebMvc converter.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class BeverageFlavorConverter implements Converter<String, BeverageFlavor> {

    public static final BeverageFlavorConverter INSTANCE = new BeverageFlavorConverter();

    @Override
    public BeverageFlavor convert(@NonNull final String code) {
        log.debug("M=convert: code={}", code);
        return BeverageFlavor.getByCode(code);
    }
}
