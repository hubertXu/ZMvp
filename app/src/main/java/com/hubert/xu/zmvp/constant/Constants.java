package com.hubert.xu.zmvp.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/14
 * Desc  :
 */

public class Constants {

    public static final String IMG_BASE_URL = "http://statics.zhuishushenqi.com";

    public static final String API_BASE_URL = "http://api.zhuishushenqi.com";

    // SPConstants
    public static final String IS_FIREST_START = "is_first_start";


    // complex discuss sort type
    public static final String TYPE_SORT_DEFAULT = "updated";

    public static final String TYPE_SORT_LATEST = "created";

    public static final String TYPE_SORT_MOST = "coment-count";
    // book type
    public static final String TYPE_BOOKE_ALL = "all";
    public static final String TYPE_BOOKE_XHQH = "xhqh";
    public static final String TYPE_BOOKE_XWXX = "wxxx";
    public static final String TYPE_BOOKE_DXYN = "dsyn";
    public static final String TYPE_BOOKE_LSJS = "lsjs";
    public static final String TYPE_BOOKE_YXJJ = "yxjj";
    public static final String TYPE_BOOKE_KHLY = "khly";
    public static final String TYPE_BOOKE_CYJK = "cyjk";
    public static final String TYPE_BOOKE_HMZC = "hmzc";
    public static final String TYPE_BOOKE_XDYQ = "xdyq";
    public static final String TYPE_BOOKE_GDYQ = "gdyq";
    public static final String TYPE_BOOKE_HXYQ = "hxyq";
    public static final String TYPE_BOOKE_DMTR = "dmtr";

    public static final int RANKING_TYPE_SIGN = 0;
    public static final int RANKING_TYPE = 1;

    public static List<String> sortType = new ArrayList<String>() {
        {
            add(TYPE_SORT_DEFAULT);
            add(TYPE_SORT_LATEST);
            add(TYPE_SORT_MOST);
        }
    };

    public static List<String> bookTypeList = new ArrayList<String>() {
        {
            add(TYPE_BOOKE_ALL);
            add(TYPE_BOOKE_XHQH);
            add(TYPE_BOOKE_XWXX);
            add(TYPE_BOOKE_DXYN);
            add(TYPE_BOOKE_LSJS);
            add(TYPE_BOOKE_YXJJ);
            add(TYPE_BOOKE_KHLY);
            add(TYPE_BOOKE_CYJK);
            add(TYPE_BOOKE_HMZC);
            add(TYPE_BOOKE_XDYQ);
            add(TYPE_BOOKE_GDYQ);
            add(TYPE_BOOKE_HXYQ);
            add(TYPE_BOOKE_DMTR);
        }
    };

    public static HashMap<String, String> bookTypeMap = new HashMap<String, String>() {
        {
            put("qt", "其它");
            put(TYPE_BOOKE_XHQH, "玄幻奇幻");
            put(TYPE_BOOKE_XWXX, "武侠仙侠");
            put(TYPE_BOOKE_DXYN, "都市异能");
            put(TYPE_BOOKE_LSJS, "历史军事");
            put(TYPE_BOOKE_YXJJ, "游戏竞技");
            put(TYPE_BOOKE_KHLY, "科幻灵异");
            put(TYPE_BOOKE_CYJK, "穿越架空");
            put(TYPE_BOOKE_HMZC, "豪门总裁");
            put(TYPE_BOOKE_XDYQ, "现代言情");
            put(TYPE_BOOKE_GDYQ, "古代言情");
            put(TYPE_BOOKE_HXYQ, "幻想言情");
            put(TYPE_BOOKE_DMTR, "耽美同人");
        }
    };
}
