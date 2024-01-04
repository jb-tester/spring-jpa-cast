package com.mytests.spring.springJpaCast.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class UuidEntity {
    @Id
    private UUID id;

    String foo;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public UuidEntity(UUID id, String foo) {
        this.id = id;
        this.foo = foo;
    }

    public UuidEntity() {
    }

    @Override
    public String toString() {
        return "UuidEntity{" +
               "id=" + id +
               ", foo='" + foo + '\'' +
               '}';
    }
}
