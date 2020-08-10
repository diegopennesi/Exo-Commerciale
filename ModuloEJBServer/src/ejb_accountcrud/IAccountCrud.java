package ejb_accountcrud;

import javax.ejb.Local;

import model.Account;

@Local
public interface IAccountCrud {

	public Account getAccount(String username,String password);
	
}
