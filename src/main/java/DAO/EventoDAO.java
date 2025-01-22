package DAO;

import jakarta.persistence.EntityManager;

import persist.Evento;

public class EventoDAO extends GenericDAO<Evento> {


	public EventoDAO (EntityManager entityManager) {
		super(entityManager);

	}


}

