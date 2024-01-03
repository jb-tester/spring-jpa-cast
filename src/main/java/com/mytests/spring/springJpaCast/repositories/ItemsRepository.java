package com.mytests.spring.springJpaCast.repositories;

import com.mytests.spring.springJpaCast.dto.LongsProjection;
import com.mytests.spring.springJpaCast.dto.ShortsProjection;
import com.mytests.spring.springJpaCast.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ItemsRepository extends CrudRepository<Item, Integer> {

    @Query("""
            select it from Item it
            where it.cathegory = :cat
            and it.price < :price
            and it.discount > 0
           """)
    List<Item> findByMultipleCriteria(String cat, int price);

    @Query("""
          select concat(record.title, " ", record.comment)
          from Item record
          where record.cathegory = :cat
         """)
    List<String> findDiscountByCategory(String cat);

    //@Query("select new com.mytests.spring.springJpaCast.dto.ShortsProjection(cast(i.discount as short), cast(i.price/10 as Short)) from Item i") // incorrect,but no errors are shown
    //List<ShortsProjection> testCastForShortsIncorrect();

    // https://youtrack.jetbrains.com/issue/IDEA-317924
    @Query("select new com.mytests.spring.springJpaCast.dto.ShortsProjection(cast(i.discount as short), cast(i.price/10 as short)) from Item i") // correct, shown as error
    List<ShortsProjection> testCastForShorts();

    @Query("select new com.mytests.spring.springJpaCast.dto.LongsProjection(cast(i.price as Long), cast(i.total as long)) from Item i") // incorrect for prev versions, ok for the latest; no errors are shown
    List<LongsProjection> testCastsForLongsIncorrect();

    @Query("select new com.mytests.spring.springJpaCast.dto.LongsProjection(cast(i.price as long), cast(i.total as long)) from Item i") // correct, shown as error
    List<LongsProjection> testCastsForLongs();

    @Query("select i from Item i where cast(i.discount as short) = ?1 or cast(i.total as long) = ?2")
    List<Item> testCastingInWhereClause(Short arg1, Long arg2);

    // https://youtrack.jetbrains.com/issue/IDEA-331513
    @Query("select i from Item i where cast(i.discount as java.lang.Short) = ?1 or cast(i.total as java.lang.Long) = ?2") // correct, shown as error
    List<Item> testCastingInWhereClauseUsingFQN(Short arg1, Long arg2);

    @Query(nativeQuery = true, value = """
		SELECT *
		FROM item t
		WHERE cast(t.cathegory as char(45)) = :t
	""")
    List<Item> nativeCastToChar(@Param("t") String t);


}
