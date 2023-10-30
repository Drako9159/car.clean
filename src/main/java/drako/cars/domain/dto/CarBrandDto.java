package drako.cars.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto for car brands
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
