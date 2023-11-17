package com.pichill.time;

import java.util.*;
import java.sql.*;

public class TimeTest {
	public static void main(String[] args) {
		TimeDAO dao = new TimeDAOimpl();
		
		// 查單筆
//		Time time = dao.getTimeByTimeID(4);
//		System.out.print(time.getReserveTime() + ",");
//		System.out.println(time.getCourtID() + ",");
//		System.out.println("---------------------");
		
		// 查多筆
		List<Time> list = dao.getAll();
		for (Time time : list) {
			System.out.print(time.getReserveTime() + ",");
			System.out.println(time.getCourtID() + ",");
			System.out.println();
		}
		
	}

}
