package fr.juliuselgringo.demospring.model;

import jakarta.persistence.*;
import lombok.*;

@Data //lombok
@Entity //création d'une entité
@Table(name="customers") // lié à la table dans la BDD
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    @Id // clé primaire
    @Column(name="id_customer") //lié à la colonne id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //auto increment
    private Integer id;

    @Column(name="first_name") // colonne de la table
    private String firstName;

    @Column(name="last_name")
    private String lastName;


}
