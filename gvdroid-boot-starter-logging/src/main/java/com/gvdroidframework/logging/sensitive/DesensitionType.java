/*
 * Copyright 2014-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gvdroidframework.logging.sensitive;

public enum DesensitionType {
    /**
     * 手机号脱敏
     * "(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}"
     * "(\\d{3})\\d{4}(\\d{4})"
     */
    PHONE("mobile", "11位手机号", "(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{4}(\\d{4}}", "$1****$2"),
    IDENTITYNO("identityNo", "15或者18身份证号", "(\\w{4})\\w{7,10}(\\w{4})", "$1****$2"),
    BANKCARDNO("bankCardNo", "银行卡号", "(\\d{4})\\d*(\\d{4})", "$1****$2"),
    REALNAME("realname","真实姓名Json类型","(\"realname\":)(\"[\u4E00-\u9FA5]{1})[\u4E00-\u9FA5]{1,}(\")","$1$2**$3"),
    REALNAME2("realname","真实姓名toString类型","(realname=)([\u4E00-\u9FA5]{1})[\u4E00-\u9FA5]{1,}","$1$2**"),
    CUSTOM("custom", "自定义正则处理", ""),
    TRUNCATE("truncate", "字符串截取处理", ""),
    ;
    String type;
    String describe;
    String[] regular;
    DesensitionType(String type, String describe, String... regular) {
        this.type = type;
        this.describe = describe;
        this.regular = regular;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String[] getRegular() {
        return regular;
    }

    public void setRegular(String[] regular) {
        this.regular = regular;
    }
}
