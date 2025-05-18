package com.sachi.maincompany.Service;

import com.sachi.maincompany.Dto.ProductDTO;
import com.sachi.maincompany.Model.Product;
import com.sachi.maincompany.Repo.ProductRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDTO> getAllProducts(){
        List<Product> ProductsList = productRepo.findAll();
        return modelMapper.map(ProductsList, new TypeToken<List<ProductDTO>>() {}.getType());
    }

    public ProductDTO saveProduct(ProductDTO Product) {
        productRepo.save(modelMapper.map(Product, Product.class));
        return Product;
    }

    public ProductDTO updateProduct(ProductDTO Product) {
        productRepo.save(modelMapper.map(Product, Product.class));
        return Product;
    }

    public String deleteProduct(int id){
        try {
            if(productRepo.existsById(id)){
                productRepo.deleteById(id);
                return "Deleted Successfully";
            } else {
                return "Product with ID " + id + " not found";
            }
        } catch (Exception e) {
            return "Error deleting Product: " + e.getMessage();
        }
    }
    public ProductDTO getProductbyid(int id) {
        Product product = productRepo.getProductbyid(id);
        return modelMapper.map(product, ProductDTO.class);
    }

}
