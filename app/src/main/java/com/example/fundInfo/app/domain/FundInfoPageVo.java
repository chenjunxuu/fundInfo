package com.example.fundInfo.app.domain;

import lombok.Data;

import java.util.List;

@Data
public class FundInfoPageVo {
    private Boolean isEnd;
    private List<AppFundInfoList> appFundInfoList;
}
