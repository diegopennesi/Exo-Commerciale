package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="fatture")
public class Fattura implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8681542817567967986L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="id_scontrino",nullable=false)
	private int id_scontrino;
	@Column(name="descrizione")
	private String descrizione;
	@Column(name="quantita")
	private int quantita;
	@ManyToOne
	@JoinColumn(name="id_account")
	private Account account;
	@Column(name="prezzo")
	private double prezzo;
	@Column(name="iva")
	private int iva;
	@ManyToOne
	@JoinColumn(name="Id_reparto")
	private Reparti reparti;
	

	 public Fattura() {
		 
	 }
	public Fattura(int id_scontrino, String descrizione, int quantita, Account account, double prezzo, int iva,
			Reparti reparti) {
		super();
		this.id_scontrino = id_scontrino;
		this.descrizione = descrizione;
		this.quantita = quantita;
		this.account = account;
		this.prezzo = prezzo;
		this.iva = iva;
		this.reparti = reparti;
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
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Reparti getReparti() {
		return reparti;
	}
	public void setReparti(Reparti reparti) {
		this.reparti = reparti;
	}
	@Override
	public String toString() {
		return "Fattura [id_scontrino=" + id_scontrino + ", descrizione=" + descrizione + ", quantita=" + quantita
				+ ", account=" + account + ", prezzo=" + prezzo + ", iva=" + iva + ", listaReparti=" + reparti + "]";
	}
	

}
