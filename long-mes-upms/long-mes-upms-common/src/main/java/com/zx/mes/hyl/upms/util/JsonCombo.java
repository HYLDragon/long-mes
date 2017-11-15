package com.zx.mes.hyl.upms.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */
public class JsonCombo implements Serializable{
    private List rows = new ArrayList();

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
