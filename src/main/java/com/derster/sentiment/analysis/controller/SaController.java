package com.derster.sentiment.analysis.controller;

import com.derster.sentiment.analysis.entity.Sa;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/sa", produces = MediaType.APPLICATION_JSON_VALUE)
public class SaController {

    @GetMapping
    public List<Sa> search(){
        return List.of(
                new Sa(1, "Record Message", 0),
                new Sa(2, "Record Message 2", 1)
        );
    }
}
