package com.pichill.place;

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

import com.google.gson.annotations.Expose;
import com.pichill.court.Court;
import com.pichill.reserveorder.entity.ReserveOrder;


@Entity
@Table(name = "place")
public class Place {
 
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "placeID", updatable = false) //PK鍵不用更新
 private Integer placeID;
 
// @Column(name = "courtID" , updatable = false ,insertable = false )
// private Integer courtID;
 
 @Column(name = "placeName", columnDefinition = "varchar")
 public String placeName;
 
 @Column(name = "placeFee")
 @Expose
 public Integer placeFee;
 
 @Column(name = "ball")
 @Expose
 public Integer ball;
 
 
 
 //球館
 @ManyToOne(fetch = FetchType.EAGER)
 @JoinColumn(name = "courtID", referencedColumnName = "courtID")
 private Court court;
 

 public Court getCourt() {
 return court;
 }

 public void setCourt(Court court) {
 this.court = court;
 }
 

 
 //預約訂單
 // fetch 預設為 LAZY
 @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
 // (mappedBy = "place")的generalUser指的是新增的Place "place"部門物件的屬性
 @OrderBy("reserveOrderID asc") 
 private Set<ReserveOrder> reserveOrder; // Set不重複


 public Place() {
  super();
  // TODO Auto-generated constructor stub
 }

 public Place(Integer placeID, String placeName, Integer placeFee, Integer ball, Court court,
   Set<ReserveOrder> reserveOrder) {
  super();
  this.placeID = placeID;
  this.placeName = placeName;
  this.placeFee = placeFee;
  this.ball = ball;
  this.court = court;
  this.reserveOrder = reserveOrder;
 }

 public Integer getPlaceID() {
  return placeID;
 }

 public void setPlaceID(Integer placeID) {
  this.placeID = placeID;
 }

 public String getPlaceName() {
  return placeName;
 }

 public void setPlaceName(String placeName) {
  this.placeName = placeName;
 }

 public Integer getPlaceFee() {
  return placeFee;
 }

 public void setPlaceFee(Integer placeFee) {
  this.placeFee = placeFee;
 }

 public Integer getBall() {
  return ball;
 }

 public void setBall(Integer ball) {
  this.ball = ball;
 }

 public Set<ReserveOrder> getReserveOrder() {
  return reserveOrder;
 }

 public void setReserveOrder(Set<ReserveOrder> reserveOrder) {
  this.reserveOrder = reserveOrder;
 }

 @Override
 public String toString() {
  return "Place [placeID=" + placeID + ", placeName=" + placeName + ", placeFee=" + placeFee + ", ball=" + ball
    + ", court=" + court + ", reserveOrder=" + reserveOrder + "]";
 }
  
 
 //貼文
 // fetch 預設為 LAZY
// @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
// // (mappedBy = "place")的generalUser指的是新增的Place "place"部門物件的屬性
// @OrderBy("postID asc") 
// private Set<Post> post; // Set不重
 
 
}