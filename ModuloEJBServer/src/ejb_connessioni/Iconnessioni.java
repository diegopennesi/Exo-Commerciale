package ejb_connessioni;

import javax.ejb.Local;
import javax.persistence.EntityManager;
@Local
public interface Iconnessioni {
	
	public EntityManager apriconnessione();
	public void chiudiconnessione(EntityManager entitymanager);

}
