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

    int createFundInfo(@Param("fundCode") String fundCode,
                          @Param("fundName") String fundName,
                          @Param("fundRate") BigInteger fundRate,
                          @Param("investTermType") Integer investTermType,
                          @Param("startBuyMoney") BigInteger startBuyMoney,
                          @Param("popularityValue") Integer popularityValue,
                          @Param("publishTimeStart") Integer publishTimeStart,
                          @Param("publishTimeEnd") Integer publishTimeEnd,
                          @Param("riskGrade") Integer riskGrade,
                          @Param("productSpecificationUrl") String productSpecificationUrl,
                          @Param("pictureUrls") String pictureUrls);


    int updateFundInfo(@Param("fundInfo") FundInfo fundInfo);

    int deleteFundInfo(@Param("id") BigInteger id);
}
