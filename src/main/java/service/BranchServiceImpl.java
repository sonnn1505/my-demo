package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BrachDAO;
import entity.Branch;

@Service
public class BranchServiceImpl implements BranchService {
	@Autowired
	private BrachDAO branchDAO;

	@Override
	public List<Branch> findALL() {
		return branchDAO.findALL();
	}

}
