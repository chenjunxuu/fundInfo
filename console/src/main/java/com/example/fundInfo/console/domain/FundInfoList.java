package com.example.fundInfo.console.domain;

import lombok.Data;
import java.math.BigInteger;

@Data
public class FundInfoList {
    private BigInteger id;
    //产品名称
    private String fundName;
    //收益率
    private String fundRate;

    //产品期限
    private String InvestTermType;
    //起购金额
    private String startBuyMoney;
    //人气值
    private Integer popularityValue;
    //图片
    private String pictureUrl;
    //创建时间
    private String createTime;
    //修改时间
    private String updateTime;
}
