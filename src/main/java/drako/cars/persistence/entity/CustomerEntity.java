package drako.cars.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @Column(name = "id_card")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String cardId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private Double numberCellPhone;

    @Column(name = "active")
    private Integer active;

    @Column(name = "password")
    private String password;
}
