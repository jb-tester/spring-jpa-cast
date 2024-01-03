package com.mytests.spring.springJpaCast.controllers;

import com.mytests.spring.springJpaCast.model.UuidEntity;
import com.mytests.spring.springJpaCast.repositories.UuidEntityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UuidEntityController {

    private final UuidEntityRepository uuidEntityRepository;

    public UuidEntityController(UuidEntityRepository uuidEntityRepository) {
        this.uuidEntityRepository = uuidEntityRepository;
    }

    @GetMapping("/getByUUID/short")
    public List<UuidEntity> testCastToShortTypeName(){

        List<UuidEntity> rez = uuidEntityRepository.testCastToShortTypeName("cdfdccfa-aa4e-11ee-9605-a6011257807d");
        return rez;
    }
    @GetMapping("/getByUUID/fqn")
    public List<UuidEntity> testCastToTypeFQN(){

        List<UuidEntity> rez = uuidEntityRepository.testCastToTypeFQN("cdf5f7f7-aa4e-11ee-9605-a6011257807d");
        return rez;
    }
}
