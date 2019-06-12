package controllers;

import dao.BillDAO;
import dao.UserDAO;
import ejb.dto.Bill;
import ejb.dto.Dish;
import ejb.dto.Order;
import ejb.dto.User;
import ejb.implementation.BillManagerBean;
import ejb.implementation.OrderManagerBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SessionScoped
@ManagedBean(name = "BillController")
public class BillController implements Serializable {

    private BillManagerBean billManagerBean = new BillManagerBean();

    private OrderManagerBean orderManagerBean = new OrderManagerBean();



}
