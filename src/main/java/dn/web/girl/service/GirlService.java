package dn.web.girl.service;

import dn.web.girl.entity.Girl;
import dn.web.girl.enums.ResultEnum;
import dn.web.girl.exception.GirlException;
import dn.web.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: 邓宁
 * @Date: Created in 22:10 2018/10/26
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    /*
     * @Description:通过id查询一个女生的年龄
     * @param: [id]
     * @return: java.lang.Integer
     */
    public Integer getAge(Integer id) throws Exception {
        //通过id查询一个girl实体
        Optional<Girl> girl=girlRepository.findById(id);
        //获取年龄
        Integer age=girl.orElseGet(Girl::new).getAge();
        if (age<20){
            throw new GirlException(ResultEnum.SMALL_SCHOOL);
        }
        else if(age>10 && age<16){
            throw new GirlException(ResultEnum.HIGH_SCHOOL);
        }
        return age;
    }

    /*
     * @Description:通过id查询一个女生的信息
     * @param: [id]
     * @return: java.util.Optional<dn.web.girl.entity.Girl>
     */
    public Optional<Girl> findOne(Integer id){
        return girlRepository.findById(id);
    }
}
