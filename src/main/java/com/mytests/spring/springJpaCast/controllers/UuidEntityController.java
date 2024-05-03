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

    @GetMapping("/variousTypesCast")
    public List<String> testCastVariousTypes(){

       uuidEntityRepository.castToBigDecimal1();
        uuidEntityRepository.castToBigDecimal2();
        uuidEntityRepository.castToBigInteger1();
       uuidEntityRepository.castToBigInteger2();
        uuidEntityRepository.castToBinary1();
        uuidEntityRepository.castToBinary2();
        uuidEntityRepository.castToBoolean1();
        uuidEntityRepository.castToBoolean2();
        uuidEntityRepository.castToBoolean3();
        uuidEntityRepository.castToByte1();
        uuidEntityRepository.castToByte2();
        uuidEntityRepository.castToByte3();
        uuidEntityRepository.castToDate1();
        uuidEntityRepository.castToDate2();
        uuidEntityRepository.castToDate3();
        uuidEntityRepository.castToDouble1();
      uuidEntityRepository.castToDouble2();
        uuidEntityRepository.castToDouble3();
       uuidEntityRepository.castToFloat1();
        uuidEntityRepository.castToFloat2();
        uuidEntityRepository.castToFloat3();
        uuidEntityRepository.castToInteger1();
        uuidEntityRepository.castToInteger2();
        uuidEntityRepository.castToInteger3();
        uuidEntityRepository.castToLong1();
        uuidEntityRepository.castToLong2();
        uuidEntityRepository.castToLong3();
        uuidEntityRepository.castToCharacter1();
        uuidEntityRepository.castToCharacter2();
        uuidEntityRepository.castToCharacter3();
        uuidEntityRepository.castToShort1();
        uuidEntityRepository.castToShort2();
        uuidEntityRepository.castToShort3();
        uuidEntityRepository.castToDuration1();
        uuidEntityRepository.castToDuration2();
        uuidEntityRepository.castToDuration3();
        uuidEntityRepository.castToInstant1();
        uuidEntityRepository.castToInstant2();
        uuidEntityRepository.castToInstant3();
        uuidEntityRepository.castToTime1();
        uuidEntityRepository.castToTime2();
        uuidEntityRepository.castToTimestamp1();
        uuidEntityRepository.castToTimestamp2();
        uuidEntityRepository.castToLocaldate1();
        uuidEntityRepository.castToLocaldate2();
        uuidEntityRepository.castToLocaldatetime1();
        uuidEntityRepository.castToLocaldatetime2();
        uuidEntityRepository.castToLocaltime1();
        uuidEntityRepository.castToLocaltime2();
        uuidEntityRepository.castToZoneddatetime1();
        uuidEntityRepository.castToZoneddatetime2();
        uuidEntityRepository.castToYesNo1();
        uuidEntityRepository.castToYesNo2();
        uuidEntityRepository.castToTrueFalse1();
        uuidEntityRepository.castToTrueFalse2();
        uuidEntityRepository.castToNumericBoolean1();
        uuidEntityRepository.castToNumericBoolean2();
        uuidEntityRepository.castToString1();
        uuidEntityRepository.castToString2();
        uuidEntityRepository.castToString3();
        return uuidEntityRepository.castToYesNo0();
    }
}
