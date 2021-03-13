package az.charming.teachermanagement.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity//hibernate,eclipselink
@Table(name = "student")
@NamedQuery(query = "select s from StudentEntity s where s.school.id=:id and s.age=:age",name = "nqFindByCshoolIdAndAge")
public class StudentEntity {

    @Id
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REMOVE
            })
    @JoinTable(name = "student_teacher",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<TeacherEntity> teacherList;

    @ManyToOne
    @JoinColumn(name = "school_id")//bunun vasitesi ile join oluram school table-na
    private SchoolEntity school;

    public Integer getId() {
        return id;
    }

    public az.charming.teachermanagement.entity.StudentEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public az.charming.teachermanagement.entity.StudentEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public az.charming.teachermanagement.entity.StudentEntity setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public az.charming.teachermanagement.entity.StudentEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BigDecimal getScholarship() {
        return scholarship;
    }

    public az.charming.teachermanagement.entity.StudentEntity setScholarship(BigDecimal scholarship) {
        this.scholarship = scholarship;
        return this;
    }

    public List<TeacherEntity> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<TeacherEntity> teacherList) {
        this.teacherList = teacherList;
    }

    public SchoolEntity getSchool() {
        return school;
    }

    public void setSchool(SchoolEntity school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", scholarship=" + scholarship +
                '}';
    }
}
