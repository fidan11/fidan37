package az.charming.teachermanagement.repository;

import az.charming.teachermanagement.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>, JpaSpecificationExecutor {
//    (ders-35,part2,1:8-ci deqiqe)

    List<StudentEntity> findByNameOrSurnameOrAgeOrScholarship(String name, String surname, Integer age, BigDecimal scholarship);

    @Query(value = "select s from StudentEntity s where s.school.id=:id and s.age=:age ")
    List<StudentEntity> findAllBySchoolIdAndAge(@Param("id") Integer id, @Param("age") Integer age);


    @Query(nativeQuery = true, value = "select s.* from student s where s.school_id=:id and s.age=:age ")
    List<StudentEntity> findAllBySchoolIdAndAge2(@Param("id") Integer id, @Param("age") Integer age);


    List<StudentEntity> nqFindBySshoolIdAndAge(Integer schoolId, String name);

    List<StudentEntity> findAllByNameOrderByAgeDesc(String name);


//    _______________________________________________________________

//    List<StudentEntity> findByNameOrSurnameOrAgeOrScholarship(String name, String surname, Integer age, BigDecimal scholarship);

    //burada yazdigimiz sutun adlari olmamalidir, ona gore ki biz obyektler ile ishleyirik,yeni bizim gozumuz ancaq
//    deyishen gormelidir,class gormelidir,obyekt gormelidir,yeni biz query dusunmemeliyik.
//    (String name...)-deyishen adinin methoddaki ad ile ust uste dusmeyi vacib deyil,deyishen adina hershey yaza bilerik,
//    sadece yeri duzgun yazmaliyiq,yeni name demishikse birinci name-ye oturacaq ikinci surname-ye ve s.


    //bu funksiya iceride avtomatik implementasiya olunacaq ada,soyada ve yasha gore axtarish funksiyalari queryler bura
// elave olunacaq ve biz bu methodu cagirmaq ile ada soyada ve yasha gore axtarish vermish olacagiq. Yeni esline baxsaq
// spring data daha cox ORM-dir neyin ki JPA, cunki JPA default olaraq spesifikasiyasinda qeyd elemeyib ki, mutleq bele
// bir shey olmalidir, amma spring data quranlar fikirlesibler ki, bele bir shey olsa daha cox ORM olariq, daha cox OOP
//yonumlu olariq,yeni adam sozun esil menasinda query yazmaz,bir kelme yazar axtariram name-ye,surname-ye,age gore.
}
//spring-data
//java persistence api   jpa orm-in java ucun spesifikasiyasidir
//orm - object relational mapping

