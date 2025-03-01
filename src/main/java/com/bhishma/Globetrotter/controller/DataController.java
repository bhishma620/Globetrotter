package com.bhishma.Globetrotter.controller;


import com.bhishma.Globetrotter.entity.Destination;
import com.bhishma.Globetrotter.entity.Request;
import com.bhishma.Globetrotter.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping("/add")
    ResponseEntity<String> addData(@RequestBody Request destination){
           return dataService.addData(destination);
    }
}
