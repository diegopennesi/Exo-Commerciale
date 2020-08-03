package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name="bollaacquistoalimentari", uniqueConstraints=@UniqueConstraint(columnNames= {"codice_acquisto"}))
public class BollaacquistoAlimenti implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1781648036592618802L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome_fornitore/venditore")
	private String nomeFV;
	
	@Column(name="codice_acquisto",unique=true,nullable=false)
	private long codiceAcquisto;
	
	@Column(name="data_acquisto")
	private String dataAcquisto;
	
	@Column(name="stock_acquistato")
	private String stock;
	
	@Column(name="prezzo_totale")
	private double prTotale;
	
	@Column(name="prezzo_unitario")
	private double prUnitario;
	@OneToOne
	@MapsId
	private Alimentari alimenti;
	
	
	//////////////////////////////////
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String getNomeFV() {
		return nomeFV;
	}
	public void setNomeFV(String nomeFV) {
		this.nomeFV = nomeFV;
	}
	public long getCodiceAcquisto() {
		return codiceAcquisto;
	}
	public void setCodiceAcquisto(long codiceAcquisto) {
		this.codiceAcquisto = codiceAcquisto;
	}
	public String getDataAcquisto() {
		return dataAcquisto;
	}
	public void setDataAcquisto(String dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public double getPrTotale() {
		return prTotale;
	}
	public void setPrTotale(double prTotale) {
		this.prTotale = prTotale;
	}
	public double getPrUnitario() {
		return prUnitario;
	}
	public void setPrUnitario(double prUnitario) {
		this.prUnitario = prUnitario;
	}
	public Alimentari getAlimenti() {
		return alimenti;
	}
	public void setAlimenti(Alimentari alimenti) {
		this.alimenti = alimenti;
	}

	

}
