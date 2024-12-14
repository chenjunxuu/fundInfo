package com.example.fundInfo.app.controller;
import com.example.fundInfo.app.domain.AppFundInfoList;
import com.example.fundInfo.app.domain.AppFundInfoVo;
import com.example.fundInfo.app.domain.FundInfoPageVo;
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
import com.example.fundInfo.module.service.FundDefine;
@RestController
@RequestMapping("/fundInfo")
public class FundInfoAppController {
    @Autowired
    private FundInfoService fundInfoService;
    //http://localhost:8080/fundInfo/all
//查询基金列表
    @RequestMapping("/all")
    public FundInfoPageVo getAllFundInfo(@RequestParam(name = "currentPage")
                                         Integer currentPage) {
        int pageSize = 3;
        List<FundInfo> fundInfoList = fundInfoService.getFundInfoByPage(currentPage, pageSize);
        List<AppFundInfoList> appFundInfoListVos = new ArrayList<>();
        FundInfoPageVo fundInfoPageVo = new FundInfoPageVo();
        if (!fundInfoList.isEmpty()) {
            for (FundInfo fundInfo : fundInfoList) {
                AppFundInfoList appFundInfoListVo = new AppFundInfoList();
                appFundInfoListVo.setId(fundInfo.getId());
                appFundInfoListVo.setFundName(fundInfo.getFundName());
                if (fundInfo.getYieldRateMin() > 0) {
                    StringBuilder sb = new StringBuilder();
                    float rateMin = fundInfo.getYieldRateMin() / 100f;
                    float rateMax = fundInfo.getYieldRateMax() / 100f;
                    String fundRate = sb.append(String.format("%.2f",
                                    rateMin)).append("%").append("-")
                            .append(String.format("%.2f",
                                    rateMax)).append("%").toString();
                    appFundInfoListVo.setFundRate(fundRate);
                }
//投资周期
                appFundInfoListVo.setInvestTermType(FundDefine.covertFundInfoType(fundInfo.getInvestTermType()));
                StringBuilder sbMoney = new StringBuilder();
                String sbm = String.valueOf(fundInfo.getStartBuyMoney());
                String zMoney = sbm.substring(0, sbm.length() - 2);
                String yMoney = sbm.substring(sbm.length() - 2);
                String startBuyMoney =
                        sbMoney.append("￥").append(zMoney).append(".").append(yMoney).toString();
                appFundInfoListVo.setStartBuyMoney(startBuyMoney);
                appFundInfoListVo.setPopularityValue(fundInfo.getPopularityValue());
// 图片地址
                List<String> split = new ArrayList<>();
                split = List.of(fundInfo.getPicturesUrl().split("\\$"));
                appFundInfoListVo.setPictureUrl(split.get(0));
                appFundInfoListVos.add(appFundInfoListVo);
            }
        }
        fundInfoPageVo.setIsEnd(appFundInfoListVos.size()<pageSize);
        fundInfoPageVo.setAppFundInfoList(appFundInfoListVos);
        return fundInfoPageVo;
    }
    //http://localhost:8080/fundInfo/info?id=1
//查询基金详情
    @RequestMapping("/info")
    public AppFundInfoVo getFundInfoById(@RequestParam(name = "id") BigInteger
                                                 id) {
//FundInfo fundInfo = new FundInfo();
//fundInfo 可能为空，需要做判空处理
        FundInfo fundInfo = fundInfoService.findInfoById(id);
        if (fundInfo != null) {
            AppFundInfoVo appFundInfoVo = new AppFundInfoVo();
            appFundInfoVo.setId(id);
            appFundInfoVo.setFundId(fundInfo.getFundCode());
            appFundInfoVo.setFundName(fundInfo.getFundName());
            if (fundInfo.getYieldRateMin() > 0) {
                StringBuilder sb = new StringBuilder();
                float rateMin = fundInfo.getYieldRateMin() / 100f;
                float rateMax = fundInfo.getYieldRateMax() / 100f;
                String fundRate = sb.append(String.format("%.2f", rateMin)).append("%").append("-")
                        .append(String.format("%.2f",
                                rateMax)).append("%").toString();
                appFundInfoVo.setFundRate(fundRate);
            }
            // /100
            StringBuilder sb = new StringBuilder();
            String sbm = String.valueOf(fundInfo.getStartBuyMoney());
            String zMoney = sbm.substring(0, sbm.length() - 2);
            String yMoney = sbm.substring(sbm.length() - 2);
            appFundInfoVo.setStartBuyMoney(sb.append("￥").append(zMoney).append(".").append
                    (yMoney).toString());
            appFundInfoVo.setPopularityValue(fundInfo.getPopularityValue());
//投资周期类型
            appFundInfoVo.setInvestTermType(FundDefine.covertFundInfoType(fundInfo.getInvestTermType()));
// 时间格式转换
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            String publishTimeStart = simpleDateFormat.format((fundInfo.getPublishTimeStart()) * 1000L);
            String publishTimeEnd = simpleDateFormat.format((fundInfo.getPublishTimeEnd()) * 1000L);
            appFundInfoVo.setPublishTime(publishTimeStart + " - " + publishTimeEnd);
            appFundInfoVo.setRiskGrade(fundInfo.getRiskGrade());
            appFundInfoVo.setProductSpecificationUrl(fundInfo.getProductSpecificationUrl());
            // 图片地址
            List<String> split = new ArrayList<>();
            split = List.of(fundInfo.getPicturesUrl().split("\\$"));
            appFundInfoVo.setPicturesUrl(split);
            return appFundInfoVo;
        } else {
            return null;
        }
    }
}