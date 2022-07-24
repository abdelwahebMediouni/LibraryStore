package com.library.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class StudentBookPK implements Serializable {
    @Column(name = "STUDENT_ID")
    private Long student_id;

    @Column(name = "BOOK_ID")
    private Long book_id;
}
