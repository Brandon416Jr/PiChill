package com.pichill.court;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.pichill.place.Place;


@Entity

@Table(name = "Court")
public class Court implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courtID", updatable = false, insertable=false) //PK鍵不用更新
//	@OneToMany(mappedBy = "courtID")
	private Integer courtID;
	
	@Column(name = "oUserID")
	private Integer oUserID;
	
	@Column(name = "manageID")
	private Integer manageID;
	
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
	
	public Court() {
        super();
    }
	
	public Court(Integer courtID, Integer oUserID, Integer manageID, Timestamp courtOnTime, Timestamp courtApplyTime, String courtName,byte[] courtPic, String courtTelephone, String courtAddress, String courtRule, String loc, Integer courtApplyStatus, Time courtOpenTime, Time courtCloseTime) {
		this.courtID = courtID;
		this.oUserID = oUserID;
		this.manageID = manageID;
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
	}

//	@ManyToOne
//	@JoinColumn(name = "courtID" , referencedColumnName = "courtID")
//	private Place place;
	

//	public void setPlace(Place place) {
//		this.place = place;
//	}

	public Integer getCourtID() {
		return courtID;
	}

	public void setCourtID(Integer courtID) {
		this.courtID = courtID;
	}

	public Integer getoUserID() {
		return oUserID;
	}

	public void setoUserID(Integer oUserID) {
		this.oUserID = oUserID;
	}

	public Integer getmanageID() {
		return manageID;
	}

	public void setmanageID(Integer manageID) {
		this.manageID = manageID;
	}

	public Timestamp getcourtOnTime() {
		return courtOnTime;
	}

	public void setcourtOnTime(Timestamp courtOnTime) {
		this.courtOnTime = courtOnTime;
	}

	public Timestamp getcourtApplyTime() {
		return courtApplyTime;
	}

	public void setcourtApplyTime(Timestamp courtApplyTime) {
		this.courtApplyTime = courtApplyTime;
	}

	public String getcourtName() {
		return courtName;
	}

	public void setcourtName(String courtName) {
		this.courtName = courtName;
	}

	public byte[] getcourtPic() {
		return courtPic;
	}

	public void setcourtPic(byte[] courtPic) {
		this.courtPic = courtPic;
	}

	public String getcourtTelephone() {
		return courtTelephone;
	}

	public void setcourtTelephone(String courtTelephone) {
		this.courtTelephone = courtTelephone;
	}

	public String getcourtAddress() {
		return courtAddress;
	}

	public void setcourtAddress(String courtAddress) {
		this.courtAddress = courtAddress;
	}

	public String getcourtRule() {
		return courtRule;
	}

	public void setcourtRule(String courtRule) {
		this.courtRule = courtRule;
	}

	public String getloc() {
		return loc;
	}

	public void setloc(String loc) {
		this.loc = loc;
	}

	public Integer getcourtApplyStatus() {
		return courtApplyStatus;
	}

	public void setcourtApplyStatus(Integer courtApplyStatus) {
		this.courtApplyStatus = courtApplyStatus;
	}
	public Time getcourtOpenTime() {
		return courtOpenTime;
	}

	
	public void setcourtOpenTime(Time courtOpenTime) {
		this.courtOpenTime = courtOpenTime;
	}

	public Time getcourtCloseTime() {
		return courtCloseTime;
	}

	public void setcourtCloseTime(Time courtCloseTime) {
		this.courtCloseTime = courtCloseTime;
	}

	// for join placeID from place
//    public com.pichill.place.Place getPlace() {
//        com.pichill.place.PlaceService placeSvc = new com.pichill.place.PlaceService();
//        com.pichill.place.Place place = placeSvc.getOnePlace(placeName);
//        com.pichill.place.Place place1 = placeSvc.getOnePlace(placeFee);
//        com.pichill.place.Place place2 = placeSvc.getOnePlace(ball);
//	    return place;
//    }
}
