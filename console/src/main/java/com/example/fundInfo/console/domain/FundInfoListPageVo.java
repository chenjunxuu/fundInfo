package com.example.fundInfo.console.domain;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.List;
@Data
@Accessors(chain = true)
public class FundInfoListPageVo {
    private Integer totalSize;
    private Integer pageSize;
    private List<FundInfoList> fundInfoList;
}
