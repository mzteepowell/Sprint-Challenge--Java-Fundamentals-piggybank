package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.model.PiggyBank;

@FunctionalInterface
public interface QueryCoins {
  boolean test(PiggyBank piggyBank);
}
