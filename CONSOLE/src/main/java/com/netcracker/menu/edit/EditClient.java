package com.netcracker.menu.edit;

import com.netcracker.menu.Menu;
import com.netcracker.menu.validator.ValidatorInstrumentsImpl;
import com.netcracker.menu.validator.ValidatorInstruments;
import com.netcracker.session.UserSession;
import com.netcracker.user.Client;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Scanner;

import static com.netcracker.menu.validator.ValidatorInstrumentsImpl.VALIDATOR_INSTRUMENTS;


@Slf4j
public class EditClient implements Menu {

  @Override
  public void preMessage(String parentsName) {
    log.info("Enter 1 {}", parentsName);
  }

  @Override
  public void run(Scanner in, String parentsName) throws IOException {
    this.preMessage(parentsName);
  }

  @SneakyThrows
  public Client run(Scanner in) throws IOException {
    Client client = UserSession.getCloneClientSession();
    log.info("Descriptions");
    if (VALIDATOR_INSTRUMENTS.edit(client.getDescription(), in)) {
      client.setDescription(VALIDATOR_INSTRUMENTS.validateDescription(in));
    }
    log.info("Name");
    if (VALIDATOR_INSTRUMENTS.edit(client.getName(), in)) {
      client.setName(VALIDATOR_INSTRUMENTS.validateNameUser(in));
    }
    log.info("Login");
    if (VALIDATOR_INSTRUMENTS.edit(client.getLogin(), in)) {
      client.setLogin(VALIDATOR_INSTRUMENTS.validateLogin(in));
    }
    log.info("Password");
    if (VALIDATOR_INSTRUMENTS.edit(client.getPassword(), in)) {
      client.setPassword(VALIDATOR_INSTRUMENTS.validatePassword(in));
    }
    log.info("Phone");
    if (VALIDATOR_INSTRUMENTS.edit(client.getPhone(), in)) {
      client.setPhone(VALIDATOR_INSTRUMENTS.validatePhone(in));
    }
    log.info("Email");
    if (VALIDATOR_INSTRUMENTS.edit(client.getEmail(), in)) {
      client.setPassword(VALIDATOR_INSTRUMENTS.validatePassword(in));
    }
    return client;
  }


  public Client run(Scanner in, String parentsName, Client client) throws IOException {
    log.info("Descriptions");
    if (VALIDATOR_INSTRUMENTS.edit(client.getDescription(), in)) {
      client.setDescription(VALIDATOR_INSTRUMENTS.validateDescription(in));
    }
    log.info("Name");
    if (VALIDATOR_INSTRUMENTS.edit(client.getName(), in)) {
      client.setName(VALIDATOR_INSTRUMENTS.validateNameUser(in));
    }
    log.info("Login");
    if (VALIDATOR_INSTRUMENTS.edit(client.getLogin(), in)) {
      client.setLogin(VALIDATOR_INSTRUMENTS.validateLogin(in));
    }
    log.info("Password");
    if (VALIDATOR_INSTRUMENTS.edit(client.getPassword(), in)) {
      client.setPassword(VALIDATOR_INSTRUMENTS.validatePassword(in));
    }
    log.info("Phone");
    if (VALIDATOR_INSTRUMENTS.edit(client.getPhone(), in)) {
      client.setPhone(VALIDATOR_INSTRUMENTS.validatePhone(in));
    }
    log.info("Email");
    if (VALIDATOR_INSTRUMENTS.edit(client.getEmail(), in)) {
      client.setPassword(VALIDATOR_INSTRUMENTS.validatePassword(in));
    }
    return client;
  }

}