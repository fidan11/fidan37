package az.charming.teachermanagement.controller.dto.request;

public class SchoolRequestDto {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public SchoolRequestDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SchoolRequestDto setName(String name) {
        this.name = name;
        return this;
    }
}
