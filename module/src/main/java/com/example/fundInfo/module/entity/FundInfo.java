package com.example.fundInfo.module.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Data
@Accessors(chain = true)
public class FundInfo {
    private BigInteger id;
    private String fundCode;
    private String fundName;
    private Integer yieldRateMin;
    private Integer yieldRateMax;
    private Integer investTermType;
    private BigInteger startBuyMoney;
    private Integer popularityValue;
    private Integer publishTimeStart;
    private Integer publishTimeEnd;
    private Integer riskGrade;
    private String productSpecificationUrl;
    private String picturesUrl;
    private Integer createTime;
    private Integer updateTime;
    private Integer isDeleted;

}