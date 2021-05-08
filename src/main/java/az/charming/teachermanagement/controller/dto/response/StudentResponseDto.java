package az.charming.teachermanagement.controller.dto.response;

import az.charming.teachermanagement.dto.StudentDto;
import az.charming.teachermanagement.dto.TeacherDto;
import az.charming.teachermanagement.entity.StudentEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class StudentResponseDto {//Data Transfer Object, sehifeden bize gelecek olan melumatlar bunun icinde yerlesir
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;
//    private String teacherName;

    private SchoolResponseDto school;
    private List<TeacherResponseDto> teacherList;

    public static StudentResponseDto instance(StudentDto st) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(st.getId());
        studentResponseDto.setAge(st.getAge());
        studentResponseDto.setName(st.getName());
        studentResponseDto.setSurname(st.getSurname());
        studentResponseDto.setScholarship(st.getScholarship());

        SchoolResponseDto schoolDto = new SchoolResponseDto();
        if (st.getSchool() != null) {
            schoolDto.setId(st.getSchool().getId());//st guya bizim tapdigimiz studentdi ve hemin studentin schoolunun id-sini
//        goturmeye calishiriq. Hemin studentin schoolu olmadiqda exception atir
            schoolDto.setName(st.getSchool().getName());
        }
        studentResponseDto.setSchool(schoolDto);

        List<TeacherResponseDto> teacherDtos = new ArrayList<>();
        for (TeacherDto teacher : st.getTeacherList()) {
            TeacherResponseDto teacherDto = new TeacherResponseDto();
            teacherDto.setId(teacher.getId());
            teacherDto.setName(teacher.getName());
            teacherDtos.add(teacherDto);
        }
        studentResponseDto.setTeacherList(teacherDtos);
        return studentResponseDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SchoolResponseDto getSchool() {
        return school;
    }

    public void setSchool(SchoolResponseDto school) {
        this.school = school;
    }

    public List<TeacherResponseDto> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<TeacherResponseDto> teacherList) {
        this.teacherList = teacherList;
    }

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
