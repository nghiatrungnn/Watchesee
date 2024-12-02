package com.example.beststore.beststore.controllers;

import com.example.beststore.beststore.models.Product;
import com.example.beststore.beststore.services.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsRepository repo;

    @GetMapping({"", "/"})
    public String showProductList(Model model) {
        List<Product> products = repo.findAll();
        model.addAttribute("products", products);
        return "products/index";
    }

    @GetMapping("/index")
    public String showProducts(Model model) {
        List<Product> products = repo.findAll();
        model.addAttribute("products", products);
        return "products/product";
    }

    @GetMapping("/{id}")
    public String showProductDetail(@PathVariable int id, Model model) {
        Product product = repo.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "products/detail";
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        // Logic để lấy sản phẩm trong giỏ hàng (nếu cần)
        return "products/cart"; // Đường dẫn đến tệp HTML giỏ hàng
    }
}
