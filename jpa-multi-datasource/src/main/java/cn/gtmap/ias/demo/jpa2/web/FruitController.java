package cn.gtmap.ias.demo.jpa2.web;

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
 * @since 2020/5/11 16:41
 **/
@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitRepo fruitRepo;

    @GetMapping
    public List<Fruit> findAll() {
        return fruitRepo.findAll();
    }

}

