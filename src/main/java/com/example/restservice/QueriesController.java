package com.example.restservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ServiceUnavailableException;

@RestController
public class QueriesController {

    Queries query1 = new Queries();

    @PostMapping("/consume")
    public Map<String, Integer> query(@RequestParam(value = "value") int value) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        query1.add(value);
        map.put("total", query1.getTotal());
        map.put("remaining", query1.getRemaining());
        if(query1.getExcess() > 0){
            map.clear();
            map.put("excess", query1.getExcess());
            System.out.println("excess: " + query1.getExcess());
            throw new Exception();
        }
        return map;
    }

/*    @GetMapping("/consume")
    public Queries query(){
        return new Queries();
    }*/
}
