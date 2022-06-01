package com.netcracker.menu.edit;


import com.netcracker.marka.CarClient;
import com.netcracker.menu.Menu;
import com.netcracker.menu.validator.ValidatorInstrumentsImpl;
import com.netcracker.menu.validator.ValidatorInstruments;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Scanner;

import static com.netcracker.menu.validator.ValidatorInstrumentsImpl.VALIDATOR_INSTRUMENTS;

@Slf4j
public class EditCar implements Menu {

  @Override
  public void preMessage(String parentsName) {
    log.info("Enter 1 {}", parentsName);
  }

  @Override
  public void run(Scanner in, String parentsName) throws IOException {
    this.preMessage(parentsName);
  }

  public CarClient run(Scanner in, String parentsName, CarClient carClient) throws IOException {
    log.info("Descriptions");
    if (VALIDATOR_INSTRUMENTS.edit(carClient.getSummary(), in)) {
      carClient.setSummary(VALIDATOR_INSTRUMENTS.validateDescription(in));
    }
    log.info("Enter vehicle mileage");
    if (VALIDATOR_INSTRUMENTS.edit(carClient.getRun(), in)) {
      carClient.setRun(VALIDATOR_INSTRUMENTS.validateMileage(in));
    }
    log.info("Enter year of car");
    if (VALIDATOR_INSTRUMENTS.edit(carClient.getEar(), in)) {
      carClient.setEar(VALIDATOR_INSTRUMENTS.validateYear(in));
    }
    log.info("Enter number of the car");
    if (VALIDATOR_INSTRUMENTS.edit(carClient.getMetadataCar(), in)) {
      carClient.setMetadataCar(VALIDATOR_INSTRUMENTS.validateNumberCar(in));
    }
    return carClient;
  }

}