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
@Table (name ="elettronica",uniqueConstraints=@UniqueConstraint(columnNames= {"prezzo"}))
public class Elettronica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1120971636605876082L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="id")
	private int id;
	@Column (name = "disponibilità")
	private boolean disponibilità;
	@Column (name = "tecnologie")//cosa implementa l'oggetto elettronico, wifi\zoom digitale\flash led\incursore a**le etc etc
	private String tecnologie;
	@Column (name = "descrizione")
	private String destrizione;
	@Column (name = "peso")
	private double peso;
	@Column(name="prezzo",unique=true, nullable=false)
	private double prezzo;
	@ManyToOne
	@JoinColumn(name="Id_reparto")
	private Reparti reparti;
	@OneToOne(mappedBy="elettronica")
	private BollaacquistoElettronica BollaAcquisto;
	///////////////////////////////////////////////
	
	public int getId() {
		return id;
	}
	
	public Elettronica() {}
	public Elettronica(boolean disponibilità, String tecnologie, String destrizione, double peso, double prezzo,Reparti reparti,
			BollaacquistoElettronica bollaAcquisto) {
		super();
		this.disponibilità = disponibilità;
		this.tecnologie = tecnologie;
		this.destrizione = destrizione;
		this.peso = peso;
		this.prezzo=prezzo;
		this.reparti = reparti;
		BollaAcquisto = bollaAcquisto;
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
	public BollaacquistoElettronica getBollaAcquisto() {
		return BollaAcquisto;
	}
	public void setBollaAcquisto(BollaacquistoElettronica bollaAcquisto) {
		BollaAcquisto = bollaAcquisto;
	}
	public boolean isDisponibilità() {
		return disponibilità;
	}
	public void setDisponibilità(boolean disponibilità) {
		this.disponibilità = disponibilità;
	}
	public String getTecnologie() {
		return tecnologie;
	}
	public void setTecnologie(String tecnologie) {
		this.tecnologie = tecnologie;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getDestrizione() {
		return destrizione;
	}
	public void setDestrizione(String destrizione) {
		this.destrizione = destrizione;
	}
  

}
