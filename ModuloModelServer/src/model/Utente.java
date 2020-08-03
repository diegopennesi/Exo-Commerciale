package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="utente")
public class Utente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6620070774300772375L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column (name = "nome")
	private String nome;
	@Column (name = "cognome")
	private String cognome;
	@Column (name = "indirizzo")
	private String indirizzo;
	@OneToOne(mappedBy="utente")
	private Account account;
    ////////////////////////////////////
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
