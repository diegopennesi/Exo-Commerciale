package model;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name ="abbigliamento")
public class Abbigliamento implements Serializable{
	private static final long serialVersionUID = 3431653033814067506L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column (name="quantita")
	private int quantita;
	@Column (name="disponibilita")
	private boolean disponibilita;
	@Column(name="prezzo", nullable=false)
	private double prezzo;
	@JsonbTransient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_reparto")
	private Reparti reparti;
	@JsonbTransient
	@OneToOne(mappedBy="abbigliamento")
	private BollaacquistoAbbigliamento bollaAcquisto;
	
	
	public int getId() {
		return id;
	}
	
	public Abbigliamento() {}
	
	public Abbigliamento(String nome, String taglia, String colore, String descrizione, int quantita,double prezzo,Reparti reparti,
			BollaacquistoAbbigliamento bollaAcquisto) {
		super();
		this.nome = nome;
		this.taglia = taglia;
		this.colore = colore;
		this.descrizione = descrizione;
		this.quantita = quantita;
		this.prezzo=prezzo;
		this.reparti=reparti;
		this.bollaAcquisto=bollaAcquisto;
	}
	public Abbigliamento(String nome, String taglia, String colore, String descrizione, int quantita,boolean disponibilita,double prezzo) {
		super();
		this.nome = nome;
		this.taglia = taglia;
		this.colore = colore;
		this.descrizione = descrizione;
		this.quantita = quantita;
		this.disponibilita=disponibilita;
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
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo=prezzo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public boolean isDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(boolean disponibilita) {
		this.disponibilita = disponibilita;
	}

	@Override
	public String toString() {
		return "Abbigliamento [id=" + id + ", nome=" + nome + ", taglia=" + taglia + ", colore=" + colore
				+ ", descrizione=" + descrizione + ", quantit�=" + quantita + ", prezzo=" + prezzo + ", reparti="
				+ reparti + ", bollaAcquisto=" + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bollaAcquisto == null) ? 0 : bollaAcquisto.hashCode());
		result = prime * result + ((colore == null) ? 0 : colore.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prezzo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantita;
		result = prime * result + ((reparti == null) ? 0 : reparti.hashCode());
		result = prime * result + ((taglia == null) ? 0 : taglia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abbigliamento other = (Abbigliamento) obj;
		if (bollaAcquisto == null) {
			if (other.bollaAcquisto != null)
				return false;
		} else if (!bollaAcquisto.equals(other.bollaAcquisto))
			return false;
		if (colore == null) {
			if (other.colore != null)
				return false;
		} else if (!colore.equals(other.colore))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(prezzo) != Double.doubleToLongBits(other.prezzo))
			return false;
		if (quantita != other.quantita)
			return false;
		if (reparti == null) {
			if (other.reparti != null)
				return false;
		} else if (!reparti.equals(other.reparti))
			return false;
		if (taglia == null) {
			if (other.taglia != null)
				return false;
		} else if (!taglia.equals(other.taglia))
			return false;
		return true;
	}

	
	
}
