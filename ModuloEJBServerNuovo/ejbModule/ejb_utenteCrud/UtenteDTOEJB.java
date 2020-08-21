package ejb_utenteCrud;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import ejb_accountcrud.IAccountCrud;
import model.Utente;
import modelDTO.UtenteDTO;

@Stateless
public class UtenteDTOEJB implements IutenteDTO {
	@EJB
	IAccountCrud x;

	@Override//non so se può servire
	public UtenteDTO UtenteToDTO(Utente utente) {
		UtenteDTO ut_DTO = new UtenteDTO();
		ut_DTO.setId(utente.getId());
		ut_DTO.setNome(utente.getNome());
		ut_DTO.setCognome(utente.getCognome());
		ut_DTO.setIndirizzo(utente.getIndirizzo());
		ut_DTO.setId_account(utente.getAccount().getId());
		return ut_DTO;
	}

	@Override//il client creerà un oggetto uteteDTO in uscita
	public Utente DtoTOUtente(UtenteDTO utenteDTO) {
		Utente ut = new Utente();
		ut.setNome(utenteDTO.getNome());
		ut.setCognome(utenteDTO.getCognome());
		ut.setIndirizzo(utenteDTO.getIndirizzo());
		ut.setAccount(x.getAccountById(utenteDTO.getId_account()));
		return ut;
	}
	
}
