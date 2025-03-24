package com.mytests.spring.springJpaCast.controllers;

import com.mytests.spring.springJpaCast.model.UuidEntity;
import com.mytests.spring.springJpaCast.repositories.UuidEntityRepository;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
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

        System.out.println(uuidEntityRepository.castToBigDecimal1());
        System.out.println(uuidEntityRepository.castToBigDecimal2());
        System.out.println(uuidEntityRepository.castToBigInteger1());
        System.out.println(uuidEntityRepository.castToBigInteger2());
        System.out.println(uuidEntityRepository.castToBinary1());
        System.out.println(uuidEntityRepository.castToBinary2());
        System.out.println(uuidEntityRepository.castToBoolean1());
        System.out.println(uuidEntityRepository.castToBoolean2());
        System.out.println(uuidEntityRepository.castToBoolean3());
        System.out.println(uuidEntityRepository.castToByte1());
        System.out.println(uuidEntityRepository.castToByte2());
        System.out.println(uuidEntityRepository.castToByte3());
        System.out.println(uuidEntityRepository.castToDate1());
        System.out.println(uuidEntityRepository.castToDate2());
        System.out.println(uuidEntityRepository.castToDate3());
        System.out.println(uuidEntityRepository.castToDouble1());
        System.out.println(uuidEntityRepository.castToDouble2());
        System.out.println(uuidEntityRepository.castToDouble3());
        System.out.println(uuidEntityRepository.castToFloat1());
        System.out.println(uuidEntityRepository.castToFloat2());
        System.out.println(uuidEntityRepository.castToFloat3());
        System.out.println(uuidEntityRepository.castToInteger1());
        System.out.println(uuidEntityRepository.castToInteger2());
        System.out.println(uuidEntityRepository.castToInteger3());
        System.out.println(uuidEntityRepository.castToLong1());
        System.out.println(uuidEntityRepository.castToLong2());
        System.out.println(uuidEntityRepository.castToLong3());
        System.out.println(uuidEntityRepository.castToCharacter1());
        System.out.println(uuidEntityRepository.castToCharacter2());
        System.out.println(uuidEntityRepository.castToCharacter3());
        System.out.println(uuidEntityRepository.castToShort1());
        System.out.println(uuidEntityRepository.castToShort2());
        System.out.println(uuidEntityRepository.castToShort3());
        System.out.println(uuidEntityRepository.castToDuration1());
        System.out.println(uuidEntityRepository.castToDuration2());
        System.out.println(uuidEntityRepository.castToDuration3());
        System.out.println(uuidEntityRepository.castToInstant1());
        System.out.println(uuidEntityRepository.castToInstant2());
        System.out.println(uuidEntityRepository.castToInstant3());
        System.out.println(uuidEntityRepository.castToTime1());
        System.out.println(uuidEntityRepository.castToTime2());
        System.out.println(uuidEntityRepository.castToTimestamp1());
        System.out.println(uuidEntityRepository.castToTimestamp2());
        System.out.println(uuidEntityRepository.castToLocaldate1());
        System.out.println(uuidEntityRepository.castToLocaldate2());
        System.out.println(uuidEntityRepository.castToLocaldatetime1());
        System.out.println(uuidEntityRepository.castToLocaldatetime2());
        System.out.println(uuidEntityRepository.castToLocaltime1());
        System.out.println(uuidEntityRepository.castToLocaltime2());
        System.out.println(uuidEntityRepository.castToZoneddatetime1());
        System.out.println(uuidEntityRepository.castToZoneddatetime2());
        System.out.println(uuidEntityRepository.castToYesNo1());
        System.out.println(uuidEntityRepository.castToYesNo2());
        System.out.println(uuidEntityRepository.castToTrueFalse1());
        System.out.println(uuidEntityRepository.castToTrueFalse2());
        System.out.println(uuidEntityRepository.castToNumericBoolean1());
        System.out.println(uuidEntityRepository.castToNumericBoolean2());
        System.out.println(uuidEntityRepository.castToString1());
        System.out.println(uuidEntityRepository.castToString2());
        System.out.println(uuidEntityRepository.castToString3());
        System.out.println(uuidEntityRepository.castToBigDecimal3(BigDecimal.valueOf(10.1)));
        System.out.println(uuidEntityRepository.castToBigDecimal4(BigDecimal.valueOf(10)));
        System.out.println(uuidEntityRepository.castToBigInteger4(BigInteger.valueOf(10)));
        return uuidEntityRepository.castToYesNo0();
    }
}
