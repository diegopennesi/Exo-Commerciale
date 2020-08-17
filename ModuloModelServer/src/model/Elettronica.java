package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name ="elettronica")
public class Elettronica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1120971636605876082L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	@Column (name = "disponibilita")
	private boolean disponibilita;
	@Column (name = "nome")//cosa implementa l'oggetto elettronico, wifi\zoom digitale\flash led\incursore a**le etc etc
	private String nome;
	@Column (name = "descrizione")
	private String descrizione;
	@Column (name = "quantita")
	private int quantita;
	@Column(name="prezzo", nullable=false)
	private double prezzo;
	@ManyToOne
	@JoinColumn(name="Id_reparto")
	private Reparti reparti;
	@OneToOne(mappedBy="elettronica")
	private BollaacquistoElettronica BollaAcquisto;
	///////////////////////////////////////////////
	public Elettronica() {}
	public Elettronica(String nome, String destrizione, int quantita,boolean disponibilita, double prezzo, Reparti reparti,
			BollaacquistoElettronica bollaAcquisto) {
		super();
		this.nome = nome;
		this.descrizione = destrizione;
		this.quantita = quantita;
		this.disponibilita = disponibilita;
		this.prezzo=prezzo;
		this.reparti = reparti;
		BollaAcquisto = bollaAcquisto;
	}
	
	public Elettronica( String nome, String descrizione, int quantita,boolean disponibilita, double prezzo) {
		this.nome=nome;
		this.descrizione=descrizione;
		this.quantita=quantita;
		this.disponibilita=disponibilita;
		this.prezzo=prezzo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(boolean disponibilita) {
		this.disponibilita = disponibilita;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public Reparti getReparti() {
		return reparti;
	}
	public void setReparti(Reparti reparti) {
		this.reparti = reparti;
	}
	public BollaacquistoElettronica getBollaAcquisto() {
		return BollaAcquisto;
	}
	public void setBollaAcquisto(BollaacquistoElettronica bollaAcquisto) {
		BollaAcquisto = bollaAcquisto;
	}
	
}