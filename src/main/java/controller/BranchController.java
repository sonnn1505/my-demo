package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BranchController {

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String WelCome() {
		return "index";
	}
	
	@RequestMapping(value = { "/grid" }, method = RequestMethod.GET)
	public String AngularGrid() {
		return "branchGrid";
	}
}
