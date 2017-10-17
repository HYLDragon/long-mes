package com.zx.mes.model.admin;


public class Resource {
    private String id;

    private String icon;

    private String name;

    private String remark;

    private Integer seq;

    private String url;

    private String pid;

    private String ids;

    private ResourceType resourcetype;

    private  String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ResourceType getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(ResourceType resourcetype) {
        this.resourcetype = resourcetype;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    private String tresourcetypeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getTresourcetypeId() {
        return tresourcetypeId;
    }

    public void setTresourcetypeId(String tresourcetypeId) {
        this.tresourcetypeId = tresourcetypeId == null ? null : tresourcetypeId.trim();
    }
}