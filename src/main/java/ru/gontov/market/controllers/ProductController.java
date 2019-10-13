package ru.gontov.market.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.gontov.market.entities.Product;
import ru.gontov.market.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView showAll(ModelAndView modelAndView){
        modelAndView.addObject("productsList", productService.findAll());
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){
        productService.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editById(@PathVariable("id") Long id, ModelAndView modelAndView){
        modelAndView.addObject("product", productService.findById(id));
        modelAndView.setViewName("edit-product");
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute(name = "product") Product product){
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/add")
    public ModelAndView add(ModelAndView modelAndView){
        modelAndView.addObject("product", new Product());
        modelAndView.setViewName("add-product");
        return modelAndView;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(name = "product") Product product){
        productService.save(product);
        return "redirect:/products";
    }

}
