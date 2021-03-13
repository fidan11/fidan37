package az.charming.teachermanagement.dto;

import az.charming.teachermanagement.entity.StudentEntity;
//import az.charming.teachermanagement.entity.TeacherEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class StudentFormDto {//Data Transfer Object, sehifeden bize gelecek olan melumatlar bunun icinde yerlesir
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;
//    private String teacherName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getScholarship() {
        return scholarship;
    }

    public void setScholarship(BigDecimal scholarship) {
        this.scholarship = scholarship;
    }

    public StudentEntity toStudentEntity() {
        return new StudentEntity()
                .setAge(this.age)
                .setName(this.name)
                .setSurname((this.surname))
                .setScholarship(this.scholarship);
    }

//    public Map<String, String> toTeacherEntity() {//TeacherEntity
//        Map<String, String> teacher = new HashMap<>();
//        teacher.put("name", this.teacherName);
//        return teacher;
//    }
}
