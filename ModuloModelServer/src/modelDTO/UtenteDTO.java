package modelDTO;

public class UtenteDTO {
	//deve essere un pojo 

	
	private int id;
	private String nome;
	private String cognome;
	private String indirizzo;
	private int id_account;
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
	public int getId_account() {
		return id_account;
	}
	public void setId_account(int id_account) {
		this.id_account = id_account;
	}
	public UtenteDTO() {
		
	}
	public UtenteDTO(int id, String nome, String cognome, String indirizzo, int id_account) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.id_account = id_account;
	}
	public UtenteDTO( String nome, String cognome, String indirizzo, int id_account) {
		super();
	
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.id_account = id_account;
	}
	
}
