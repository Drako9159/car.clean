package drako.cars.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @Column(name = "id_brand")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * description for brand
     */
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "carBrandEntity", orphanRemoval = true)
    private List<CarEntity> carEntityList;

}
