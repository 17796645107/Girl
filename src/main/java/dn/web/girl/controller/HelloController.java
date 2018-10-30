package dn.web.girl.controller;

import dn.web.girl.entity.Girl;
import dn.web.girl.entity.Result;
import dn.web.girl.repository.GirlRepository;
import dn.web.girl.service.GirlService;
import dn.web.girl.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author: 邓宁
 * @Date: Created in 14:10 2018/10/24
 */

@RestController
public class HelloController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    private static  final Logger logger= LoggerFactory .getLogger(HelloController.class);

    @RequestMapping(value = "/hello")
    public String hello(Model model){
        model.addAttribute("now",new Date());
        return "hello";
    }

    /*
     * @Description:
     * @param: []
     * @return: java.util.List<dn.web.girl.girl>
     */
    @ResponseBody
    @GetMapping(value = "/getGirls")
    public List<Girl>getGirlList(){
        return girlRepository.findAll();
    }

    /*
     * @Description:添加一个女孩
     * @param: [age, size]
     * @return: dn.web.girl.girl
     */
    @GetMapping(value = "/addGirl")
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            //设置返回实体
            return ResultUtil.error(0,bindingResult.getFieldError().getDefaultMessage());
        }
        else{
            //设置girl
            girl.setAge(girl.getAge());
            girl.setSize(girl.getSize());

            return ResultUtil.success(girlRepository.save(girl));
        }
    }

    /*
     * @Description:通过id查询一个女孩的所有信息
     * @param: [id]
     * @return: dn.web.girl.entity.Girl
     */
    @ResponseBody
    @GetMapping(value = "/findGirl/{id}")
    public Optional<Girl> findGirlById(@PathVariable("id") Integer id){
        return girlRepository.findById(id);
    }
    
 
    /*
         *
         * @Description:
         * @date: 16:12 2018/10/27
         * @param: [id]
         * @return: dn.web.girl.entity.Result
         */
    @GetMapping(value = "/getAge/{id}")
    @ResponseBody
    public Result getAge(@PathVariable("id") Integer id) throws Exception {
        return ResultUtil.success(girlService.getAge(id));
    }

}

