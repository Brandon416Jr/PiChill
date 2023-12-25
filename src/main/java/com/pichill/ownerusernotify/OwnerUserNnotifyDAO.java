package com.pichill.ownerusernotify;

import java.util.List;



public class OwnerUserNnotifyDAO {
	int add(OwnerUserNnotify ownerUserNnotify);
	int update(OwnerUserNnotify ownerUserNnotify);
	List<OwnerUserNnotify> getAll();
	List<OwnerUserNnotify> findByoUserID(Integer oUserID);
	
}
