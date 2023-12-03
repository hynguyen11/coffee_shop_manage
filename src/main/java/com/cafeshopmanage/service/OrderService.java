package com.cafeshopmanage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;

import com.cafeshopmanage.entity.Order;
import com.cafeshopmanage.model.OrderModel;
import com.cafeshopmanage.repository.OrderRepository;
import com.cafeshopmanage.utils.MapperUtils;
//import com.clothesselling.utils.ImageUtils;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void createUpdateOrder(OrderModel orderForm) {
    	Order order = null;
        if (orderForm.getId() != null) {
            Optional<Order> orderEntity = orderRepository.findById(orderForm.getId());
            if (orderEntity.isPresent()) {
            	order = orderEntity.get();
            }
        }
        if (order == null) {
        	order = new Order();
        }

//        if (productForm.getImageUpload() != null && StringUtils.hasText(productForm.getImageUpload().getOriginalFilename())) {
//            product.setPictureLink(ImageUtils.upload(productForm.getImageUpload()));
//        }
        MapperUtils.map(orderForm, order);
        orderRepository.save(order);
        orderForm.setId(order.getId());
//        productForm.setPictureLink(product.getPictureLink());
    }

    public List<OrderModel> getOrderList() {
        List<OrderModel> listOrderModel = new ArrayList<>();
        List<Order> listOrder = orderRepository.findAll();
        for (Order order : listOrder) {
        	OrderModel model = new OrderModel();
            MapperUtils.map(order, model);
            listOrderModel.add(model);
        }
        return listOrderModel;
    }

    public OrderModel getOrder(Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
        	OrderModel model = new OrderModel();
            MapperUtils.map(order.get(), model);
            return model;
        }
        return new OrderModel();
    }

    public void deleteOrder(OrderModel orderForm) {
    	orderRepository.deleteById(orderForm.getId());
    }

    public OrderModel getOrderById(OrderModel orderForm) {
    	Order order = new Order();
        if (orderForm.getId() != null) {
            Optional<Order> orderEntity = orderRepository.findById(orderForm.getId());
            if (orderEntity.isPresent()) {
            	order = orderEntity.get();
            }
        }
        MapperUtils.map(order, orderForm);
        return orderForm;
    }

	public long countOrder() {
		return orderRepository.count();
	}
	
//	public List<OrderModel> getOrderByCategory(String id) {
//		List<OrderModel> listOrderModel = new ArrayList<>();
//        List<Order> listOrder = orderRepository.findByCategory(id);
//        for (Order order : listOrder) {
//        	OrderModel model = new OrderModel();
//            MapperUtils.map(order, model);
//            listOrderModel.add(model);
//        }
//        return listOrderModel;
//	}
	
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
