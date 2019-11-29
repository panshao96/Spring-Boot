package com.imooc.girl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

    //添加通过年龄查询的方法
    public List<Girl> findByAge(Integer age);
}
