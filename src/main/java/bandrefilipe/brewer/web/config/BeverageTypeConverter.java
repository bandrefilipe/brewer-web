package bandrefilipe.brewer.web.config;

import bandrefilipe.brewer.web.core.model.BeverageType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * A package-private singleton to be registered as a WebMvc converter.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class BeverageTypeConverter implements Converter<String, BeverageType> {

    public static final BeverageTypeConverter INSTANCE = new BeverageTypeConverter();

    @Override
    public BeverageType convert(@NonNull final String id) {
        log.debug("M=convert: id={}", id);
        return toLong(id)
                .map(BeverageType::withId)
                .orElse(null);
    }

    Optional<Long> toLong(final String string) {
        try { return Optional.of(Long.valueOf(string)); }
        catch (final NumberFormatException nfe) {
            log.warn("Exception converting [{}] to type Long", string, nfe);
            return Optional.empty();
        }
    }
}
