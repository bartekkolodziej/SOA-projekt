import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.apache.http.HttpException;


public class Main {

    public static void main(String[] args) throws IOException, HttpException, URISyntaxException {
        RestClient restClient = new RestClient();

        while (true) {
            System.out.println("Choose category'");
            System.out.println("For all categories type 'all'");
            System.out.println("For specific category type categoryname");
            System.out.print(">>>>: ");
            Scanner scan = new Scanner(System.in);
            String value = scan.nextLine();
            System.out.println("Choose version, def or de");
            System.out.print(">>>>: ");
            String version = scan.nextLine();
            if(!version.equals("de")) version = "def";
            System.out.println(version);
            if (value.equals("all")) {
                restClient.getAllCategories(version);
            } else if (value != null) {
                restClient.getCategoryByName(value,version);
            }
        }

    }


}