package com.example.fundInfo.module.service;
import com.example.fundInfo.module.entity.FundInfo;
import com.example.fundInfo.module.mapper.FundInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@Service
public class FundInfoService {
    @Resource
    private FundInfoMapper fundInfoMapper;
    public List<FundInfo> findAll() {
        return fundInfoMapper.findAll();
    }
    public FundInfo findInfoById(BigInteger id) {
        return fundInfoMapper.findInfoById(id);
    }
    public int createFundInfo(String fundCode, String fundName, String
            fundRateMin, String fundRateMax,
                              Integer investTermType, BigInteger startBuyMoney,
                              Integer popularityValue,
                              Integer publishTimeStart, Integer publishTimeEnd,
                              Integer riskGrade,
                              String productSpecificationUrl, String picturesUrl)
    {
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        FundInfo fundInfo = new FundInfo();
        if (fundCode != null && fundCode.length() > 0) {
            fundInfo.setFundCode(fundCode);
        } else {
            return -1;
        }
        if (fundName != null && fundName.length() > 0) {
            fundInfo.setFundName(fundName);
        } else {
            return -1;
        }
        //2.20%-2.40%
        if (fundRateMin != null && fundRateMin.length() > 0) {
            fundInfo.setYieldRateMin(Integer.valueOf(fundRateMin));
        } else {
            return -1;
        }
        if (fundRateMax != null && fundRateMax.length() > 0) {
            fundInfo.setYieldRateMax(Integer.valueOf(fundRateMax));
        } else {
            return -1;
        }
        fundInfo.setInvestTermType(investTermType);
        fundInfo.setStartBuyMoney(startBuyMoney);
        fundInfo.setPopularityValue(popularityValue);
        fundInfo.setPublishTimeStart(publishTimeStart);
        fundInfo.setPublishTimeEnd(publishTimeEnd);
        fundInfo.setRiskGrade(riskGrade);
        fundInfo.setProductSpecificationUrl(productSpecificationUrl);
        fundInfo.setPicturesUrl(picturesUrl);
        fundInfo.setCreateTime(timestamp);
        fundInfo.setUpdateTime(timestamp);
        fundInfo.setIsDeleted(0);
        return fundInfoMapper.insert(fundInfo);
    }
    public int updateFundInfo(BigInteger id, String fundCode, String fundName,
                              String fundRateMin, String fundRateMax, Integer investTermType, BigInteger
                                      startBuyMoney, Integer popularityValue, Integer publishTimeStart, Integer
                                      publishTimeEnd, Integer riskGrade, String productSpecificationUrl, String
                                      picturesUrl) {
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        FundInfo fundInfo = new FundInfo();
        fundInfo.setId(id);
        if (fundCode != null && fundCode.length() > 0) {
            fundInfo.setFundCode(fundCode);
        } else {
            return -1;
        }
        if (fundName != null && fundName.length() > 0) {
            fundInfo.setFundName(fundName);
        } else {
            return -1;
        }
//2.20%-2.40%
        if (fundRateMin != null && fundRateMin.length() > 0) {
            fundInfo.setYieldRateMin(Integer.valueOf(fundRateMin));
        } else {
            return -1;
        }
        if (fundRateMax != null && fundRateMax.length() > 0) {
            fundInfo.setYieldRateMax(Integer.valueOf(fundRateMax));
        } else {
            return -1;
        }
        fundInfo.setInvestTermType(investTermType);
        fundInfo.setStartBuyMoney(startBuyMoney);
        fundInfo.setPopularityValue(popularityValue);
        fundInfo.setPublishTimeStart(publishTimeStart);
        fundInfo.setPublishTimeEnd(publishTimeEnd);
        fundInfo.setRiskGrade(riskGrade);
        fundInfo.setProductSpecificationUrl(productSpecificationUrl);
        fundInfo.setPicturesUrl(picturesUrl);
        fundInfo.setUpdateTime(timestamp);
        fundInfo.setIsDeleted(0);
        return fundInfoMapper.update(fundInfo);
    }
    public List<FundInfo> getFundInfoByPage(int currentPage, int pageSize) {
        int startIndex = (currentPage - 1) * pageSize;
        return fundInfoMapper.findList(startIndex, pageSize);
    }
    public int getTotalCount() {
        return fundInfoMapper.count();
    }
    public int deleteFundInfo(BigInteger id) {
        return fundInfoMapper.delete(id, ((int) (System.currentTimeMillis() /
                1000)));
    }
}