package com.example.medical_demo_deplacement.repository;

import com.example.medical_demo_deplacement.model.DeplacementModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface DeplacementRepository extends MongoRepository<DeplacementModel, String> {
    public List<DeplacementModel> findDeplacementModelsByDateIsGreaterThan(Date dateAuj);
    public List<DeplacementModel> findDeplacementModelsByPatientIdAndDateIsGreaterThan(String patientId, Date dateAuj);
    public List<DeplacementModel> findDeplacementModelsByInfirmierIdAndDateIsGreaterThan(String infirmierId, Date dateAuj);
 }
