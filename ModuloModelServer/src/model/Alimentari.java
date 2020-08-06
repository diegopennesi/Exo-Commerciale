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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="alimenti",uniqueConstraints=@UniqueConstraint(columnNames= {"prezzo"}))
public class Alimentari implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5901568129033252703L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id")
	private int id;
	@Column (name = "quantita")//????? come la gestiamo?
	private int quantita;
	@Column (name = "nome")
	private String nome;
	@Column (name = "scadenza")
	private String scadenza;
	@Column (name ="descrizione")
	private String descrizione;
	@Column (name = "disponibilita")
	private boolean disponibilita;
	@Column(name="prezzo",unique=true, nullable=false)
	private double prezzo;
	@ManyToOne
	@JoinColumn(name="Id_reparto")
	private Reparti reparti;
	@OneToOne(mappedBy="alimenti")
	private BollaacquistoAlimenti bollaAcquisto;
	////////////////////////////////////////////
	
	public Alimentari() {}
	public Alimentari( String nome,String scadenza, String descrizione,int quantita,boolean disponibilita,
			double prezzo,Reparti reparti,BollaacquistoAlimenti bollaAcquisto) {
		this.nome=nome;
		this.scadenza=scadenza;
		this.descrizione=descrizione;
		this.quantita=quantita;
		this.disponibilita=disponibilita;
		this.prezzo=prezzo;
		this.reparti=reparti;
		this.bollaAcquisto=bollaAcquisto;
	}
	
	public Alimentari(String nome,String scadenza, String descrizione,int quantita,boolean disponibilita,
			double prezzo) {
		this.nome=nome;
		this.scadenza=scadenza;
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
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getQuantità() {
		return quantita;
	}
	public void setQuantità(int quantita) {
		this.quantita = quantita;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getScadenza() {
		return scadenza;
	}
	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}
	public Reparti getReparti() {
		return reparti;
	}
	public void setReparti(Reparti reparti) {
		this.reparti = reparti;
	}
	public BollaacquistoAlimenti getBollaAcquisto() {
		return bollaAcquisto;
	}
	public void setBollaAcquisto(BollaacquistoAlimenti bollaAcquisto) {
		this.bollaAcquisto = bollaAcquisto;
	}
	public boolean isDisponibilità() {
		return disponibilita;
	}
	public void setDisponibilità(boolean disponibilita) {
		this.disponibilita = disponibilita;
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
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo=prezzo;
	}
	@Override
	public String toString() {
		return "Alimentari [id=" + id + ", quantita=" + quantita + ", nome=" + nome + ", scadenza=" + scadenza
				+ ", descrizione=" + descrizione + ", disponibilita=" + disponibilita + ", prezzo=" + prezzo
				+ ", reparti=" + reparti + ", bollaAcquisto=" + bollaAcquisto + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bollaAcquisto == null) ? 0 : bollaAcquisto.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + (disponibilita ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prezzo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantita;
		result = prime * result + ((reparti == null) ? 0 : reparti.hashCode());
		result = prime * result + ((scadenza == null) ? 0 : scadenza.hashCode());
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
		Alimentari other = (Alimentari) obj;
		if (bollaAcquisto == null) {
			if (other.bollaAcquisto != null)
				return false;
		} else if (!bollaAcquisto.equals(other.bollaAcquisto))
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
		if (scadenza == null) {
			if (other.scadenza != null)
				return false;
		} else if (!scadenza.equals(other.scadenza))
			return false;
		return true;
	}
	
	
	
}
