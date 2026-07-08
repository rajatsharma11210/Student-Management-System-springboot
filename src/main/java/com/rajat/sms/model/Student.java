package com.rajat.sms.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="students")
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

    private Integer id;

    @NotBlank(message ="Course is Required")
    private String course;

    @Email(message="Please eneter valid email ")
    @NotBlank(message ="Emails Required")
    private String email;

    @NotBlank(message ="name is Required")
    private String name;

    
public Student(){}
public Student (Integer id, String course, String email, String name){
this.id=id;
this.course=course;
this.email=email;
this.name=name;

}

public Integer getId(){
    return id;
}
public String getName(){
    return name;
}

public String getCourse(){
    return course;
}
public String getEmail(){
    return email;
}



public void setId(Integer id){
    this.id=id;
}
public void setName(String name){
    this.name=name;
}
public void setEmail(String email){
    this.email=email;
}
public void setCourse(String course){
    this.course=course;
}



}

