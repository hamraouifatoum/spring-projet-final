package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.service.FactureService;

@RestController
public class FactureRestControl {

	@Autowired
	FactureService factureServ;

	@PutMapping("/paiement-facture/{refFacture}/{idCompte}")
	public boolean paimentFacture(@PathVariable("refFacture") String refFacture,
			@PathVariable("idCompte") int idCompte) {
		return factureServ.paiement(refFacture, idCompte);
	}
	
	public FactureService getFactureServ() {
		return factureServ;
	}

	public void setFactureServ(FactureService factureServ) {
		this.factureServ = factureServ;
	}

}
