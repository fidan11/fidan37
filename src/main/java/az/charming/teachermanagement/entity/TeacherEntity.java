package az.charming.teachermanagement.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "teacher")
public class TeacherEntity {

    @Id
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal salary;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "student_teacher",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentEntity> studentList;

    public Integer getId() {
        return id;
    }

    public az.charming.teachermanagement.entity.TeacherEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public az.charming.teachermanagement.entity.TeacherEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public az.charming.teachermanagement.entity.TeacherEntity setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public az.charming.teachermanagement.entity.TeacherEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public az.charming.teachermanagement.entity.TeacherEntity setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';

    }

}
