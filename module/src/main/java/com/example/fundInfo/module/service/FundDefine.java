package com.example.fundInfo.module.service;

public enum FundDefine {
    INVERST_TERM_TYPE_DAY("按日申赎",1),
    INVERST_TERM_TYPE_WEEK("按周申购",2),
    INVERST_TERM_TYPE_MONTH("按月申赎",3);
    private final String desc;
    private final int index;
    FundDefine(String desc, int index) {
        this.desc = desc;
        this.index = index;
    }
    public static String covertFundInfoType(int index) {
        return switch (index) {
            case 1 -> INVERST_TERM_TYPE_DAY.desc;
            case 2 -> INVERST_TERM_TYPE_WEEK.desc;
            case 3 -> INVERST_TERM_TYPE_MONTH.desc;
            default -> "";
        };
    }
}
