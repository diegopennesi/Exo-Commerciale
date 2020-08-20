package modelDTO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




public class FatturaDTO implements Serializable {

	private static final long serialVersionUID = -8681542817567967986L;

	private int id;
	private int id_scontrino;
	private String descrizione;
	private int quantita;
	private int account;
	private double prezzo;
	private int iva;
	private int reparti;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_scontrino() {
		return id_scontrino;
	}
	public void setId_scontrino(int id_scontrino) {
		this.id_scontrino = id_scontrino;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getReparti() {
		return reparti;
	}
	public void setReparti(int reparti) {
		this.reparti = reparti;
	}
	public FatturaDTO(int id_scontrino, String descrizione, int quantita, int account, double prezzo, int iva,
			int reparti) {
		super();
		this.id_scontrino = id_scontrino;
		this.descrizione = descrizione;
		this.quantita = quantita;
		this.account = account;
		this.prezzo = prezzo;
		this.iva = iva;
		this.reparti = reparti;
	}
	
	
}
