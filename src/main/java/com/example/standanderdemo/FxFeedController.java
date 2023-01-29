package com.example.standanderdemo;

import com.example.standanderdemo.model.InstrumentDto;
import com.example.standanderdemo.services.FxState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fx/feed")
public class FxFeedController {
    private FxState state;

    public FxFeedController(FxState state) {
        this.state = state;
    }

    @GetMapping("/all")
    public List<InstrumentDto> GetAll() {
        var collection = state.Instruments.values()
                .stream()
                .map(x -> new InstrumentDto(x.GetName(), x.GetBid(), x.GetAsk(), x.GetTimeStamp()))
                .toList();
        return collection;
    }

    @GetMapping
    public ResponseEntity<InstrumentDto> GetByName(@RequestParam String name) {
        var instrument = state.Instruments.values()
                .stream()
                .filter(x -> name.toLowerCase().equals(x.Name.toLowerCase()))
                .findFirst();
        if(instrument.isPresent()){
            return ResponseEntity.ok(instrument.get());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
