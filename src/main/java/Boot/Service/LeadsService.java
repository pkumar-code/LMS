package Boot.Service;

import java.util.List;

import Boot.TO.Leads;
import Boot.TO.Users;


public interface LeadsService {
	
	public List<Leads> viewAllLeads();
	public List<Leads>viewAllLeads(int start,int total);
	
	public Leads viewLeadById(int leadId);
	public void AddLeads(Leads leads);
	public void  updateLeads(Leads leads);
	
	public int getLeadsCount();
	
	public List<Users> getAllUsers();
	public List<Users> verifyUser(String username,String password);

}
