package com.wanxi.util;

public enum PathEnum {
    PATH("C:\\Users\\25677\\IdeaProjects\\lv-shi02-11-1\\web\\note"),
    FILE_NAME_COMPANY("company.txt"),
    FILE_NAME_NAV("nav.txt"),
    FILE_NAME_NEWS_FOR_HOME_PAGE("newsForHomePage.txt"),
    COMMA(",");

    //xml 配置

    /**
     * PeizhiModel =readResource（“E:\wanxi\step-3\canyin03-0615\src\resources\faces-config.xml”）
     */
//    PathEnum() {
//
//    }

    private String path;

    public String getPath() {
        return path;
    }

    PathEnum(String path) {
        this.path = path;
    }
//    public static final String FILE_NAME_COMPANY = "company.txt";
//    public static final String FILE_NAME_NAV = "nav.txt";
//    public static final String FILE_NAME_NEWS_FOR_HOME_PAGE = "newsForHomePage.txt";
//    public static final String COMMA = ",";
}
