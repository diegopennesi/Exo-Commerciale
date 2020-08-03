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
	@ManyToOne
	@JoinColumn(name="Id_reparto")
	private Reparti reparti;
	@OneToOne(mappedBy="abbigliamento")
	private BollaacquistoAbbigliamento BollaAcquisto;
	/////////////////////////////////////////////////
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
	public BollaacquistoAbbigliamento getBollaAcquisto() {
		return BollaAcquisto;
	}
	public void setBollaAcquisto(BollaacquistoAbbigliamento bollaAcquisto) {
		BollaAcquisto = bollaAcquisto;
	}
	
}
