package SOAPService;

import ejb.dto.Dish;
import ejb.implementation.CategoryManagerBean;
import ejb.implementation.DishManagerBean;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "SOAPService.DishSOAPInterface")
public class DishSOAP implements DishSOAPInterface {

    @Override
    @WebMethod
    public void addDish(String name,  int price, int weight, String categoryName) {
        Dish dish = new Dish();
        dish.setName(name);
        dish.setPrice(price);
        dish.setWeight(weight);
        dish.setCategory(new CategoryManagerBean().getCategory(categoryName));
        new DishManagerBean().addDish(dish);
    }


}
