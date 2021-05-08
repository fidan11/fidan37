package az.charming.teachermanagement.sevice.business.vacation;

import az.charming.teachermanagement.dto.StudentDto;
import az.charming.teachermanagement.sevice.functional.StudentService;
import org.springframework.stereotype.Service;

@Service
public class VacationService {

    private StudentService studentService;

    public void submitVacation(VacationSubmitDto vacationSubmitDto) {
        studentService.save(new StudentDto().setName(vacationSubmitDto.getSubmitter()));//studentserviceni insert
//        etmek isteyirik.Hemin telebeni yaziriq bazaya.VacationSubmitDto-nun baza ile hec bir elaqesi yoxdur,
//        bunun service classi ile elaqesi var,ki kimse otpusk almaq istese bu obyekte gondersin ve bashlayacaq iceride
//    ishlemeye. new StudentDto studentService aiddir ve bir basha baza ile elaqeli dto-dur,lakin VacationSubmitDto
//        xeyir.
    }
}
