package bandrefilipe.brewer.web.service.impl;

import bandrefilipe.brewer.web.core.model.Beverage;
import bandrefilipe.brewer.web.core.model.BeverageFlavor;
import bandrefilipe.brewer.web.core.model.BeverageType;
import bandrefilipe.brewer.web.core.model.Origin;
import bandrefilipe.brewer.web.integration.request.BeverageRegistrationRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class BeverageRegistrationModelConverter implements Converter<Beverage, Optional<BeverageRegistrationRequest>> {

    public static final BeverageRegistrationModelConverter INSTANCE = new BeverageRegistrationModelConverter();

    @NonNull
    @Override
    public Optional<BeverageRegistrationRequest> convert(final Beverage source) {
        log.debug("M=convert: source={}", source);
        final var result = ofNullable(source)
                .map(beverage -> BeverageRegistrationRequest.builder()
                        .sku(beverage.getSku())
                        .name(beverage.getName())
                        .description(beverage.getDescription())
                        .unitPrice(beverage.getUnitPrice())
                        .alcoholContent(beverage.getAlcoholContent())
                        .commission(beverage.getCommission())
                        .stock(beverage.getStock())
                        .originCode(ofNullable(beverage.getOrigin()).map(Origin::getCode).orElse(null))
                        .flavorCode(ofNullable(beverage.getFlavor()).map(BeverageFlavor::getCode).orElse(null))
                        .beverageTypeId(ofNullable(beverage.getType()).map(BeverageType::getId).orElse(null))
                        .build());
        log.debug("M=convert: return={}", result);
        return result;
    }
}
