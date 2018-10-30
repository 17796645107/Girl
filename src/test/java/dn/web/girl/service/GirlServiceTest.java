package dn.web.girl.service;

import dn.web.girl.entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @Author: 邓宁
 * @Date: Created in 0:31 2018/10/27
 */

//GirlService测试类
@RunWith(SpringRunner.class)
@SpringBootTest//启动spring工程
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Optional<Girl> girl=girlService.findOne(10);
        Assert.assertEquals(new Integer(12),girl.orElseGet(Girl::new).getAge());
    }
}
