package org.spring.Media;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Media {
            @Id
            @Column(name="mediaid")
            String mediaid;
            @Column(name="mediatype")
            String mediatype ;
            byte[] media ;
            String  mediatitle;
            String mediadescription ;
            Date createdat ;
            String userid ;
}
