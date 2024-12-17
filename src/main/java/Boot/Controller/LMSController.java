package Boot.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Boot.Service.LeadsService;
import Boot.TO.Leads;
import Boot.TO.Users;

@Controller
public class LMSController {

	@Autowired
	LeadsService leadsService;

	int start = 0;
	int end = 5;
	int totalDisplay = 5;
	int totalLeads;

	private void showFirstPage(Model model) {

		start = 0;
		end = 5;
		totalDisplay = 5;
		totalLeads = leadsService.getLeadsCount();
		// System.out.println("Leads Count : "+totalLeads);

		model.addAttribute("ShowPrevious", "FALSE");
		model.addAttribute("ShowNext", "TRUE");

	}

	@GetMapping("/")
	public String showLoginPage() {
		System.out.println("---------------------showLogin Page-------------");

		return "login";
	}

	@GetMapping("/nextLeads")
	public String showNextLeads(Model model) {

		start = start + totalDisplay;
		if (start <= 0) {
			start = 0;
			model.addAttribute("ShowPrevious", "FALSE");
		} else {
			model.addAttribute("ShowPrevious", "TRUE");
		}

		end = end + totalDisplay;
		if (end >= totalLeads) {
			model.addAttribute("ShowNext", "FALSE");
		} else {
			model.addAttribute("ShowNext", "TRUE");
		}

		List<Leads> myleads = leadsService.viewAllLeads(start, totalDisplay);
		model.addAttribute("MyLeads", myleads);
		// model.addAttribute("")

		return "viewLeads";
	}

	@GetMapping("/previousLeads")
	public String showPreviousLeads(Model model) {

		start = start - totalDisplay;
		if (start <= 0) {
			start = 0;
			model.addAttribute("ShowPrevious", "FALSE");
		} else {
			model.addAttribute("ShowPrevious", "TRUE");
		}

		end = end - totalDisplay;
		if (end >= totalLeads) {
			model.addAttribute("ShowNext", "FALSE");
		} else {
			model.addAttribute("ShowNext", "TRUE");
		}

		List<Leads> myleads = leadsService.viewAllLeads(start, totalDisplay);
		model.addAttribute("MyLeads", myleads);
		// model.addAttribute("")

		return "viewLeads";
	}

	@PostMapping("/allleads")
	public String getAllLead(@RequestParam("username") String un, @RequestParam("password") String pw, Model model,
			HttpServletRequest req) {

		System.out.println("----------------------getAllLeads() COntroller--------");
		List<Users> user = leadsService.verifyUser(un, pw);
		Users users = null;
		String page = " ";

		if (user.isEmpty()) {
			page = "login";
		} else {

			List<Leads> myleads = leadsService.viewAllLeads(start, totalDisplay);

			for (Leads lead : myleads) {
				System.out.println(lead);
			}
			model.addAttribute("MyLeads", myleads);
			req.setAttribute("MyLeads", myleads);
			users = user.get(0);
			HttpSession session = req.getSession();
			session.setAttribute("Users", users);
			System.out.println(user);

			page = "viewLeads";
		}
		showFirstPage(model);
		return page;

	}

	@GetMapping("/viewLead")
	public String leadInfo(@RequestParam("leadId") int leadId, Model model) {
		System.out.println("------------addLead-----LMS Controller--------");
		System.out.println(leadId);

		Leads lead = leadsService.viewLeadById(leadId);
		model.addAttribute("Lead", lead);

		return "leadInfo";

	}

	@PostMapping("/addEditLead")
	public String addEditLead(@RequestParam("leadId") Integer leadId, Model model) {

		System.out.println("----------AddEditLead------Controller-----");
		System.out.println("lead id in add edit lead" + "\n" + leadId);

		Leads lead = new Leads();
		String opType = "ADD";

		if (leadId != 0) {
			lead = leadsService.viewLeadById(leadId);
			opType = "UPDATE";
			model.addAttribute("Lead", lead);
		}
		model.addAttribute("OpType", opType);
		model.addAttribute("Lead", lead);

		showFirstPage(model);
		return "addEditLead";
	}

	@PostMapping("/saveUpdateLead")
	public String updateLead(@ModelAttribute("mylead") Leads leads, Model model, HttpServletRequest req) {

		System.out.println("---------------updateLead ------LMSController--------------");
		System.out.println(leads.getLeadId());
		String opType = req.getParameter("OpType");
		System.out.println(opType);

		if (opType.equals("ADD")) {
			leadsService.AddLeads(leads);
		}
		if (opType.equals("UPDATE")) {
			int leadId = Integer.parseInt(req.getParameter("leadId"));
			System.out.println(leadId);
			leads.setLeadId(leadId);
			leadsService.updateLeads(leads);
		}

		List<Leads> myleads = leadsService.viewAllLeads(start, totalDisplay);
		model.addAttribute("MyLeads", myleads);

		showFirstPage(model);
		return "viewLeads";
	}

	@GetMapping("/logout")
	public String getLogout(Model model, HttpServletRequest req) {
		System.out.println("------------------LMSController - logout ()-----------");
		String page = "login";
		HttpSession session = req.getSession();
		if (session != null) {
			session.invalidate();
		}

		return page;

	}

}
