package RestAssuredPojo;

import RestAssuredPojo.baseUrl.BaseUrl;
import RestAssuredPojo.pojos.BookingDatesPojo;
import RestAssuredPojo.pojos.BookingPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequestWithPojoTest extends BaseUrl {

    @Test
    public void getRequestPojo() {
        spec.pathParams("pp1", "booking", "pp2", 10);

        BookingDatesPojo bookingDatesExpected = new BookingDatesPojo("2023-01-01", "2023-01-10");
        BookingPojo expectedData = new BookingPojo("Mehmet Ali", "Eşgi", 1000, false, bookingDatesExpected, "B2B");

        Response response = given(spec)
                .when()
                .get("{pp1}/{pp2}");
        BookingPojo responsePojo = response.as(BookingPojo.class);

        assertEquals(expectedData.getFirstname(), responsePojo.getFirstname());
        assertEquals(expectedData.getLastname(), responsePojo.getLastname());
        assertEquals(expectedData.getTotalprice(), responsePojo.getTotalprice());
        assertEquals(expectedData.isDepositpaid(), responsePojo.isDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(), responsePojo.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(), responsePojo.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), responsePojo.getAdditionalneeds());

    }
}
