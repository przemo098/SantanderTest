package com.example.standanderdemo.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public class InstrumentDto {
    public InstrumentDto(String name, BigDecimal bid, BigDecimal ask, Timestamp timeStamp) {
        Id = UUID.randomUUID();
        Name = name;
        Bid = bid;
        Ask = ask;
        TimeStamp = timeStamp;
    }
    public UUID Id;
    public String Name;
    public BigDecimal Bid;
    public BigDecimal Ask;
    public Timestamp TimeStamp;
}
