package com.mytests.spring.springJpaCast.controllers;

import com.mytests.spring.springJpaCast.dto.LongsProjection;
import com.mytests.spring.springJpaCast.dto.ShortsProjection;
import com.mytests.spring.springJpaCast.model.Item;
import com.mytests.spring.springJpaCast.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ItemsController {
    final
    ItemsRepository itemsRepository;

    public ItemsController(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @RequestMapping("/testLongsCasting")
    public String testLongsCasting() {
        String rez = " ";
        for (LongsProjection p : itemsRepository.testCastsForLongs()) {
            rez = rez + p + " ";
        }
        return rez;
    }
    @RequestMapping("/testLongsCasting2")
    public String testLongsCasting2() {
        String rez = " ";
        for (LongsProjection p : itemsRepository.testCastsForLongsIncorrect()) {
            rez = rez + p + " ";
        }
        return rez;
    }
    @RequestMapping("/testShortsCasting2")
    public String testShortsCasting2() {
        String rez = " ";
        for (ShortsProjection p : itemsRepository.testCastForShorts()) {
            rez = rez + p + " ";
        }
        return rez;
    }
    @RequestMapping("/testCastingInWhereClause")
    public String testCastingInWhereClause() {
        String rez = " ";
        for (Item item : itemsRepository.testCastingInWhereClause((short) 5, 500L)) {
            rez = rez + item + " ";
        }
        return rez;
    }
}
