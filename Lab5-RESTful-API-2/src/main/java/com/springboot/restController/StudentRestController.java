package com.springboot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.StudenDAO;
import com.springboot.model.Student;

@RestController
@CrossOrigin(origins = "*")
public class StudentRestController {
	@Autowired
	StudenDAO dao;

	@GetMapping(value = "/rest/students")
	private List<Student> getAll() {
		return dao.findAll();
	}

	@GetMapping(value = "/rest/student/{email}")
	private Student getOne(@PathVariable("email") String email) {
		return dao.findById(email).get();
	}

	@PostMapping(value = "/rest/student")
	private Student create(@RequestBody Student student) {
		return dao.save(student);
	}

	@DeleteMapping(value = "/rest/student/{email}")
	private void delete(@PathVariable("email") String email) {
		dao.deleteById(email);
	}

	@PutMapping(value = "/rest/student/{email}")
	private Student update(@PathVariable("email") String email,@RequestBody Student student) {
		Student newStudent = dao.findById(email).orElse(null);
	    if (newStudent != null) {
	        return dao.save(student);
	    }
	    return null;
	}
}
