package com.example.fundInfo.app.controller;

import com.example.fundInfo.module.entity.FundInfo;
import com.example.fundInfo.module.service.FundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fundInfo")
public class FundInfoAppController {
    @Autowired
    private FundInfoService fundInfoService;
    //http://localhost:8080/fundInfo/all
    @RequestMapping("/all")
    public List<FundInfo> getAllFundInfo(){
        return fundInfoService.findAll();
    }
    //http://localhost:8080/fundInfo/info?id=1
    @RequestMapping("/info")
    public FundInfo getFundInfoById(@RequestParam(name = "id") Integer id){
        return fundInfoService.findInfoById(id);
    }
}
