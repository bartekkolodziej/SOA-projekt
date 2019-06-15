package SOAPService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface DishSOAPInterface {

    @WebMethod
    public void addDish(String name,  int price, int weight, String categoryName);
}