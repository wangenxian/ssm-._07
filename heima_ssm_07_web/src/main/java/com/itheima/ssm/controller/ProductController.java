package com.itheima.ssm.controller;

import com.itheima.ssm.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: heima_ssm_07
 * @description:
 * @author: wangenxian
 * @create: 2019-07-15 17:00
 *
 **/
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        
        System.out.println("方法执行了");
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list1");
        return  mv;

    }
    @RequestMapping("/save")
    public String save(Product product) throws Exception {
         System.out.println("save方法执行了");
           productService.save(product);
          return "redirect:findAll";
    }
    @RequestMapping("/findProductById")
    public  ModelAndView findProductById(String productNum){
            ModelAndView mv =  new ModelAndView();
            Product product = productService.findProductById(productNum);
            mv.addObject("product", product);
            mv.setViewName("product_update");
            return mv;

    }
    @RequestMapping("/updateByNum")
    public  String updateByNum(@RequestParam(name = "productNum", required = true) String productNum, Product product){
        productService.updateByNum(productNum,product);
        return  "redirect:findAll";
    }

}
