package tn.esprit.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entity.Compte;
import tn.esprit.repository.CompteRepository;

@Service
public class CompteServiceImpl implements CompteService{

	@Autowired
	CompteRepository compteRep;

	public CompteRepository getCompteRep() {
		return compteRep;
	}

	public void setCompteRep(CompteRepository compteRep) {
		this.compteRep = compteRep;
	}

	@Override
	public Compte addCompte(Compte c, Long idAgence, Long code_client) {
		c.setDatOuverture(new Date());
		compteRep.save(c);
		return null;
	}

}
