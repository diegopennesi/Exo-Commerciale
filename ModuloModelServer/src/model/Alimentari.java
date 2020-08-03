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
@Table(name="alimenti")
public class Alimentari implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5901568129033252703L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id")
	private int id;
	@Column (name = "quantità")//????? come la gestiamo?
	private int quantità;
	@Column (name = "nome")
	private String nome;
	@Column (name = "scadenza")
	private String scadenza;
	@Column (name ="descrizione")
	private String descrizione;
	@Column (name = "disponibilità")
	private boolean disponibilità;
	@ManyToOne
	@JoinColumn(name="Id_reparto")
	private Reparti reparti;
	@OneToOne(mappedBy="alimenti")
	private BollaacquistoAlimenti BollaAcquisto;
	////////////////////////////////////////////
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantità() {
		return quantità;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public void setQuantità(int quantità) {
		this.quantità = quantità;
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
		return BollaAcquisto;
	}
	public void setBollaAcquisto(BollaacquistoAlimenti bollaAcquisto) {
		BollaAcquisto = bollaAcquisto;
	}
	public boolean isDisponibilità() {
		return disponibilità;
	}
	public void setDisponibilità(boolean disponibilità) {
		this.disponibilità = disponibilità;
	}
	
	
}
