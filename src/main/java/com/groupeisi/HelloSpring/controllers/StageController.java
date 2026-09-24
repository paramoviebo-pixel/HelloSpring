package com.groupeisi.HelloSpring.controllers;

import com.groupeisi.HelloSpring.entities.Etudiant;
import com.groupeisi.HelloSpring.entities.Stage;
import com.groupeisi.HelloSpring.services.EtudiantService;
import com.groupeisi.HelloSpring.services.StageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/stages")
public class StageController {

    private final StageService stageService;


    @GetMapping
    private List<Stage> getAllEtudiants() {
        return stageService.findAll();
    }


}
