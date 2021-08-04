package tn.esprit.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entity.Compte;
import tn.esprit.entity.Facture;
import tn.esprit.repository.CompteRepository;
import tn.esprit.repository.FactureRepository;

@Service
public class FactureServiceImpl implements FactureService {

	@Autowired
	FactureRepository factureRep;

	@Autowired
	CompteRepository compteRep;

	public FactureRepository getFactureRep() {
		return factureRep;
	}

	public void setFactureRep(FactureRepository factureRep) {
		this.factureRep = factureRep;
	}
	@Override
	public boolean paiement(String refFacture, int idCompte) {
		Facture facture = factureRep.findByReference(refFacture);
		float montantapaye = facture.getMontantTTC();
		Compte cpt = compteRep.findById(idCompte).orElse(null);
		cpt.setSolde(cpt.getSolde() - montantapaye);
		compteRep.save(cpt);
		return compteRep.save(cpt) != null;
	}

	

}
