package com.example.medical_demo_deplacement.service;

import com.example.medical_demo_deplacement.model.DeplacementModel;
import com.example.medical_demo_deplacement.model.DeplacementPatientInfirmierModel;
import com.example.medical_demo_deplacement.repository.DeplacementRepository;
import com.example.medical_demo_deplacement.repository.InfirmierRepository;
import com.example.medical_demo_deplacement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeplacementService {

    @Autowired
    public DeplacementRepository deplacementRepository;

    @Autowired
    public InfirmierRepository infirmierRepository;

    @Autowired
    public PatientRepository patientRepository;


    public List<DeplacementModel> findAll(){
        return deplacementRepository.findAll();
    }

    public DeplacementModel createDeplacement(DeplacementModel deplacementModel) {
        return deplacementRepository.save(deplacementModel);
    }

    public DeplacementModel findOneDeplacementById(String deplacementId) {
        return deplacementRepository.findById(deplacementId).get();
    }

    public DeplacementModel updateDeplacement(DeplacementModel deplacementModel) {
        return deplacementRepository.save(deplacementModel);
    }

    public void deleteDeplacement(String deplacementId){
        deplacementRepository.deleteById(deplacementId);
    }

    /**
     * Méthode permettant d’afficher uniquement les déplacements à venir
     * @return les déplacements après la date d'auj
     */
    public List<DeplacementModel> findNext() {
        Date dateAuj = new Date();
        //localdate.now
        return deplacementRepository.findDeplacementModelsByDateIsGreaterThan(dateAuj);
    }

    /**
     * Méthode permettant d’afficher tous les déplacements à venir d’un
     * patient
     * @param id du patient
     * @return les déplacements du patient patientId après la date d'auj
     */
    public List<DeplacementModel> findByPatient(String id){
        Date dateAuj = new Date();
        return deplacementRepository.findDeplacementModelsByPatientIdAndDateIsGreaterThan(id, dateAuj);
    }

    /**
     * Méthode permettant d’afficher tous les déplacements à venir d’un
     * infirmier
     * @param idInfirmier
     * @return
     */
    public List<DeplacementModel> findByInfirmier( String idInfirmier){
        Date dateAuj = new Date();
        return deplacementRepository.findDeplacementModelsByInfirmierIdAndDateIsGreaterThan(idInfirmier, dateAuj);
    }


    public DeplacementPatientInfirmierModel findDetails(String deplacementId) {
        DeplacementModel deplacementModel = this.findOneDeplacementById(deplacementId);

        return new DeplacementPatientInfirmierModel(
                deplacementModel,
                patientRepository.getPatientModel(deplacementModel.getPatientId()),
                infirmierRepository.getInfirmierModel(deplacementModel.getInfirmierId())

        );
    }
}
