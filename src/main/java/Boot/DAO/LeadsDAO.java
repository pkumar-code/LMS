package Boot.DAO;

import java.util.List;

import Boot.TO.Leads;
import Boot.TO.Users;


public interface LeadsDAO {
	
	public List<Leads> viewAllLeads();
	public List<Leads>viewAllLeads(int start,int total);
	
	public Leads viewLeadById(int leadId);
	public void AddLeads(Leads leads);
	public void updateLeads(Leads Leads);
	
	public int getLeadsCount();
	
	public List<Users> getAllUsers();
	public List<Users> verifyUser(String username,String password);
	

}
