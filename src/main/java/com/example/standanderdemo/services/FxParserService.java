package com.example.standanderdemo.services;

import com.example.standanderdemo.model.FxAdjustment;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FxParserService {
    public List<FxAdjustment> Parse(String csv){
        var instrumentUpdates = csv
                .lines()
                .map(x -> {
                    var items = x.split(",");
                    var stringArray = Arrays.stream(items).map(String::trim)
                            .toArray(String[]::new);
                    return stringArray;
                })
                .map(x -> new FxAdjustment(x[1], x[2], x[3], x[4]))
                .collect(Collectors.toList());
        return instrumentUpdates;
    }
}
