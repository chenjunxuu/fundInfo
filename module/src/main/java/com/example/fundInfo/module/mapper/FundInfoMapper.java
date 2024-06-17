package com.example.fundInfo.module.mapper;

import com.example.fundInfo.module.entity.FundInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.math.BigInteger;
import java.util.List;



@Mapper
public interface FundInfoMapper {
    @Select("select * from fund_info where is_deleted = 0")
    List<FundInfo> findAll();

    @Select("select * from fund_info where id = #{id} and is_deleted = 0")
    FundInfo findInfoById(@Param("id") BigInteger id);
}
