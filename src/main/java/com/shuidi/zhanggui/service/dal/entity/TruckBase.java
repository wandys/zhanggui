package com.shuidi.zhanggui.service.dal.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @实体名称 好气网车辆ID与智慧物流车辆ID映射关系表
 * @数表名称 TRUCK_BASE
 * @开发日期 2017-05-08
 * @技术服务 www.fwjava.com
 */

public class TruckBase implements Serializable {

    /**
     * 唯一索引id，自增(必填项)(主键ID)
     */
    private Long id                    = null;
    /**
     * 车辆牌照
     */
    private String licensePlate        = null;
    /**
     * 组织机构id
     */
    private Long departmentId          = null;
    /**
     * 所属车辆品牌，枚举
     */
    private String truckBrand          = null;
    /**
     * 上牌时间
     */
    private Date plateRegDate          = null;
    /**
     * 购买价格
     */
    private BigDecimal buyingPrice     = null;
    /**
     * 车辆自重，单位KG
     */
    private BigDecimal weight          = null;
    /**
     * 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE）
     */
    private String auditStatus         = null;
    /**
     * 车辆状态：启用、停用、删除
     */
    private String status              = null;
    /**
     * 备注
     */
    private String note                = null;
    /**
     * 企业主账号id
     */
    private Long enterpriseId          = null;
    /**
     * 使用年限
     */
    private Integer serviceLife        = null;
    /**
     * 车辆类型:车头、车拍
     */
    private String type                = null;
    /**
     * 车辆gps状态：在线、离线
     */
    private String gpsStatus           = null;
    /**
     * 创建时间
     */
    private Date createTime            = null;
    /**
     * 更新时间
     */
    private Date updateTime            = null;
    /**
     * 操作人id
     */
    private Long operateId             = null;
    /**
     * 最大行驶速度
     */
    private Integer maxTravelSpeed     = null;
    /**
     * 空载长度
     */
    private Integer noloadLength       = null;
    /**
     * 空载宽度
     */
    private Integer noloadWidth        = null;
    /**
     * 空载高度
     */
    private Integer noloadHeight       = null;
    /**
     * 审验周期/年
     */
    private Integer inspectionCycle    = null;
    /**
     * 停用说明
     */
    private String disableNote         = null;
    /**
     * 排序
     */
    private String orderBy             = null;

    /*
     *--------------------------------------------------
     * Getter方法区
     *--------------------------------------------------
     */

