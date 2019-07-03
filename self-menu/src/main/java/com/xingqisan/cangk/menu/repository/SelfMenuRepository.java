package com.xingqisan.cangk.menu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xingqisan.cangk.menu.domain.SelfMenu;

@Repository
public interface SelfMenuRepository extends JpaRepository<SelfMenu, String> {

}
