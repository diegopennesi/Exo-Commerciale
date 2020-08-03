package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	/////////////////////////////////////////////////////////////////////////
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
}
