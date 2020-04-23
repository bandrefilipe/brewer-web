package bandrefilipe.brewer.web.integration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BeverageRegistrationResponse {

    private Long id;
    private String name;
    private String sku;
    private BeverageTypeRegistrationResponse type;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BeverageTypeRegistrationResponse {

        private Long id;
        private String name;
    }
}
