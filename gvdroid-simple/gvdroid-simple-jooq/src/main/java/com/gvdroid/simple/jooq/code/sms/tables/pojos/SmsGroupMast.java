/*
 * This file is generated by jOOQ.
 */
package com.gvdroid.simple.jooq.code.sms.tables.pojos;


import com.gvdroid.simple.jooq.code.sms.tables.interfaces.ISmsGroupMast;

import java.time.LocalDateTime;


/**
 * 权限-用户分组主表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SmsGroupMast implements ISmsGroupMast {

    private static final long serialVersionUID = 1L;

    private Long          groupid;
    private String        name;
    private String        grouptype;
    private String        treeleaf;
    private Short         treelevel;
    private String        treeparent;
    private String        treesequence;
    private String        adminid;
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

    public SmsGroupMast() {}

    public SmsGroupMast(ISmsGroupMast value) {
        this.groupid = value.getGroupid();
        this.name = value.getName();
        this.grouptype = value.getGrouptype();
        this.treeleaf = value.getTreeleaf();
        this.treelevel = value.getTreelevel();
        this.treeparent = value.getTreeparent();
        this.treesequence = value.getTreesequence();
        this.adminid = value.getAdminid();
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

    public SmsGroupMast(
        Long          groupid,
        String        name,
        String        grouptype,
        String        treeleaf,
        Short         treelevel,
        String        treeparent,
        String        treesequence,
        String        adminid,
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
        this.groupid = groupid;
        this.name = name;
        this.grouptype = grouptype;
        this.treeleaf = treeleaf;
        this.treelevel = treelevel;
        this.treeparent = treeparent;
        this.treesequence = treesequence;
        this.adminid = adminid;
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
     * Getter for <code>sms.sms_group_mast.groupId</code>. 主键(用户组编号)
     */
    @Override
    public Long getGroupid() {
        return this.groupid;
    }

    /**
     * Setter for <code>sms.sms_group_mast.groupId</code>. 主键(用户组编号)
     */
    @Override
    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    /**
     * Getter for <code>sms.sms_group_mast.name</code>. 用户组名称
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>sms.sms_group_mast.name</code>. 用户组名称
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>sms.sms_group_mast.groupType</code>. 用户组类型 org/branch/dummy
     */
    @Override
    public String getGrouptype() {
        return this.grouptype;
    }

    /**
     * Setter for <code>sms.sms_group_mast.groupType</code>. 用户组类型 org/branch/dummy
     */
    @Override
    public void setGrouptype(String grouptype) {
        this.grouptype = grouptype;
    }

    /**
     * Getter for <code>sms.sms_group_mast.treeLeaf</code>. 树形-是否叶子节点
     */
    @Override
    public String getTreeleaf() {
        return this.treeleaf;
    }

    /**
     * Setter for <code>sms.sms_group_mast.treeLeaf</code>. 树形-是否叶子节点
     */
    @Override
    public void setTreeleaf(String treeleaf) {
        this.treeleaf = treeleaf;
    }

    /**
     * Getter for <code>sms.sms_group_mast.treeLevel</code>. 树形-级别
     */
    @Override
    public Short getTreelevel() {
        return this.treelevel;
    }

    /**
     * Setter for <code>sms.sms_group_mast.treeLevel</code>. 树形-级别
     */
    @Override
    public void setTreelevel(Short treelevel) {
        this.treelevel = treelevel;
    }

    /**
     * Getter for <code>sms.sms_group_mast.treeParent</code>. 树形-父编号
     */
    @Override
    public String getTreeparent() {
        return this.treeparent;
    }

    /**
     * Setter for <code>sms.sms_group_mast.treeParent</code>. 树形-父编号
     */
    @Override
    public void setTreeparent(String treeparent) {
        this.treeparent = treeparent;
    }

    /**
     * Getter for <code>sms.sms_group_mast.treeSequence</code>. 树形-排序
     */
    @Override
    public String getTreesequence() {
        return this.treesequence;
    }

    /**
     * Setter for <code>sms.sms_group_mast.treeSequence</code>. 树形-排序
     */
    @Override
    public void setTreesequence(String treesequence) {
        this.treesequence = treesequence;
    }

    /**
     * Getter for <code>sms.sms_group_mast.adminId</code>. 管理员
     */
    @Override
    public String getAdminid() {
        return this.adminid;
    }

    /**
     * Setter for <code>sms.sms_group_mast.adminId</code>. 管理员
     */
    @Override
    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    /**
     * Getter for <code>sms.sms_group_mast.status</code>. 状态 1 normal
     */
    @Override
    public Integer getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>sms.sms_group_mast.status</code>. 状态 1 normal
     */
    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Getter for <code>sms.sms_group_mast.deleted</code>. 删除状态 0 正常 1 逻辑删除
     */
    @Override
    public Boolean getDeleted() {
        return this.deleted;
    }

    /**
     * Setter for <code>sms.sms_group_mast.deleted</code>. 删除状态 0 正常 1 逻辑删除
     */
    @Override
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * Getter for <code>sms.sms_group_mast.createDate</code>. 创建时间
     */
    @Override
    public LocalDateTime getCreatedate() {
        return this.createdate;
    }

    /**
     * Setter for <code>sms.sms_group_mast.createDate</code>. 创建时间
     */
    @Override
    public void setCreatedate(LocalDateTime createdate) {
        this.createdate = createdate;
    }

    /**
     * Getter for <code>sms.sms_group_mast.createUser</code>. 创建人员
     */
    @Override
    public String getCreateuser() {
        return this.createuser;
    }

    /**
     * Setter for <code>sms.sms_group_mast.createUser</code>. 创建人员
     */
    @Override
    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    /**
     * Getter for <code>sms.sms_group_mast.createOrg</code>. 创建机构
     */
    @Override
    public String getCreateorg() {
        return this.createorg;
    }

    /**
     * Setter for <code>sms.sms_group_mast.createOrg</code>. 创建机构
     */
    @Override
    public void setCreateorg(String createorg) {
        this.createorg = createorg;
    }

    /**
     * Getter for <code>sms.sms_group_mast.updateDate</code>. 维护时间
     */
    @Override
    public LocalDateTime getUpdatedate() {
        return this.updatedate;
    }

    /**
     * Setter for <code>sms.sms_group_mast.updateDate</code>. 维护时间
     */
    @Override
    public void setUpdatedate(LocalDateTime updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * Getter for <code>sms.sms_group_mast.updateUser</code>. 维护人员
     */
    @Override
    public String getUpdateuser() {
        return this.updateuser;
    }

    /**
     * Setter for <code>sms.sms_group_mast.updateUser</code>. 维护人员
     */
    @Override
    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }

    /**
     * Getter for <code>sms.sms_group_mast.updateOrg</code>. 维护机构
     */
    @Override
    public String getUpdateorg() {
        return this.updateorg;
    }

    /**
     * Setter for <code>sms.sms_group_mast.updateOrg</code>. 维护机构
     */
    @Override
    public void setUpdateorg(String updateorg) {
        this.updateorg = updateorg;
    }

    /**
     * Getter for <code>sms.sms_group_mast.updateNo</code>. 维护序号
     */
    @Override
    public Integer getUpdateno() {
        return this.updateno;
    }

    /**
     * Setter for <code>sms.sms_group_mast.updateNo</code>. 维护序号
     */
    @Override
    public void setUpdateno(Integer updateno) {
        this.updateno = updateno;
    }

    /**
     * Getter for <code>sms.sms_group_mast.entityId</code>. 所属实体
     */
    @Override
    public String getEntityid() {
        return this.entityid;
    }

    /**
     * Setter for <code>sms.sms_group_mast.entityId</code>. 所属实体
     */
    @Override
    public void setEntityid(String entityid) {
        this.entityid = entityid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SmsGroupMast (");

        sb.append(groupid);
        sb.append(", ").append(name);
        sb.append(", ").append(grouptype);
        sb.append(", ").append(treeleaf);
        sb.append(", ").append(treelevel);
        sb.append(", ").append(treeparent);
        sb.append(", ").append(treesequence);
        sb.append(", ").append(adminid);
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
    public void from(ISmsGroupMast from) {
        setGroupid(from.getGroupid());
        setName(from.getName());
        setGrouptype(from.getGrouptype());
        setTreeleaf(from.getTreeleaf());
        setTreelevel(from.getTreelevel());
        setTreeparent(from.getTreeparent());
        setTreesequence(from.getTreesequence());
        setAdminid(from.getAdminid());
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
    public <E extends ISmsGroupMast> E into(E into) {
        into.from(this);
        return into;
    }
}