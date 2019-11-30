package com.imooc.girl.respository;

import com.imooc.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author panshao
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    /**
     * 添加通过年龄查询的方法
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
