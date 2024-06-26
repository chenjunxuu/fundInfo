package com.example.fundInfo.console.controller;

import com.example.fundInfo.module.service.FundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/console/fundInfo")
public class FundInfoConsoleController {
    @Autowired
    private FundInfoService fundInfoService;

    @RequestMapping(value =  "/create",method = RequestMethod.GET)
    //@RequestMapping("/create")
    public String fundInfoCreate(@RequestParam(name = "fundCode") String fundCode,
                                 @RequestParam(name = "fundName") String fundName,
                                 @RequestParam(name = "fundRate") String fundRate,
                                 @RequestParam(name = "investTermType") Integer investTermType,
                                 @RequestParam(name = "startBuyMoney") BigInteger startBuyMoney,
                                 @RequestParam(name = "popularityValue") Integer popularityValue,
                                 @RequestParam(name = "publishTimeStart") Integer publishTimeStart,
                                 @RequestParam(name = "publishTimeEnd") Integer publishTimeEnd,
                                 @RequestParam(name = "riskGrade") Integer riskGrade,
                                 @RequestParam(name = "productSpecificationUrl") String productSpecificationUrl,
                                 @RequestParam(name = "picturesUrl") String picturesUrl
                                 ){
        int result = fundInfoService.createFundInfo(fundCode,fundName,fundRate,investTermType,startBuyMoney,popularityValue,publishTimeStart,publishTimeEnd,riskGrade,productSpecificationUrl,picturesUrl);
        return 1 == result ? "成功" : "失败";
    }
    @RequestMapping(value = "/update" ,method = RequestMethod.GET)
    public String fundInfoUpdate(@RequestParam(name = "id") BigInteger id,
                              @RequestParam(name = "fundCode") String fundCode,
                              @RequestParam(name = "fundName") String fundName,
                              @RequestParam(name = "fundRate") String fundRate,
                              @RequestParam(name = "investTermType") Integer investTermType,
                              @RequestParam(name = "startBuyMoney") BigInteger startBuyMoney,
                              @RequestParam(name = "popularityValue") Integer popularityValue,
                              @RequestParam(name = "publishTimeStart") Integer publishTimeStart,
                              @RequestParam(name = "publishTimeEnd") Integer publishTimeEnd,
                              @RequestParam(name = "riskGrade") Integer riskGrade,
                              @RequestParam(name = "productSpecificationUrl") String productSpecificationUrl,
                              @RequestParam(name = "picturesUrl") String picturesUrl) {
        int result = fundInfoService.updateFundInfo(id,fundCode,fundName,fundRate,investTermType,startBuyMoney,popularityValue,publishTimeStart,publishTimeEnd,riskGrade,productSpecificationUrl,picturesUrl);
        return 1 == result ? "成功" : "失败";

    }
    @RequestMapping("/delete")
    public String fundInfoDeleted(@RequestParam(name = "id") BigInteger id) {
        int result = fundInfoService.deleteFundInfo(id);
        return 1 == result ? "成功" : "失败";
    }
}
