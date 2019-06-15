package SOAPService;

import java.net.URL;
import java.util.Random;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class DishSOAPClient{

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9999/dishService?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://SOAPService/","DishSOAPImplService");

        Random generator = new Random();
        String name = "dishname" + generator.nextInt(999999);
        int weight = generator.nextInt(20);
        int price = generator.nextInt(50);
        String category = "test";

        Service service = Service.create(url, qname);
        DishSOAP dishSOAP = service.getPort(DishSOAP.class);
        dishSOAP.addDish(name,price,weight,category);

    }

}