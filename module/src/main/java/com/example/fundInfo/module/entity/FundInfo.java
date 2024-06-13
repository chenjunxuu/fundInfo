package com.example.fundInfo.module.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class FundInfo {
    private int id;
    private String fundCode;
    private String fundName;
    private BigInteger yieldRateMin;
    private BigInteger yieldRateMax;
    private Integer investTermType;
    private BigInteger startBuyMoney;
    private Integer popularityValue;
    private Integer publishTimeStart;
    private Integer publishTimeEnd;
    private Integer riskGrade;
    private String productSpecificationUrl;
    private String pictureUrl;
    private Integer createTime;
    private Integer updateTime;
    private Integer isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public BigInteger getYieldRateMin() {
        return yieldRateMin;
    }

    public void setYieldRateMin(BigInteger yieldRateMin) {
        this.yieldRateMin = yieldRateMin;
    }

    public BigInteger getYieldRateMax() {
        return yieldRateMax;
    }

    public void setYieldRateMax(BigInteger yieldRateMax) {
        this.yieldRateMax = yieldRateMax;
    }

    public Integer getInvestTermType() {
        return investTermType;
    }

    public void setInvestTermType(Integer investTermType) {
        this.investTermType = investTermType;
    }

    public BigInteger getStartBuyMoney() {
        return startBuyMoney;
    }

    public void setStartBuyMoney(BigInteger startBuyMoney) {
        this.startBuyMoney = startBuyMoney;
    }

    public Integer getPopularityValue() {
        return popularityValue;
    }

    public void setPopularityValue(Integer popularityValue) {
        this.popularityValue = popularityValue;
    }

    public Integer getPublishTimeStart() {
        return publishTimeStart;
    }

    public void setPublishTimeStart(Integer publishTimeStart) {
        this.publishTimeStart = publishTimeStart;
    }

    public Integer getPublishTimeEnd() {
        return publishTimeEnd;
    }

    public void setPublishTimeEnd(Integer publishTimeEnd) {
        this.publishTimeEnd = publishTimeEnd;
    }

    public Integer getRiskGrade() {
        return riskGrade;
    }

    public void setRiskGrade(Integer riskGrade) {
        this.riskGrade = riskGrade;
    }

    public String getProductSpecificationUrl() {
        return productSpecificationUrl;
    }

    public void setProductSpecificationUrl(String productSpecificationUrl) {
        this.productSpecificationUrl = productSpecificationUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }




}