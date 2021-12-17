package com.example.medical_demo_deplacement.repository;

import com.example.medical_demo_deplacement.model.InfirmierModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class InfirmierRepository {

    @Value("${variable.uriInfirmier}")
    private String UriINF;

    @Autowired
    private WebClient webClient;

    public InfirmierModel getInfirmierModel(String infirmierId){
        return webClient.get()
                .uri(UriINF + "/infirmiers/" + infirmierId)
                .retrieve()
                .bodyToMono(InfirmierModel.class)
                .block();
    }

}
