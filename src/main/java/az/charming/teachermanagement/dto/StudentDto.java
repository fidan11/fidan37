package az.charming.teachermanagement.dto;

import az.charming.teachermanagement.entity.SchoolEntity;
import az.charming.teachermanagement.entity.StudentEntity;
import az.charming.teachermanagement.entity.TeacherEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class StudentDto {//Data Transfer Object, sehifeden bize gelecek olan melumatlar bunun icinde yerlesir
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;

    private String schoolName;
    private SchoolDto school;
    private List<TeacherDto> teacherList;

    public String defineFullName() {//bu ishi entutyde gore bilmerik,cunki entytyde yazdigimiz her shey entytynin table
//        ile elaqesini ifade edir. getFullName yazsaq o ele basha dusecek ki orda tableda hansisa sutun var
        return name + " " + surname;
    }

    public StudentEntity toEntity() {//studenti yaradir ve return edir
        List<TeacherEntity> teachers = new ArrayList<>();
        for (TeacherDto teacherDto : this.getTeacherList()) {
            teachers.add(new TeacherEntity()
                    .setName(teacherDto.getName())
                    .setId(teacherDto.getId()))
            ;
        }
        return new StudentEntity()
                .setAge(this.getAge())
                .setId(this.getId())
                .setName(this.getName())
                .setScholarship(this.getScholarship())
                .setSchool(
                        new SchoolEntity()
                                .setId(this.getSchool().getId())
                                .setName(this.getSchool().getName())
                )
                .setTeacherList(teachers)
                ;
    }

    public static StudentDto instance(StudentEntity st) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(st.getId());
        studentDto.setAge(st.getAge());
        studentDto.setName(st.getName());
        studentDto.setSurname(st.getSurname());
        studentDto.setScholarship(st.getScholarship());

        if (st.getSchool() != null) {//getschool null olduqda null pointer vermeyecek
            SchoolDto schoolDto = new SchoolDto();
            schoolDto.setId(st.getSchool().getId());
            schoolDto.setName(st.getSchool().getName());
            studentDto.setSchool(schoolDto);
        }

        List<TeacherDto> teacherDtos = new ArrayList<>();
        for (TeacherEntity teacher : st.getTeacherList()) {
            TeacherDto teacherDto = new TeacherDto();
            teacherDto.setId(teacher.getId());
            teacherDto.setName(teacher.getName());
            teacherDtos.add(teacherDto);
        }
        studentDto.setTeacherList(teacherDtos);
        return studentDto;
    }


    public Integer getId() {
        return id;
    }

    public StudentDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public StudentDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public StudentDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BigDecimal getScholarship() {
        return scholarship;
    }

    public StudentDto setScholarship(BigDecimal scholarship) {
        this.scholarship = scholarship;
        return this;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public StudentDto setSchoolName(String schoolName) {
        this.schoolName = schoolName;
        return this;
    }

    public SchoolDto getSchool() {
        return school;
    }

    public StudentDto setSchool(SchoolDto school) {
        this.school = school;
        return this;
    }

    public List<TeacherDto> getTeacherList() {
        return teacherList;
    }

    public StudentDto setTeacherList(List<TeacherDto> teacherList) {
        this.teacherList = teacherList;
        return this;
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
