package ejb_abbigliamentoCrud;

import java.util.List;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ejb_connessioni.Iconnessioni;
import model.Abbigliamento;

@Stateless
public class AbbigliamentoEJB implements Iabbigliamento {
	
	@EJB
	Iconnessioni x;

	@Override
	public boolean inserisciabbigliamento(Abbigliamento ab) {
		EntityManager entitymanager=x.apriconnessione();
		try{
			entitymanager.persist(ab);
		}catch (Exception e) {
			return false;
		}
		x.chiudiconnessione(entitymanager);	
		return true;
	}
	@Override
	public void cancellaabbigliamento(Utente ab) {
		EntityManager entitymanager=x.apriconnessione();
		entitymanager.remove(ab);
		x.chiudiconnessione(entitymanager);
	}
	@Override
	public void modificabbigliamento(Abbigliamento ab) {
		EntityManager entitymanager=x.apriconnessione();
		Abbigliamento temp=entitymanager.find(Abbigliamento.class, ab.getId());
		temp.setNome(ab.getNome());
		temp.setDescrizione(ab.getDescrizione());
		temp.setPrezzo(ab.getPrezzo());
		temp.setTaglia(ab.getTaglia());
		temp.setColore(ab.getColore());
		temp.setQuantita(ab.getQuantita());
		temp.setReparti(ab.getReparti());
		x.chiudiconnessione(entitymanager);
	}
	@Override
	public Utente cercaabbigliamentoperid(Abbigliamento ab) {
		EntityManager entitymanager=x.apriconnessione();
		Abbigliamento temp=entitymanager.find(Abbigliamento.class, ab.getId());
		return temp;
	}

}
