package drako.cars.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto for customer
 */
@Getter
@Setter
public class CustomerDto {

    private String cardId;

    private String fullName;

    private String email;

    private Double numberCellPhone;

    private Integer active;

    private String password;

}
