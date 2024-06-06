package com.example.fundInfo.module.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class FundInfo {
    private int id;
    private String findCode;
    private String findName;
    private BigInteger yiedRateMin;
    private BigInteger yiedRateMax;
    private Integer investTermType;
    private BigInteger startBuyMoney;
    private Integer popularityValue;
    private Integer publishTimeStart;
    private Integer publishTimeEnd;
    private Integer riskGrade;
    private String productSpecificationUrl;
    private String pictureUrl;
    private Integer createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFindCode() {
        return findCode;
    }

    public void setFindCode(String findCode) {
        this.findCode = findCode;
    }

    public String getFindName() {
        return findName;
    }

    public void setFindName(String findName) {
        this.findName = findName;
    }

    public BigInteger getYiedRateMin() {
        return yiedRateMin;
    }

    public void setYiedRateMin(BigInteger yiedRateMin) {
        this.yiedRateMin = yiedRateMin;
    }

    public BigInteger getYiedRateMax() {
        return yiedRateMax;
    }

    public void setYiedRateMax(BigInteger yiedRateMax) {
        this.yiedRateMax = yiedRateMax;
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

    private Integer updateTime;
    private Integer isDelete;


}