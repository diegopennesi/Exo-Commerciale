package ejb_accountcrud;

import model.Account;
import modelDTO.AccountDTO;

public class AccountDTO_EJB implements IaccountDTO {

	@Override
	public Account DTOtoAccount(AccountDTO accountDTO) {
		Account a = new Account();
		a.setId_ruolo(accountDTO.getId_ruolo());
		a.setPassword(accountDTO.getPassword());
		a.setUsername(accountDTO.getUsername());
		a.setPortafoglio(accountDTO.getPortafoglio());
		return a;
	}

}
