package com.gvdroid.simple.print;

import java.io.IOException;

public class TestPrint {

    static String template = "{ \"bill\":[{\"bold\":true,\"format\":1,\"line\":2,\"size\":3,\"text\":\"实收现金\",\"type\":0,\"underline\":false},{\"bold\":true,\"format\":1,\"line\":2,\"size\":3,\"text\":\"{$cash}\",\"type\":0,\"underline\":false}],\"footer\":[{\"bold\":true,\"format\":1,\"line\":2,\"size\":3,\"text\":\"李亮（先生）\",\"type\":0,\"underline\":false},{\"bold\":true,\"format\":1,\"line\":2,\"size\":3,\"text\":\"顾客号码：13600010002\",\"type\":0,\"underline\":false}],\"goods\":[{\"format\":0,\"name\":\"商品名\",\"variable\":\"name\",\"width\":24},{\"format\":1,\"name\":\"数量\",\"variable\":\"num\",\"width\":8},{\"format\":1,\"name\":\"单价\",\"variable\":\"price\",\"width\":8},{\"format\":2,\"name\":\"金额\",\"variable\":\"pay\",\"width\":8}],\"header\":[{\"bold\":true,\"format\":0,\"line\":1,\"size\":2,\"text\":\"商家小票\",\"type\":0,\"underline\":false},{\"bold\":true,\"format\":0,\"line\":1,\"size\":1,\"text\":\"------------------------------------------------\",\"type\":0,\"underline\":false},{\"bold\":true,\"format\":1,\"line\":1,\"size\":2,\"text\":\"**#00留一手外卖**\",\"type\":0,\"underline\":false},{\"bold\":false,\"format\":1,\"line\":2,\"size\":1,\"text\":\"* 留一手火锅 *\",\"type\":0,\"underline\":false},{\"bold\":false,\"format\":0,\"line\":1,\"size\":1,\"text\":\"下单时间：2020-12-06 21:57:56\",\"type\":0,\"underline\":false},{\"bold\":true,\"format\":0,\"line\":1,\"size\":1,\"text\":\"------------------------------------------------\",\"type\":0,\"underline\":false},{\"bold\":true,\"format\":0,\"line\":2,\"size\":2,\"text\":\"备注：顾客需要餐具，还需要两个辣椒和一个洋葱\",\"type\":0,\"underline\":false},{\"bold\":true,\"format\":0,\"line\":2,\"size\":1,\"text\":\"************************************************\",\"type\":0,\"underline\":false},{\"bold\":false,\"format\":0,\"line\":2,\"size\":1,\"text\":\"------------------ 一号口袋 ------------------\",\"type\":0,\"underline\":false}],\"otherTitle\":[{\"bold\":true,\"format\":1,\"line\":1,\"size\":1,\"text\":\"-------------------- 其它 --------------------\",\"type\":0,\"underline\":false}],\"others\":[{\"format\":0,\"name\":\"商品名\",\"variable\":\"name\",\"width\":40},{\"format\":2,\"name\":\"金额\",\"variable\":\"pay\",\"width\":8}]}";
//            "{\n" +
//            "\"header\":[{\"bold\":true,\"format\":0,\"line\":1,\"size\":2,\"text\":\"商家小票\",\"type\":0,\"underline\":false},{\"bold\":true,\"format\":0,\"line\":1,\"size\":1,\"text\":\"------------------------------------------------\",\"type\":0,\"underline\":false},{\"bold\":true,\"format\":1,\"line\":1,\"size\":2,\"text\":\"**#00留一手外卖**\",\"type\":0,\"underline\":false},{\"bold\":false,\"format\":1,\"line\":2,\"size\":1,\"text\":\"*留一手火锅*\",\"type\":0,\"underline\":false},{\"bold\":false,\"format\":0,\"line\":1,\"size\":1,\"text\":\"下单时间：2020-12-06 21::57:56\",\"type\":0,\"underline\":false},{\"bold\":true,\"format\":0,\"line\":1,\"size\":1,\"text\":\"------------------------------------------------\",\"type\":0,\"underline\":false},{\"bold\":true,\"format\":0,\"line\":1,\"size\":2,\"text\":\"备注：顾客需要餐具\",\"type\":0,\"underline\":false},{\"bold\":true,\"format\":0,\"line\":1,\"size\":1,\"text\":\"************************************************\",\"type\":0,\"underline\":false}]," +
//            "    \"goods\": [\n" +
//            "        {\n" +
//            "            \"name\": \"商品名\",\n" +
//            "            \"width\": 24,\n" +
//            "            \"format\": 0,\n" +
//            "            \"variable\": \"name\"\n" +
//            "        },\n" +
//            "        {\n" +
//            "            \"name\": \"数量\",\n" +
//            "            \"width\": 8,\n" +
//            "            \"format\": 1,\n" +
//            "            \"variable\": \"num\"\n" +
//            "        },\n" +
//            "        {\n" +
//            "            \"name\": \"单价\",\n" +
//            "            \"width\": 8,\n" +
//            "            \"format\": 1,\n" +
//            "            \"variable\": \"price\"\n" +
//            "        },\n" +
//            "        {\n" +
//            "            \"name\": \"金额\",\n" +
//            "            \"width\": 8,\n" +
//            "            \"format\": 2,\n" +
//            "            \"variable\": \"pay\"\n" +
//            "        }\n" +
//            "    ],\n" +
//
//            "    \"bill\": [\n" +
//            "        {\n" +
//            "            \"text\": \"实收现金\",\n" +
//            "            \"size\": 3,\n" +
//            "            \"bold\": true,\n" +
//            "            \"format\": 1,\n" +
//            "            \"line\": 2,\n" +
//            "            \"underline\": false,\n" +
//            "            \"type\": 0\n" +
//            "        },\n" +
//            "        {\n" +
//            "            \"text\": \"{$cash}\",\n" +
//            "            \"size\": 3,\n" +
//            "            \"bold\": true,\n" +
//            "            \"format\": 1,\n" +
//            "            \"line\": 2,\n" +
//            "            \"underline\": false,\n" +
//            "            \"type\": 0\n" +
//            "        }\n" +
//            "    ],\n" +
//            "    \"footer\": [\n" +
//            "        {\n" +
//            "            \"text\": \"详情请访问官网\",\n" +
//            "            \"size\": 2,\n" +
//            "            \"bold\": true,\n" +
//            "            \"format\": 1,\n" +
//            "            \"line\": 2,\n" +
//            "            \"underline\": true,\n" +
//            "            \"type\": 0\n" +
//            "        },\n" +
//            "        {\n" +
//            "            \"text\": \"http://www.sublulu.com\",\n" +
//            "            \"format\": 1,\n" +
//            "            \"line\": 2,\n" +
//            "            \"type\": 2\n" +
//            "        }\n" +
//            "    ]\n" +
//            "}";

