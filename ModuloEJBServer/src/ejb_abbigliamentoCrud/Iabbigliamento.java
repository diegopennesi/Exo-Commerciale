package ejb_abbigliamentoCrud;

import java.util.List;

import javax.ejb.Local;

import model.Abbigliamento;

@Local
public interface Iabbigliamento {
	
	 public boolean inserisciabbigliamento(Abbigliamento ab);
	 public void cancellaabbigliamento(Abbigliamento ab);
	 public void modificaabbigliamento(Abbigliamento ab);
	 public Abbigliamento cercaabbigliamentoperid(Abbigliamento ab);
	 // ?
}
