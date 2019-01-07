package cucumber.StepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BeastsStepDefs {
    HttpResponse response;

    @When("^le client appel (/beasts)$")
    public void le_client_appel_GET(String url) throws Throwable {
       // CloseableHttpClient httpClient = HttpClients.createDefault();
       // HttpGet request = new HttpGet("http://localhost:8080"+ url);
       // response = httpClient.execute(request);
    }

    @Then("^le client reçoit le code HTTP (\\d+)$")
    public void le_client_recoit_le_code_HTTP(int codeHttp) throws IOException {
        // Assertions.assertThat(response.getStatusLine().getStatusCode()).isEqualTo(codeHttp);
    }

    @And("^reçoit un certain nombre d'animaux$")
    public void recoit_un_certain_nombre_d_animaux() throws IOException {
       // Assertions.assertThat(con.getResponseMessage()).isNotNull();
    }
}