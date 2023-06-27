package RestAssuredPojo;

import RestAssuredPojo.baseUrl.BaseUrlPokeAPI;
import RestAssuredPojo.pojos.PokeAPI_ItemPojo;
import RestAssuredPojo.pojos.PokeAPI_NaturalGiftTypePojo;
import RestAssuredPojo.pojos.PokeAPI_RootPojo;
import org.junit.Test;

public class GetRequestPokeAPIWithPojoTest extends BaseUrlPokeAPI {
    @Test
    public void getRequestPojo() {
        spec.pathParams("pp1", "berry", "pp2", 4);

        PokeAPI_NaturalGiftTypePojo naturalGiftTypePojo = new PokeAPI_NaturalGiftTypePojo("grass", "https://pokeapi.co/api/v2/type/12/");
        PokeAPI_ItemPojo itemPojo = new PokeAPI_ItemPojo("rawst-berry", "https://pokeapi.co/api/v2/item/129/");

    }
}
