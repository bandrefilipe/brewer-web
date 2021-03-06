package bandrefilipe.brewer.web.core.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public final class Beverage {

    @NotBlank(message = "{model.beverage.validation.sku.not-blank}")
    private String sku;

    @NotBlank(message = "{model.beverage.validation.name.not-blank}")
    private String name;

    @Size(max = 50, message = "{model.beverage.validation.description.size}")
    private String description;

    private BeverageType type;

    private BeverageFlavor flavor;

    private BigDecimal alcoholContent;

    private Origin origin;

    private BigDecimal unitPrice;

    private BigDecimal commission;

    private Integer stock;
}
