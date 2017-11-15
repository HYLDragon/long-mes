package com.zx.mes.hyl.upms.util;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/7.
 */
public class Combobox implements Serializable{
    private String id;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
