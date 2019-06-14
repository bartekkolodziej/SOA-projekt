package endpoint;


import ejb.dto.Category;
import ejb.implementation.CategoryManagerBean;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("categories")
public class CategoryController {

    CategoryManagerBean categoryManagerBean = new CategoryManagerBean();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories(){

        return categoryManagerBean.getCategories();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}")
    public Category getCategoryByName(@PathParam("name") String name) {

        return categoryManagerBean.getCategory(name);

    }

}
