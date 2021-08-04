package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.repository.ClientPhysiqueRepository;

@Service
public class ClientPotentielServiceImpl implements ClientPotentielService{

	@Autowired
	ClientPhysiqueRepository clientPhysiqueRep;

	public ClientPhysiqueRepository getClientPhysiqueRep() {
		return clientPhysiqueRep;
	}

	public void setClientPhysiqueRep(ClientPhysiqueRepository clientPhysiqueRep) {
		this.clientPhysiqueRep = clientPhysiqueRep;
	}
	
}
