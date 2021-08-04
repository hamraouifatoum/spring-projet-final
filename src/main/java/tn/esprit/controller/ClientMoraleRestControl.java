package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.service.ClientMoraleService;

@RestController
public class ClientMoraleRestControl {

	@Autowired
	ClientMoraleService clientMoraleServ;

	public ClientMoraleService getClientMoraleServ() {
		return clientMoraleServ;
	}

	public void setClientMoraleServ(ClientMoraleService clientMoraleServ) {
		this.clientMoraleServ = clientMoraleServ;
	}

}
