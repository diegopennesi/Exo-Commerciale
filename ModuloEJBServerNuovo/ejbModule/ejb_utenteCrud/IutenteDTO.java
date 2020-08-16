package ejb_utenteCrud;

import javax.ejb.Local;

import model.Utente;
import modelDTO.UtenteDTO;

@Local
public interface IutenteDTO {
	public UtenteDTO UtenteToDTO(Utente utente);
	public Utente DtoTOUtente(UtenteDTO utenteDTO);
}
