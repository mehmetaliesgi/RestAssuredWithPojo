package RestAssuredPojo;

import RestAssuredPojo.baseUrl.BaseUrlPokeAPI;
import RestAssuredPojo.pojos.*;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequestPokeAPIWithPojoTest extends BaseUrlPokeAPI {
    @Test
    public void getRequestPojo() {
        spec.pathParams("pp1", "berry", "pp2", 4);

        PokeAPI_NaturalGiftTypePojo naturalGiftTypePojo = new PokeAPI_NaturalGiftTypePojo("grass", "https://pokeapi.co/api/v2/type/12/");
        PokeAPI_ItemPojo itemPojo = new PokeAPI_ItemPojo("rawst-berry", "https://pokeapi.co/api/v2/item/129/");

        PokeAPI_Flavor2Pojo flavor2Item1 = new PokeAPI_Flavor2Pojo("spicy", "https://pokeapi.co/api/v2/berry-flavor/1/");
        PokeAPI_Flavor2Pojo flavor2Item2 = new PokeAPI_Flavor2Pojo("dry", "https://pokeapi.co/api/v2/berry-flavor/2/");
        PokeAPI_Flavor2Pojo flavor2Item3 = new PokeAPI_Flavor2Pojo("sweet", "https://pokeapi.co/api/v2/berry-flavor/3/");
        PokeAPI_Flavor2Pojo flavor2Item4 = new PokeAPI_Flavor2Pojo("bitter", "https://pokeapi.co/api/v2/berry-flavor/4/");
        PokeAPI_Flavor2Pojo flavor2Item5 = new PokeAPI_Flavor2Pojo("sour", "https://pokeapi.co/api/v2/berry-flavor/5/");
        PokeAPI_FlavorPojo flavorPojo1 = new PokeAPI_FlavorPojo(flavor2Item1,0);
        PokeAPI_FlavorPojo flavorPojo2 = new PokeAPI_FlavorPojo(flavor2Item2,0);
        PokeAPI_FlavorPojo flavorPojo3 = new PokeAPI_FlavorPojo(flavor2Item3,0);
        PokeAPI_FlavorPojo flavorPojo4 = new PokeAPI_FlavorPojo(flavor2Item4,0);
        PokeAPI_FlavorPojo flavorPojo5 = new PokeAPI_FlavorPojo(flavor2Item5,0);
        ArrayList<PokeAPI_FlavorPojo> flavorPojoList = new ArrayList<>();
        flavorPojoList.add(flavorPojo1);
        flavorPojoList.add(flavorPojo2);
        flavorPojoList.add(flavorPojo3);
        flavorPojoList.add(flavorPojo4);
        flavorPojoList.add(flavorPojo5);

        PokeAPI_FirmnessPojo firmnessPojo = new PokeAPI_FirmnessPojo("hard", "https://pokeapi.co/api/v2/berry-firmness/3/");
        PokeAPI_RootPojo expectedData = new PokeAPI_RootPojo(firmnessPojo, flavorPojoList, 3, 4, itemPojo, 5, "rawst", 60, naturalGiftTypePojo, 32, 25, 15);

        Response response = given(spec)
                .when()
                .get("{pp1}/{pp2}");
        PokeAPI_RootPojo responsePojo = response.as(PokeAPI_RootPojo.class);

        assertEquals(expectedData.getFirmness().getName(), responsePojo.getFirmness().getName());
        assertEquals(expectedData.getFirmness().getUrl(), responsePojo.getFirmness().getUrl());
        assertEquals(expectedData.getFlavors().size(), responsePojo.getFlavors().size());
        assertEquals(expectedData.getGrowth_time(), responsePojo.getGrowth_time());
        assertEquals(expectedData.getId(), responsePojo.getId());
        assertEquals(expectedData.getItem().getName(), responsePojo.getItem().getName());
        assertEquals(expectedData.getItem().getUrl(), responsePojo.getItem().getUrl());
        assertEquals(expectedData.getMax_harvest(), responsePojo.getMax_harvest());
        assertEquals(expectedData.getName(), responsePojo.getName());
        assertEquals(expectedData.getNatural_gift_power(), responsePojo.getNatural_gift_power());
        assertEquals(expectedData.getNatural_gift_type().getName(), responsePojo.getNatural_gift_type().getName());
        assertEquals(expectedData.getNatural_gift_type().getUrl(), responsePojo.getNatural_gift_type().getUrl());
        assertEquals(expectedData.getSize(), responsePojo.getSize());
        assertEquals(expectedData.getSmoothness(), responsePojo.getSmoothness());
        assertEquals(expectedData.getSoil_dryness(), responsePojo.getSoil_dryness());
    }
}
