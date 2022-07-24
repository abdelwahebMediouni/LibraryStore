package com.library.entities;

import com.library.enums.Gender;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table
public class Student extends AbstractEntity {

    public Student(@NotBlank String name, @Email String email, @NotNull Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    @NotBlank
    @Column(nullable = false)
    private String name;
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private Set<StudentBook> studentBooks = new HashSet<StudentBook>();

}
