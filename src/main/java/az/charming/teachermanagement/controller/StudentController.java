package az.charming.teachermanagement.controller;


import az.charming.teachermanagement.dto.StudentDto;
import az.charming.teachermanagement.entity.StudentEntity;
import az.charming.teachermanagement.repository.StudentRepository;
import az.charming.teachermanagement.sevice.functional.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("students")//StudentControllere gele bilmesi ucun students yazmaliyiq
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @GetMapping
    public String index(Model model,
                        @RequestParam(required = false) String name,//false demek mecburidir eks halda sehifeye daxil
                        // olduqda deyecek mene name,surname,age,scholarship gondermelisen
                        @RequestParam(required = false) String surname,
                        @RequestParam(required = false) Integer age,
                        @RequestParam(required = false) BigDecimal scholarship
    ) {

        List<StudentDto> list = studentService.findAll(
                name,
                surname,
                age,
                scholarship
        );

        model.addAttribute("list", list);
        return "students/index";//bu urli goster
    }

    @PostMapping(value = "/add")
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


    @PostMapping(value = "/update")
    public String update(@ModelAttribute StudentEntity studentEntity
    ) {
        studentRepository.save(studentEntity);

        return "redirect:/students";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam(required = false) Integer id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }

}
