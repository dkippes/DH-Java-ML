package com.example.jpademo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.security.auth.Subject;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_student")
    private Long id;

    @Column(name = "dni")
    @Nullable()
    private String dni;

    @Column(name = "name")
    @Length(max = 45)
    private String name;

    @Column(name = "last_name")
    @Length(max = 45)
    private String lastname;
}
