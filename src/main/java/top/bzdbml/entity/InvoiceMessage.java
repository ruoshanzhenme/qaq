package top.bzdbml.entity;

import lombok.Data;

@Data
public class InvoiceMessage {
    private Long id;
    private String enterpriseName;
    private String dutyParagraph;
    private String address;
    private Integer phone;
    private String bank;
    private Integer account;
    private Integer messageType;
    private Long enterpriseId;


}
