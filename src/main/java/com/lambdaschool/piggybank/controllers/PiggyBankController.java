package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.PiggybankApplication;
import com.lambdaschool.piggybank.model.PiggyBank;
import com.lambdaschool.piggybank.repositories.PiggyBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PiggyBankController {
  
  @Autowired
  private PiggyBankRepository piggyBankRepository;
  
  // http://localhost:2019/total
  @GetMapping(value = "/total", produces = "application/json")
  public ResponseEntity<?> getTotal() {
    List<PiggyBank> piggyBankList = new ArrayList<>();
    piggyBankRepository.findAll().iterator().forEachRemaining(e -> piggyBankList.add(e));
    
    double total = 0.0;
    
    for (PiggyBank e : piggyBankList) {
      total += e.getQuantity() * e.getValue();
      if (e.getQuantity() <= 1) {
        System.out.print(e.getQuantity() + " " +  e.getName() + "\n");
      }
      else {
        System.out.print(e.getQuantity() + " " + e.getNameplural() + "\n");
      }
    }
    System.out.println("The piggy bank holds: " + total);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
