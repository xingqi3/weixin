package com.xingqisan.cangk.menu.service;

import com.xingqisan.cangk.menu.domain.SelfMenu;

public interface SelfMenuService {

	SelfMenu getMenu();

	void saveMenu(SelfMenu selfMenu);

}
