package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.service.ClientPotentielService;

@RestController
public class ClientPotentielRestControl {
	
	@Autowired
	ClientPotentielService clientPotentielServ;

	public ClientPotentielService getClientPotentielServ() {
		return clientPotentielServ;
	}

	public void setClientPotentielServ(ClientPotentielService clientPotentielServ) {
		this.clientPotentielServ = clientPotentielServ;
	}

}
