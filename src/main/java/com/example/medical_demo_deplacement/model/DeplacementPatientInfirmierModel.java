package com.example.medical_demo_deplacement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeplacementPatientInfirmierModel {

    private DeplacementModel deplacementModel;
    private PatientModel patientModel;
    private InfirmierModel infirmierModel;

}
