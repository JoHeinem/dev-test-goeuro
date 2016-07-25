package de.johannes.heinemann.devtest;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by johannes on 19/07/16.
 */
public class APIQuery {

    /**
     *
     * @param urlString
     * @return
     * @throws Exception
     */
    public static String readUrl(String urlString)  {
        URI url = null;
        String responseString = "";
        try {
            url = new URI(urlString);
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpResponse response = httpClient.execute(new HttpGet(url));
            HttpEntity entity = response.getEntity();
            Header encoding = entity.getContentEncoding();
            String encodingName = encoding == null ? "UTF-8" : encoding.getName();
            responseString = EntityUtils.toString(entity, encodingName);
        } catch (URISyntaxException e) {
            System.out.println("String could not be parsed as a URI reference!");
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            System.out.println("Error in the HTTP protocol! Please check your internet connection!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Was not able to encode http response! Please check if the API changed!");
            e.printStackTrace();
        }
        return responseString;
    }
}
