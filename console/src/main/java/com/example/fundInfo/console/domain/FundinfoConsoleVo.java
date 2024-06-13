package com.example.fundInfo.console.domain;

import java.math.BigInteger;

public class FundinfoConsoleVo {
    private String fundCode;
    private String fundName;
    private String fundRate;
    private Integer investTermType;
    private BigInteger startBuyMoney;
    private Integer popularityValue;
    private Integer publishTimeStart;
    private Integer publishTimeEnd;
    private Integer riskGrade;
    private String productSpecificationUrl;
    private String pictureUrls;

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

    public String getFundRate() {
        return fundRate;
    }

    public void setFundRate(String fundRate) {
        this.fundRate = fundRate;
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

    public String getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(String pictureUrls) {
        this.pictureUrls = pictureUrls;
    }
}
