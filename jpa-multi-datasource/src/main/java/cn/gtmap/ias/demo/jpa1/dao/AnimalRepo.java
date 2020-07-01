package cn.gtmap.ias.demo.jpa1.dao;

import cn.gtmap.ias.demo.jpa1.po.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zenglihuan
 * @version 1.0.0
 * @since 2020/5/11 15:37
 **/
public interface AnimalRepo extends JpaRepository<Animal, String>, JpaSpecificationExecutor<Animal> {
}
