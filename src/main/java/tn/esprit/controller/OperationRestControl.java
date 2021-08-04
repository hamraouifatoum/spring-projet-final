package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entity.Compte;
import tn.esprit.entity.Operation;
import tn.esprit.service.CompteService;
import tn.esprit.service.OperationService;

@RestController
public class OperationRestControl {

	@Autowired
	OperationService operationService;

	@Autowired
	CompteService compteservice;

	@GetMapping("/get-compte-by-id/{idCompte}")
	@ResponseBody
	public Compte getCompte(@PathVariable("idCompte") int idCompte) {
		return operationService.consulterCompte(idCompte);
	}

	@ResponseBody
	@PutMapping(value = "/retirer/{idCompte}/{montant}")
	public boolean retrait(@PathVariable("idCompte") int idCompte, @PathVariable("montant") int montant) {
		return operationService.retirer(idCompte, montant);
	}

	@PutMapping(value = "/verser/{idCompte}/{montant}")
	public boolean versement(@PathVariable("idCompte") int idCompte, @PathVariable("montant") int montant) {
		return operationService.verser(idCompte, montant);
	}

	@PutMapping(value = "/virement/{idCompte1}/{idCompte2}/{montant}")
	public boolean virement(@PathVariable("idCompte1") int idCompte1, @PathVariable("idCompte2") int idCompte2,
			@PathVariable("montant") int montant) {
		return operationService.virement(idCompte1, idCompte2, montant);
	}

	@GetMapping("/historique/{idCompte}")
	public List<Operation> historique(@PathVariable("idCompte") int idCompte) {
		return operationService.historique(idCompte);
	}

	public OperationService getOperationServ() {
		return operationService;
	}

	public void setOperationServ(OperationService operationServ) {
		this.operationService = operationServ;
	}

	@GetMapping("/get-all-operations")
	public List<Operation> operation() {
		return operationService.getAllOperations();
	}

	@PostMapping("/add-operation")
	public Operation addOperation(@RequestBody Operation operation) {
		return operationService.addOperation(operation);
	}

	@PutMapping(value = "/update-operation/{idOperation}")
	public Operation updateOperation(@PathVariable("idOperation") int idOperation, @RequestBody Operation operation) {
		return operationService.updateOperation(idOperation, operation);
	}

	@DeleteMapping(value = "/delete-operation/{idOperation}")
	public int deleteOperation(@PathVariable("idOperation") int idOperation) {
		return operationService.deleteOperation(idOperation);
	}
}
