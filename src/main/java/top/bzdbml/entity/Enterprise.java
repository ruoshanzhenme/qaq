package top.bzdbml.entity;

import lombok.Data;

@Data
public class Enterprise {
    private Long id;
    private String logo;
    private String name;
    private String englishName;
    private String abbreviation;
    private String personInCharge;
    private Integer phone;
    private String email;
}
