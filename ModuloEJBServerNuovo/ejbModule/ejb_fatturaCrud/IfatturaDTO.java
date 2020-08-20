package ejb_fatturaCrud;

import javax.ejb.Local;
import model.Fattura;

import modelDTO.FatturaDTO;

@Local
public interface IfatturaDTO {
		public FatturaDTO FatturaToDTO(Fattura Fattura);
		public Fattura DtoTOFattura(FatturaDTO FatturaDTO);
	


}
