package com.lab3web.hero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab3web.hero.model.Hero;

public interface HeroRespository extends JpaRepository<Hero,Long>{
    
}
