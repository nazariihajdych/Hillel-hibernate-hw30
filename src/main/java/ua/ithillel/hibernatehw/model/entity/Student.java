package ua.ithillel.hibernatehw.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "student")
@Table(name = "t_student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email")
    private String email;
}
