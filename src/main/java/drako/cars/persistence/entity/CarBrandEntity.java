package drako.cars.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity for car brand
 */
@Entity
@Getter
@Setter
@Table(name = "car_brand")
public class CarBrandEntity {
    /**
     * id for brand
     */
    @Id
    @Column(name = "id_car")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * description for brand
     */
    @Column(name = "description")
    private String description;

}
