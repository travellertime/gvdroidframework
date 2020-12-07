package com.gvdroid.simple.print.core;

import com.alibaba.fastjson.JSON;
import com.gvdroid.simple.print.dto.ParamDTO;
import com.gvdroid.simple.print.dto.ParamGoodsDTO;
import com.gvdroid.simple.print.dto.ParamKeysDTO;
import com.gvdroid.simple.print.dto.ParamOtherDTO;

import java.util.ArrayList;
import java.util.List;

public class ChineseParamBuilder {

    public String buildParam() {
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setKeys(buildParamKeys());
        paramDTO.setGoods(buildParamGoods());
        paramDTO.setOthers(buildParamOthers());
        return JSON.toJSONString(paramDTO);
    }

    private ParamKeysDTO buildParamKeys() {
        ParamKeysDTO dto = new ParamKeysDTO();
        dto.setBillTitle("商家小票");
        dto.setQrCode("https://news.163.com/20/1207/20/FT970HRL000189FH.html?clickfrom=w_yw");
        dto.setBarCode("6921734976505");
        dto.setOrderTitle("留一手外卖");
        dto.setStoreName("留一手火锅");
        dto.setOrderSubmitDatetime("下单时间：2020-12-07 22:15:15");
        dto.setOrderMemo("备注：顾客需要餐具，还需要两个辣椒和一个洋葱");
        dto.setOriginPrice("原价：93.00元");
        dto.setPaymentMethod("（用户在线支付）");
        dto.setPaymentPrice("74011.09元");
        dto.setCustomer("乔布斯（先生）");
        dto.setCustomerContact("顾客号码：手机尾号 8848");
        dto.setOrderSerialNo("98848");
        dto.setCompletedText("完");
        dto.setPocketName("一号口袋");
        dto.setOtherName("其它");

        return dto;
    }

    private List<ParamOtherDTO> buildParamOthers() {
        List<ParamOtherDTO> dataList = new ArrayList<>();
        ParamOtherDTO other1 = new ParamOtherDTO();
        other1.setName("打包费打包费打包费打包费打包费打包打包费打包费打包费打包费打包费打包打包费打包费打包费打包费打包费打包打包费打包费打包费打包费打包费打包打包费打包费打包费打包费打包费打包打包费打包费打包费打包费打包费打包打包费打包费打包费打包费打包费打包");
        other1.setPay("3.00");
        dataList.add(other1);

        ParamOtherDTO other2 = new ParamOtherDTO();
        other2.setName("配送费");
        other2.setPay("6.00");
        dataList.add(other2);
        
        ParamOtherDTO other3 = new ParamOtherDTO();
        other3.setName("减配送费6.00元");
        other3.setPay("-6.00");
        dataList.add(other3);
        
        ParamOtherDTO other4 = new ParamOtherDTO();
        other4.setName("赠送绿豆汤 1份 x 1");
        other4.setPay("5.90");
        dataList.add(other4);
        
        return dataList;
    }

    private List<ParamGoodsDTO> buildParamGoods() {
        List<ParamGoodsDTO> dataList = new ArrayList<>();
        ParamGoodsDTO goods1 = new ParamGoodsDTO();
        goods1.setName("外婆小炖菜+米饭套餐6.6折，原价36.00外婆小炖菜+米饭套餐6.6折，原价36.00");
        goods1.setNum("12");
        goods1.setPrice("23.80");
        goods1.setPay("23.80");
        dataList.add(goods1);

        ParamGoodsDTO goods2 = new ParamGoodsDTO();
        goods2.setName("筋头巴脑");
        goods2.setNum("1");
        goods2.setPrice("48.80");
        goods2.setPay("48.80");
        dataList.add(goods2);

        ParamGoodsDTO goods3 = new ParamGoodsDTO();
        goods3.setName("我要加大米饭（小碗菜不带米饭）");
        goods3.setNum("220");
        goods3.setPrice("2.80");
        goods3.setPay("5.60");
        dataList.add(goods3);

        ParamGoodsDTO goods4 = new ParamGoodsDTO();
        goods4.setName("白灼菜心（现炒小份菜），7.5折，原价7.90");
        goods4.setNum("1");
        goods4.setPrice("5.89");
        goods4.setPay("5.89");
        dataList.add(goods4);
        return dataList;
    }


}
