package com.example.medical_demo_deplacement.repository;

import com.example.medical_demo_deplacement.model.PatientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class PatientRepository {

    @Value("${variable.uriPatient}")
    private String URIPatient;

    @Autowired
    private WebClient webClient;

    public PatientModel getPatientModel(String patientId){
        return webClient.get()
                .uri(URIPatient + "/patients/" + patientId)
                .retrieve()
                .bodyToMono(PatientModel.class)
                .block();
    }
}
