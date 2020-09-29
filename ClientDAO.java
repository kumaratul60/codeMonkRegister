package monk.login;

public interface ClientDAO {
	public int insertClient(Client c);

	public Client getClient(String userName, String password);

}
