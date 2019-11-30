package com.imooc.girl.controller;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.respository.GirlRepository;
import com.imooc.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


/**
 * @author panshao
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 获取Girl表中所有数据
     * @return
     */
    @GetMapping(value = "/girl")
    public List<Girl> girlList() {
        System.out.println("girlList");
        return girlRepository.findAll();
    }

    /**
     * 为添加Girl表添加一条数据
     * @return
     */
    @PostMapping(value = "/girl")
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        girl.setMoney(girl.getMoney());

        return girlRepository.save(girl);
    }

    /**
     * 使用id查询某一条信息
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/{id}")
    public Optional<Girl> girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findById(id);
    }

    /**
     * 查询所有符合年龄的数据，并返回List
     * @param age
     * @return
     */
    @GetMapping(value = "/girl/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * 将对应id的条目信息更新
     * @param id
     * @param girl
     * @return
     */
    @PutMapping(value = "/girl/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, Girl girl) {

        girl.setId(id);
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setMoney(girl.getMoney());
        return girlRepository.save(girl);
    }

    /**
     * 删除对应id的条目
     * @param id
     */
    @DeleteMapping(value = "/girl/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    /**
     * 添加两条信息
     */
    @PostMapping(value = "/girl/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

}
