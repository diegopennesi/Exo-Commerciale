package ejb_repartiCrud;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import ejb_connessioni.Iconnessioni;
import model.Reparti;

@Stateless
public class RepartiEJB implements Ireparti{
	@EJB
	Iconnessioni x;;
	
	
	@Override
	public List<Reparti> prendiReparti() {
		EntityManager entitymanager=x.apriconnessione();
		TypedQuery<Reparti> query =entitymanager.createQuery("SELECT c FROM Reparti c", Reparti.class);
		List<Reparti> list= query.getResultList();
		return list;
	}
	@Override
	public Reparti prendiRepartiperID(int id) {
		EntityManager entitymanager=x.apriconnessione();
		Reparti temp=entitymanager.find(Reparti.class, id);
		return temp;
	}
}
