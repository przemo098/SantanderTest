package com.example.standanderdemo.model;
import java.util.UUID;

public class DupaDto {
    public UUID getId() {
        return Id;
    }

    public DupaDto setId(UUID id) {
        Id = id;
        return this;
    }

    UUID Id;
}
