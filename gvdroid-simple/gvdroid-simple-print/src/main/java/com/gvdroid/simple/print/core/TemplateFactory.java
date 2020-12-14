package com.gvdroid.simple.print.core;

public class TemplateFactory {

    public static TemplateService getInstance(PaperSizeEnum paperSizeEnum) {
        if (paperSizeEnum == PaperSizeEnum.s56) {
            return new Template56Builder();
        }
        return new Template80Builder();
    }
}
