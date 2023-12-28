package com.pichill.court.courtinfo;

import java.util.List;

import com.pichill.court.Court;



	public interface CourtDAO{
		public Court getCourtByCourtID(Integer courtID);
//		public Court getCourtByCourtName(String courtName);
		public List<Court> getAll();
				
//		List<Court> getByCompositeQuery(Map<String, String> map);
		
	}
