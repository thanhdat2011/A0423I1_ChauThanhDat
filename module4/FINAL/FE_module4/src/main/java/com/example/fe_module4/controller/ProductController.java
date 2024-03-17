package com.example.fe_module4.controller;

import com.example.fe_module4.model.DTO.ProductDTO;
import com.example.fe_module4.model.Product;
import com.example.fe_module4.model.ProductType;
import com.example.fe_module4.service.Interface.IProductService;
import com.example.fe_module4.service.Interface.IProductTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;
    @Autowired
    private IProductTypeService iProductTypeService;
    @GetMapping
    public String showLibrary(){
        return "redirect:/product/list";
    }

    @ModelAttribute("productTypeList")
    public List<ProductType> getProductTypeList(){
        return iProductTypeService.findAll();
    }
    @GetMapping("/list")
    public ModelAndView showProductList(@RequestParam(defaultValue = "0", required = false) int page){
        Pageable pageable = PageRequest.of(page, 3);
        Page<Product> productPage = iProductService.getProductList(pageable);
        return new ModelAndView("/product/list", "productList", productPage);
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        iProductService.removeProductById(id);
        return "redirect:/product/list";
    }

    @GetMapping("/show-form-create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("/product/create", "product", new ProductDTO());
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("product") ProductDTO productDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "/product/create";
        }
        Product product = new Product();
        ProductType productType = iProductTypeService.findById(productDTO.getpType());
        BeanUtils.copyProperties(productDTO, product);

        product.setpType(productType);
        iProductService.save(product);
        return "redirect:/product/list";
    }

    @GetMapping("/{id}/show-form-edit")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        Product product = iProductService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("student") ProductDTO productDTO,
                       BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "/product/edit";
        }
        Product product = new Product();
        ProductType productType = iProductTypeService.findById(productDTO.getpType());

        BeanUtils.copyProperties(productDTO, product);
        product.setpType(productType);
        iProductService.save(product);
        return "redirect:/product/list";
    }

    @GetMapping("/search")
    public ModelAndView showSearch(@RequestParam(defaultValue = "0", required = false) int page, @RequestParam String keySearch){
        Pageable pageable = PageRequest.of(page, 3);
        Page<Product> productPage = iProductService.find(pageable, keySearch);
        ModelAndView modelAndView = new ModelAndView("/product/search");
        modelAndView.addObject("productList", productPage);
        modelAndView.addObject("keySearch", keySearch);
        return modelAndView;
    }
}
