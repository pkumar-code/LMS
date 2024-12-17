package Boot.DAO;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Boot.TO.Leads;
import Boot.TO.Users;


@Repository
@Transactional
public class LeadsDAOImpl implements LeadsDAO{
	
	@Autowired
	HibernateTemplate htemp;

	@Override
	public List<Leads> viewAllLeads() {
		List<Leads>myleads=htemp.loadAll(Leads.class);
		return myleads;
	}

	@Override
	public Leads viewLeadById(int leadId) {
		Leads lead=htemp.get(Leads.class, leadId);
		return lead;
	}

	@Override
	public void AddLeads(Leads leads) {
		htemp.save(leads);
	}

	@Override
	public void  updateLeads(Leads leads) {
		
			htemp.update(leads);	
	}

	@Override
	public List<Users> getAllUsers() {
		List<Users>users=htemp.loadAll(Users.class);
		return users;
	}

	@Override
	public List<Users> verifyUser(String username, String password) {
	
		DetachedCriteria dc=DetachedCriteria.forClass(Users.class);
		dc.add(Restrictions.and(Restrictions.eq("username",username),Restrictions.eq("password", password)));
           List<Users> users=  (List<Users>) htemp.findByCriteria(dc);
           		//htemp.find(password, null)
           		
		//String HQL="from Users users where users.username=1? and users.password=2?";
		//Users users=htemp.find(HQL, username,password);
           return users;
	}

	@Override
	public List<Leads> viewAllLeads(int start, int total) {

		System.out.println("LeadsDAOimpl -- viewAllLeads(start,totalDisplay");
		 
		 DetachedCriteria dc=DetachedCriteria.forClass(Leads.class);
		 List<Leads> leadsList= (List<Leads>) htemp.findByCriteria(dc,start,total);
		 System.out.println("Leads strt end total : "+leadsList);
		return leadsList;
	}

	
	@Override
	public int getLeadsCount() {
	
		SessionFactory sessionFactory =htemp.getSessionFactory();
		Session session=sessionFactory.openSession();
		
		String sql="select count(*) from myleads";
		BigInteger big=(BigInteger) session.createNativeQuery(sql).uniqueResult();
		//System.out.println("Total Leads Count : "+big.intValue());
		return big.intValue();

	}
	
	

}
