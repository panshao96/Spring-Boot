package com.imooc.girl.controller;


import com.imooc.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author panshao
 */
@RestController
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    @GetMapping(value = {"/say", "/hi"})
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "id: " + id;
    }
}
