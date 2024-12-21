package com.example.fundInfo.console.controller;
import com.example.fundInfo.console.domain.FundInfoListPageVo;
import com.example.fundInfo.console.domain.FundInfoList;
import com.example.fundInfo.module.entity.FundInfo;
import com.example.fundInfo.module.service.FundDefine;
import com.example.fundInfo.module.service.FundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/console/fundInfo")
public class FundInfoConsoleController {
    @Autowired
    private FundInfoService fundInfoService;
    @RequestMapping(value = "/create")
    public String fundInfoCreate(@RequestParam(name = "fundCode") String fundCode,
                                 @RequestParam(name = "fundName") String fundName,
                                 @RequestParam(name = "fundRateMin") String fundRateMin,
                                 @RequestParam(name = "fundRateMax") String fundRateMax,
                                 @RequestParam(name = "investTermType") Integer investTermType,
                                 @RequestParam(name = "startBuyMoney") BigInteger startBuyMoney,
                                 @RequestParam(name = "popularityValue",required = false) Integer popularityValue,
                                 @RequestParam(name = "publishTimeStart") Integer publishTimeStart,
                                 @RequestParam(name = "publishTimeEnd") Integer publishTimeEnd,
                                 @RequestParam(name = "riskGrade") Integer riskGrade,
                                 @RequestParam(name = "productSpecificationUrl",required = false) String productSpecificationUrl,
                                 @RequestParam(name = "picturesUrl") String picturesUrl){
        fundCode = fundCode.trim();
        fundName = fundName.trim();
        fundRateMin = fundRateMin.trim();
        fundRateMax = fundRateMax.trim();
        if ( fundCode.isEmpty() || fundName.isEmpty() ||
                fundRateMin.isEmpty() || fundRateMax.isEmpty() ) {
            return "参数错误";
        }
        int result = fundInfoService.createFundInfo(fundCode,fundName,fundRateMin,fundRateMax,investTermType,startBuyMoney,popularityValue,
                        publishTimeStart,publishTimeEnd,riskGrade,productSpecificationUrl,picturesUrl);
        return 1 == result ? "成功" : "失败";
    }
    @RequestMapping(value = "/update")
    public String fundInfoUpdate(@RequestParam(name = "id") BigInteger id,
                                 @RequestParam(name = "fundCode") String fundCode,
                                 @RequestParam(name = "fundName") String fundName,
                                 @RequestParam(name = "fundRateMin") String fundRateMin,
                                 @RequestParam(name = "fundRateMax") String fundRateMax,
                                 @RequestParam(name = "investTermType") Integer investTermType,
                                 @RequestParam(name = "startBuyMoney") BigInteger startBuyMoney,
                                 @RequestParam(name = "popularityValue",required = false) Integer popularityValue,
                                 @RequestParam(name = "publishTimeStart") Integer publishTimeStart,
                                 @RequestParam(name = "publishTimeEnd") Integer publishTimeEnd,
                                 @RequestParam(name = "riskGrade") Integer riskGrade,
                                 @RequestParam(name = "productSpecificationUrl",required = false) String productSpecificationUrl,
                                 @RequestParam(name = "picturesUrl") String picturesUrl) {
        fundCode = fundCode.trim();
        fundName = fundName.trim();
        fundRateMin = fundRateMin.trim();
        fundRateMax = fundRateMax.trim();
        if (fundCode.isEmpty() || fundName.isEmpty() ||
                fundRateMin.isEmpty() || fundRateMax.isEmpty()) {
            return "参数错误";
        }
        int result =
                fundInfoService.updateFundInfo(id,fundCode,fundName,fundRateMin,fundRateMax,investTermType,
                        startBuyMoney,popularityValue,publishTimeStart,publishTimeEnd,riskGrade,productSpecificationUrl,picturesUrl);
        return 1 == result ? "成功" : "失败";
    }
    @RequestMapping("/list")
    public FundInfoListPageVo fundInfoListByPage(@RequestParam(name =
            "currentPage") Integer currentPage,@RequestParam(name = "name") String name){
        int pageSize = 2;
        List<FundInfo> fundInfos = fundInfoService.getFundInfoByPage(currentPage,pageSize,name);
        List<FundInfoList> fundInfoList = new ArrayList<>();
        if(!fundInfos.isEmpty()){
            for (FundInfo fundInfo : fundInfos) {
                FundInfoList fundInfoVo = new FundInfoList();
                fundInfoVo.setId(fundInfo.getId());
                fundInfoVo.setFundName(fundInfo.getFundName());
                if (fundInfo.getYieldRateMin() > 0){
                    StringBuilder sb = new StringBuilder();
                    float rateMin = fundInfo.getYieldRateMin() / 100f;
                    float rateMax = fundInfo.getYieldRateMax() / 100f;
                    String fundRate =
                            sb.append(String.format("%.2f",rateMin)).append("%").append("-").append(String.format("%.2f",rateMax)).append("%").toString();
                                    fundInfoVo.setFundRate(fundRate);
                }
                //投资周期
                fundInfoVo.setInvestTermType(FundDefine.covertFundInfoType(fundInfo.getInvestTermType()));
                StringBuilder sbMoney = new StringBuilder();
                String sbm = String.valueOf(fundInfo.getStartBuyMoney());
                String zMoney = sbm.substring(0, sbm.length()-2);
                String yMoney = sbm.substring(sbm.length()-2);
                String startBuyMoney = sbMoney.append("￥").append(zMoney).append(".").append(yMoney).toString();
                fundInfoVo.setStartBuyMoney(startBuyMoney);
                fundInfoVo.setPopularityValue(fundInfo.getPopularityValue());
                // 图片地址
                List<String> split = List.of(fundInfo.getPicturesUrl().split("\\$"));
                fundInfoVo.setPictureUrl(split.get(0));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                fundInfoVo.setCreateTime(simpleDateFormat.format(fundInfo.getCreateTime()*1000L));
                fundInfoVo.setUpdateTime(simpleDateFormat.format(fundInfo.getUpdateTime()*1000L));
                fundInfoList.add(fundInfoVo);
            }
            FundInfoListPageVo fundInfoListPage = new FundInfoListPageVo();
            fundInfoListPage.setFundInfoList(fundInfoList);
            fundInfoListPage.setTotalSize(fundInfoService.getTotalCount());
            fundInfoListPage.setPageSize(pageSize);
            return fundInfoListPage;
        }else {
            return null;
        }
    };
    @RequestMapping("/delete")
    public String fundInfoDeleted(@RequestParam(name = "id") BigInteger id) {
        int result = fundInfoService.deleteFundInfo(id);
        return 1 == result ? "成功" : "失败";
    }
}