package org.questionBank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.questionBank.dao.DepartmentDataUtil;
import org.questionBank.dao.PersonDataUtil;
import org.questionBank.data.Department;
import org.questionBank.data.Person;
import org.questionBank.exception.InvalidDepartmentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentDataUtil departmentDAO;
	@Autowired
	PersonDataUtil personDAO;

	// List
	@RequestMapping(value="/DepartmentsView",method=RequestMethod.GET)
	public ModelAndView listDepartments(HttpServletRequest request){
		ModelAndView mve =  null;
		List<Department> departments = departmentDAO.getDepartments();
		mve = new ModelAndView("views/departments/ListDepartments");
		mve.addObject("departments",departments);
		HttpSession s = request.getSession();
		Object uid = s.getAttribute("userId");
		if(uid != null){
			Integer userId = (Integer) uid;
			Person p = personDAO.findPerson(userId);
			boolean isAdmin = p.isAdmin();
			mve.addObject("isAdmin", isAdmin);
			return mve;
		}else{
			mve = new ModelAndView("index");
			mve.addObject("message", "Invalid User ID for Session");
			return mve;
		}
	}

	// Create
	@RequestMapping(value="/AddDepartment",method=RequestMethod.GET)
	public ModelAndView addDepartmentView(@RequestParam(required=false) String name, @RequestParam(required=false) String abbreviation){
		ModelAndView mve =  null;
		Department d = null;
		boolean newDepartment = true;
		if(name != null || abbreviation != null){
			d = departmentDAO.populateDepartment(name, abbreviation);
			newDepartment = false;
		}else{
			d = new Department();
		}
		mve = new ModelAndView("views/departments/AddDepartment");
		if(d != null){
			mve.addObject("dept", d);
			if(!newDepartment)
				mve.addObject("errors", departmentDAO.departmentErrors(d));
		}
		return mve;
	}

	@RequestMapping(value="/AddDepartment",method=RequestMethod.POST)
	public ModelAndView createCourse(HttpServletRequest request, @ModelAttribute("dept") Department dept){
		ModelAndView mve =  null;
		try {
			Department newDepartment = departmentDAO.createDepartment(dept);
			mve=new ModelAndView("redirect:ShowDepartment?id="+newDepartment.getId());
			mve.addObject("department", newDepartment);
		} catch (InvalidDepartmentException e) {
			mve= new ModelAndView("redirect:AddDepartment");
			mve.addObject("name", dept.getName());
			mve.addObject("abbreviation", dept.getAbbreviation());
		}
		return mve;
	}
	
	// Show
	@RequestMapping(value="/ShowDepartment",method=RequestMethod.GET)
	public ModelAndView showDepartment(@RequestParam("id") int id){
		ModelAndView mve = null;
		mve = new ModelAndView("views/departments/ShowDepartment");
		Department d = departmentDAO.findDepartment(id);
		
		mve.addObject("department",d);
		return mve;
	}
	
	// Edit
	@RequestMapping(value="/EditDepartment",method=RequestMethod.GET)
	public ModelAndView editDepartment(@RequestParam("id") int id){
		ModelAndView mve = null;
		mve = new ModelAndView("views/departments/EditDepartment");
		Department d = departmentDAO.findDepartment(id);
		try{
			departmentDAO.validateDepartment(d);
		}catch(InvalidDepartmentException ex){
			mve.addObject("errors", departmentDAO.departmentErrors(d));
		}
		mve.addObject("dept",d);
		return mve;
	}

	@RequestMapping(value="/UpdateDepartment",method=RequestMethod.POST)
	public ModelAndView updateDepartment(@ModelAttribute("dept") Department dept){
		ModelAndView mve =  null;
		try {
			departmentDAO.updateDepartment(dept);
			mve=new ModelAndView("redirect:ShowDepartment?id="+dept.getId());
			mve.addObject("dept", dept);
		} catch (InvalidDepartmentException e) {
			mve=new ModelAndView("redirect:EditDepartment?id="+dept.getId());
		}
		return mve;
	}
	
}
