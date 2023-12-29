package com.pichill.frontstage.court.service;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import com.pichill.court.Court;
import com.pichill.frontstage.court.model.CourtDAOFront;
import com.pichill.frontstage.court.model.CourtDAOImplFront;
import com.pichill.manage.entity.Manage;
import com.pichill.owneruser.entity.OwnerUser;


public class CourtServiceFront {
	private final CourtDAOFront dao;
	
	public CourtServiceFront() {
		dao = new CourtDAOImplFront();
	}
	
	public List<Court> getoUserID(Integer oUserID) {
		return dao.findCourtByoUserID(oUserID);
	}
	
	public Court getOneCourt(Integer courtID) {
		return dao.getCourtByCourtID(courtID);
	}
	
	public int insertCourtAll(Court court) {
		return dao.insert(court);	
	}
	
	public int updateCourtAll(Court court) {
		return dao.update(court);
	}
	
	public Court updateCourt(Integer courtID, Time courtOpenTime, Time courtCloseTime, String courtName, byte[] courtPic, String courtTelephone, String courtAddress, String loc, String courtRule) {
		Court court = dao.getCourtByCourtID(courtID);
		if (court != null) {
			court.setCourtID(courtID);
//			court.setOwnerUser(ownerUser);
//			court.setManage(manage);
//			court.setCourtApplyTime(courtApplyTime);
//			court.setCourtOnTime(courtOnTime);
			court.setCourtOpenTime(courtOpenTime);
			court.setCourtOpenTime(courtOpenTime);
			court.setCourtName(courtName);
			court.setCourtPic(courtPic);
			court.setCourtTelephone(courtTelephone);
			court.setCourtAddress(courtAddress);
			court.setCourtRule(courtRule);
//			court.setCourtApplyStatus(courtApplyStatus);
			court.setLoc(loc);
						dao.update(court);
		}
		return court;
	}
}
