package bandrefilipe.brewer.web.integration.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BeverageRegistrationRequest {

    private String sku;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private BigDecimal alcoholContent;
    private BigDecimal commission;
    private Integer stock;
    private String originCode;
    private String flavorCode;
    private Long beverageTypeId;
}
