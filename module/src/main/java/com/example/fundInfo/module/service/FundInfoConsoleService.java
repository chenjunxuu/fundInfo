package com.example.fundInfo.module.service;

import com.example.fundInfo.module.entity.FundInfo;
import com.example.fundInfo.module.mapper.FundInfoConsoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;

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

    public int createFundInfo(String fundCode,String fundName,String fundRate,Integer investTermType,BigInteger startBuyMoney,Integer popularityValue,Integer publishTimeStart,Integer publishTimeEnd,Integer riskGrade,String productSpecificationUrl,String pictureUrls){
        int timestamp = (int)(System.currentTimeMillis()/1000);
        FundInfo fundInfo = new FundInfo();

        fundInfo.setFundCode(fundCode);
        fundInfo.setFundName(fundName);
        //2.20%-2.40%
        String[] rates;
        rates = fundRate.split("-",2);
        String yieldRateMin = rates[0].replace("%","").replace(".","");
        String yieldRateMax = rates[1].replace("%","").replace(".","");
//        for(int i=0;i<rates.length;i++){
//            System.out.println(i+":"+rates[i]);
//        }
        fundInfo.setYieldRateMin(BigInteger.valueOf(Long.parseLong(yieldRateMin)));
        fundInfo.setYieldRateMax(BigInteger.valueOf(Long.parseLong(yieldRateMax)));
        fundInfo.setInvestTermType(investTermType);
        fundInfo.setStartBuyMoney(startBuyMoney);
        fundInfo.setPopularityValue(popularityValue);
        fundInfo.setPublishTimeStart(publishTimeStart);
        fundInfo.setPublishTimeEnd(publishTimeEnd);
        fundInfo.setRiskGrade(riskGrade);
        fundInfo.setProductSpecificationUrl(productSpecificationUrl);
        fundInfo.setPictureUrl(pictureUrls);
        fundInfo.setCreateTime(timestamp);
        fundInfo.setIsDelete(0);
        return fundInfoConsoleMapper.insert(fundInfo);
    }

    public int updateFundInfo(BigInteger id, String fundCode,String fundName,String fundRate,Integer investTermType,BigInteger startBuyMoney,Integer popularityValue,Integer publishTimeStart,Integer publishTimeEnd,Integer riskGrade,String productSpecificationUrl,String pictureUrls){
        int timestamp = (int)(System.currentTimeMillis()/1000);
        FundInfo fundInfo = new FundInfo();
        fundInfo.setId(id);
        fundInfo.setFundCode(fundCode);
        fundInfo.setFundName(fundName);
        //2.20%-2.40%
        String[] rates;
        rates = fundRate.split("-",2);
        String yieldRateMin = rates[0].replace("%","").replace(".","");
        String yieldRateMax = rates[1].replace("%","").replace(".","");
//        for(int i=0;i<rates.length;i++){
//            System.out.println(i+":"+rates[i]);
//        }
        fundInfo.setYieldRateMin(BigInteger.valueOf(Long.parseLong(yieldRateMin)));
        fundInfo.setYieldRateMax(BigInteger.valueOf(Long.parseLong(yieldRateMax)));
        fundInfo.setInvestTermType(investTermType);
        fundInfo.setStartBuyMoney(startBuyMoney);
        fundInfo.setPopularityValue(popularityValue);
        fundInfo.setPublishTimeStart(publishTimeStart);
        fundInfo.setPublishTimeEnd(publishTimeEnd);
        fundInfo.setRiskGrade(riskGrade);
        fundInfo.setProductSpecificationUrl(productSpecificationUrl);
        fundInfo.setPictureUrl(pictureUrls);
        fundInfo.setUpdateTime(timestamp);
        fundInfo.setIsDelete(0);
        return fundInfoConsoleMapper.update(fundInfo);
    }

    public int deleteFundInfo(BigInteger id){
        return fundInfoConsoleMapper.delete(id,((int)(System.currentTimeMillis()/1000)));
    }
}
