package com.example.fundInfo.console.controller;

import com.example.fundInfo.console.domain.FundinfoConsoleVo;
import com.example.fundInfo.module.entity.FundInfo;
import com.example.fundInfo.module.service.FundInfoConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/console/fundInfo")
public class FundInfoConsoleController {
    @Autowired
    private FundInfoConsoleService fundInfoConsoleService;

    @RequestMapping(value =  "/create",method = RequestMethod.GET)
    //@RequestMapping("/create")
    public int fundInfoCreate(@RequestParam(name = "fundCode") String fundCode,
                                 @RequestParam(name = "fundName") String fundName,
                                 @RequestParam(name = "fundRate") String fundRate,
                                 @RequestParam(name = "investTermType") Integer investTermType,
                                 @RequestParam(name = "startBuyMoney") BigInteger startBuyMoney,
                                 @RequestParam(name = "popularityValue") Integer popularityValue,
                                 @RequestParam(name = "publishTimeStart") Integer publishTimeStart,
                                 @RequestParam(name = "publishTimeEnd") Integer publishTimeEnd,
                                 @RequestParam(name = "riskGrade") Integer riskGrade,
                                 @RequestParam(name = "productSpecificationUrl") String productSpecificationUrl,
                                 @RequestParam(name = "pictureUrls") String pictureUrls
                                 ){

        return fundInfoConsoleService.createFundInfo(fundCode,fundName,fundRate,investTermType,startBuyMoney,popularityValue,publishTimeStart,publishTimeEnd,riskGrade,productSpecificationUrl,pictureUrls);
    }
    @RequestMapping("/console/updateFundInfo")
    public int fundInfoUpdate(FundInfo fundInfo) {
        return fundInfoConsoleService.updateFundInfo(fundInfo);

    }
    @RequestMapping("/console/delete")
    public int fundInfoDeleted(@RequestParam(name = "id") BigInteger id) {
        return fundInfoConsoleService.deleteFundInfo(id);
    }
}
