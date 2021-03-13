package az.charming.teachermanagement.controller;


import az.charming.teachermanagement.dto.StudentFormDto;
import az.charming.teachermanagement.entity.StudentEntity;
import az.charming.teachermanagement.repository.StudentRepository;
import az.charming.teachermanagement.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @RequestMapping(value = "students", method = {RequestMethod.GET})
    public String index(Model model,
                        @RequestParam(required = false) String name,//false demek mecburidir eks halda sehifeye daxil
                        // olduqda deyecek mene name,surname,age,scholarship gondermelisen
                        @RequestParam(required = false) String surname,
                        @RequestParam(required = false) Integer age,
                        @RequestParam(required = false) BigDecimal scholarship
    ) {

        List<StudentEntity> list = studentService.findAll(
                name,
                surname,
                age,
                scholarship
        );
//        for (StudentEntity l : list) {
//            System.out.println(l.getTeacherList());
//            System.out.println(l.getSchool());
//        }

        model.addAttribute("list", list);
        return "students/index";//bu urli goster
    }

    @RequestMapping(value = "students/add", method = {RequestMethod.POST})
    public String add(@ModelAttribute StudentEntity studentEntity    //bize FormDto gelir ve onun toEntity
//  methodunu cagiririq,toEntity methodu obyektin ozunden bir dene entity duzeltdi onu return eledi  ve
//  onu studentRepository inserte gonderirik.
    ) {
        studentRepository.save(studentEntity);

        return "redirect:/students";//yuxarida students/index etdikde biz sehifeni geri qaytaririq,burada ise
//      redirect edirik,bu ne demekdir?Biz burada insert edirik,insert etdikden sonra yeniden students urline
//      gonderirik,bu urle gonderende ise Get kimi gondermis olur,cunki default olaraq get gonderilir.
//      redirect-yeniden yonlendir students sehifesine
    }


    @RequestMapping(value = "students/update", method = {RequestMethod.POST})
    public String update(@ModelAttribute StudentEntity studentEntity
    ) {
        studentRepository.save(studentEntity);

        return "redirect:/students";
    }

    @RequestMapping(value = "students/delete", method = {RequestMethod.POST})
    public String delete(@RequestParam(required = false) Integer id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }

}
