package ejb_fatturaCrud;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ejb_connessioni.Iconnessioni;
import ejb_repartiCrud.Ireparti;
import model.Account;
import model.Fattura;
import model.Reparti;
import modelDTO.FatturaDTO;

@Stateless
public class FatturaEJB implements Ifattura {
	@EJB
	IfatturaDTO z;
	@EJB
	Iconnessioni x;
	@EJB
	Ireparti y;

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
	public List<Fattura> cercafatturaperIdUtente(Account a) {
		EntityManager entitymanager=x.apriconnessione();
		TypedQuery<Fattura> query = entitymanager.createQuery("SELECT p FROM Fattura p WHERE p.id_account LIKE :id_account",Fattura.class)
				.setParameter("id_utente", a.getId());
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
	@Override
	public List<Fattura> cercafatturaperReparto(int reparto) {
		Reparti rep= new Reparti();
		rep.setId(reparto);
		EntityManager entitymanager=x.apriconnessione();
		TypedQuery<FatturaDTO> query = entitymanager.createQuery("SELECT p FROM Fattura p WHERE p.id_reparto LIKE :id_reparto",FatturaDTO.class)
				.setParameter("id_reparto",reparto);
		List<FatturaDTO> lista = query.getResultList();
		List<Fattura> listafattura = new ArrayList<Fattura>();
		for(FatturaDTO o:lista) {
		Fattura temp=z.DtoTOFattura(o);
		listafattura.add(temp);
		}
		x.chiudiconnessione(entitymanager);
		return listafattura;
	}
//	@Override
//	public void inseriscifatturareparti(Fattura fa, Reparti rp) {
//		EntityManager entitymanager=x.apriconnessione();
//		 fa.getListaReparti().add(rp);
//		
//	}

}
