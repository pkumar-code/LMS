package Boot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Boot.DAO.LeadsDAO;
import Boot.TO.Leads;
import Boot.TO.Users;


@Service
public class LeadsServiceImpl  implements LeadsService{

	@Autowired
	LeadsDAO leadsDAO;

	@Override
	public List<Leads> viewAllLeads() {
	List<Leads>mylist=leadsDAO.viewAllLeads();
		return mylist;
	}

	@Override
	public Leads viewLeadById(int leadId) {
		Leads lead=leadsDAO.viewLeadById(leadId);
		return lead;
	}

	@Override
	public void AddLeads(Leads leads) {
		leadsDAO.AddLeads(leads);
		
	}

	@Override
	public void updateLeads(Leads leads) {
		
		leadsDAO.updateLeads(leads);
	
	}

	@Override
	public List<Users> getAllUsers() {
		
		List<Users>users=leadsDAO.getAllUsers();
		return users;
	}

	@Override
	public List<Users> verifyUser(String username, String password) {
		
		List<Users> users=leadsDAO.verifyUser(username, password);
		
		return users;
	}

	@Override
	public List<Leads> viewAllLeads(int start, int total) {
		// TODO Auto-generated method stub
		return leadsDAO.viewAllLeads(start, total);
	}

	@Override
	public int getLeadsCount() {
		// TODO Auto-generated method stub
		return leadsDAO.getLeadsCount();
	}
	
	
}
