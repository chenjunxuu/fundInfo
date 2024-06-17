package com.example.fundInfo.app.domain;

import java.math.BigInteger;

public class AppFundInfoVo {
    private BigInteger id;

    private String fundId;
    //产品名称
    private String fundName;
    //收益率
    private String fundRate;
    //投资期限
    private String investTermType;
    //起购金额
    private String startBuyMoney;
    //人气值
    private Integer popularityValue;
    //发行时间
    private String publishTime;
    //风险等级
    private Integer riskGrade;
    //产品说明书
    private String productSpecificationUrl;
    //图片地址
    private String[] pictureUrl;



    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
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

    public String getInvestTermType() {
        return investTermType;
    }

    public void setInvestTermType(String investTermType) {
        this.investTermType = investTermType;
    }

    public String getStartBuyMoney() {
        return startBuyMoney;
    }

    public void setStartBuyMoney(String startBuyMoney) {
        this.startBuyMoney = startBuyMoney;
    }

    public Integer getPopularityValue() {
        return popularityValue;
    }

    public void setPopularityValue(Integer popularityValue) {
        this.popularityValue = popularityValue;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
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

    public String[] getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String[] pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
