package com.example.standanderdemo;

import com.example.standanderdemo.model.FxAdjustment;
import com.example.standanderdemo.services.FxManagerService;
import com.example.standanderdemo.services.FxState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FxManagerServiceTest {
    @Autowired
    private FxManagerService fxManagerService;
    @Autowired
    private FxState fxState;

    @Test
    void ParserTest() {
        var someTime = "01-06-2020 12:01:01:001";
        List<FxAdjustment> newItems = Arrays.asList(new FxAdjustment("Test", "1", "1", someTime),
                new FxAdjustment("Test2", "2", "2", someTime));
        fxManagerService.Update(newItems);
        assertThat(fxState.Instruments.size()).isEqualTo(2);

        var someTimeLater = "01-06-2020 12:01:01:002";
        List<FxAdjustment> nextNewItems = Arrays.asList(new FxAdjustment("Test", "1", "1", someTimeLater),
                new FxAdjustment("Test3", "2", "2", someTimeLater));
        fxManagerService.Update(nextNewItems);
        assertThat(fxState.Instruments.size()).isEqualTo(3);
    }
}
