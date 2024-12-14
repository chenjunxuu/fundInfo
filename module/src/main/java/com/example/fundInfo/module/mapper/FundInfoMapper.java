package com.example.fundInfo.module.mapper;
import com.example.fundInfo.module.entity.FundInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.math.BigInteger;
import java.util.List;
@Mapper
public interface FundInfoMapper {
    @Select("select * from fund_info where is_deleted = 0")
    List<FundInfo> findAll();
    @Select("select * from fund_info where id = #{id} and is_deleted = 0")
    FundInfo findInfoById(@Param("id") BigInteger id);
    int insert(@Param("fundInfo") FundInfo fundInfo);

    int update(@Param("fundInfo") FundInfo fundInfo);
    @Update("update fund_info set is_deleted = 1,update_time = #{time} where id = #{id}")
    int delete(@Param("id") BigInteger id, @Param("time") Integer time);

    List<FundInfo> findList(@Param("startIndex") Integer startIndex,
                            @Param("pageSize") Integer pageSize);
    @Select("select count(*) from fund_info where is_deleted = 0")
    int count();
}