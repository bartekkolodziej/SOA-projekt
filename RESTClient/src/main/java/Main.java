import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.apache.http.HttpException;


public class Main {

    public static void main(String[] args) throws IOException, HttpException, URISyntaxException {
        RestClient restClient = new RestClient();

        while (true) {
            System.out.println("For all categories X");
            System.out.println("For specific category type name");
            System.out.print(">>>> ");
            Scanner scan = new Scanner(System.in);
            String value = scan.nextLine();
            if (value.equals("X")) {
                restClient.getAllCategories();
            } else if (value != null) {
                restClient.getCategoryByName(value);
            }
        }

    }


}