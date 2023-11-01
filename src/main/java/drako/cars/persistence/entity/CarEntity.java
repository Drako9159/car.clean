package drako.cars.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Car Entity
 */
@Entity
@Getter
@Setter
@Table(name = "car")
public class CarEntity {
    @Id
    @Column(name = "code_car")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeCar;

    @Column(name = "car_brand")
    private Integer carBrandId;

    @Column(name = "reference")
    private String reference;

    @Column(name = "price")
    private Double price;

    @Column(name = "model_year")
    private Double modelYear;

    @Column(name = "color")
    private String color;

    @Column(name = "horsepower")
    private Double horsepower;

    @Column(name = "number_door")
    private Integer numberDoor;

    @Column(name = "engine_displacement")
    private Double engineDisplacement;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "number_seats")
    private Integer numberSeats;

    @Column(name = "traction")
    private Integer traction;

    @Column(name = "steering")
    private String steering;

    @Column(name = "category")
    private String category;

    @Column(name = "image_path")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "car_brand", insertable = false, updatable = false)
    private CarBrandEntity carBrandEntity;

    @OneToMany(mappedBy = "carEntity")
    private List<CarPurchaseEntity> carPurchaseEntity;
}
