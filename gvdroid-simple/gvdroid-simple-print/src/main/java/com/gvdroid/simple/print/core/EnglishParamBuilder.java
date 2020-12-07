package com.gvdroid.simple.print.core;

import com.alibaba.fastjson.JSON;
import com.gvdroid.simple.print.dto.ParamDTO;
import com.gvdroid.simple.print.dto.ParamGoodsDTO;
import com.gvdroid.simple.print.dto.ParamKeysDTO;
import com.gvdroid.simple.print.dto.ParamOtherDTO;

import java.util.ArrayList;
import java.util.List;

public class EnglishParamBuilder {

    public String buildParam() {
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setKeys(buildParamKeys());
        paramDTO.setGoods(buildParamGoods());
        paramDTO.setOthers(buildParamOthers());
        return JSON.toJSONString(paramDTO);
    }

    private ParamKeysDTO buildParamKeys() {
        ParamKeysDTO dto = new ParamKeysDTO();
        dto.setBillTitle("Merchant Bill");
        dto.setQrCode("https://news.163.com/20/1207/20/FT970HRL000189FH.html?clickfrom=w_yw");
        dto.setBarCode("6921734976505");
        dto.setOrderTitle("LiuYiShou");
        dto.setStoreName("Liuyishou hotpot");
        dto.setOrderSubmitDatetime("order date: 2020-12-07 22:15:15");
        dto.setOrderMemo("remarks: remark big remark");
        dto.setOriginPrice("origin price：93.00");
        dto.setPaymentMethod("(payment online)");
        dto.setPaymentPrice("74011.09");
        dto.setCustomer("Mr.Jobs");
        dto.setCustomerContact("Customer: Mobile Suffix 8848");
        dto.setOrderSerialNo("98848");
        dto.setCompletedText("");
        dto.setPocketName("First Pocket");
        dto.setOtherName("Others");
        return dto;
    }

    private List<ParamOtherDTO> buildParamOthers() {
        List<ParamOtherDTO> dataList = new ArrayList<>();
        ParamOtherDTO other1 = new ParamOtherDTO();
        other1.setName("a lot of package fee.");
        other1.setPay("3.00");
        dataList.add(other1);

        ParamOtherDTO other2 = new ParamOtherDTO();
        other2.setName("delivery fee");
        other2.setPay("6.00");
        dataList.add(other2);

        ParamOtherDTO other3 = new ParamOtherDTO();
        other3.setName("discount delivery fee 6.00");
        other3.setPay("-6.00");
        dataList.add(other3);

        ParamOtherDTO other4 = new ParamOtherDTO();
        other4.setName("fee available tang x 1");
        other4.setPay("5.90");
        dataList.add(other4);

        return dataList;
    }

    private List<ParamGoodsDTO> buildParamGoods() {
        List<ParamGoodsDTO> dataList = new ArrayList<>();
        ParamGoodsDTO goods1 = new ParamGoodsDTO();
        goods1.setName("what goods i have ordered.what goods i have ordered.");
        goods1.setNum("12");
        goods1.setPrice("23.80");
        goods1.setPay("23.80");
        dataList.add(goods1);

        ParamGoodsDTO goods2 = new ParamGoodsDTO();
        goods2.setName("oh my good food.");
        goods2.setNum("1");
        goods2.setPrice("48.80");
        goods2.setPay("48.80");
        dataList.add(goods2);

        ParamGoodsDTO goods3 = new ParamGoodsDTO();
        goods3.setName("yes or no rice.");
        goods3.setNum("2");
        goods3.setPrice("2.80");
        goods3.setPay("5.60");
        dataList.add(goods3);

        ParamGoodsDTO goods4 = new ParamGoodsDTO();
        goods4.setName("good more food is a better thing for customer.");
        goods4.setNum("1");
        goods4.setPrice("5.89");
        goods4.setPay("5.89");
        dataList.add(goods4);
        return dataList;
    }
}
