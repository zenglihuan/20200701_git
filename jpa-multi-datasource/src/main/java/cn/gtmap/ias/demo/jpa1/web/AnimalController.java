package cn.gtmap.ias.demo.jpa1.web;

import cn.gtmap.ias.demo.jpa1.dao.AnimalRepo;
import cn.gtmap.ias.demo.jpa1.po.Animal;
import cn.gtmap.ias.demo.jpa2.dao.FruitRepo;
import cn.gtmap.ias.demo.jpa2.po.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zenglihuan
 * @version 1.0.0
 * @since 2020/5/11 16:40
 **/
@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalRepo animalRepo;

    @Autowired
    private FruitRepo fruitRepo;

    @GetMapping
    public List<Animal> findAll() {
        return animalRepo.findAll();
    }

    @GetMapping("/fruits")
    public List<Fruit> findAllFruit() {
        return fruitRepo.findAll();
    }

}

