package drako.cars.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarPurchaseResponseDto {

    private String referenceCar;

    private Integer quantity;

    private Integer total;

}