    static String params = "{\n" +
            "  \"keys\": {\n" +
            "    \"shopname\": \"黄太吉\",\n" +
            "    \"barCode\": \"6921734976505\",\n" +
            "    \"qrCode\": \"http://www.sublulu.com\",\n" +
            "    \"time\": \"15:35\",\n" +
            "    \"num\": 14,\n" +
            "    \"cash\": 324.5,\n" +
//            "    \"logo\": \"/sdcard/qr.png\",\n" +
            "    \"adv\": \"关注微信，有大大地活动哦\"\n" +
            "  },\n" +
            "  \"goods\": [\n" +
            "    {\n" +
            "      \"name\": \"外婆小炖菜+米饭套餐 \n 6.6折，原价36.00\",\n" +
            "      \"num\": 1,\n" +
            "      \"price\": 23.80,\n" +
            "      \"pay\": 23.80\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"筋头巴脑\",\n" +
            "      \"num\": 1,\n" +
            "      \"price\": 48.00,\n" +
            "      \"pay\": 48.00\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"我要加大米饭 \n（小碗菜不带米饭）\",\n" +
            "      \"num\": 1,\n" +
            "      \"price\": 2.00,\n" +
            "      \"pay\": 2.00\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"白灼菜心（现炒小份菜） \n，7.5折，原价7.90\",\n" +
            "      \"num\": 1,\n" +
            "      \"price\": 5.90,\n" +
            "      \"pay\": 5.90\n" +
            "    }\n" +
            "  ],\n" +
            "  \"others\": [\n" +
            "    {\n" +
            "      \"name\": \"打包费\",\n" +
            "      \"pay\": 3.00\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"配送费\",\n" +
            "      \"pay\": 6.00\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"减配送费6.00元\",\n" +
            "      \"pay\": -6.00\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"赠送绿豆汤 1份 x 1\",\n" +
            "      \"pay\": 5.90\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static void main(String[] args) {
        try {
            EscPos.getInstance("192.168.8.188");
            EscPos.print(template, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
