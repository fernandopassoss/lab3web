package com.lab3web.hero.rest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab3web.hero.model.Hero;
import com.lab3web.hero.repository.HeroRespository;

@RestController
@RequestMapping("/hero")
public class HeroRest {


    @Autowired
    private HeroRespository repository;


    @PostMapping("/post")
    public void salvar(@RequestBody Hero hero){
        repository.save(hero);

    }

    @GetMapping("/get")
    public List<Hero> consultar(){
        return repository.findAll();
    }

    @PutMapping("/put")
    public void atualizar(@RequestBody Hero hero){
        if(hero.getId()>0){
            repository.save(hero);
        }
    }

    @DeleteMapping("/delete")
    public void excluir(@RequestBody Hero hero){
        repository.delete(hero);
    }

    @GetMapping(path = "/get/{id}")
    public Optional<Hero> consultarPorID(@PathVariable Long id){
        return repository.findById(id);
    }


}
