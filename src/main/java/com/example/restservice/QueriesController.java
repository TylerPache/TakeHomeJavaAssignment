package com.example.restservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
            throw new ResponseStatusException(HttpStatusCode.valueOf(503),"\"excess\": " + query1.getExcess());
        }
        return map;
    }

    @GetMapping("/consume")
    public Map<String, Integer> query(){
        Map<String, Integer> map = new HashMap<>();
        map.put("total", query1.getTotal());
        map.put("remaining", query1.getRemaining());
        return map;
    }

    @PostMapping("/reset")
    public Map<String, Integer> queryReset() {
        Map<String, Integer> map = new HashMap<>();
        query1.reset();
        map.put("total", query1.getTotal());
        map.put("remaining", query1.getRemaining());
        return map;
    }

}
