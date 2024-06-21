package com.example.fundInfo.app.controller;
import com.example.fundInfo.app.domain.AppFundInfoListVo;
import com.example.fundInfo.app.domain.AppFundInfoVo;
import com.example.fundInfo.module.entity.FundInfo;
import com.example.fundInfo.module.service.FundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fundInfo")
public class FundInfoAppController {
    @Autowired
    private FundInfoService fundInfoService;


    //http://localhost:8080/fundInfo/all
    //查询基金列表
    @RequestMapping("/all")
    public List<AppFundInfoListVo> getAllFundInfo(){

        List<FundInfo> fundInfoList = new ArrayList<>();
        fundInfoList = fundInfoService.findAll();
        List<AppFundInfoListVo> AppFundInfoListVos = new ArrayList<>();
        for (FundInfo fundInfo : fundInfoList) {

            AppFundInfoListVo appFundInfoListVo = new AppFundInfoListVo();
            appFundInfoListVo.setId(fundInfo.getId());
            appFundInfoListVo.setFundName(fundInfo.getFundName());

            Long RateMin = Long.valueOf(String.valueOf(fundInfo.getYieldRateMin()));
            Long z = RateMin/100;
            Long r = RateMin%100;
            String yieldRateMin = String.valueOf(String.valueOf(z)+"."+String.valueOf(r));

            Long RateMax = Long.valueOf(String.valueOf(fundInfo.getYieldRateMax()));
            Long zMax = RateMax/100;
            Long rMax = RateMax%100;
            String yieldRateMax = String.valueOf(String.valueOf(zMax)+"."+String.valueOf(rMax));

            //appFundInfoListVo.setFundRate((String.valueOf(fundInfo.getYieldRateMin()))+"%"+"-"+(String.valueOf(fundInfo.getYieldRateMax()))+"%");
            appFundInfoListVo.setFundRate(yieldRateMin+"%"+"-"+yieldRateMax+"%");

            appFundInfoListVo.setInvestTermType(String.valueOf(fundInfo.getInvestTermType()));
            appFundInfoListVo.setStartBuyMoney(String.valueOf(fundInfo.getStartBuyMoney()));
            appFundInfoListVo.setPopularityValue(fundInfo.getPopularityValue());
            // 图片地址
            List<String> split = new ArrayList<>();
            split = List.of(fundInfo.getPicturesUrl().split("\\$"));
            appFundInfoListVo.setPictureUrl(split.get(0));
            AppFundInfoListVos.add(appFundInfoListVo);
        }
        return AppFundInfoListVos;
    }
    //http://localhost:8080/fundInfo/info?id=1
    //查询基金详情
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
        // 时间格式转换
        String timeStart = String.valueOf(fundInfo.getPublishTimeStart());
        String timeEnd = String.valueOf(fundInfo.getPublishTimeEnd());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String publishTimeStart = simpleDateFormat.format(Long.valueOf(timeStart));
        String publishTimeEnd = simpleDateFormat.format(Long.valueOf(timeEnd));
        appFundInfoVo.setPublishTime(publishTimeStart+" -- "+publishTimeEnd);

        appFundInfoVo.setRiskGrade(fundInfo.getRiskGrade());
        appFundInfoVo.setProductSpecificationUrl(fundInfo.getProductSpecificationUrl());
        // 图片地址
        List<String> split = new ArrayList<>();
        split = List.of(fundInfo.getPicturesUrl().split("\\$"));
        appFundInfoVo.setPicturesUrl(split);
        return appFundInfoVo;
    }
}
