package com.imooc.girl.controller;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.domain.Result;
import com.imooc.girl.respository.GirlRepository;
import com.imooc.girl.service.GirlService;
import com.imooc.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * @author panshao
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    /**
     * 获取Girl表中所有数据
     * @return
     */
    @GetMapping(value = "/girl")
    public Result girlList() {
        return ResultUtil.success(girlRepository.findAll());
    }

    /**
     * 为添加Girl表添加一条数据
     * @return
     */
    @PostMapping(value = "/girl")
    public Result girlAdd(@Valid Girl girl, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.fail(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 使用id查询某一条信息
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/{id}")
    public Result girlFindById(@PathVariable("id") Integer id) {
        return ResultUtil.success(girlRepository.findById(id));
    }

    /**
     * 查询所有符合年龄的数据，并返回List
     * @param age
     * @return
     */
    @GetMapping(value = "/girl/age/{age}")
    public Result girlListByAge(@PathVariable("age") Integer age) {
        if(girlRepository.findByAge(age).isEmpty()) {
            return ResultUtil.fail("数据为空");
        }
        return ResultUtil.success(girlRepository.findByAge(age));
    }

    /**
     * 将对应id的条目信息更新
     * @param id
     * @param girl
     * @return
     */
    @PutMapping(value = "/girl/{id}")
    public Result girlUpdate(@PathVariable("id") Integer id, @Valid Girl girl, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.fail(bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setId(id);
        return ResultUtil.success(girlRepository.save(girl));
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
