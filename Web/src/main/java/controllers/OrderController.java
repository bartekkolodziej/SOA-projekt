package controllers;


import dao.CategoryDAO;
import ejb.dto.Category;
import ejb.dto.Dish;
import ejb.dto.OrderedDish;
import ejb.dto.User;
import ejb.implementation.OrderManagerBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SessionScoped
@ManagedBean(name = "OrderController")
public class OrderController {

    OrderManagerBean orderManagerBean = new OrderManagerBean();

    private List<OrderedDish> orderedDishes = new ArrayList<>();

    private User customer;

    private Date orderDate;

    private Date finalisationDate;

    private String status;

    private Double price;

    private Category selectedCategory;

    public List<OrderedDish> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(List<OrderedDish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getFinalisationDate() {
        return finalisationDate;
    }

    public void setFinalisationDate(Date finalisationDate) {
        this.finalisationDate = finalisationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public Category getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(Category selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public void addOrder(){
        //TODO - finish adding order
        status = "ordered";
        price = 5.00;
        orderDate = new Date();
        this.orderManagerBean.addOrder(orderedDishes,customer,orderDate,finalisationDate,status, price);
    }

    public List<Category> getCategories(){
        return CategoryDAO.getInstance().getItems();
    }

    public List<Dish> getDishes(){
        return selectedCategory.getDishes();
    }

    public void addDish(Dish dish){
        //TODO - code adding dish to list of ordered dishes
    }
}
