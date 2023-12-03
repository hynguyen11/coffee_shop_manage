package com.cafeshopmanage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cafeshopmanage.entity.Product;
import com.cafeshopmanage.model.ProductModel;
import com.cafeshopmanage.repository.ProductRepository;
import com.cafeshopmanage.utils.ImageUtils;
import com.cafeshopmanage.utils.MapperUtils;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void createUpdateProduct(ProductModel productForm) {
        Product product = null;
        if (productForm.getId() != null) {
            Optional<Product> productEntity = productRepository.findById(productForm.getId());
            if (productEntity.isPresent()) {
                product = productEntity.get();
            }
        }
        if (product == null) {
            product = new Product();
        }

        if (productForm.getImageUpload() != null && StringUtils.hasText(productForm.getImageUpload().getOriginalFilename())) {
            product.setPictureLink(ImageUtils.upload(productForm.getImageUpload()));
        }
        MapperUtils.map(productForm, product);
        productRepository.save(product);
        productForm.setId(product.getId());
        productForm.setPictureLink(product.getPictureLink());
    }

    public List<ProductModel> getProductList() {
        List<ProductModel> listProductModel = new ArrayList<>();
        List<Product> listProduct = productRepository.findAll();
        for (Product product : listProduct) {
            ProductModel model = new ProductModel();
            MapperUtils.map(product, model);
            listProductModel.add(model);
        }
        return listProductModel;
    }

    public ProductModel getProduct(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            ProductModel model = new ProductModel();
            MapperUtils.map(product.get(), model);
            return model;
        }
        return new ProductModel();
    }

    public void deleteProduct(ProductModel productForm) {
        productRepository.deleteById(productForm.getId());
    }

    public ProductModel getProductById(ProductModel productForm) {
        Product product = new Product();
        if (productForm.getId() != null) {
            Optional<Product> productEntity = productRepository.findById(productForm.getId());
            if (productEntity.isPresent()) {
                product = productEntity.get();
            }
        }
        MapperUtils.map(product, productForm);
        return productForm;
    }

	public long countProduct() {
		return productRepository.count();
	}
	
	public List<ProductModel> getProductByCategory(String id) {
		List<ProductModel> listProductModel = new ArrayList<>();
        List<Product> listProduct = productRepository.findByCategory(id);
        for (Product product : listProduct) {
            ProductModel model = new ProductModel();
            MapperUtils.map(product, model);
            listProductModel.add(model);
        }
        return listProductModel;
	}
	
//	public List<ProductModel> getProductByBrand(String id) {
//		List<ProductModel> listProductModel = new ArrayList<>();
//        List<Product> listProduct = productRepository.findByBrand(id);
//        for (Product product : listProduct) {
//            ProductModel model = new ProductModel();
//            MapperUtils.map(product, model);
//            listProductModel.add(model);
//        }
//        return listProductModel;
//	}
}
