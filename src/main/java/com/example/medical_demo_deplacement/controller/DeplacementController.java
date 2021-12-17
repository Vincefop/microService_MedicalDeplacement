package com.example.medical_demo_deplacement.controller;

import com.example.medical_demo_deplacement.model.DeplacementModel;
import com.example.medical_demo_deplacement.model.DeplacementPatientInfirmierModel;
import com.example.medical_demo_deplacement.service.DeplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin
@RequestMapping("/deplacements")
public class DeplacementController {

    @Autowired
    private DeplacementService service;

    @GetMapping
    public List<DeplacementModel> findAll(){
        return service.findAll();
    }

    @GetMapping("/{deplacementId}")
    public DeplacementModel findOneDeplacementById(@PathVariable String deplacementId){
        return service.findOneDeplacementById(deplacementId);
    }


    /**
     * Méthode permettant d’afficher uniquement les déplacements à venir
     */
    @GetMapping("/after")
    public List<DeplacementModel> findNext(){
        return service.findNext();
    }


    /**
     * Méthode permettant d’afficher tous les déplacements à venir d’un
     * patient
     * @param idPatient du patient
     * @return les déplacements du patient patientId après la date d'auj
     */
    @GetMapping("/patientAfter/{idPatient}")
    public List<DeplacementModel> findByPatient(@PathVariable String idPatient){
        return service.findByPatient(idPatient);
    }

    /**
     * Méthode permettant d’afficher tous les déplacements à venir d’un
     * infirmier
     * @param idInfirmier
     * @return les déplacements de l'infirmier idInfirmier après la date d'auj
     */
    @GetMapping("/infirmierAfter/{idInfirmier}")
    public List<DeplacementModel> findByInfirmier(@PathVariable String idInfirmier) {
        return service.findByInfirmier(idInfirmier);
    }



    @GetMapping("/deplacementFull/{deplacementId}")
    /**
     * o Méthode permettant d’afficher un déplacement avec les noms
     * prénom du patient et de l’infirmier
     * @param deplacementId
     * @return le déplacement avec noms et prénoms des patient et infirmier
     */
    public DeplacementPatientInfirmierModel findDetails(@PathVariable String deplacementId){
        return service.findDetails(deplacementId);
    }

    @PostMapping
    public DeplacementModel createDeplacement(@RequestBody DeplacementModel deplacementModel){
        return service.createDeplacement(deplacementModel);
    }

    @PutMapping
    public DeplacementModel updateDeplacement(@RequestBody DeplacementModel deplacementModel){
        return service.updateDeplacement(deplacementModel);
    }

    @DeleteMapping("{deplacementId}")
    public void deleteDeplacement (@PathVariable String deplacementId){
        service.deleteDeplacement(deplacementId);
    }


}
