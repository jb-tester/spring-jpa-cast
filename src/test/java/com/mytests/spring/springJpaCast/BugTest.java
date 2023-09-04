package com.mytests.spring.springJpaCast;

import com.mytests.spring.springJpaCast.model.Item;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BugTest {
    @Autowired
    private EntityManager entityManager;

    @Test
    void entityManagerCanReadItems() {
        var query = entityManager.createQuery("select p from Item p", Item.class);
        var items = query.getResultList();
        assertNotEquals(items.size(),0);


    }

}