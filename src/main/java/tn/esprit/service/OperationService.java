package tn.esprit.service;

import java.util.List;

import tn.esprit.entity.Compte;
import tn.esprit.entity.Operation;

public interface OperationService {
	
	public boolean verser(int idCompte,int montant);
	public boolean retirer(int idCompte ,int montant);
	public boolean virement(int idCompte1,int idCompte2, int montant);
	public List<Operation> historique(int idCompte);
	/**********************************************************************************/
	public Compte consulterCompte(int idCompte);
	public List<Operation> getAllOperations();
	public Operation addOperation(Operation operation);
	public Operation updateOperation(int idOperation, Operation operation);
	public int deleteOperation(int idOperation);
	
}
