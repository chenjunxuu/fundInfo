package com.example.fundInfo.module.mapper;

import com.example.fundInfo.module.entity.FundInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;
import java.util.List;

public interface FundInfoConsoleMapper {
    @Select("select * from fund_info where is_deleted = 0")
    List<FundInfo> findAll();

    @Select("select * from fund_info where id = #{id} and is_deleted = 0")
    FundInfo findById(@Param("id") Integer id);


    int insert(@Param("fundInfo") FundInfo fundInfo);


    int update(@Param("fundInfo") FundInfo fundInfo);

    int delete(@Param("id") BigInteger id);
}
