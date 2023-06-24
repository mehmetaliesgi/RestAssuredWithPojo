package RestAssuredPojo;

import RestAssuredPojo.baseUrl.BaseUrl;
import RestAssuredPojo.pojos.BookingDatesPojo;
import RestAssuredPojo.pojos.BookingPojo;
import RestAssuredPojo.pojos.RootPojo;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojoTests extends BaseUrl {
    @Test
    public void PostRequestPojo() {

        // 1 - Set endpoint and if you need request body, create request body
        spec.pathParam("pp1", "booking");
        BookingDatesPojo bookingdates = new BookingDatesPojo("2023-01-01", "2023-01-05");
        BookingPojo requestBody = new BookingPojo("Mehmet Ali", "EŞGİ", 245, false, bookingdates, "Wi-Fi");

        // 2 - If they want to you expected data, create expected data
        RootPojo expectedData = new RootPojo(1, requestBody);

        // 3- Do a request, save response and modify the response
        Response response = given(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .post("{pp1}");
        RootPojo responsePojo = response.as(RootPojo.class);

        // 4- Doing assertions
        Assert.assertEquals(expectedData.getBooking().getFirstname(), responsePojo.getBooking().getFirstname());
    }
}
