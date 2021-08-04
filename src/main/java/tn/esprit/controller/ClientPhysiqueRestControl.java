package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.service.ClientPhysiqueService;

@RestController
public class ClientPhysiqueRestControl {

	@Autowired
	ClientPhysiqueService clientPhysiqueServ;

	public ClientPhysiqueService getClientPhysiqueServ() {
		return clientPhysiqueServ;
	}

	public void setClientPhysiqueServ(ClientPhysiqueService clientPhysiqueServ) {
		this.clientPhysiqueServ = clientPhysiqueServ;
	}

}
