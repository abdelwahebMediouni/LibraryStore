package com.library.entities;

import com.library.student.util.DateProcessor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "StudentBook")
public class StudentBook implements Serializable {

    @EmbeddedId
    private StudentBookPK id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("student_id") //This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("book_id")
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @Column(name= "started_reading_on")
    @DateTimeFormat(pattern = DateProcessor.DATE_FORMAT)
    private LocalDate startedReadingOn;
    @Column(name= "finished_reading_on")
    @DateTimeFormat(pattern = DateProcessor.DATE_FORMAT)
    private  LocalDate finishedReadingOn;
}
