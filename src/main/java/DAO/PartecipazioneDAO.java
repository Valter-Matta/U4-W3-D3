package DAO;

import jakarta.persistence.EntityManager;
import persist.Partecipazione;

public class PartecipazioneDAO extends GenericDAO<Partecipazione> {
	public PartecipazioneDAO (EntityManager entityManager) {
		super(entityManager);
	}
}
