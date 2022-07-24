package com.library.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Book extends AbstractEntity {

    @Column(nullable = false)
    private  String title;
    @Column(nullable = false)
    private  String author;
    @Column(nullable = false)
    private  LocalDate publishedOn;


    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private Set<StudentBook> studentBooks = new HashSet<StudentBook>();

}
