package modelDTO;



public class AccountDTO {
	//deve essere un pojo
	private int id;
	private String username;
	private String password;
	private int id_ruolo;
	private double portafoglio;
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
	@Override
	public String toString() {
		return "AccountDTO [id=" + id + ", username=" + username + ", password=" + password + ", id_ruolo=" + id_ruolo
				+ ", portafoglio=" + portafoglio + "]";
	}
	public AccountDTO(int id, String username, String password, int id_ruolo, double portafoglio) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.id_ruolo = id_ruolo;
		this.portafoglio = portafoglio;
	}

	
}
