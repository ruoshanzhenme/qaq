package top.bzdbml.mybatis;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.bzdbml.entity.InvoiceMessage;

@Mapper
@Repository
public interface InvoiceMessageRepository {
    @Select("select * from invoice_message where id= #{id}")
    InvoiceMessage get(Long id);

    @Delete("delete from invoice_message where id=#{id}")
    void delete(Long id);

    @Insert(("INSERT INTO test.invoice_message (enterprise_name, duty_paragraph, address, phone, bank, account, message_type,enterprise_id) VALUES (#{enterpriseName}," +
            "#{dutyParagraph}," +
            "#{address}," +
            "#{phone}," +
            "#{bank}," +
            "#{account}," +
            "#{messageType}," +
            "#{enterpriseId})"))
    void insert(InvoiceMessage a);

    @Update("update invoice_message set enterprise_name= #{enterpriseName},duty_paragraph=#{dutyParagraph},address=#{address},phone=#{phone},bank=#{bank},account=#{account},message_type=#{messageType},enterprise_id=#{enterpriseId}")
    void update(InvoiceMessage b);

    @Select("select count(*) from invoice_message")
    Long count();

}
