package com.imooc.girl.service;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.respository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
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
}
