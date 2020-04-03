package bandrefilipe.brewer.web.repository.impl;

import bandrefilipe.brewer.web.integration.response.AllBeverageTypesResponse;
import bandrefilipe.brewer.web.core.model.BeverageType;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

@Component
class BeverageTranslator {

    List<BeverageType> translate(final Collection<AllBeverageTypesResponse> allBeverageTypesResponse) {
        return ofNullable(allBeverageTypesResponse)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(this::translate)
                .collect(toList());
    }

    BeverageType translate(final AllBeverageTypesResponse response) {
        return ofNullable(response)
                .map(res -> new BeverageType(res.getId(), res.getName()))
                .orElse(null);
    }
}
