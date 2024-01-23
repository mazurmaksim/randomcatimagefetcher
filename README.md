# Fetching Image from URL

This code contains a method to fetch an image from a specified URL and return it as a byte array. The code utilizes the Apache HttpClient library to perform an HTTP GET request and handle the response.

## Usage

To use this method, integrate it into your project and call it, passing the image URL as a parameter. The method will return a byte array representing the retrieved image.

```java
public byte[] getPicture(String url) {
    // Method code here
}
```
## Dependencies

The code relies on the Apache HttpClient library, so make sure you have the correct dependencies in your project.

```xml
 <dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>3.8.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.apache.httpcomponents.client5</groupId>
        <artifactId>httpclient5</artifactId>
        <version>5.2.1</version>
    </dependency>
    <dependency>
        <groupId>org.assertj</groupId>
        <artifactId>assertj-core</artifactId>
        <version>3.25.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>

```

# Testing `getPicture` Method

This test ensures that the `getPicture` method in the `RequestPicture` class functions as expected. The method is designed to fetch an image from a random URL (in this case, a random cat image) and return it as a byte array.

## Test Scenario

1. **Arrange:** Create an instance of the `RequestPicture` class.
2. **Act:** Call the `getPicture` method to fetch a random cat image.
3. **Assert:**
    - Ensure that the result (byte array) is not empty.
    - Save the fetched image to a temporary file ("cat.jpg" in the "C:\cats" directory) to visually inspect the retrieved image.

```java
@Test
void getPicture() throws IOException {
    // Arrange
    RequestPicture requestPicture = new RequestPicture();

    // Act
    byte[] result = requestPicture.getPicture(requestPicture.getRandomCat());

    // Create a temporary file to save the fetched image
    File tempFile = File.createTempFile("cat", ".jpg", new File("C:\\cats"));

    try (FileOutputStream fos = new FileOutputStream(tempFile)) {
        // Write the fetched image data to the temporary file
        fos.write(result);
    }

    // Assert
    // Ensure that the result (byte array) is not empty
    Assert.assertTrue(result.length > 0);
}