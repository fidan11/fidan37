package az.charming.teachermanagement.controller.dto.request;

public class TeacherRequestDto {
    private Integer id;
    private String name;


    public Integer getId() {
        return id;
    }

    public TeacherRequestDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TeacherRequestDto setName(String name) {
        this.name = name;
        return this;
    }
}
