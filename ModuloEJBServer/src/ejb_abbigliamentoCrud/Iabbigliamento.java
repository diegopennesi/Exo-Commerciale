package ejb_abbigliamentoCrud;

import javax.ejb.Local;
import model.Abbigliamento;
import model.BollaacquistoAbbigliamento;

@Local
public interface Iabbigliamento {
	
	 public boolean inserisciabbigliamento(Abbigliamento ab);
	 public void cancellaabbigliamento(Abbigliamento ab);
	 public void modificaabbigliamento(Abbigliamento ab);
	 public Abbigliamento cercaabbigliamentoperid(Abbigliamento ab);
	 public void inseriscibolla(BollaacquistoAbbigliamento bolla);
}
