package com.zx.mes.model.admin;

import com.zx.mes.dao.admin.BugTypeMapper;

import java.util.Date;

public class Bug {
    private String id;

    private Date createdatetime;

    private Date modifydatetime;

    private String name;

    private String note;

    private String bugtypeId;

    private BugType bugType;

    public BugType getBugType() {
        return bugType;
    }

    public void setBugType(BugType bugType) {
        this.bugType = bugType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getBugtypeId() {
        return bugtypeId;
    }

    public void setBugtypeId(String bugtypeId) {
        this.bugtypeId = bugtypeId == null ? null : bugtypeId.trim();
    }
}