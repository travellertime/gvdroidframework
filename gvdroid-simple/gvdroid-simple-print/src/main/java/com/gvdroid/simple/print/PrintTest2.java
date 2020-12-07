package com.gvdroid.simple.print;

import com.gvdroid.simple.print.core.ParamBuilder;
import com.gvdroid.simple.print.core.TemplateBuilder;

import java.io.IOException;

public class PrintTest2 {

    public static void main(String[] args) {
        TemplateBuilder templateBuilder = new TemplateBuilder();
        ParamBuilder paramBuilder = new ParamBuilder();

        System.out.println(templateBuilder.buildTemplate());
        System.out.println(paramBuilder.buildParam());

        try {
            EscPos instance = EscPos.getInstance("192.168.8.188");
            instance.print(templateBuilder.buildTemplate(), paramBuilder.buildParam());
//            instance.print(templateBuilder.buildTemplate(), paramBuilder.buildParam());
//            EscPos.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
