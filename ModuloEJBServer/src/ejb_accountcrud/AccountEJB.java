package ejb_accountcrud;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ejb_connessioni.Iconnessioni;
import model.Account;

@Stateless
public class AccountEJB implements IAccountCrud {

	@EJB
	Iconnessioni x;
	
	@Override
	public Account getAccount(String username,String password) {
		EntityManager entityManager=x.apriconnessione();
		try {
			
		Account account= (Account)  entityManager.createQuery("select a from Account a where a.username=:username and a.password=:password",Account.class)
				.setParameter("username", username).setParameter("password", password);
				
		return account;
		}catch (NoResultException e) {
			return null;
		}
	}

}
