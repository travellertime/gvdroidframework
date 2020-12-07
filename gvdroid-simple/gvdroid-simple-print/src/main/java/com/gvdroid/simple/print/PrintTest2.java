package com.gvdroid.simple.print;

import com.gvdroid.simple.print.core.ChineseParamBuilder;
import com.gvdroid.simple.print.core.EnglishParamBuilder;
import com.gvdroid.simple.print.core.TemplateBuilder;

import java.io.IOException;

public class PrintTest2 {

    public static void main(String[] args) {
        TemplateBuilder templateBuilder = new TemplateBuilder();
        ChineseParamBuilder chineseParamBuilder = new ChineseParamBuilder();
        EnglishParamBuilder englishParamBuilder = new EnglishParamBuilder();

        System.out.println(templateBuilder.buildTemplate());
        System.out.println(chineseParamBuilder.buildParam());

        try {
//            EscPos instance = EscPos.getInstance("192.168.8.188");
//            instance.print(templateBuilder.buildTemplate(), chineseParamBuilder.buildParam());

            EscPos eng = EscPos.getInstance("192.168.8.188", "UTF-8");
            eng.print(templateBuilder.buildTemplate(), englishParamBuilder.buildParam());
//            instance.print(templateBuilder.buildTemplate(), paramBuilder.buildParam());
//            EscPos.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
