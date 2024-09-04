package com.trendy.config.seguridad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "No security here";
    }

    @GetMapping("/test-secured")
    public String testSecured(){
        return "THERE is security here";
    }

}
