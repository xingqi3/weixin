package com.xingqisan.cangk.menu.repository;

import java.awt.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {

}
