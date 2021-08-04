package tn.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {
	
	@Query("select o from Operation o where o.compte.numCompte=:numCompte order by o.dateOperation desc")
	public List<Operation> listOperation(@Param("numCompte") Long numCompte);
}
