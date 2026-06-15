package com.example.tp_spring.web;

import com.example.tp_spring.product.entity.Product;
import com.example.tp_spring.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductWebController {

    private final ProductService service;

    public ProductWebController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public String products(Model model) {

        model.addAttribute("products", service.getAll());
        model.addAttribute("product", new Product());

        return "products";
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute Product product) {

        service.save(product);

        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {

        service.delete(id);

        return "redirect:/products";
    }
    @GetMapping("/products/new")
    public String addForm() {
        return "add-product";
    }
    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {

        Product product = service.getById(id);

        model.addAttribute("product", product);

        return "edit-product";
    }

    @PostMapping("/products/update/{id}")
    public String updateProduct(
            @PathVariable Long id,
            @ModelAttribute Product product) {

        service.update(id, product);

        return "redirect:/products";
    }
}