package com.netcracker.menu.edit;

import com.netcracker.menu.Menu;
import com.netcracker.menu.validator.ValidatorInstruments;
import com.netcracker.menu.validator.ValidatorInstrumentsImpl;
import com.netcracker.outfit.Outfit;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.netcracker.outfit.State;
import lombok.extern.slf4j.Slf4j;

import static com.netcracker.menu.validator.ValidatorInstrumentsImpl.VALIDATOR_INSTRUMENTS;

@Slf4j
public class EditOutfit implements Menu {


  @Override
  public void preMessage(String parentsName) {
    log.info("Enter 1 {}", parentsName);
  }


  @Override
  public void run(Scanner in, String parentsName) throws IOException {
    this.preMessage(parentsName);
  }

  public Outfit run(Scanner in, String parentsName, Outfit outfit) throws IOException {
    log.info("Descriptions");
    if (VALIDATOR_INSTRUMENTS.edit(outfit.getDescription(), in)) {
      outfit.setDescription(VALIDATOR_INSTRUMENTS.validateDescription(in));
    }
    log.info("Enter name outfit");
    if (VALIDATOR_INSTRUMENTS.edit(outfit.getName(), in)) {
      outfit.setName(VALIDATOR_INSTRUMENTS.validateNameOutfit(in));
    }
    log.info("Enter state outfit");
    if (VALIDATOR_INSTRUMENTS.edit(List.of(State.values()).stream()
            .filter(z -> z.getId().equals(outfit.getStateOutfit())).findFirst().get().name(),
        in)) {
      outfit.setStateOutfit(VALIDATOR_INSTRUMENTS.stateOutfit(in));
    }
    log.info("Enter price outfit");
    if (VALIDATOR_INSTRUMENTS.edit(String.valueOf(outfit.getPrice()), in)) {
      outfit.setPrice(VALIDATOR_INSTRUMENTS.validatePrice(in));
    }
    return outfit;
  }
}