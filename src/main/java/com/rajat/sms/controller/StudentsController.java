package com.rajat.sms.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajat.sms.model.Student;
import com.rajat.sms.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name="Student Management APISs",description="CRUD operations for SMS")
public class StudentsController {

private final StudentService studentService;
public StudentsController(StudentService studentService){

    this.studentService=studentService;
}

@Operation(summary="Get students data by Id ")
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
return ResponseEntity.ok(studentService.getStudentById(id));   
    }


@Operation(summary="Get all students data")
@GetMapping("/students")
public List<Student>getAllStudents(){

    return studentService.getStudents();
}


@Operation(summary="Add a new student",description="Creates a new Student and Save it into Mysql Database")
@PostMapping("/student")
public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student){
Student savedStudent=studentService.addStudent(student);
return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
}

@Operation(summary="Delete Details By ID")
@DeleteMapping("/student/{id}")
public String deleteStudent(@PathVariable Integer id){
studentService.deleteStudent(id);
return "Deleted";
}

@Operation(summary="Update details")
@PutMapping("/student/{id}")
public Student UpdateStudent(
    @PathVariable Integer id,
    @RequestBody Student updatedStudent){
return studentService.updateStudent(id,updatedStudent);

    }



}


