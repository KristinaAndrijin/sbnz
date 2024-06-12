package com.ftn.sbnz.backward.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.backward.service.services.ActivateBackwardRulesService;
import com.ftn.sbnz.backward.service.services.ForwardService;

import com.ftn.sbnz.backward.model.models.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/forward")
public class ForwardController {

    private ForwardService service;

  @Autowired
  public ForwardController(ForwardService _service) {
    this.service = _service;
  }

    @GetMapping("/methods")
    public ResponseEntity<List<LearningMethod>> getMethods() {
        List<LearningMethod> methods = service.getMethods(true);
        return ResponseEntity.ok(methods);
    }

    @GetMapping("/methods/forward1")
    public ResponseEntity<List<LearningMethod>> getMethods1() {
        List<LearningMethod> methods = service.getMethods(true);
        return ResponseEntity.ok(methods);
    }

    @GetMapping("/methods/forward2")
    public ResponseEntity<List<LearningMethod>> getMethods2() {
        List<LearningMethod> methods = service.getMethods(false);
        return ResponseEntity.ok(methods);
    }

}
