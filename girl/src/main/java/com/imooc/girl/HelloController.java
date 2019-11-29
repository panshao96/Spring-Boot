package com.imooc.girl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value = "/hello", method = RequestMethod.GET)
public class HelloController {

   @Autowired
   private  GirlProperties girlProperties;

    @GetMapping(value = {"/say", "/hi"})
    public String say(@RequestParam(value = "id", required = false, defaultValue = "") Integer id) {
//        return "Hello Spring Boot!";
        return "id: " + id;
    }
}
