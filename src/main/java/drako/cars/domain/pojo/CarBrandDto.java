package drako.cars.domain.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Pojo for car brand
 */
@Getter
@Setter
public class CarBrandDto {
    /**
     * id for brand
     */
    private Integer id;
    /**
     * description for brand
     */
    private String description;

}
