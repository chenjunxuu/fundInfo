package com.example.fundInfo.module.service;

import com.example.fundInfo.module.entity.FundInfo;
import com.example.fundInfo.module.mapper.FundInfoMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FundInfoService {
    @Resource
    private FundInfoMapper fundInfoMapper;

    public List<FundInfo> findAll() {
        return fundInfoMapper.findAll();
    }

    public FundInfo findInfoById(Integer id) {
        return fundInfoMapper.findInfoById(id);
    }
}
