package entitities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    @Id
    private Double id;

    @Column(name = "Name", nullable = false)
    private String name;

    //Timestamp
    //Что-то пошло категорически не так и он отказался задавать другой тип
    @Column(name = "Birthdate", nullable = false)
    private String birthdate;

    @Column(name = "Breed", nullable = false)
    private String breed;

    @Column(name = "Color")
    private Color color;

    @Column(name = "Length")
    private Integer length;

    @JoinColumn(name = "Owner")
    private Double owner;
}