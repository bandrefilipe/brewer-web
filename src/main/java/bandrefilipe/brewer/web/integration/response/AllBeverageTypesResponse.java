package bandrefilipe.brewer.web.integration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllBeverageTypesResponse {

    private Long id;
    private String name;
}
