package RestAssuredPojo;

import RestAssuredPojo.baseUrl.BaseUrl;
import RestAssuredPojo.pojos.BookingDatesPojo;
import RestAssuredPojo.pojos.BookingPojo;
import RestAssuredPojo.pojos.RootPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PutRequestWithPojoTest extends BaseUrl {

    @Test
    public void putRequestPojo() {
        spec.pathParams("pp1", "booking", "pp2", 10);
        BookingDatesPojo bookingdates = new BookingDatesPojo("2023-01-01", "2023-01-10");
        BookingPojo putRequest = new BookingPojo("Mehmet Ali", "Eşgi", 1000, false, bookingdates, "B2B");

        BookingDatesPojo bookingDatesExpected = new BookingDatesPojo("2023-01-01", "2023-01-10");
        BookingPojo expectedData = new BookingPojo("Mehmet Ali", "Eşgi", 1000, false, bookingDatesExpected, "B2B");


        Response response = given(spec).auth()
                .preemptive()
                .basic("admin", "password123")
                .contentType(ContentType.JSON)
                .when()
                .body(putRequest)
                .put("{pp1}/{pp2}");
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
