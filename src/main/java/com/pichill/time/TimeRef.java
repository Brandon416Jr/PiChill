package com.pichill.time;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.pichill.court.Court;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.reserveorder.entity.ReserveOrder;

@Entity
@Table(name="timeref")
public class TimeRef {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="timeID", updatable = false)
	private Integer timeID;
	
	@Column(name="reserveTime", updatable = false)
	private String reserveTime;
	
	// fetch 預設為 EAGER
	@ManyToOne
	@JoinColumn(name = "courtID", referencedColumnName = "courtID", updatable = false)//(name=自己(FK), referencedColumnName = 對應到的PK)
	private Court court;
//	@Column(name="courtID", updatable = false)
//	private Integer courtID;
	
	
	//預約訂單
	// fetch 預設為 LAZY
	@OneToMany(mappedBy = "timeRef", cascade = CascadeType.ALL)
	// (mappedBy = "time")的time指的是新增的Time "time"部門物件的屬性
	@OrderBy("reserveOrderID asc") 
	private Set<ReserveOrder> reserveOrder; // Set不重複
		
	public TimeRef() {
		super();
	}


	public TimeRef(Integer timeID, String reserveTime, Court court, Set<ReserveOrder> reserveOrder) {
		super();
		this.timeID = timeID;
		this.reserveTime = reserveTime;
		this.court = court;
		this.reserveOrder = reserveOrder;
	}


	public Integer getTimeID() {
		return timeID;
	}

	public void setTimeID(Integer timeID) {
		this.timeID = timeID;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

//	public Integer getCourtID() {
//		return courtID;
//	}
//
//	public void setCourtID(Integer courtID) {
//		this.courtID = courtID;
//	}

	
	public Set<ReserveOrder> getReserveOrder() {
		return reserveOrder;
	}

	public void setReserveOrder(Set<ReserveOrder> reserveOrder) {
		this.reserveOrder = reserveOrder;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}


	@Override
	public String toString() {
		return "Time [timeID=" + timeID + ", reserveTime=" + reserveTime + ", court=" + court + ", reserveOrder="
				+ reserveOrder + "]";
	}

	public static TimeRef parseInt(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
