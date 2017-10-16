package com.zx.mes.model.mes;

import java.util.Date;

public class Care {
    private String id;

    private String name;

    private Date createdatetime;

    private Date modifydatetime;

    private String remark;

    private String caretypeId;

    public CareType getCareType() {
        return careType;
    }

    public void setCareType(CareType careType) {
        this.careType = careType;
    }

    private CareType careType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    public Date getModifydatetime() {
        return modifydatetime;
    }

    public void setModifydatetime(Date modifydatetime) {
        this.modifydatetime = modifydatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCaretypeId() {
        return caretypeId;
    }

    public void setCaretypeId(String caretypeId) {
        this.caretypeId = caretypeId == null ? null : caretypeId.trim();
    }
}