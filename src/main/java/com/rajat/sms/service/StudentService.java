package com.rajat.sms.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rajat.sms.exception.StudentNotFoundException;
import com.rajat.sms.model.Student;
import com.rajat.sms.repository.StudentRepository;

@Service

public class StudentService{
    private final StudentRepository studentRepository;


    public StudentService( StudentRepository studentRepository ){
        this.studentRepository=studentRepository;
 
    
}

public List<Student> getStudents(){

return studentRepository.findAll();

}

public Student addStudent(Student student){

    return studentRepository.save(student);
}

public void deleteStudent(Integer id){

    studentRepository.deleteById(id);
}

public Student updateStudent (Integer id, Student updatedStudent){
Student student = studentRepository.findById(id).orElse(null);
if(student != null){
student.setName(updatedStudent.getName());
student.setEmail(updatedStudent.getEmail());
student.setCourse(updatedStudent.getCourse());
return studentRepository.save(student);

}
return null;

}


public Student getStudentById(Integer id){
       return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student Not Found Of This ID " + id));

}



}
   



