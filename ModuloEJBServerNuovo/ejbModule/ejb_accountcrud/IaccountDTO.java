package ejb_accountcrud;

import javax.ejb.Local;

import model.Account;
import modelDTO.AccountDTO;
@Local
public interface IaccountDTO {
	
	public Account DTOtoAccount(AccountDTO accountDTO);

}
