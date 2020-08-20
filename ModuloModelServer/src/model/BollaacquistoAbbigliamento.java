package model;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name  ="bollaacquistoabbigliamento", uniqueConstraints=@UniqueConstraint(columnNames= {"codice_acquisto"}) )
public class BollaacquistoAbbigliamento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3084091051025520907L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome_fornitore_venditore")
	private String nomeFV;
	
	@Column(name="codice_acquisto", unique=true,nullable=false)
	private long codiceAcquisto;
	
	@Column(name="data_acquisto")
	private String dataAcquisto;
	
	@Column(name="stock_acquistato")
	private String stock;
	
	@Column(name="prezzo_totale")
	private double prTotale;
	
	@Column(name="prezzo_unitario")
	private double prUnitario;
	@JsonbTransient
	@OneToOne
	@JoinColumn(name="id_abbigliamento")
	private Abbigliamento abbigliamento;
	////////////////////////////////////
	public BollaacquistoAbbigliamento(String nomeFV,long codiceAcquisto,String dataAcquisto,String stock,double prTotale,double prUnitario,
			Abbigliamento abbigliamento) {
		this.nomeFV=nomeFV;
		this.codiceAcquisto=codiceAcquisto;
		this.dataAcquisto=dataAcquisto;
		this.stock=stock;
		this.prTotale=prTotale;
		this.prUnitario=prUnitario;
		this.abbigliamento=abbigliamento;
}
	public BollaacquistoAbbigliamento(String nomeFV,long codiceAcquisto,String dataAcquisto,String stock,double prTotale,double prUnitario) {
		this.nomeFV=nomeFV;
		this.codiceAcquisto=codiceAcquisto;
		this.dataAcquisto=dataAcquisto;
		this.stock=stock;
		this.prTotale=prTotale;
		this.prUnitario=prUnitario;
}
	
	public BollaacquistoAbbigliamento(double prTotale,double prUnitario) {
		this.prTotale=prTotale;
		this.prUnitario=prUnitario;
	}
	public BollaacquistoAbbigliamento() {}
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
	public Abbigliamento getAbbigliamento() {
		return abbigliamento;
	}
	public void setAbbigliamento(Abbigliamento abbigliamento) {
		this.abbigliamento = abbigliamento;
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((abbigliamento == null) ? 0 : abbigliamento.hashCode());
//		result = prime * result + (int) (codiceAcquisto ^ (codiceAcquisto >>> 32));
//		result = prime * result + ((dataAcquisto == null) ? 0 : dataAcquisto.hashCode());
//		result = prime * result + id;
//		result = prime * result + ((nomeFV == null) ? 0 : nomeFV.hashCode());
//		long temp;
//		temp = Double.doubleToLongBits(prTotale);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		temp = Double.doubleToLongBits(prUnitario);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
//		return result;
//	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BollaacquistoAbbigliamento other = (BollaacquistoAbbigliamento) obj;
		if (abbigliamento == null) {
			if (other.abbigliamento != null)
				return false;
		} else if (!abbigliamento.equals(other.abbigliamento))
			return false;
		if (codiceAcquisto != other.codiceAcquisto)
			return false;
		if (dataAcquisto == null) {
			if (other.dataAcquisto != null)
				return false;
		} else if (!dataAcquisto.equals(other.dataAcquisto))
			return false;
		if (id != other.id)
			return false;
		if (nomeFV == null) {
			if (other.nomeFV != null)
				return false;
		} else if (!nomeFV.equals(other.nomeFV))
			return false;
		if (Double.doubleToLongBits(prTotale) != Double.doubleToLongBits(other.prTotale))
			return false;
		if (Double.doubleToLongBits(prUnitario) != Double.doubleToLongBits(other.prUnitario))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BollaacquistoAbbigliamento [id=" + id + ", nomeFV=" + nomeFV + ", codiceAcquisto=" + codiceAcquisto
				+ ", dataAcquisto=" + dataAcquisto + ", stock=" + stock + ", prTotale=" + prTotale + ", prUnitario="
				+ prUnitario + ", abbigliamento=" + abbigliamento + "]";
	}
	

}
