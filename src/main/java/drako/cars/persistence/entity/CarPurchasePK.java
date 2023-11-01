package drako.cars.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CarPurchasePK implements Serializable {
    @Serial
    private static final long serialVersionUID = -2145479604343286721L;

    @Column(name = "purchase_number_bill")
    private Integer purchaseNumberBill;

    @Column(name = "code_car")
    private Integer codeCar;
}
