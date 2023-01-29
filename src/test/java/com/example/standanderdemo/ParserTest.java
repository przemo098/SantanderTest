package com.example.standanderdemo;

import com.example.standanderdemo.services.FxParserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ParserTest {
    @Test
    void ParserTest() {
        var csv = "106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001\n" +
                "107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002";
        var parser = new FxParserService();

        var result = parser.Parse(csv);
        assertThat(result.get(0).GetName()).isEqualTo("EUR/USD");
        assertThat(result.get(0).GetBid()).isEqualByComparingTo(BigDecimal.valueOf(1.089000));
        assertThat(result.get(0).GetAsk()).isEqualByComparingTo(BigDecimal.valueOf(1.212));
        assertThat(result.get(0).GetTimeStamp()).isEqualTo(Timestamp.valueOf("2020-06-01 12:01:01.001"));

        assertThat(result.get(1).GetName()).isEqualTo("EUR/JPY");
        assertThat(result.get(1).GetBid()).isEqualByComparingTo(BigDecimal.valueOf(118.4040));
        assertThat(result.get(1).GetAsk()).isEqualByComparingTo(BigDecimal.valueOf(121.0990));
        assertThat(result.get(1).GetTimeStamp()).isEqualTo(Timestamp.valueOf("2020-06-01 12:01:02.002"));
    }
}


