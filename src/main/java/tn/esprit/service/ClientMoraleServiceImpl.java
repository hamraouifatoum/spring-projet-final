package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.repository.ClientMoraleRepository;

@Service
public class ClientMoraleServiceImpl implements ClientMoraleService{

	@Autowired
	ClientMoraleRepository clientMoraleRep;

	public ClientMoraleRepository getClientMoraleRep() {
		return clientMoraleRep;
	}

	public void setClientMoraleRep(ClientMoraleRepository clientMoraleRep) {
		this.clientMoraleRep = clientMoraleRep;
	}
	
}
