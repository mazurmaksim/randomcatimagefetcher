package httprequest;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class RequestPicture {

    public String getRandomCat() {
        return "https://cataas.com/cat";
    }

    public byte[] getPicture(String url) {
        try (final CloseableHttpClient httpclient = HttpClients.custom().build()) {
            final HttpGet httpget = new HttpGet(url);
            HttpClientResponseHandler<byte[]> responseHandler = response -> {
                try (final CloseableHttpResponse closeableHttpResponse = (CloseableHttpResponse)response) {
                        return EntityUtils.toByteArray(closeableHttpResponse.getEntity());
                }
            };
            return httpclient.execute(httpget, responseHandler);
        } catch (IOException ignore) {
        }
        return new byte[]{};
    }
}
