package ejb_fatturaCrud;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ejb_connessioni.Iconnessioni;
import model.Elettronica;
import model.Fattura;

@Stateless
public class FatturaEJB implements Ifattura {
	
	@EJB
	Iconnessioni x;

	@Override
	public boolean inseriscifattura(Fattura fa) {
		EntityManager entitymanager=x.apriconnessione();
		try{
			entitymanager.persist(fa);
		}catch (Exception e) {
			return false;
		}
		x.chiudiconnessione(entitymanager);	
		return true;
	}
	@Override
	public List<Fattura> cercafatturaperId(Fattura fa) {
		EntityManager entitymanager=x.apriconnessione();
		TypedQuery<Fattura> query = entitymanager.createQuery("SELECT p FROM Fattura p WHERE p.id_scontrino LIKE :id_scontrino",Fattura.class)
				.setParameter("id_scontrino", fa.getId_scontrino());
		List<Fattura> lista = query.getResultList();
		x.chiudiconnessione(entitymanager);
		return lista;
	}

	@Override
	public List<Fattura> cercafatturaperIdUtente(Fattura fa) {
		EntityManager entitymanager=x.apriconnessione();
		TypedQuery<Fattura> query = entitymanager.createQuery("SELECT p FROM Fattura p WHERE p.id_account LIKE :id_account",Fattura.class)
				.setParameter("id_utente", fa.getAccount().getId());
		List<Fattura> lista = query.getResultList();
		x.chiudiconnessione(entitymanager);
		return lista;
	}

	@Override
	public void cancellafattura(Fattura fa) {
		EntityManager entitymanager=x.apriconnessione();
		entitymanager.remove(fa);
		x.chiudiconnessione(entitymanager);
	}

}
