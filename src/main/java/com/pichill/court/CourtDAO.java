package com.pichill.court;

import java.util.List;

	public interface CourtDAO{
		int add(Court court);
		int update(Court court);
		void delete(int courtID);
		public Court getCourtByCourtID(Integer courtID);
		public List<Court> getAll();
	}
