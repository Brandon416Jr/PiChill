package com.pichill.court;

import java.util.List;

	public interface CourtDAO{
		void add(Court court);
		void update(Court court);
		void delete(int courtID);
		public Court findByPK(Integer courtID);
		public List<Court> getAll();
	}
