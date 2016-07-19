
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
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
public class GoEuroTest {

    public static void main(String[] args) throws URISyntaxException, IOException {
        String url = "http://api.goeuro.com/api/v2/position/suggest/en/Berlin";
        String responseString = readUrl(url);
        System.out.println(responseString);
    }

    /**
     *
     * @param urlString
     * @return
     * @throws Exception
     */
    private static String readUrl(String urlString) throws URISyntaxException, IOException {
        URI url = new URI(urlString);
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(new HttpGet(url));
        HttpEntity entity = response.getEntity();
        Header encoding = entity.getContentEncoding();
        String encodingName = encoding == null ? "UTF-8" : encoding.getName();
        String responseString = EntityUtils.toString(entity, encodingName);
        return responseString;
    }
}
