package endpoint;


import ejb.dto.Category;
import ejb.dto.Dish;
import ejb.implementation.CategoryManagerBean;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("categories")
public class CategoryController {

    CategoryManagerBean categoryManagerBean = new CategoryManagerBean();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories(@Context HttpHeaders httpHeaders){
        if(httpHeaders.getLanguage().toString().equals("de")){
            List<Category> categories = categoryManagerBean.getCategories();
            for(Category cat: categories){
                cat.setName(cat.getName() + "de");
                List<Dish> dishes = cat.getDishes();
                for(Dish dish: dishes) {
                    dish.setName(dish.getName() + "de");
                }
                cat.setDishes(dishes);
            }
            return categories;
        }
        return categoryManagerBean.getCategories();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}")
    public Category getCategoryByName(@PathParam("name") String name, @Context HttpHeaders httpHeaders) {
        System.out.println(httpHeaders.getLanguage().toString());
        if(httpHeaders.getLanguage().toString().equals("de")){
            Category category = categoryManagerBean.getCategory(name);
            category.setName(category.getName() + "de");
            List<Dish> dishes = category.getDishes();
            for(Dish dish: dishes) dish.setName(dish.getName() + "de");
            category.setDishes(dishes);
            return category;
        }

        return categoryManagerBean.getCategory(name);

    }

}
