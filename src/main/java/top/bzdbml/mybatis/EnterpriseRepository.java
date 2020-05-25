package top.bzdbml.mybatis;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.bzdbml.entity.Enterprise;

@Mapper
@Repository
public interface EnterpriseRepository {

    @Select("select * from enterprise where id= #{id} ")
    Enterprise get(Long id);

    @Delete("delete from enterprise where id= #{id}")
    void delete(Long id);

    @Insert("INSERT INTO test.enterprise (english_name, abbreviation, person_in_charge, phone, email, logo, name) VALUES (#{englishName}," +
            "#{abbreviation}," +
            "#{personInCharge}," +
            "#{phone}," +
            "#{email}," +
            "#{logo}," +
            "#{name})")
    void insert(Enterprise e);

    @Update("update enterprise set  english_name=#{englishName}, abbreviation=#{abbreviation}, person_in_charge=#{personInCharge}, phone=#{phone}, email=#{email}, logo=#{logo}, name=#{name}  where id=#{id}")
    void update(Enterprise jb);

    @Select("SELECT COUNT(*) FROM enterprise")
    Long count();


}

