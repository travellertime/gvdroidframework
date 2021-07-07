/*
 * This file is generated by jOOQ.
 */
package com.gvdroid.simple.jooq.code.sms.tables.pojos;


import com.gvdroid.simple.jooq.code.sms.tables.interfaces.ISmsResourceMast;

import java.time.LocalDateTime;


/**
 * 权限-权限主表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SmsResourceMast implements ISmsResourceMast {

    private static final long serialVersionUID = 1L;

    private Long          id;
    private String        name;
    private String        resourcetype;
    private String        resources;
    private Boolean       treeleaf;
    private Short         treelevel;
    private String        treeparent;
    private String        treesequence;
    private Integer       status;
    private Boolean       deleted;
    private LocalDateTime createdate;
    private String        createuser;
    private String        createorg;
    private LocalDateTime updatedate;
    private String        updateuser;
    private String        updateorg;
    private Integer       updateno;
    private String        entityid;

    public SmsResourceMast() {}

    public SmsResourceMast(ISmsResourceMast value) {
        this.id = value.getId();
        this.name = value.getName();
        this.resourcetype = value.getResourcetype();
        this.resources = value.getResources();
        this.treeleaf = value.getTreeleaf();
        this.treelevel = value.getTreelevel();
        this.treeparent = value.getTreeparent();
        this.treesequence = value.getTreesequence();
        this.status = value.getStatus();
        this.deleted = value.getDeleted();
        this.createdate = value.getCreatedate();
        this.createuser = value.getCreateuser();
        this.createorg = value.getCreateorg();
        this.updatedate = value.getUpdatedate();
        this.updateuser = value.getUpdateuser();
        this.updateorg = value.getUpdateorg();
        this.updateno = value.getUpdateno();
        this.entityid = value.getEntityid();
    }

    public SmsResourceMast(
        Long          id,
        String        name,
        String        resourcetype,
        String        resources,
        Boolean       treeleaf,
        Short         treelevel,
        String        treeparent,
        String        treesequence,
        Integer       status,
        Boolean       deleted,
        LocalDateTime createdate,
        String        createuser,
        String        createorg,
        LocalDateTime updatedate,
        String        updateuser,
        String        updateorg,
        Integer       updateno,
        String        entityid
    ) {
        this.id = id;
        this.name = name;
        this.resourcetype = resourcetype;
        this.resources = resources;
        this.treeleaf = treeleaf;
        this.treelevel = treelevel;
        this.treeparent = treeparent;
        this.treesequence = treesequence;
        this.status = status;
        this.deleted = deleted;
        this.createdate = createdate;
        this.createuser = createuser;
        this.createorg = createorg;
        this.updatedate = updatedate;
        this.updateuser = updateuser;
        this.updateorg = updateorg;
        this.updateno = updateno;
        this.entityid = entityid;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.id</code>. 功能编号
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.id</code>. 功能编号
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.name</code>. 功能名称
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.name</code>. 功能名称
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.resourceType</code>. 功能类型 interface/page/element/data
     */
    @Override
    public String getResourcetype() {
        return this.resourcetype;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.resourceType</code>. 功能类型 interface/page/element/data
     */
    @Override
    public void setResourcetype(String resourcetype) {
        this.resourcetype = resourcetype;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.resources</code>. 功能资源 如按钮id 页面url
     */
    @Override
    public String getResources() {
        return this.resources;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.resources</code>. 功能资源 如按钮id 页面url
     */
    @Override
    public void setResources(String resources) {
        this.resources = resources;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.treeLeaf</code>. 树形-是否叶子节点
     */
    @Override
    public Boolean getTreeleaf() {
        return this.treeleaf;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.treeLeaf</code>. 树形-是否叶子节点
     */
    @Override
    public void setTreeleaf(Boolean treeleaf) {
        this.treeleaf = treeleaf;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.treeLevel</code>. 树形-级别
     */
    @Override
    public Short getTreelevel() {
        return this.treelevel;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.treeLevel</code>. 树形-级别
     */
    @Override
    public void setTreelevel(Short treelevel) {
        this.treelevel = treelevel;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.treeParent</code>. 树形-父编号
     */
    @Override
    public String getTreeparent() {
        return this.treeparent;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.treeParent</code>. 树形-父编号
     */
    @Override
    public void setTreeparent(String treeparent) {
        this.treeparent = treeparent;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.treeSequence</code>. 树形-排序
     */
    @Override
    public String getTreesequence() {
        return this.treesequence;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.treeSequence</code>. 树形-排序
     */
    @Override
    public void setTreesequence(String treesequence) {
        this.treesequence = treesequence;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.status</code>. 状态 1 normal
     */
    @Override
    public Integer getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.status</code>. 状态 1 normal
     */
    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.deleted</code>. 删除状态 0 正常 1 逻辑删除
     */
    @Override
    public Boolean getDeleted() {
        return this.deleted;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.deleted</code>. 删除状态 0 正常 1 逻辑删除
     */
    @Override
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.createDate</code>. 创建时间
     */
    @Override
    public LocalDateTime getCreatedate() {
        return this.createdate;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.createDate</code>. 创建时间
     */
    @Override
    public void setCreatedate(LocalDateTime createdate) {
        this.createdate = createdate;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.createUser</code>. 创建人员
     */
    @Override
    public String getCreateuser() {
        return this.createuser;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.createUser</code>. 创建人员
     */
    @Override
    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.createOrg</code>. 创建机构
     */
    @Override
    public String getCreateorg() {
        return this.createorg;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.createOrg</code>. 创建机构
     */
    @Override
    public void setCreateorg(String createorg) {
        this.createorg = createorg;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.updateDate</code>. 维护时间
     */
    @Override
    public LocalDateTime getUpdatedate() {
        return this.updatedate;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.updateDate</code>. 维护时间
     */
    @Override
    public void setUpdatedate(LocalDateTime updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.updateUser</code>. 维护人员
     */
    @Override
    public String getUpdateuser() {
        return this.updateuser;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.updateUser</code>. 维护人员
     */
    @Override
    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.updateOrg</code>. 维护机构
     */
    @Override
    public String getUpdateorg() {
        return this.updateorg;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.updateOrg</code>. 维护机构
     */
    @Override
    public void setUpdateorg(String updateorg) {
        this.updateorg = updateorg;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.updateNo</code>. 维护序号
     */
    @Override
    public Integer getUpdateno() {
        return this.updateno;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.updateNo</code>. 维护序号
     */
    @Override
    public void setUpdateno(Integer updateno) {
        this.updateno = updateno;
    }

    /**
     * Getter for <code>sms.sms_resource_mast.entityId</code>. 所属实体
     */
    @Override
    public String getEntityid() {
        return this.entityid;
    }

    /**
     * Setter for <code>sms.sms_resource_mast.entityId</code>. 所属实体
     */
    @Override
    public void setEntityid(String entityid) {
        this.entityid = entityid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SmsResourceMast (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(resourcetype);
        sb.append(", ").append(resources);
        sb.append(", ").append(treeleaf);
        sb.append(", ").append(treelevel);
        sb.append(", ").append(treeparent);
        sb.append(", ").append(treesequence);
        sb.append(", ").append(status);
        sb.append(", ").append(deleted);
        sb.append(", ").append(createdate);
        sb.append(", ").append(createuser);
        sb.append(", ").append(createorg);
        sb.append(", ").append(updatedate);
        sb.append(", ").append(updateuser);
        sb.append(", ").append(updateorg);
        sb.append(", ").append(updateno);
        sb.append(", ").append(entityid);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ISmsResourceMast from) {
        setId(from.getId());
        setName(from.getName());
        setResourcetype(from.getResourcetype());
        setResources(from.getResources());
        setTreeleaf(from.getTreeleaf());
        setTreelevel(from.getTreelevel());
        setTreeparent(from.getTreeparent());
        setTreesequence(from.getTreesequence());
        setStatus(from.getStatus());
        setDeleted(from.getDeleted());
        setCreatedate(from.getCreatedate());
        setCreateuser(from.getCreateuser());
        setCreateorg(from.getCreateorg());
        setUpdatedate(from.getUpdatedate());
        setUpdateuser(from.getUpdateuser());
        setUpdateorg(from.getUpdateorg());
        setUpdateno(from.getUpdateno());
        setEntityid(from.getEntityid());
    }

    @Override
    public <E extends ISmsResourceMast> E into(E into) {
        into.from(this);
        return into;
    }
}
