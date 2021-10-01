package com.application.Tasks.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/demo")
    String demo() {
        return "demo";
    }
}
