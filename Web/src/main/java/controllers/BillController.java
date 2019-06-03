package controllers;

import dao.UserDAO;
import ejb.implementation.BillManagerBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@SessionScoped
@ManagedBean(name = "BillController")
public class BillController implements Serializable {

    private BillManagerBean billManagerBean = new BillManagerBean();

    private int finalValue;

    public int getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(int finalValue) {
        this.finalValue = finalValue;
    }

    public void addBill(){
        this.billManagerBean.addBill(this.finalValue, UserDAO.getInstance().getItems().get(0));
    }
}
