package com.example.fundInfo.app.controller;
import com.example.fundInfo.app.domain.AppFundInfoVo;
import com.example.fundInfo.module.entity.FundInfo;
import com.example.fundInfo.module.service.FundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fundInfo")
public class FundInfoAppController {
    @Autowired
    private FundInfoService fundInfoService;


    //http://localhost:8080/fundInfo/all
    @RequestMapping("/all")
    public List<AppFundInfoVo> getAllFundInfo(){

        List<FundInfo> fundInfoList = new ArrayList<>();
        fundInfoList = fundInfoService.findAll();
        List<AppFundInfoVo> appFundInfoVos = new ArrayList<>();
        for (FundInfo fundInfo : fundInfoList) {
            AppFundInfoVo appFundInfoVo = new AppFundInfoVo();
            appFundInfoVo.setId(fundInfo.getId());
            appFundInfoVo.setFundName(fundInfo.getFundName());
            appFundInfoVo.setFundRate((String.valueOf(fundInfo.getYieldRateMin()))+"%"+"-"+(String.valueOf(fundInfo.getYieldRateMax()))+"%");
            appFundInfoVo.setInvestTermType(String.valueOf(fundInfo.getInvestTermType()));
            appFundInfoVo.setStartBuyMoney(String.valueOf(fundInfo.getStartBuyMoney()));
            appFundInfoVo.setPopularityValue(fundInfo.getPopularityValue());
            // 图片地址
            List<String> split = new ArrayList<>();
            split = List.of(fundInfo.getPictureUrl().split("\\$"));
            appFundInfoVo.setPictureUrl(split);
            appFundInfoVos.add(appFundInfoVo);
        }
        return appFundInfoVos;
    }
    //http://localhost:8080/fundInfo/info?id=1
    @RequestMapping("/info")
    public AppFundInfoVo getFundInfoById(@RequestParam(name = "id") BigInteger id){
        FundInfo fundInfo = new FundInfo();
        fundInfo = fundInfoService.findInfoById(id);
        AppFundInfoVo appFundInfoVo = new AppFundInfoVo();
        appFundInfoVo.setId(id);
        appFundInfoVo.setFundId(fundInfo.getFundCode());
        appFundInfoVo.setFundName(fundInfo.getFundName());
        appFundInfoVo.setFundRate(fundInfo.getFundCode());
        appFundInfoVo.setStartBuyMoney(String.valueOf((fundInfo.getStartBuyMoney())));
        appFundInfoVo.setPopularityValue(fundInfo.getPopularityValue());
        appFundInfoVo.setInvestTermType(String.valueOf(fundInfo.getInvestTermType()));
        appFundInfoVo.setPublishTime(String.valueOf(fundInfo.getPublishTimeStart())+"-"+String.valueOf(fundInfo.getPublishTimeEnd()));
        appFundInfoVo.setRiskGrade(fundInfo.getRiskGrade());
        appFundInfoVo.setProductSpecificationUrl(fundInfo.getProductSpecificationUrl());
        // 图片地址
        List<String> split = new ArrayList<>();
        split = List.of(fundInfo.getPictureUrl().split("\\$"));
        appFundInfoVo.setPictureUrl(split);
        return appFundInfoVo;
    }
}
