package com.mytests.spring.springJpaCast.repositories;

import com.mytests.spring.springJpaCast.model.UuidEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface UuidEntityRepository extends CrudRepository<UuidEntity, UUID> {

    @Query(value = "select e from UuidEntity e where e.id = cast(?1 as uuid)")
    List<UuidEntity> testCastToShortTypeName(String id);

    @Query(value = "select e from UuidEntity e where e.id = cast(?1 as java.util.UUID)")
    List<UuidEntity> testCastToTypeFQN(String id);


}
