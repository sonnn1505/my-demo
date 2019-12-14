package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.FluentIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entity.Branch;
import service.BranchService;

@RestController
public class BranchRestController {
	@Autowired
	private BranchService branchService;

	@RequestMapping(value = "/branch", method = RequestMethod.GET)
	@ResponseBody
	public List<Branch> findALL() {

		return branchService.findALL();
	}

	@RequestMapping(value = "/branchLimit/{offset}&{limit}", method = RequestMethod.GET)
	@ResponseBody
	public List<Branch> branchLimit(@PathVariable("offset") int offset, @PathVariable("limit") int limit) {
		// sort list
		List<Branch> brList = getSortList(branchService.findALL(), false);
		// limit ofset
		return brList.stream().skip(offset).limit(limit).collect(Collectors.toList());
	}

	// sort list ASC/ DESC
	public List<Branch> getSortList(List<Branch> branchList, boolean reversedFlg) {
		List<Branch> res = new ArrayList<Branch>();
		if (!branchList.isEmpty()) {
			// sort which field
			Comparator<Branch> byID = Comparator.comparing(Branch::getId);
			if (reversedFlg == false) {
				res = branchList.stream().sorted(byID).collect(Collectors.toList());
			} else {
				res = branchList.stream().sorted(byID.reversed()).collect(Collectors.toList());
			}

		}

		return res;
	}

	// get limit/ofset Listbranch
	public List<Branch> getLimitList(List<Branch> branchList, int offset, int limit) {
		List<Branch> res = new ArrayList<Branch>();
		if (!branchList.isEmpty()) {
			res.subList(offset, limit);
		}
		return res;

	}

}
