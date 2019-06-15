import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public class RestClient {

    public void getAllCategories(String version) throws IOException, HttpException, URISyntaxException {
        String url = "http://localhost:8080/rest/categories/";
        String json = getResponse(url,version);
        if (json != null) {
            System.out.println(json);
        }
    }

    public void getCategoryByName(String name, String version) throws IOException, HttpException, URISyntaxException {
        String url = "http://localhost:8080/rest/categories/" + name;
        String json = getResponse(url,version);
        if (json != null) {
            System.out.println(json);
        }
    }

    public String getResponse(String url,String version) throws IOException, HttpException, URISyntaxException{
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        request.setHeader("Content-Language",version);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String json = "";
        if ((json = rd.readLine()) != null) {
            return json;
        }
        return "";
    }

}
