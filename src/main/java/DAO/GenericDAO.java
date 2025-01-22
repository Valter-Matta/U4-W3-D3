package DAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class GenericDAO<T> {
	private EntityManager em;

	public GenericDAO(EntityManager em) {
		this.em = em;
	}

	public void save(T entity) {
		EntityTransaction transaction = em.getTransaction();
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			em.persist(entity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}
}
