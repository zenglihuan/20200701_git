package cn.gtmap.ias.demo.jpa2.dao;

import cn.gtmap.ias.demo.jpa1.po.Animal;
import cn.gtmap.ias.demo.jpa2.po.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zenglihuan
 * @version 1.0.0
 * @since 2020/5/11 15:37
 **/
public interface FruitRepo extends JpaRepository<Fruit, String>, JpaSpecificationExecutor<Fruit> {
}
