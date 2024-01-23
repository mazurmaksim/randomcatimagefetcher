package httprequest;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class RequestPictureTest {
    RequestPicture requestPicture = new RequestPicture();

    @Test
    void getPicture() throws IOException {
            byte[] result = requestPicture.getPicture(requestPicture.getRandomCat());
            File tempFile = File.createTempFile("cat", ".jpg", new File("C:\\cats"));
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(result);
            }
            Assert.assertTrue(result.length > 0);
    }
}