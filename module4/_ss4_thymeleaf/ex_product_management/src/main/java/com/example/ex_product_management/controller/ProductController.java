package com.example.ex_product_management.controller;

import com.example.ex_product_management.model.Product;
import com.example.ex_product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/product")
@Controller
public class ProductController {

    @Autowired
    private IProductService productService;
    @GetMapping
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/showCreateForm")
    public String showCreateForm(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("msg", "Create successfully !!!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/detail")
    public String showDetail(@PathVariable String id, Model model){
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model){
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("msg", "Edit succesfull");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable String id, RedirectAttributes redirectAttributes){
        Product product = productService.findProductById(id);
        productService.removeProduct(product);
        redirectAttributes.addFlashAttribute("msg", "Delete " + id + " successfully !!!");
        return "redirect:/product";
    }

    @PostMapping("/search")
    public String searchByName(@RequestParam("productName") String productName, Model model){
        List<Product> searchList = productService.findProductByName(productName);
        model.addAttribute("productList", searchList);
        return "search";
    }

}
