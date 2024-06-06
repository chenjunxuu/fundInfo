package com.example.fundInfo.module.service;

import com.example.fundInfo.module.entity.FundInfo;
import com.example.fundInfo.module.mapper.FundInfoConsoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;
@Service
public class FundInfoConsoleService {
    @Resource
    private FundInfoConsoleMapper fundInfoConsoleMapper;

//    public List<FundInfo> fundAll(){
//        return fundInfoConsoleMapper.findAll();
//    }
//
//    public FundInfo fundById(Integer id){
//        return fundInfoConsoleMapper.findById(id);
//    }

    public int createFundInfo(String fundCode,String fundName,BigInteger fundRate,Integer investTermType,BigInteger startBuyMoney,Integer popularityValue,Integer publishTimeStart,Integer publishTimeEnd,Integer riskGrade,String productSpecificationUrl,String pictureUrls){
        return fundInfoConsoleMapper.createFundInfo(fundCode,fundName,fundRate,investTermType,startBuyMoney,popularityValue,publishTimeStart,publishTimeEnd,riskGrade,productSpecificationUrl,pictureUrls);
    }

    public int updateFundInfo(FundInfo fundInfo){
        return fundInfoConsoleMapper.updateFundInfo(fundInfo);
    }

    public int deleteFundInfo(BigInteger id){
        return fundInfoConsoleMapper.deleteFundInfo(id);
    }
}
