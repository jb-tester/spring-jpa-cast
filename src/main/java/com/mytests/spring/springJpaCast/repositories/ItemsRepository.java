package com.mytests.spring.springJpaCast.repositories;

import com.mytests.spring.springJpaCast.dto.LongsProjection;
import com.mytests.spring.springJpaCast.dto.ShortsProjection;
import com.mytests.spring.springJpaCast.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * *
 * <p>Created by irina on 11/2/2021.</p>
 * <p>Project: spring-java-records</p>
 * *
 */
public interface ItemsRepository extends CrudRepository<Item, Integer> {

    @Query("""
           select i from Item i
           where i.cathegory = :cat
           and i.price < :price
           and i.discount > 0
           """)
    List<Item> findByMultipleCriteria(String cat, int price);

    //@Query("select new com.mytests.spring.springJpaCast.dto.ShortsProjection(cast(i.discount as short), cast(i.price/10 as Short)) from Item i") // incorrect,but no errors are shown
    //List<ShortsProjection> testCastForShortsIncorrect();

    @Query("select new com.mytests.spring.springJpaCast.dto.ShortsProjection(cast(i.discount as short), cast(i.price/10 as short)) from Item i") // correct, shown as error
    List<ShortsProjection> testCastForShorts();

    @Query("select new com.mytests.spring.springJpaCast.dto.LongsProjection(cast(i.price as Long), cast(i.total as long)) from Item i") // incorrect for prev versions, ok for the latest; no errors are shown
    List<LongsProjection> testCastsForLongsIncorrect();

    @Query("select new com.mytests.spring.springJpaCast.dto.LongsProjection(cast(i.price as long), cast(i.total as long)) from Item i") // correct, shown as error
    List<LongsProjection> testCastsForLongs();

    @Query("select i from Item i where cast(i.discount as short) = ?1 or cast(i.total as long) = ?2")
    List<Item> testCastingInWhereClause(Short arg1, Long arg2);

    @Query("select i from Item i where cast(i.discount as java.lang.Short) = ?1 or cast(i.total as java.lang.Long) = ?2")
    List<Item> testCastingInWhereClauseUsingFQN(Short arg1, Long arg2);
}
