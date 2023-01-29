package com.example.standanderdemo.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Instrument {
    static BigDecimal BidMargin = BigDecimal.valueOf(0.99);
    static BigDecimal AskMargin = BigDecimal.valueOf(1.01);

    public Instrument(String name, String bid, String ask, String timeStamp) {
        Id = UUID.randomUUID();
        Name = name;
        setBidValue(new BigDecimal(bid));
        setAskValue(new BigDecimal(ask));
        String pattern = "dd-MM-yyyy HH:mm:ss:SSS";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(timeStamp));
        TimeStamp = Timestamp.valueOf(localDateTime);
    }

    private void setBidValue(BigDecimal value){
        Bid = value.multiply(BidMargin);
    }

    private void setAskValue(BigDecimal value){
        Ask = value.multiply(BidMargin);
    }

    public void Adjust(FxAdjustment newValues){
        if(newValues.TimeStamp.after(this.TimeStamp)){
            setBidValue(newValues.Bid);
            setAskValue(newValues.Ask);
            TimeStamp = newValues.TimeStamp;
        }
    }

    UUID Id;
    String Name;
    BigDecimal Bid;
    BigDecimal Ask;
    Timestamp TimeStamp;

    public String GetName() {
        return Name;
    }
    public BigDecimal GetBid() { return Bid; }
    public BigDecimal GetAsk() { return Ask; }
    public Timestamp GetTimeStamp() { return TimeStamp; }
}
