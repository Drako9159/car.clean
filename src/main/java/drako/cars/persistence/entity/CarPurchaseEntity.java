package drako.cars.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "car_purchase")
public class CarPurchaseEntity {

    @EmbeddedId
    private CarPurchasePK id;

    @Column(name = "quantity")
    private Integer quantity;

    private Integer total;

    @ManyToOne
    @MapsId(value = "purchaseNumberBill")
    @JoinColumn(name = "purchase_number_bill", insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;

    @ManyToOne
    @JoinColumn(name = "code_car", insertable = false, updatable = false)
    private CarEntity carEntity;

}
