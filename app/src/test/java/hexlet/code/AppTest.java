package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import hexlet.code.model.Url;
import hexlet.code.repository.UrlChecksRepository;
import hexlet.code.repository.UrlsRepository;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;

public class AppTest {
    private static final String FIXTURE_NAME_FOR_RESPONSE_BODY = "index.html";
    Javalin app;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeEach
    public final void setUp() throws IOException, SQLException {
        app = App.getApp();
    }

    @Test
    public void testAddUrlCheck() throws Exception {
        try (MockWebServer mockServer = new MockWebServer()) {
            String baseUrl = mockServer.url("/").toString();
            MockResponse mockResponse = new MockResponse().setBody(readFixture(FIXTURE_NAME_FOR_RESPONSE_BODY));
            mockServer.enqueue(mockResponse);

            var actualUrl = new Url(baseUrl);
            UrlsRepository.save(actualUrl);

            JavalinTest.test(app, ((server, client) -> {
                var response = client.post("/urls/" + actualUrl.getId() + "/checks");

                var actualCheckUrl = UrlChecksRepository.findLatestChecks().get(actualUrl.getId());

                assertThat(actualCheckUrl).isNotNull();
                assertThat(actualCheckUrl.getStatusCode()).isEqualTo(200);
                assertThat(actualCheckUrl.getTitle()).isEqualTo("Example Title");
                assertThat(actualCheckUrl.getH1()).isEqualTo("Example Page");
                assertThat(actualCheckUrl.getDescription()).isEqualTo("test page for education project");

                assertThat(response.code()).isEqualTo(200);
                assertThat(response.body()).isNotNull();
                assertThat(response.body().string()).contains("Example Title");
            }));
        }
    }

    @Test
    public void testRootPage() {
        JavalinTest.test(app, ((server, client) -> {
            var response = client.get("/");
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body()).isNotNull();
            assertThat(response.body().string()).contains("Бесплатно проверяйте сайты на SEO пригодность");
        }));
    }

    @Test
    public void testUrlsPage() {
        JavalinTest.test(app, ((server, client) -> {
            var response = client.get("/urls");
            assertThat(response.code()).isEqualTo(200);
        }));
    }

    @Test
    public void testCreateValidUrlWithoutPortWithoutPath() {
        JavalinTest.test(app, ((server, client) -> {
            var requestBody = "url=https://www.examplename.com";
            var response = client.post("/urls", requestBody);

            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body()).isNotNull();
            assertThat(response.body().string()).contains("https://www.examplename.com");
        }));
    }

    @Test
    public void testCreateValidUrlWithPortWithPath() {
        JavalinTest.test(app, ((server, client) -> {
            var requestBody = "url=https://some-domain.org:8080/example/path";
            var response = client.post("/urls", requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body()).isNotNull();
            assertThat(response.body().string()).contains("https://some-domain.org:8080");
        }));
    }

    @Test
    public void testInvalidUrl() {
        JavalinTest.test(app, ((server, client) -> {
            var requestBody = "url=invalid-url";
            var response = client.post("/urls", requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body()).isNotNull();
            assertThat(response.body().string()).contains("Бесплатно проверяйте сайты на SEO пригодность");
        }));
    }

    @Test
    public void testUrlPage() throws SQLException {
        var url = new Url("https://www.hexlet.com");
        UrlsRepository.save(url);
        JavalinTest.test(app, ((server, client) -> {
            var response = client.get("/urls/" + url.getId());
            assertThat(response.code()).isEqualTo(200);
        }));
    }

    @Test
    public void testUrlNotFound() throws SQLException {
        Long id = 123456L;
        UrlsRepository.delete(id);
        JavalinTest.test(app, ((server, client) -> {
            var response = client.get("/urls/" + id);
            assertThat(response.code()).isEqualTo(404);
        }));
    }

}