    /**
     * 唯一索引id，自增(必填项)(主键ID)
     */
    public Long getId() {
        return id;
    }
    /**
     * 车辆牌照
     */
    public String getLicensePlate() {
        return trim(licensePlate);
    }
    /**
     * 组织机构id
     */
    public Long getDepartmentId() {
        return departmentId;
    }
    /**
     * 所属车辆品牌，枚举
     */
    public String getTruckBrand() {
        return trim(truckBrand);
    }
    /**
     * 上牌时间
     */
    public Date getPlateRegDate() {
        return plateRegDate;
    }
    /**
     * 购买价格
     */
    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }
    /**
     * 车辆自重，单位KG
     */
    public BigDecimal getWeight() {
        return weight;
    }
    /**
     * 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE）
     */
    public String getAuditStatus() {
        return trim(auditStatus);
    }
    /**
     * 车辆状态：启用、停用、删除
     */
    public String getStatus() {
        return trim(status);
    }
    /**
     * 备注
     */
    public String getNote() {
        return trim(note);
    }
    /**
     * 企业主账号id
     */
    public Long getEnterpriseId() {
        return enterpriseId;
    }
    /**
     * 使用年限
     */
    public Integer getServiceLife() {
        return serviceLife;
    }
    /**
     * 车辆类型:车头、车拍
     */
    public String getType() {
        return trim(type);
    }
    /**
     * 车辆gps状态：在线、离线
     */
    public String getGpsStatus() {
        return trim(gpsStatus);
    }
    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
     * 操作人id
     */
    public Long getOperateId() {
        return operateId;
    }
    /**
     * 最大行驶速度
     */
    public Integer getMaxTravelSpeed() {
        return maxTravelSpeed;
    }
    /**
     * 空载长度
     */
    public Integer getNoloadLength() {
        return noloadLength;
    }
    /**
     * 空载宽度
     */
    public Integer getNoloadWidth() {
        return noloadWidth;
    }
    /**
     * 空载高度
     */
    public Integer getNoloadHeight() {
        return noloadHeight;
    }
    /**
     * 审验周期/年
     */
    public Integer getInspectionCycle() {
        return inspectionCycle;
    }
    /**
     * 停用说明
     */
    public String getDisableNote() {
        return trim(disableNote);
    }
    /**
     * 排序
     */
    public String getOrderBy() {
        return trim(orderBy);
    }

    /*
     *--------------------------------------------------
     * Setter方法区
     *--------------------------------------------------
     */

    /**
     * 唯一索引id，自增(必填项)(主键ID)
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 车辆牌照
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    /**
     * 组织机构id
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    /**
     * 所属车辆品牌，枚举
     */
    public void setTruckBrand(String truckBrand) {
        this.truckBrand = truckBrand;
    }
    /**
     * 上牌时间
     */
    public void setPlateRegDate(Date plateRegDate) {
        this.plateRegDate = plateRegDate;
    }
    /**
     * 购买价格
     */
    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }
    /**
     * 车辆自重，单位KG
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
    /**
     * 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE）
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }
    /**
     * 车辆状态：启用、停用、删除
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * 备注
     */
    public void setNote(String note) {
        this.note = note;
    }
    /**
     * 企业主账号id
     */
    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
    /**
     * 使用年限
     */
    public void setServiceLife(Integer serviceLife) {
        this.serviceLife = serviceLife;
    }
    /**
     * 车辆类型:车头、车拍
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * 车辆gps状态：在线、离线
     */
    public void setGpsStatus(String gpsStatus) {
        this.gpsStatus = gpsStatus;
    }
    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
     * 操作人id
     */
    public void setOperateId(Long operateId) {
        this.operateId = operateId;
    }
    /**
     * 最大行驶速度
     */
    public void setMaxTravelSpeed(Integer maxTravelSpeed) {
        this.maxTravelSpeed = maxTravelSpeed;
    }
    /**
     * 空载长度
     */
    public void setNoloadLength(Integer noloadLength) {
        this.noloadLength = noloadLength;
    }
    /**
     * 空载宽度
     */
    public void setNoloadWidth(Integer noloadWidth) {
        this.noloadWidth = noloadWidth;
    }
    /**
     * 空载高度
     */
    public void setNoloadHeight(Integer noloadHeight) {
        this.noloadHeight = noloadHeight;
    }
    /**
     * 审验周期/年
     */
    public void setInspectionCycle(Integer inspectionCycle) {
        this.inspectionCycle = inspectionCycle;
    }
    /**
     * 停用说明
     */
    public void setDisableNote(String disableNote) {
        this.disableNote = disableNote;
    }
    /**
     * 排序
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }


    /*
     *--------------------------------------------------
     * 常用自定义字段
     *--------------------------------------------------
     */
    /**
     * 车辆牌照(全模糊)
     */
    private String licensePlateLike           = null;
    /**
     * 所属车辆品牌，枚举(全模糊)
     */
    private String truckBrandLike             = null;
    /**
     * 上牌时间(起始日期)
     */
    private String plateRegDateBegin          = null;
    /**
     * 上牌时间(结束日期)
     */
    private String plateRegDateEnd            = null;
    /**
     * 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE）(全模糊)
     */
    private String auditStatusLike            = null;
    /**
     * 车辆状态：启用、停用、删除(全模糊)
     */
    private String statusLike                 = null;
    /**
     * 备注(全模糊)
     */
    private String noteLike                   = null;
    /**
     * 车辆类型:车头、车拍(全模糊)
     */
    private String typeLike                   = null;
    /**
     * 车辆gps状态：在线、离线(全模糊)
     */
    private String gpsStatusLike              = null;
    /**
     * 创建时间(起始日期)
     */
    private String createTimeBegin            = null;
    /**
     * 创建时间(结束日期)
     */
    private String createTimeEnd              = null;
    /**
     * 更新时间(起始日期)
     */
    private String updateTimeBegin            = null;
    /**
     * 更新时间(结束日期)
     */
    private String updateTimeEnd              = null;
    /**
     * 停用说明(全模糊)
     */
    private String disableNoteLike            = null;

    /**
     * 车辆牌照(全模糊)
     */
    public String getLicensePlateLike() {
        return trim(licensePlateLike);
    }
    public void setLicensePlateLike(String licensePlateLike) {
        this.licensePlateLike = licensePlateLike;
    }
    /**
     * 所属车辆品牌，枚举(全模糊)
     */
    public String getTruckBrandLike() {
        return trim(truckBrandLike);
    }
    public void setTruckBrandLike(String truckBrandLike) {
        this.truckBrandLike = truckBrandLike;
    }
    /**
     * 上牌时间(起始日期)
     */
    public String getPlateRegDateBegin() {
        return trim(plateRegDateBegin);
    }
    public void setPlateRegDateBegin(String plateRegDateBegin) {
        this.plateRegDateBegin = plateRegDateBegin;
    }
    /**
     * 上牌时间(结束日期)
     */
    public String getPlateRegDateEnd() {
        return trim(plateRegDateEnd);
    }
    public void setPlateRegDateEnd(String plateRegDateEnd) {
        this.plateRegDateEnd = plateRegDateEnd;
    }
    /**
     * 上牌时间(格式化)
     */
    public String getPlateRegDateChar() {
        return getDate(plateRegDate);
    }
    public void setPlateRegDateChar(String plateRegDateChar) {
        this.plateRegDate = getDate(plateRegDateChar);
    }
    /**
     * 上牌时间(格式化)
     */
    public String getPlateRegDateCharAll() {
        return getDateTime(plateRegDate);
    }
    public void setPlateRegDateCharAll(String plateRegDateCharAll) {
        this.plateRegDate = getDate(plateRegDateCharAll);
    }
    /**
     * 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE）(全模糊)
     */
    public String getAuditStatusLike() {
        return trim(auditStatusLike);
    }
    public void setAuditStatusLike(String auditStatusLike) {
        this.auditStatusLike = auditStatusLike;
    }
    /**
     * 车辆状态：启用、停用、删除(全模糊)
     */
    public String getStatusLike() {
        return trim(statusLike);
    }
    public void setStatusLike(String statusLike) {
        this.statusLike = statusLike;
    }
    /**
     * 备注(全模糊)
     */
    public String getNoteLike() {
        return trim(noteLike);
    }
    public void setNoteLike(String noteLike) {
        this.noteLike = noteLike;
    }
    /**
     * 车辆类型:车头、车拍(全模糊)
     */
    public String getTypeLike() {
        return trim(typeLike);
    }
    public void setTypeLike(String typeLike) {
        this.typeLike = typeLike;
    }
    /**
     * 车辆gps状态：在线、离线(全模糊)
     */
    public String getGpsStatusLike() {
        return trim(gpsStatusLike);
    }
    public void setGpsStatusLike(String gpsStatusLike) {
        this.gpsStatusLike = gpsStatusLike;
    }
    /**
     * 创建时间(起始日期)
     */
    public String getCreateTimeBegin() {
        return trim(createTimeBegin);
    }
    public void setCreateTimeBegin(String createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }
    /**
     * 创建时间(结束日期)
     */
    public String getCreateTimeEnd() {
        return trim(createTimeEnd);
    }
    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
    /**
     * 创建时间(格式化)
     */
    public String getCreateTimeChar() {
        return getDate(createTime);
    }
    public void setCreateTimeChar(String createTimeChar) {
        this.createTime = getDate(createTimeChar);
    }
    /**
     * 创建时间(格式化)
     */
    public String getCreateTimeCharAll() {
        return getDateTime(createTime);
    }
    public void setCreateTimeCharAll(String createTimeCharAll) {
        this.createTime = getDate(createTimeCharAll);
    }
    /**
     * 更新时间(起始日期)
     */
    public String getUpdateTimeBegin() {
        return trim(updateTimeBegin);
    }
    public void setUpdateTimeBegin(String updateTimeBegin) {
        this.updateTimeBegin = updateTimeBegin;
    }
    /**
     * 更新时间(结束日期)
     */
    public String getUpdateTimeEnd() {
        return trim(updateTimeEnd);
    }
    public void setUpdateTimeEnd(String updateTimeEnd) {
        this.updateTimeEnd = updateTimeEnd;
    }
    /**
     * 更新时间(格式化)
     */
    public String getUpdateTimeChar() {
        return getDate(updateTime);
    }
    public void setUpdateTimeChar(String updateTimeChar) {
        this.updateTime = getDate(updateTimeChar);
    }
    /**
     * 更新时间(格式化)
     */
    public String getUpdateTimeCharAll() {
        return getDateTime(updateTime);
    }
    public void setUpdateTimeCharAll(String updateTimeCharAll) {
        this.updateTime = getDate(updateTimeCharAll);
    }
    /**
     * 停用说明(全模糊)
     */
    public String getDisableNoteLike() {
        return trim(disableNoteLike);
    }
    public void setDisableNoteLike(String disableNoteLike) {
        this.disableNoteLike = disableNoteLike;
    }

    /*
     *--------------------------------------------------
     * 应用小方法
     *--------------------------------------------------
     */

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public String trim(String input)
    {
        return input==null?null:input.trim();
    }
    
    public String getDate(Date date)
    {
        if( null == date ) return "";
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    public String getDateTime(Date date)
    {
        if( null == date ) return "";
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
    public Date getDate(String date)
    {
        if( null == date || date.trim().isEmpty() ) return null;
        date = date.trim();
        Date result = null;
        try {
            if( date.length() >= 19 )
            {
                result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
            }
            else if( date.length() == 10 )
            {
                result = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            }
        }
        catch (ParseException e) 
        {
            
        }
        return result;
    }

}


/** 
------------------------------------------------------
 Copy专用区
------------------------------------------------------

------------------------------------------------------------------------------------------------------------
  Setter方法
------------------------------------------------------------------------------------------------------------

// 好气网车辆ID与智慧物流车辆ID映射关系表
TruckBase truckBase = new TruckBase();

// 唯一索引id，自增(必填项)(主键ID)
truckBase.setId(  );
// 车辆牌照
truckBase.setLicensePlate(  );
// 组织机构id
truckBase.setDepartmentId(  );
// 所属车辆品牌，枚举
truckBase.setTruckBrand(  );
// 上牌时间
truckBase.setPlateRegDate(  );
// 购买价格
truckBase.setBuyingPrice(  );
// 车辆自重，单位KG
truckBase.setWeight(  );
// 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE）
truckBase.setAuditStatus(  );
// 车辆状态：启用、停用、删除
truckBase.setStatus(  );
// 备注
truckBase.setNote(  );
// 企业主账号id
truckBase.setEnterpriseId(  );
// 使用年限
truckBase.setServiceLife(  );
// 车辆类型:车头、车拍
truckBase.setType(  );
// 车辆gps状态：在线、离线
truckBase.setGpsStatus(  );
// 创建时间
truckBase.setCreateTime(  );
// 更新时间
truckBase.setUpdateTime(  );
// 操作人id
truckBase.setOperateId(  );
// 最大行驶速度
truckBase.setMaxTravelSpeed(  );
// 空载长度
truckBase.setNoloadLength(  );
// 空载宽度
truckBase.setNoloadWidth(  );
// 空载高度
truckBase.setNoloadHeight(  );
// 审验周期/年
truckBase.setInspectionCycle(  );
// 停用说明
truckBase.setDisableNote(  );


//------ 自定义部分 ------

// 车辆牌照(全模糊)
truckBase.setLicensePlateLike(  );
// 所属车辆品牌，枚举(全模糊)
truckBase.setTruckBrandLike(  );
// 上牌时间(起始日期)
truckBase.setPlateRegDateBegin(  );
// 上牌时间(结束日期)
truckBase.setPlateRegDateEnd(  );
// 上牌时间(格式化)
truckBase.setPlateRegDateChar(  );
// 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE）(全模糊)
truckBase.setAuditStatusLike(  );
// 车辆状态：启用、停用、删除(全模糊)
truckBase.setStatusLike(  );
// 备注(全模糊)
truckBase.setNoteLike(  );
// 车辆类型:车头、车拍(全模糊)
truckBase.setTypeLike(  );
// 车辆gps状态：在线、离线(全模糊)
truckBase.setGpsStatusLike(  );
// 创建时间(起始日期)
truckBase.setCreateTimeBegin(  );
// 创建时间(结束日期)
truckBase.setCreateTimeEnd(  );
// 创建时间(格式化)
truckBase.setCreateTimeChar(  );
// 更新时间(起始日期)
truckBase.setUpdateTimeBegin(  );
// 更新时间(结束日期)
truckBase.setUpdateTimeEnd(  );
// 更新时间(格式化)
truckBase.setUpdateTimeChar(  );
// 停用说明(全模糊)
truckBase.setDisableNoteLike(  );


------------------------------------------------------------------------------------------------------------
  Getter方法
------------------------------------------------------------------------------------------------------------

// 好气网车辆ID与智慧物流车辆ID映射关系表
TruckBase truckBase = new TruckBase();

// 唯一索引id，自增(必填项)(主键ID)
truckBase.getId();
// 车辆牌照
truckBase.getLicensePlate();
// 组织机构id
truckBase.getDepartmentId();
// 所属车辆品牌，枚举
truckBase.getTruckBrand();
// 上牌时间
truckBase.getPlateRegDate();
// 购买价格
truckBase.getBuyingPrice();
// 车辆自重，单位KG
truckBase.getWeight();
// 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE）
truckBase.getAuditStatus();
// 车辆状态：启用、停用、删除
truckBase.getStatus();
// 备注
truckBase.getNote();
// 企业主账号id
truckBase.getEnterpriseId();
// 使用年限
truckBase.getServiceLife();
// 车辆类型:车头、车拍
truckBase.getType();
// 车辆gps状态：在线、离线
truckBase.getGpsStatus();
// 创建时间
truckBase.getCreateTime();
// 更新时间
truckBase.getUpdateTime();
// 操作人id
truckBase.getOperateId();
// 最大行驶速度
truckBase.getMaxTravelSpeed();
// 空载长度
truckBase.getNoloadLength();
// 空载宽度
truckBase.getNoloadWidth();
// 空载高度
truckBase.getNoloadHeight();
// 审验周期/年
truckBase.getInspectionCycle();
// 停用说明
truckBase.getDisableNote();


//------ 自定义部分 ------

// 车辆牌照(全模糊)
truckBase.getLicensePlateLike();
// 所属车辆品牌，枚举(全模糊)
truckBase.getTruckBrandLike();
// 上牌时间(起始日期)
truckBase.getPlateRegDateBegin();
// 上牌时间(结束日期)
truckBase.getPlateRegDateEnd();
// 上牌时间(格式化)
truckBase.getPlateRegDateChar();
// 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE）(全模糊)
truckBase.getAuditStatusLike();
// 车辆状态：启用、停用、删除(全模糊)
truckBase.getStatusLike();
// 备注(全模糊)
truckBase.getNoteLike();
// 车辆类型:车头、车拍(全模糊)
truckBase.getTypeLike();
// 车辆gps状态：在线、离线(全模糊)
truckBase.getGpsStatusLike();
// 创建时间(起始日期)
truckBase.getCreateTimeBegin();
// 创建时间(结束日期)
truckBase.getCreateTimeEnd();
// 创建时间(格式化)
truckBase.getCreateTimeChar();
// 更新时间(起始日期)
truckBase.getUpdateTimeBegin();
// 更新时间(结束日期)
truckBase.getUpdateTimeEnd();
// 更新时间(格式化)
truckBase.getUpdateTimeChar();
// 停用说明(全模糊)
truckBase.getDisableNoteLike();


------------------------------------------------------------------------------------------------------------
  Getter Setter方法
------------------------------------------------------------------------------------------------------------

// 好气网车辆ID与智慧物流车辆ID映射关系表
TruckBase truckBase = new TruckBase();

// 唯一索引id，自增(必填项)(主键ID)
truckBase.setId( truckBase2.getId() );
// 车辆牌照
truckBase.setLicensePlate( truckBase2.getLicensePlate() );
// 组织机构id
truckBase.setDepartmentId( truckBase2.getDepartmentId() );
// 所属车辆品牌，枚举
truckBase.setTruckBrand( truckBase2.getTruckBrand() );
// 上牌时间
truckBase.setPlateRegDate( truckBase2.getPlateRegDate() );
// 购买价格
truckBase.setBuyingPrice( truckBase2.getBuyingPrice() );
// 车辆自重，单位KG
truckBase.setWeight( truckBase2.getWeight() );
// 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE）
truckBase.setAuditStatus( truckBase2.getAuditStatus() );
// 车辆状态：启用、停用、删除
truckBase.setStatus( truckBase2.getStatus() );
// 备注
truckBase.setNote( truckBase2.getNote() );
// 企业主账号id
truckBase.setEnterpriseId( truckBase2.getEnterpriseId() );
// 使用年限
truckBase.setServiceLife( truckBase2.getServiceLife() );
// 车辆类型:车头、车拍
truckBase.setType( truckBase2.getType() );
// 车辆gps状态：在线、离线
truckBase.setGpsStatus( truckBase2.getGpsStatus() );
// 创建时间
truckBase.setCreateTime( truckBase2.getCreateTime() );
// 更新时间
truckBase.setUpdateTime( truckBase2.getUpdateTime() );
// 操作人id
truckBase.setOperateId( truckBase2.getOperateId() );
// 最大行驶速度
truckBase.setMaxTravelSpeed( truckBase2.getMaxTravelSpeed() );
// 空载长度
truckBase.setNoloadLength( truckBase2.getNoloadLength() );
// 空载宽度
truckBase.setNoloadWidth( truckBase2.getNoloadWidth() );
// 空载高度
truckBase.setNoloadHeight( truckBase2.getNoloadHeight() );
// 审验周期/年
truckBase.setInspectionCycle( truckBase2.getInspectionCycle() );
// 停用说明
truckBase.setDisableNote( truckBase2.getDisableNote() );


//------ 自定义部分 ------

// 车辆牌照(全模糊)
truckBase.setLicensePlateLike( truckBase2.getLicensePlateLike() );
// 所属车辆品牌，枚举(全模糊)
truckBase.setTruckBrandLike( truckBase2.getTruckBrandLike() );
// 上牌时间(起始日期)
truckBase.setPlateRegDateBegin( truckBase2.getPlateRegDateBegin() );
// 上牌时间(结束日期)
truckBase.setPlateRegDateEnd( truckBase2.getPlateRegDateEnd() );
// 上牌时间(格式化)
truckBase.setPlateRegDateChar( truckBase2.getPlateRegDateChar() );
// 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE）(全模糊)
truckBase.setAuditStatusLike( truckBase2.getAuditStatusLike() );
// 车辆状态：启用、停用、删除(全模糊)
truckBase.setStatusLike( truckBase2.getStatusLike() );
// 备注(全模糊)
truckBase.setNoteLike( truckBase2.getNoteLike() );
// 车辆类型:车头、车拍(全模糊)
truckBase.setTypeLike( truckBase2.getTypeLike() );
// 车辆gps状态：在线、离线(全模糊)
truckBase.setGpsStatusLike( truckBase2.getGpsStatusLike() );
// 创建时间(起始日期)
truckBase.setCreateTimeBegin( truckBase2.getCreateTimeBegin() );
// 创建时间(结束日期)
truckBase.setCreateTimeEnd( truckBase2.getCreateTimeEnd() );
// 创建时间(格式化)
truckBase.setCreateTimeChar( truckBase2.getCreateTimeChar() );
// 更新时间(起始日期)
truckBase.setUpdateTimeBegin( truckBase2.getUpdateTimeBegin() );
// 更新时间(结束日期)
truckBase.setUpdateTimeEnd( truckBase2.getUpdateTimeEnd() );
// 更新时间(格式化)
truckBase.setUpdateTimeChar( truckBase2.getUpdateTimeChar() );
// 停用说明(全模糊)
truckBase.setDisableNoteLike( truckBase2.getDisableNoteLike() );



------------------------------------------------------------------------------------------------------------
 HTML标签区
------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------
  属性区
------------------------------------------------------------------------------------------------------------

<!-- 唯一索引id，自增 -->
<input name="id" value="" type="text" maxlength="20"/>
<!-- 车辆牌照 -->
<input name="licensePlate" value="" type="text" maxlength="20"/>
<!-- 组织机构id -->
<input name="departmentId" value="" type="text" maxlength="50"/>
<!-- 所属车辆品牌，枚举 -->
<input name="truckBrand" value="" type="text" maxlength="50"/>
<!-- 上牌时间 -->
<input name="plateRegDate" value="" type="text"/>
<!-- 购买价格 -->
<input name="buyingPrice" value="" type="text" maxlength="20"/>
<!-- 车辆自重，单位KG -->
<input name="weight" value="" type="text" maxlength="11"/>
<!-- 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE） -->
<input name="auditStatus" value="" type="text" maxlength="20"/>
<!-- 车辆状态：启用、停用、删除 -->
<input name="status" value="" type="text" maxlength="20"/>
<!-- 备注 -->
<input name="note" value="" type="text" maxlength="400"/>
<!-- 企业主账号id -->
<input name="enterpriseId" value="" type="text" maxlength="20"/>
<!-- 使用年限 -->
<input name="serviceLife" value="" type="text" maxlength="11"/>
<!-- 车辆类型:车头、车拍 -->
<input name="type" value="" type="text" maxlength="20"/>
<!-- 车辆gps状态：在线、离线 -->
<input name="gpsStatus" value="" type="text" maxlength="20"/>
<!-- 创建时间 -->
<input name="createTime" value="" type="text"/>
<!-- 更新时间 -->
<input name="updateTime" value="" type="text"/>
<!-- 操作人id -->
<input name="operateId" value="" type="text" maxlength="20"/>
<!-- 最大行驶速度 -->
<input name="maxTravelSpeed" value="" type="text" maxlength="11"/>
<!-- 空载长度 -->
<input name="noloadLength" value="" type="text" maxlength="11"/>
<!-- 空载宽度 -->
<input name="noloadWidth" value="" type="text" maxlength="11"/>
<!-- 空载高度 -->
<input name="noloadHeight" value="" type="text" maxlength="11"/>
<!-- 审验周期/年 -->
<input name="inspectionCycle" value="" type="text" maxlength="10"/>
<!-- 停用说明 -->
<input name="disableNote" value="" type="text" maxlength="400"/>


------------------------------------------------------------------------------------------------------------
  表名 + 属性区
------------------------------------------------------------------------------------------------------------

<!-- 唯一索引id，自增 -->
<input name="truckBase.id" value="" type="text" maxlength="20"/>
<!-- 车辆牌照 -->
<input name="truckBase.licensePlate" value="" type="text" maxlength="20"/>
<!-- 组织机构id -->
<input name="truckBase.departmentId" value="" type="text" maxlength="50"/>
<!-- 所属车辆品牌，枚举 -->
<input name="truckBase.truckBrand" value="" type="text" maxlength="50"/>
<!-- 上牌时间 -->
<input name="truckBase.plateRegDate" value="" type="text"/>
<!-- 购买价格 -->
<input name="truckBase.buyingPrice" value="" type="text" maxlength="20"/>
<!-- 车辆自重，单位KG -->
<input name="truckBase.weight" value="" type="text" maxlength="11"/>
<!-- 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE） -->
<input name="truckBase.auditStatus" value="" type="text" maxlength="20"/>
<!-- 车辆状态：启用、停用、删除 -->
<input name="truckBase.status" value="" type="text" maxlength="20"/>
<!-- 备注 -->
<input name="truckBase.note" value="" type="text" maxlength="400"/>
<!-- 企业主账号id -->
<input name="truckBase.enterpriseId" value="" type="text" maxlength="20"/>
<!-- 使用年限 -->
<input name="truckBase.serviceLife" value="" type="text" maxlength="11"/>
<!-- 车辆类型:车头、车拍 -->
<input name="truckBase.type" value="" type="text" maxlength="20"/>
<!-- 车辆gps状态：在线、离线 -->
<input name="truckBase.gpsStatus" value="" type="text" maxlength="20"/>
<!-- 创建时间 -->
<input name="truckBase.createTime" value="" type="text"/>
<!-- 更新时间 -->
<input name="truckBase.updateTime" value="" type="text"/>
<!-- 操作人id -->
<input name="truckBase.operateId" value="" type="text" maxlength="20"/>
<!-- 最大行驶速度 -->
<input name="truckBase.maxTravelSpeed" value="" type="text" maxlength="11"/>
<!-- 空载长度 -->
<input name="truckBase.noloadLength" value="" type="text" maxlength="11"/>
<!-- 空载宽度 -->
<input name="truckBase.noloadWidth" value="" type="text" maxlength="11"/>
<!-- 空载高度 -->
<input name="truckBase.noloadHeight" value="" type="text" maxlength="11"/>
<!-- 审验周期/年 -->
<input name="truckBase.inspectionCycle" value="" type="text" maxlength="10"/>
<!-- 停用说明 -->
<input name="truckBase.disableNote" value="" type="text" maxlength="400"/>


------------------------------------------------------------------------------------------------------------
  ID + 属性区
------------------------------------------------------------------------------------------------------------

<!-- 唯一索引id，自增 -->
<input id="TB_ID" name="id" value="" type="text" maxlength="20"/>
<!-- 车辆牌照 -->
<input id="TB_LICENSE_PLATE" name="licensePlate" value="" type="text" maxlength="20"/>
<!-- 组织机构id -->
<input id="TB_DEPARTMENT_ID" name="departmentId" value="" type="text" maxlength="50"/>
<!-- 所属车辆品牌，枚举 -->
<input id="TB_TRUCK_BRAND" name="truckBrand" value="" type="text" maxlength="50"/>
<!-- 上牌时间 -->
<input id="TB_PLATE_REG_DATE" name="plateRegDate" value="" type="text"/>
<!-- 购买价格 -->
<input id="TB_BUYING_PRICE" name="buyingPrice" value="" type="text" maxlength="20"/>
<!-- 车辆自重，单位KG -->
<input id="TB_WEIGHT" name="weight" value="" type="text" maxlength="11"/>
<!-- 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE） -->
<input id="TB_AUDIT_STATUS" name="auditStatus" value="" type="text" maxlength="20"/>
<!-- 车辆状态：启用、停用、删除 -->
<input id="TB_STATUS" name="status" value="" type="text" maxlength="20"/>
<!-- 备注 -->
<input id="TB_NOTE" name="note" value="" type="text" maxlength="400"/>
<!-- 企业主账号id -->
<input id="TB_ENTERPRISE_ID" name="enterpriseId" value="" type="text" maxlength="20"/>
<!-- 使用年限 -->
<input id="TB_SERVICE_LIFE" name="serviceLife" value="" type="text" maxlength="11"/>
<!-- 车辆类型:车头、车拍 -->
<input id="TB_TYPE" name="type" value="" type="text" maxlength="20"/>
<!-- 车辆gps状态：在线、离线 -->
<input id="TB_GPS_STATUS" name="gpsStatus" value="" type="text" maxlength="20"/>
<!-- 创建时间 -->
<input id="TB_CREATE_TIME" name="createTime" value="" type="text"/>
<!-- 更新时间 -->
<input id="TB_UPDATE_TIME" name="updateTime" value="" type="text"/>
<!-- 操作人id -->
<input id="TB_OPERATE_ID" name="operateId" value="" type="text" maxlength="20"/>
<!-- 最大行驶速度 -->
<input id="TB_MAX_TRAVEL_SPEED" name="maxTravelSpeed" value="" type="text" maxlength="11"/>
<!-- 空载长度 -->
<input id="TB_NOLOAD_LENGTH" name="noloadLength" value="" type="text" maxlength="11"/>
<!-- 空载宽度 -->
<input id="TB_NOLOAD_WIDTH" name="noloadWidth" value="" type="text" maxlength="11"/>
<!-- 空载高度 -->
<input id="TB_NOLOAD_HEIGHT" name="noloadHeight" value="" type="text" maxlength="11"/>
<!-- 审验周期/年 -->
<input id="TB_INSPECTION_CYCLE" name="inspectionCycle" value="" type="text" maxlength="10"/>
<!-- 停用说明 -->
<input id="TB_DISABLE_NOTE" name="disableNote" value="" type="text" maxlength="400"/>


------------------------------------------------------------------------------------------------------------
  ID + 表名 + 属性区
------------------------------------------------------------------------------------------------------------

<!-- 唯一索引id，自增 -->
<input id="TB_ID" name="truckBase.id" value="" type="text" maxlength="20"/>
<!-- 车辆牌照 -->
<input id="TB_LICENSE_PLATE" name="truckBase.licensePlate" value="" type="text" maxlength="20"/>
<!-- 组织机构id -->
<input id="TB_DEPARTMENT_ID" name="truckBase.departmentId" value="" type="text" maxlength="50"/>
<!-- 所属车辆品牌，枚举 -->
<input id="TB_TRUCK_BRAND" name="truckBase.truckBrand" value="" type="text" maxlength="50"/>
<!-- 上牌时间 -->
<input id="TB_PLATE_REG_DATE" name="truckBase.plateRegDate" value="" type="text"/>
<!-- 购买价格 -->
<input id="TB_BUYING_PRICE" name="truckBase.buyingPrice" value="" type="text" maxlength="20"/>
<!-- 车辆自重，单位KG -->
<input id="TB_WEIGHT" name="truckBase.weight" value="" type="text" maxlength="11"/>
<!-- 审核状态:（--（初始状态）NOTAUDIT、提交认证审核中SUBAUDITING、提交认证审核失败SUBAUDITFAILURE、已审核AUDITED、取消认证审核中CELAUDITING、取消认证审核失败CELAUDITFAILURE） -->
<input id="TB_AUDIT_STATUS" name="truckBase.auditStatus" value="" type="text" maxlength="20"/>
<!-- 车辆状态：启用、停用、删除 -->
<input id="TB_STATUS" name="truckBase.status" value="" type="text" maxlength="20"/>
<!-- 备注 -->
<input id="TB_NOTE" name="truckBase.note" value="" type="text" maxlength="400"/>
<!-- 企业主账号id -->
<input id="TB_ENTERPRISE_ID" name="truckBase.enterpriseId" value="" type="text" maxlength="20"/>
<!-- 使用年限 -->
<input id="TB_SERVICE_LIFE" name="truckBase.serviceLife" value="" type="text" maxlength="11"/>
<!-- 车辆类型:车头、车拍 -->
<input id="TB_TYPE" name="truckBase.type" value="" type="text" maxlength="20"/>
<!-- 车辆gps状态：在线、离线 -->
<input id="TB_GPS_STATUS" name="truckBase.gpsStatus" value="" type="text" maxlength="20"/>
<!-- 创建时间 -->
<input id="TB_CREATE_TIME" name="truckBase.createTime" value="" type="text"/>
<!-- 更新时间 -->
<input id="TB_UPDATE_TIME" name="truckBase.updateTime" value="" type="text"/>
<!-- 操作人id -->
<input id="TB_OPERATE_ID" name="truckBase.operateId" value="" type="text" maxlength="20"/>
<!-- 最大行驶速度 -->
<input id="TB_MAX_TRAVEL_SPEED" name="truckBase.maxTravelSpeed" value="" type="text" maxlength="11"/>
<!-- 空载长度 -->
<input id="TB_NOLOAD_LENGTH" name="truckBase.noloadLength" value="" type="text" maxlength="11"/>
<!-- 空载宽度 -->
<input id="TB_NOLOAD_WIDTH" name="truckBase.noloadWidth" value="" type="text" maxlength="11"/>
<!-- 空载高度 -->
<input id="TB_NOLOAD_HEIGHT" name="truckBase.noloadHeight" value="" type="text" maxlength="11"/>
<!-- 审验周期/年 -->
<input id="TB_INSPECTION_CYCLE" name="truckBase.inspectionCycle" value="" type="text" maxlength="10"/>
<!-- 停用说明 -->
<input id="TB_DISABLE_NOTE" name="truckBase.disableNote" value="" type="text" maxlength="400"/>




--------------------------------------------------------
 */


    