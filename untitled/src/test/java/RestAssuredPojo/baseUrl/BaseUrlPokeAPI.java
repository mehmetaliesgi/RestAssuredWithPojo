package RestAssuredPojo.baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlPokeAPI {
    protected RequestSpecification spec;
    @Before
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://pokeapi.co/api/v2")
                .build();
    }
}
