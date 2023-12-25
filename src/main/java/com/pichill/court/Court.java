package com.pichill.court;

//測試


import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.pichill.manage.entity.Manage;
import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.place.Place;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.time.TimeRef;


@Entity
@Table(name = "Court")
public class Court implements Serializable{
 
 @Id 
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "courtID", updatable = false, insertable=false) //PK鍵不用更新

 private Integer courtID;
 
 
// @Column(name = "oUserID")
// private Integer oUserID;
 
// @Column(name = "manageID")
// private Integer manageID;
 
 @Column(name = "courtOnTime" , updatable = false)
 private Timestamp courtOnTime;
 
 @Column(name = "courtApplyTime", updatable = false)
 @CreationTimestamp
 private Timestamp courtApplyTime;
 

 @Column(name = "courtName")
 private String courtName;
 
 @Column(name = "courtPic" , columnDefinition = "longblob")
 private byte[] courtPic;
 
 @Column(name = "courtTelephone")
 private String courtTelephone;
 
 @Column(name = "courtAddress")
 private String courtAddress;
 
 @Column(name = "courtRule" , columnDefinition = "text")
 private String courtRule;
 
 @Column(name = "loc")
 private String loc;
 
 @Column(name = "courtApplyStatus")
 private Integer courtApplyStatus;
 
 
 @Column(name = "courtOpenTime")
 private Time courtOpenTime;

 
 @Column(name = "courtCloseTime")
 private Time courtCloseTime;
 
 
 //預約訂單
 // fetch 預設為 LAZY
 @OneToMany(mappedBy = "court", cascade = CascadeType.ALL)
 @OrderBy("reserveOrderID asc") 
 private Set<ReserveOrder> reserveOrder; // Set不重複
 
 
 //場地
 // fetch 預設為 LAZY
 @OneToMany(mappedBy = "court", cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
// @JoinColumn(name = "courtID")
 @OrderBy("placeID asc") 
 private Set<Place> place; // Set不重複
 

 //時段
 // fetch 預設為 LAZY
 @OneToMany(mappedBy = "court", cascade = CascadeType.ALL)
 @OrderBy("timeID asc") 
 private Set<TimeRef> timeRef; // Set不重複
 
 
 
     //管理員
  //fetch 預設為 EAGER
  @ManyToOne
  @JoinColumn(name = "manageID", referencedColumnName = "manageID")
  private Manage manage;
   
 // @Column(name="courtID", updatable = false)
 // private Integer courtID;
 
 
     //企業會員
  //fetch 預設為 EAGER
  @ManyToOne
  @JoinColumn(name = "oUserID", referencedColumnName = "oUserID")
  private OwnerUser ownerUser;

 public Court(Integer courtID, Timestamp courtOnTime, Timestamp courtApplyTime, String courtName, byte[] courtPic,
   String courtTelephone, String courtAddress, String courtRule, String loc, Integer courtApplyStatus,
   Time courtOpenTime, Time courtCloseTime, Set<ReserveOrder> reserveOrder, Set<Place> place,
   Set<TimeRef> timeRef, Manage manage, OwnerUser ownerUser) {
  super();
  this.courtID = courtID;
  this.courtOnTime = courtOnTime;
  this.courtApplyTime = courtApplyTime;
  this.courtName = courtName;
  this.courtPic = courtPic;
  this.courtTelephone = courtTelephone;
  this.courtAddress = courtAddress;
  this.courtRule = courtRule;
  this.loc = loc;
  this.courtApplyStatus = courtApplyStatus;
  this.courtOpenTime = courtOpenTime;
  this.courtCloseTime = courtCloseTime;
  this.reserveOrder = reserveOrder;
  this.place = place;
  this.timeRef = timeRef;
  this.manage = manage;
  this.ownerUser = ownerUser;
 }

 public Court() {
  super();
  // TODO Auto-generated constructor stub
 }

 public Integer getCourtID() {
  return courtID;
 }

 public void setCourtID(Integer courtID) {
  this.courtID = courtID;
 }

 public Timestamp getCourtOnTime() {
  return courtOnTime;
 }

 public void setCourtOnTime(Timestamp courtOnTime) {
  this.courtOnTime = courtOnTime;
 }

 public Timestamp getCourtApplyTime() {
  return courtApplyTime;
 }

 public void setCourtApplyTime(Timestamp courtApplyTime) {
  this.courtApplyTime = courtApplyTime;
 }

 public String getCourtName() {
  return courtName;
 }

 public void setCourtName(String courtName) {
  this.courtName = courtName;
 }

 public byte[] getCourtPic() {
  return courtPic;
 }

 public void setCourtPic(byte[] courtPic) {
  this.courtPic = courtPic;
 }

 public String getCourtTelephone() {
  return courtTelephone;
 }

 public void setCourtTelephone(String courtTelephone) {
  this.courtTelephone = courtTelephone;
 }

 public String getCourtAddress() {
  return courtAddress;
 }

 public void setCourtAddress(String courtAddress) {
  this.courtAddress = courtAddress;
 }

 public String getCourtRule() {
  return courtRule;
 }

 public void setCourtRule(String courtRule) {
  this.courtRule = courtRule;
 }

 public String getLoc() {
  return loc;
 }

 public void setLoc(String loc) {
  this.loc = loc;
 }

 public Integer getCourtApplyStatus() {
  return courtApplyStatus;
 }

 public void setCourtApplyStatus(Integer courtApplyStatus) {
  this.courtApplyStatus = courtApplyStatus;
 }

 public Time getCourtOpenTime() {
  return courtOpenTime;
 }

 public void setCourtOpenTime(Time courtOpenTime) {
  this.courtOpenTime = courtOpenTime;
 }

 public Time getCourtCloseTime() {
  return courtCloseTime;
 }

 public void setCourtCloseTime(Time courtCloseTime) {
  this.courtCloseTime = courtCloseTime;
 }

 public Set<ReserveOrder> getReserveOrder() {
  return reserveOrder;
 }

 public void setReserveOrder(Set<ReserveOrder> reserveOrder) {
  this.reserveOrder = reserveOrder;
 }

 public Set<Place> getPlace() {
  return place;
 }

 public void setPlace(Set<Place> place) {
  this.place = place;
 }

 public Set<TimeRef> getTimeRef() {
  return timeRef;
 }

 public void setTimeRef(Set<TimeRef> timeRef) {
  this.timeRef = timeRef;
 }

 public Manage getManage() {
  return manage;
 }

 public void setManage(Manage manage) {
  this.manage = manage;
 }

 public OwnerUser getOwnerUser() {
  return ownerUser;
 }

 public void setOwnerUser(OwnerUser ownerUser) {
  this.ownerUser = ownerUser;
 }

 @Override
 public String toString() {
  return "Court [courtID=" + courtID + ", courtOnTime=" + courtOnTime + ", courtApplyTime=" + courtApplyTime
    + ", courtName=" + courtName + ", courtPic=" + Arrays.toString(courtPic) + ", courtTelephone="
    + courtTelephone + ", courtAddress=" + courtAddress + ", courtRule=" + courtRule + ", loc=" + loc
    + ", courtApplyStatus=" + courtApplyStatus + ", courtOpenTime=" + courtOpenTime + ", courtCloseTime="
    + courtCloseTime + ", reserveOrder=" + reserveOrder + ", place=" + place + ", timeRef=" + timeRef
    + ", manage=" + manage + ", ownerUser=" + ownerUser + "]";
 }

}