package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="reparti")
public class Reparti implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6277868469105084715L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	@Column (name="reparto")
	private String reparto;
	@OneToMany (mappedBy="reparti")
	private List<Alimentari> alimentari= new ArrayList<Alimentari>();
	@OneToMany (mappedBy="reparti")
	private List<Elettronica> elettronica= new ArrayList<Elettronica>();
	@OneToMany (mappedBy="reparti")
	private List<Abbigliamento> abbigliamento= new ArrayList<Abbigliamento>();
	@ManyToMany
	@JoinTable(name="fattura_reparti",
			joinColumns=@JoinColumn(name="id_fattura"),
			inverseJoinColumns=@JoinColumn(name="id_reparto"))
			private List<Fattura> listaFatture = new ArrayList<Fattura>();
	/////////////////////////////////////////////////////////////////////////

	public Reparti() {}
	public Reparti(String reparto,List<Alimentari> alimentari,List<Elettronica>elettronica, List<Abbigliamento>abbigliamento) {
		this.reparto=reparto;
		this.alimentari=alimentari;
		this.elettronica=elettronica;
		this.abbigliamento=abbigliamento;
	}
	public Reparti(String reparto) {
		this.reparto=reparto;
	}
	public Reparti(List<Alimentari> alimentari) {
		this.alimentari=alimentari;
	}
	public List<Elettronica> getElettronica() {
		return elettronica;
	}
	public void setElettronica(List<Elettronica> elettronica) {
		this.elettronica = elettronica;
	}
	public List<Alimentari> getAlimentari() {
		return alimentari;
	}
	public void setAlimentari(List<Alimentari> alimentari) {
		this.alimentari = alimentari;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReparto() {
		return reparto;
	}
	public void setReparto(String reparto) {
		this.reparto = reparto;
	}
	
	
	@Override
	public String toString() {
		return "Reparti [id=" + id + ", reparto=" + reparto + ", alimentari=" + alimentari + ", elettronica="
				+ elettronica + ", abbigliamento=" + abbigliamento + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abbigliamento == null) ? 0 : abbigliamento.hashCode());
		result = prime * result + ((alimentari == null) ? 0 : alimentari.hashCode());
		result = prime * result + ((elettronica == null) ? 0 : elettronica.hashCode());
		result = prime * result + id;
		result = prime * result + ((reparto == null) ? 0 : reparto.hashCode());
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
		Reparti other = (Reparti) obj;
		if (abbigliamento == null) {
			if (other.abbigliamento != null)
				return false;
		} else if (!abbigliamento.equals(other.abbigliamento))
			return false;
		if (alimentari == null) {
			if (other.alimentari != null)
				return false;
		} else if (!alimentari.equals(other.alimentari))
			return false;
		if (elettronica == null) {
			if (other.elettronica != null)
				return false;
		} else if (!elettronica.equals(other.elettronica))
			return false;
		if (id != other.id)
			return false;
		if (reparto == null) {
			if (other.reparto != null)
				return false;
		} else if (!reparto.equals(other.reparto))
			return false;
		return true;
	}
}
