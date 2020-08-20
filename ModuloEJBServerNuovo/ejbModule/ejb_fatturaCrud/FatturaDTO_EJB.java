package ejb_fatturaCrud;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ejb_accountcrud.IAccountCrud;
import ejb_repartiCrud.Ireparti;
import model.Fattura;
import modelDTO.FatturaDTO;

@Stateless
public class FatturaDTO_EJB implements IfatturaDTO {
	@EJB
	IAccountCrud x;
	@EJB
	Ireparti y;
	
	@Override
	public FatturaDTO FatturaToDTO(Fattura Fattura) {
		
		return null;
	}

	@Override
	public Fattura DtoTOFattura(FatturaDTO FatturaDTO) {
		Fattura fa= new Fattura();
		fa.setId(FatturaDTO.getId());
		fa.setId_scontrino(FatturaDTO.getId_scontrino());
		fa.setDescrizione(FatturaDTO.getDescrizione());
		fa.setIva(FatturaDTO.getIva());
		fa.setPrezzo(FatturaDTO.getPrezzo());
		fa.setQuantita(FatturaDTO.getQuantita());
		fa.setAccount(x.getAccountById(FatturaDTO.getAccount()));
		fa.setReparti(y.prendiRepartiperID(FatturaDTO.getReparti()));
		return fa;
	}


}
