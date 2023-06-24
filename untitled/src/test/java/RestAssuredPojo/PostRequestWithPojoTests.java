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
import static org.junit.Assert.assertEquals;

public class PostRequestWithPojoTests extends BaseUrl {
    int bookingid;
    @Test
    public void PostRequestPojo() {

        // 1 - Set endpoint and if you need request body, create request body
        spec.pathParam("pp1", "booking");
        BookingDatesPojo bookingdates = new BookingDatesPojo("2023-01-01", "2023-01-05");
        BookingPojo requestBody = new BookingPojo("Mehmet Ali", "EŞGİ", 245, false, bookingdates, "Wi-Fi");

        // 2- Do a request, save response and modify the response
        Response response = given(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .post("{pp1}");
        RootPojo responsePojo = response.as(RootPojo.class);
        bookingid = responsePojo.getBookingid();

        // 3 - If they want to you expected data, create expected data
        RootPojo expectedData = new RootPojo(bookingid, requestBody);

        // 4- Doing assertions
        assertEquals(expectedData.getBookingid(), responsePojo.getBookingid());
        assertEquals(expectedData.getBooking().getFirstname(), responsePojo.getBooking().getFirstname());
        assertEquals(expectedData.getBooking().getLastname(), responsePojo.getBooking().getLastname());
        assertEquals(expectedData.getBooking().getTotalprice(), responsePojo.getBooking().getTotalprice());
        assertEquals(expectedData.getBooking().isDepositpaid(), responsePojo.getBooking().isDepositpaid());
        assertEquals(expectedData.getBooking().getBookingdates().getCheckin(), responsePojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedData.getBooking().getBookingdates().getCheckout(), responsePojo.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedData.getBooking().getAdditionalneeds(), responsePojo.getBooking().getAdditionalneeds());
    }
}
