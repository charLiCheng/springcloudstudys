package com.charli.common.constant;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2019/11/8 11:01
 */
public class Constant {

    private Constant() {

    }
    //--------------------------- 符号常量 -----------------------
    /**
     * 连接号
     */
    public static final String HYPHEN_CHART = "-";
    /**
     * 波浪号(时间拼接)
     */
    public static final String TILDE_CHART = "~";
    /**
     * 逗号
     */
    public static final String COMMA_CHART = ",";
    /**
     * 冒号
     */
    public static final String COLON_CHART = ":";
    /**
     * 百分号
     */
    public static final String PERCENT_SIGN = "%";
    /**
     * 问号
     */
    public static final String QUESTION_MARK = "?";
    /**
     * 斜杠
     */
    public static final String SLASH = "/";
    /**
     * 双斜杠
     */
    public static final String SLASH_DOUBLE = "//";
    /**
     * 下划线
     */
    public static final String UNDERLINE = "_";

    /**
     * 点
     */
    public static final String SPOT = ".";

    //-------------------------- 字符串常量 -----------------------
    /**
     * 数字字符串
     */
    public static final String STRING_ZERO = "0";
    public static final String STRING_ONE = "1";
    public static final String STRING_TWO = "2";
    public static final String STRING_THREE = "3";

    //--------------------------- 数字常量 -----------------------

    public static final int INT_ZERO = 0;
    public static final int INT_ONE = 1;
    public static final int INT_TWO = 2;
    public static final int INT_THREE = 3;
    public static final int INT_FOUR = 4;
    public static final int INT_FIVE = 5;
    public static final int INT_SIX = 6;
    public static final int INT_SEVEN = 7;
    public static final int INT_EIGHT = 8;
    public static final int INT_NINE = 9;
    public static final int INT_TEN = 10;
    public static final int INT_ELEVEN = 11;
    public static final int INT_TWELVE = 12;
    public static final int INT_THIRTEEN = 13;
    public static final int INT_FOURTEEN = 14;
    public static final int INT_FIFTEEN = 15;
    public static final int INT_SIXTEEN = 16;
    public static final int INT_TWENTY = 20;
    public static final int INT_THIRTY = 30;
    public static final int INT_TWOHUNDRED = 200;
    public static final int INT_TWOHUNDREDONE = 201;

    public static final int INT_ONE_HUNDRED_AND_TWENTY_EIGHT = 128;
    public static final int INT_TWO_HUNDRED_AND_FIFTY_SIX = 256;
    public static final int INT_FIVE_HUNDRED_AND_TWELVE = 512;
    public static final int INT_THOUSAND = 1000;

    public static final long LONG_ZERO = 0L;
    public static final long LONG_ONT = 1L;
    public static final long LONG_TWO = 2L;

    // 负整数 -------------------------

    public static final Long LONG_NEGATIVE_TEN = -10L;
    public static final Long LONG_NEGATIVE_TWENTY = -20L;
    public static final Long LONG_NEGATIVE_THIRTY = -30L;
    public static final Long LONG_NEGATIVE_FORTY = -40L;


    /**
     * 已删除
     */
    public static final int DELETED = 0;
    /**
     * 未删除
     */
    public static final int UNDELETED = 1;
    //--------------------------- 日期格式 ------------------------

    public static final String DATE_LONG_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 性别
     */
    public static final String FIELD_SEX = "sex";
    /**
     * 排序位置
     */
    public static final String FIELD_TO_SEQ = "toSeq";


    //------------------------用户登录过期时间----------------------------------

    public static final int LOGIN_EXPIRE_TIME = 60 * 60;
    public static final int REFRESH_TOKEN_EXPIRE_TIME = 60 * 60 * 24 * 7;

    //---------------------------   其他  ------------------------

    /**
     * 菜单树根目录
     */
    public static final String TREE_ROOT_NAME = "根目录";
    /**
     * 添加用户 :无角色
     */
    public static final Long NO_ROLE_ID = -1L;

    public static final String NO_ROLE_NAME = "无角色";

    /**
     * 正则匹配
     */
    public static final String regex = "[0-9a-zA-Z]{3,15}";


    // ----------------图片后缀格式--------------------------------------

    public static final String SUB_JPG = ".jpg";
    public static final String SUB_PNG = ".png";

    /**
     * Excel文件类型-值域
     */
    public static final String[] EXCEL_ARRAY = {"xls", "xlsx", "xlsm", "xlsb", "xltx", "xltm", "xlt", "xlam", "xla"};

    // ----------------- excel 文件后缀格式 -------------------

    public static final String EXCEL_SUB_XLS = ".xls";
    public static final String EXCEL_SUB_XLSX = ".xlsx";
}
