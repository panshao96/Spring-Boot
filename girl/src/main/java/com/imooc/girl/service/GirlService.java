package com.imooc.girl.service;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.domain.Result;
import com.imooc.girl.enums.ResultEnum;
import com.imooc.girl.exception.GirlException;
import com.imooc.girl.respository.GirlRepository;
import com.imooc.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author panshao
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;


    @Transactional(rollbackFor = Exception.class)
    public void insertTwo() {
        Girl girlA =new Girl();
        girlA.setAge(19);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB =new Girl();
        girlB.setAge(19);
        girlB.setCupSize("BBB");
        girlRepository.save(girlB);
    }


    public void getAge(Integer id) {
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw  new GirlException(ResultEnum.JUNIOR);
        }else if (age > 10 && age < 18) {
            throw new GirlException(ResultEnum.MIDDLE_STUDENT);
        }else {
            throw new GirlException(ResultEnum.ADULT);
        }
    }

    /**
     * 通过id查询信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        return girlRepository.getOne(id);
    }

}
