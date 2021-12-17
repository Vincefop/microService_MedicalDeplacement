package com.example.medical_demo_deplacement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("deplacement")
public class DeplacementModel {

    @Id
    private String deplacementId;
    private Date date;
    private Float cout;
    private String infirmierId;
    private String patientId;
}
