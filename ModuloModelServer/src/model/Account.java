package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="accounts")
public class Account implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = -2966574268362210835L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="username", unique=true)
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="id_ruolo")
	private int id_ruolo;
	@Column(name="portafoglio")
	private double portafoglio;
	@JsonbTransient
	@OneToOne(mappedBy="account")
	private Utente utente;
	@OneToMany(mappedBy="account")
	private List<Fattura> listaFattura =new ArrayList<Fattura>();
    //////////////////////
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId_ruolo() {
		return id_ruolo;
	}
	public void setId_ruolo(int id_ruolo) {
		this.id_ruolo = id_ruolo;
	}
	public double getPortafoglio() {
		return portafoglio;
	}
	public void setPortafoglio(double portafoglio) {
		this.portafoglio = portafoglio;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	public void setListFattura(ArrayList<Fattura> listaFattura) {
		this.listaFattura=listaFattura;
	}
	
	public List<Fattura> getListFattura(){
		return listaFattura;
	}
	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", id_ruolo=" + id_ruolo + ", portafoglio="
				+ portafoglio + ", utente=" + utente + ", listaFattura=" + listaFattura + "]";
	}
	
	
}

