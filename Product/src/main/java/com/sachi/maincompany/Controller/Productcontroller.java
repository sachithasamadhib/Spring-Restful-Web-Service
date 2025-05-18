package com.sachi.maincompany.Controller;

import com.sachi.maincompany.Dto.ProductDTO;
import com.sachi.maincompany.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/")
public class Productcontroller {

    @Autowired
    private ProductService ProductService;

    @GetMapping("/getallProduct")
    public List<ProductDTO> getallProduct() {
        return ProductService.getAllProducts();
    }

    @GetMapping("/getProduct/{Productid}")
    public ProductDTO getProductid(@PathVariable int Productid) {
        return ProductService.getProductbyid(Productid);
    }

    @GetMapping("/hi")
    public String hi() {
        return "Hi";
    }

    @PostMapping("/addProduct")
    public ProductDTO addProduct(@RequestBody ProductDTO Product) {
        return ProductService.saveProduct(Product);

    }

    @PutMapping("/updateProduct")
    public ProductDTO updateProduct(@RequestBody ProductDTO Product) {
        return ProductService.updateProduct(Product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct (@PathVariable int id) {
        return ProductService.deleteProduct(id);
    }

}
