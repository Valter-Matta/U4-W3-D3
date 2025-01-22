package DAO;

import jakarta.persistence.EntityManager;
import persist.Persona;

public class PersonaDAO extends GenericDAO<Persona> {

	public PersonaDAO (EntityManager entityManager) {
		super(entityManager);
	}
}
