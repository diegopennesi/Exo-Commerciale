package ejb_bollaCrud;

import java.util.List;

import javax.ejb.Local;

import model.BollaacquistoAbbigliamento;
import model.BollaacquistoAlimenti;
import model.BollaacquistoElettronica;


@Local
public interface Ibolla {
	public List<BollaacquistoAlimenti> prendiListaBolleAlimenti();
	public List<BollaacquistoAbbigliamento> prendiListaBolleAbbigliamento();
	public List<BollaacquistoElettronica> prendiListaBolleElettronica();
}
