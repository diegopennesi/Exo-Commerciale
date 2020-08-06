package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="fatture",uniqueConstraints=@UniqueConstraint(columnNames= {"id_scontrino"}))
public class Fattura implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_scontrino",unique=true,nullable=false)
	private int id_scontrino;
	@Column(name="descrizione")
	private String descrizione;
	@Column(name="quantita")
	private int quantita;
	@ManyToOne
	@JoinColumn(name="id_utente")
	private Utente utente;
	@Column(name="prezzo")
	private double prezzo;
	@Column(name="iva")
	private int iva;
	@ManyToMany
	@JoinTable(name="fattura_reparti",
	joinColumns=@JoinColumn(name="id_reparto"),
	inverseJoinColumns=@JoinColumn(name="id_fattura"))
	private List<Reparti> listaReparti = new ArrayList<Reparti>();
	
	public Fattura() {}
	public Fattura(int id_scontrino, String descrizione,int quantita,Utente utente, int iva, List<Reparti>listaReparti) {
		this.id_scontrino=id_scontrino;
		this.descrizione=descrizione;
		this.quantita=quantita;
		this.utente=utente;
		this.iva=iva;
		this.listaReparti=listaReparti;
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
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
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
	public List<Reparti> getListaReparti() {
		return listaReparti;
	}
	public void setListaReparti(List<Reparti> listaReparti) {
		this.listaReparti = listaReparti;
	}
	
	
	

}
