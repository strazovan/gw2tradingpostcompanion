package utilities;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by David Stražovan on 20.04.2016.
 * Class that provides methods to get data from api.
 */
public class JSONDataDownloader {
    /**
     * Data downloaded from API server
     *
     * @return string representing data
     */
    public String getDownloadedData() {
        return downloadedData;
    }


    private String downloadedData;
    private String APIKey;

    private URL request;

    public JSONDataDownloader(String apiKey) {
        APIKey = apiKey;

    }


    public String getData(RequestType type, String param) {


        StringBuilder sb = new StringBuilder();
        try {
            if (type.isKeyRequired())
                request = new URL(type.toString() + APIKey);
            else
                request = new URL(type.toString() + param);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //System.out.println(request.toString() );
        try (InputStream io = request.openStream()) {
            int data;
            while ((data = io.read()) != -1) {
                sb.append((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();

    }


}
