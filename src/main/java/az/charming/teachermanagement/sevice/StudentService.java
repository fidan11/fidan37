package az.charming.teachermanagement.sevice;

import az.charming.teachermanagement.entity.StudentEntity;
import az.charming.teachermanagement.repository.StudentRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

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


//    public List<StudentEntity> findByAgeAndName(String name, Integer age) {
//        return studentRepository.findAll(new Specification<StudentEntity>() {
//            public Predicate toPredicate(Root<StudentEntity> root,
//                                         CriteriaQuery<?> query,
//                                         CriteriaBuilder cb) {
//                Predicate namePredicate = cb.equal(root.get("name"), name);
//                Predicate agePredicate = cb.equal(root.get("age"), age);
//                return cb.and(agePredicate, namePredicate);
//            }
//        });

//    __________________________
//    (1:53-cu deqiqe)

//    public List<StudentEntity> findByAgeAndName(String name, Integer age) {
//        return studentRepository.findAll(new Specification<StudentEntity>() {
//            public Predicate toPredicate(Root<StudentEntity> root,
//                                         CriteriaQuery<?> query,
//                                         CriteriaBuilder cb) {
//                List<Predicate> predicates = new ArrayList<>();
//                if (name != null && name.trim().length() > 0) {
//                    predicates.add(cb.equal(root.get("name"), name));
//                }
//                if (age != null && age > 0) {
//                    predicates.add(cb.equal(root.get("age"), age));
//                }
//
//                Predicate[] arr = new Predicate[predicates.size()];
//                return cb.and(predicates.toArray(arr));
//            }
//        });

    //    _________________________
//    (2:00-cu deqiqe)
    public List<StudentEntity> findByAgeAndName(String name, Integer age) {
        Specification<StudentEntity> specification = new Specification<StudentEntity>() {
            public Predicate toPredicate(Root<StudentEntity> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (name != null && name.trim().length() > 0) {
                    predicates.add(cb.equal(root.get("name"), name));
                }
                if (age != null && age > 0) {
                    predicates.add(cb.equal(root.get("age"), age));
                }

                Predicate[] arr = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(arr));
            }
        };
        return studentRepository.findAll(specification);
    }
}