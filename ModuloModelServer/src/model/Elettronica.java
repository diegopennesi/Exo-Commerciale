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
	@JsonbTransient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_reparto")
	private Reparti reparti;
	@JsonbTransient
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BollaAcquisto == null) ? 0 : BollaAcquisto.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + (disponibilita ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prezzo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantita;
		result = prime * result + ((reparti == null) ? 0 : reparti.hashCode());
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
		Elettronica other = (Elettronica) obj;
		if (BollaAcquisto == null) {
			if (other.BollaAcquisto != null)
				return false;
		} else if (!BollaAcquisto.equals(other.BollaAcquisto))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (disponibilita != other.disponibilita)
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
		return true;
	}
	
}