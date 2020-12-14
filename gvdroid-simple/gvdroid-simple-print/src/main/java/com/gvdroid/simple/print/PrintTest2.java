package com.gvdroid.simple.print;

import com.gvdroid.simple.print.core.*;

import java.io.IOException;

public class PrintTest2 {

    public static void main(String[] args) {
//        Template80Builder template80Builder = new Template80Builder();
        ChineseParamBuilder chineseParamBuilder = new ChineseParamBuilder();
//        EnglishParamBuilder englishParamBuilder = new EnglishParamBuilder();

        TemplateService templateService = TemplateFactory.getInstance(PaperSizeEnum.s80);

        System.out.println(templateService.buildTemplate());
        System.out.println(chineseParamBuilder.buildParam());

        try {
//            EscPos instance = EscPos.getInstance("192.168.8.198");
//            instance.print(template80Builder.buildTemplate(), chineseParamBuilder.buildParam());

//            EscPos eng = EscPos.getInstance("192.168.8.188", "UTF-8");
//            eng.print(templateBuilder.buildTemplate(), englishParamBuilder.buildParam());
//            instance.print(templateBuilder.buildTemplate(), paramBuilder.buildParam());
//            EscPos.print();
            EscPos instance = EscPos.getInstance("192.168.8.188");
            instance.print(templateService.buildTemplate(), chineseParamBuilder.buildParam());

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
