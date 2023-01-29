package com.example.standanderdemo.model;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Instrument extends InstrumentDto {
    static BigDecimal BidMargin = BigDecimal.valueOf(0.99);
    static BigDecimal AskMargin = BigDecimal.valueOf(1.01);

    public Instrument(String name, String bid, String ask, String timeStampString) {
        super(name, getBidValue(new BigDecimal(bid)), getAskValue(new BigDecimal(ask)), getTimeStamp(timeStampString));
    }

    private void setBidValue(BigDecimal value){
        Bid = value.multiply(BidMargin);
    }
    static private BigDecimal getBidValue(BigDecimal value){
        return value.multiply(BidMargin);
    }
   static private Timestamp getTimeStamp(String value){
       String pattern = "dd-MM-yyyy HH:mm:ss:SSS";
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
       LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(value));
       return Timestamp.valueOf(localDateTime);
    }

    private void setAskValue(BigDecimal value){
        Ask = value.multiply(BidMargin);
    }
    static private BigDecimal getAskValue(BigDecimal value){
        return value.multiply(AskMargin);
    }

    public void Adjust(FxAdjustment newValues){
        if(newValues.TimeStamp.after(this.TimeStamp)){
            setBidValue(newValues.Bid);
            setAskValue(newValues.Ask);
            TimeStamp = newValues.TimeStamp;
        }
    }

    public String GetName() {
        return Name;
    }
    public BigDecimal GetBid() { return Bid; }
    public BigDecimal GetAsk() { return Ask; }
    public Timestamp GetTimeStamp() { return TimeStamp; }
}
