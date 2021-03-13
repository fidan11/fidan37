package az.charming.teachermanagement.sevice;

import az.charming.teachermanagement.entity.StudentEntity;
import az.charming.teachermanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("alma")
public class StudentService2 implements StudentServiceInter{

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> findAll(String name, String surname, Integer age, BigDecimal scholarship) {//search basanda bosh olmasin deye yaziriq bunu
        if (isAllEmpty(name, surname, age, scholarship)) return studentRepository.findAll();
        return studentRepository.findByNameOrSurnameOrAgeOrScholarship(name, surname, age, scholarship);
    }

    public static boolean isAllEmpty(Object... objs) {//bu massivdi obyektlerin hamisini firladir forda
        for (Object obj : objs) {
            if (obj != null) System.out.println("obj=" + obj.toString());
            if (obj != null && !obj.toString().isEmpty()) return false;
        }
        return true;
    }
}
