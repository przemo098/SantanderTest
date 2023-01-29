package com.example.standanderdemo;
import com.example.standanderdemo.services.FxManagerService;
import com.example.standanderdemo.services.FxParserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("fx/subscriber")
public class FxSubscriberController {
    private final FxManagerService manager;
    private final FxParserService parser;

    public FxSubscriberController(FxManagerService manager, FxParserService parser) {
        this.manager = manager;
        this.parser = parser;
    }

    @PostMapping("/update")
    public String OnMessage(@RequestBody String update) {
        var instrumentUpdates = parser.Parse(update);
        manager.updates(instrumentUpdates);
        return "Success";
    }
}