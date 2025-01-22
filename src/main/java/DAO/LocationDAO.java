package DAO;

import jakarta.persistence.EntityManager;
import persist.Location;

public class LocationDAO extends GenericDAO<Location> {
	public LocationDAO (EntityManager entityManager) {
		super(entityManager);
	}
}
