package com.example.fundInfo.app.domain;

import java.math.BigInteger;
//基金列表Vo
public class AppFundInfoList {
    private BigInteger id;
    //基金名称
    private String fundName;
    //收益率
    private String fundRate;
    //投资期限
    private String investTermType;
    //起购金额
    private String startBuyMoney;
    //人气值
    private Integer popularityValue;
    //图片地址
    private String pictureUrl;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
