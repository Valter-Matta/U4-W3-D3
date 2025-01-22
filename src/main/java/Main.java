import DAO.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import persist.Evento;
import persist.Location;
import persist.Partecipazione;
import persist.Persona;

import java.time.LocalDate;

public class Main {
	public static void main (String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneEventiPU");
		EntityManager em = emf.createEntityManager();

		PersonaDAO personaDAO = new PersonaDAO(em);
		LocationDAO locationDAO = new LocationDAO(em);
		EventoDAO eventoDAO = new EventoDAO(em);
		PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

		try {
			em.getTransaction().begin();

			// Creazione di una Location
			Location location = new Location();
			location.setNome("Teatro");
			location.setCitta("Milano");
			locationDAO.save(location);

			// Creazione di una Persona
			Persona persona = new Persona();
			persona.setNome("Valter");
			persona.setCognome("oooo");
			persona.setEmail("ooosi@example.com");
			persona.setDataNascita(LocalDate.of(1985, 6, 15));
			persona.setSesso('M');
			personaDAO.save(persona);

			// Creazione di un Evento
			Evento evento = new Evento();
			evento.setTitolo("Concerto");
			evento.setDataEvento(LocalDate.of(2025, 5, 14));
			evento.setDescrizione("Marracash ");
			evento.setTipoEvento(Evento.TipoEvento.PUBBLICO);
			eventoDAO.save(evento);

			// Creazione di una Partecipazione
			Partecipazione partecipazione = new Partecipazione();
			partecipazione.setEvento(evento);
			partecipazione.setPersona(persona);
			partecipazione.setStato(Partecipazione.StatoPartecipazione.CONFERMATA);
			partecipazioneDAO.save(partecipazione);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

	}
}
