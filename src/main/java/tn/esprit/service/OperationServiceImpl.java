package tn.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tn.esprit.entity.Compte;

import tn.esprit.service.OperationService;

import tn.esprit.entity.NatureOperation;

import tn.esprit.entity.Operation;

import tn.esprit.entity.TypeOperation;

import tn.esprit.repository.CompteRepository;

import tn.esprit.repository.OperationRepository;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired

	private CompteRepository compteRepository;

	@Autowired

	private OperationRepository operationRepository;

	@Override
	public Compte consulterCompte(int idCompte) {
		return compteRepository.findById(idCompte).orElse(null);
	}

	@Override
	@Transactional
	public boolean verser(int idCompte, int montant) {
		Compte cp = compteRepository.findById(idCompte).orElse(null);
		Operation op = new Operation("REF 120", montant, TypeOperation.VERSEMENTS, NatureOperation.CREDITAIRE);
		op.setCompte(cp);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);
		operationRepository.save(op);
		if (compteRepository.save(cp) != null)
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean retirer(int idCompte, int montant) {
		Compte cp = compteRepository.findById(idCompte).orElse(null);
		Operation op = new Operation("REF 120", montant, TypeOperation.RETRAIT, NatureOperation.DEBITAIRE);
		op.setCompte(cp);
		cp.setSolde(cp.getSolde() - montant);
		compteRepository.save(cp);
		operationRepository.save(op);
		if (compteRepository.save(cp) != null)
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean virement(int idCompte1, int idCompte2, int montant) {
		Compte cp1 = compteRepository.findById(idCompte1).orElse(null);
		Compte cp2 = compteRepository.findById(idCompte2).orElse(null);

		cp1.setSolde(cp1.getSolde() - montant);
		cp2.setSolde(cp2.getSolde() + montant);

		if (compteRepository.save(cp1) != null && compteRepository.save(cp2) != null) {
			Operation op1 = new Operation("REF 120", montant, TypeOperation.VIREMENT, NatureOperation.DEBITAIRE);
			op1.setCompte(cp1);
			Operation op2 = new Operation("REF 120", montant, TypeOperation.VIREMENT, NatureOperation.CREDITAIRE);
			op2.setCompte(cp2);
			operationRepository.save(op1);
			operationRepository.save(op2);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public List<Operation> historique(int idCompte) {
		Compte cp = compteRepository.findById(idCompte).orElse(null);
		List<Operation> listOperation = operationRepository.listOperation(cp.getNumCompte());
		return listOperation;
	}

	@Override
	public List<Operation> getAllOperations() {
		   return operationRepository.findAll();
	}

	@Override
	public Operation addOperation(Operation operation) {
		return operationRepository.save(operation);
	}

	@Override
	public Operation updateOperation(int idOperation, Operation operation) {
		operation.setId(idOperation);
		return operationRepository.save(operation); 
	}

	@Override
	public int deleteOperation(int idOperation) {	
		operationRepository.deleteById(idOperation);
		return idOperation;
	}

}
