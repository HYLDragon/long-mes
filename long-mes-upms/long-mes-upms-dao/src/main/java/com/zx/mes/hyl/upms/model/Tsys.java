package com.zx.mes.hyl.upms.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/10/13.
 */
@Entity
@Table(name = "tsys")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Tsys implements Serializable {
    private String id;
    private String code;

    private String name;
    private Set<Tresource> tresources = new HashSet<Tresource>(0);

    public Tsys() {

    }

    public Tsys(String id, String code, String name, Set<Tresource> tresources) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.tresources = tresources;
    }

    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 36)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "CODE", length = 20)
    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "NAME", length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tsys")
    public Set<Tresource> getTresources() {
        return tresources;
    }

    public void setTresources(Set<Tresource> tresources) {
        this.tresources = tresources;
    }

}
