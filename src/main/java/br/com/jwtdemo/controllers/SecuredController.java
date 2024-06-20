package br.com.jwtdemo.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/secured")
public class SecuredController {

    @GetMapping
    public ResponseEntity<Void> security() {
        return ResponseEntity.ok().build();
    }

}