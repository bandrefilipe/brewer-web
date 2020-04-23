package bandrefilipe.brewer.web.integration;

import bandrefilipe.brewer.web.integration.request.BeverageRegistrationRequest;
import bandrefilipe.brewer.web.integration.response.AllBeverageTypesResponse;
import bandrefilipe.brewer.web.integration.response.BeverageRegistrationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "BrewerPersistenceClient", url = "${integration.brewer.persistence.url}")
public interface BrewerPersistenceClient {

    @GetMapping(path = "/beverages/types/all", produces = APPLICATION_JSON_VALUE)
    List<AllBeverageTypesResponse> getAllBeverageTypes();

    @PostMapping(path = "/beverages/new", produces = APPLICATION_JSON_VALUE)
    BeverageRegistrationResponse postNewBeverageRegistration(BeverageRegistrationRequest requestBody);
}
