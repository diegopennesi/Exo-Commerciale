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
@Table (name ="abbigliamento")
public class Abbigliamento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6587541972395128627L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="id")
	private int id;
	@Column (name="nome")
	private String nome;
	@Column (name="taglia")
	private String taglia;
	@Column (name="colore")
	private String colore;
	@Column (name="descrizione")
	private String descrizione;
	@Column (name="quantità")
	private int quantità;
	@Column(name="prezzo")
	private double prezzo;
	@ManyToOne
	@JoinColumn(name="Id_reparto")
	private Reparti reparti;
	@OneToOne(mappedBy="abbigliamento")
	private BollaacquistoAbbigliamento bollaAcquisto;
	/////////////////////////////////////////////////
	
	public int getId() {
		return id;
	}
	
	public Abbigliamento() {}
	
	public Abbigliamento(String nome, String taglia, String colore, String descrizione, int quantità,double prezzo) {
		super();
		this.nome = nome;
		this.taglia = taglia;
		this.colore = colore;
		this.descrizione = descrizione;
		this.quantità = quantità;
		this.prezzo=prezzo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public BollaacquistoAbbigliamento getBollaAcquisto() {
		return bollaAcquisto;
	}
	public void setBollaAcquisto(BollaacquistoAbbigliamento bollaAcquisto) {
		this.bollaAcquisto = bollaAcquisto;
	}
	public String getTaglia() {
		return taglia;
	}
	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getQuantità() {
		return quantità;
	}
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo=prezzo;
	}

	@Override
	public String toString() {
		return "Abbigliamento [id=" + id + ", nome=" + nome + ", taglia=" + taglia + ", colore=" + colore
				+ ", descrizione=" + descrizione + ", quantità=" + quantità + ", reparti=" + reparti
				+ ", BollaAcquisto=" + bollaAcquisto + "]";
	}
	
}
