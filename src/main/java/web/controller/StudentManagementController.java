package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import web.dao.StudentDAO;
import web.model.Student;

@RestController
@EnableWebMvc
public class StudentManagementController {

	@Autowired
    private StudentDAO studentDAO;
	@RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to StudentManagementRest.";
    }
	//get
	 @RequestMapping(value = "/student/{id}", 
	            method = RequestMethod.GET, 
	            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    public Student getEmployee(@PathVariable("id") String id) {
	        return studentDAO.getStudent(id);
	    }
	 //create
	 @RequestMapping(value = "/student",
	            method = RequestMethod.POST,
	            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    public Student addEmployee(@RequestBody Student st) {
	 
	        return studentDAO.addStudent(st);
	 
	    }
	 //update
	 @RequestMapping(value = "/student",
	            method = RequestMethod.PUT, 
	            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    public Student updateEmployee(@RequestBody Student st) {
	 
	        return studentDAO.updateStudent(st);
	    }
	 //delete
	 @RequestMapping(value = "/student/{id}", 
	            method = RequestMethod.DELETE, 
	            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    public void deleteEmployee(@PathVariable("id") String id) {
	        studentDAO.deleteStudent(id);
	    }
}
