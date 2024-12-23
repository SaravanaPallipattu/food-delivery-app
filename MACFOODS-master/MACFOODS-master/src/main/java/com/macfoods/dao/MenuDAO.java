package com.macfoods.dao;

import java.util.List;

import com.macfoods.dto.Menu;

public interface MenuDAO {

	int insertMenu(Menu m);
	List<Menu> getAllRestMenu(int restId);
	Menu getMenuById(int id);
	int deleteMenuById(int id);
	int updateMenuById(int id,boolean isAvailable);
	public List<Menu> getResItems(int restId);
	
}
