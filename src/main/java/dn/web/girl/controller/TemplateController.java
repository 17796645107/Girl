package dn.web.girl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 邓宁
 * @Date: Created in 14:47 2018/10/28
 */

@Controller
//@RequestMapping("th")
public class TemplateController {

    @RequestMapping("/index")
    public String test (ModelMap map){
        map.addAttribute("test","a");
        return "index";
    }
}
