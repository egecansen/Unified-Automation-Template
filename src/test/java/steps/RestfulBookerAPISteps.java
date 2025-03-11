package steps;

import context.ContextStore;
import io.cucumber.datatable.DataTable;
import models.BookingRequestModel;
import models.BookingUpdateResponseModel;
import org.junit.Assert;
import restfulbooker.RestfulBooker;
import io.cucumber.java.en.Given;
import utils.Printer;
import utils.StringUtilities;
import utils.reflection.ReflectionUtilities;

import java.util.Map;

import static utils.StringUtilities.contextCheck;

public class RestfulBookerAPISteps {

    Printer log = new Printer(RestfulBooker.class);
    RestfulBooker restfulBooker = new RestfulBooker();

    @Given("Ping the restful booker api server")
    public void ping() {
        restfulBooker.ping();
        log.success("Pinged!");
    }

    @Given("Get booking ids with parameter:")
    public void getBookingIds(DataTable table) {
        Map<String, String> tableMap = table.asMap();
        String firstName = tableMap.get("firstName");
        String lastName = tableMap.get("lastName");
        String checkInDate = tableMap.get("checkInDate");
        String checkOutDate = tableMap.get("checkOutDate");
        restfulBooker.getBookingIds(firstName, lastName, checkInDate, checkOutDate);
        log.success("Booking id's acquired!");
    }

    @Given("Get booking with id {}")
    public void getBooking(String bookingId) {
        bookingId = contextCheck(bookingId);
        BookingRequestModel booking = restfulBooker.getBooking(bookingId);
        ContextStore.put("getBookingResponse", booking);
        log.success("Booking acquired!");
    }

    @Given("Create booking with parameter:")
    public void createBooking(DataTable table) {
        Map<String, String> tableMap = table.asMap();
        String firstName = tableMap.get("firstName");
        String lastName = tableMap.get("lastName");
        String depositPaid = tableMap.get("depositPaid");
        String totalPrice = tableMap.get("totalPrice");
        String additionalNeeds = tableMap.get("additionalNeeds");
        String checkInDate = tableMap.get("checkInDate");
        String checkOutDate = tableMap.get("checkOutDate");

        BookingRequestModel.BookingDates bookingDates = new BookingRequestModel.BookingDates(
                checkInDate,
                checkOutDate
        );
        BookingRequestModel bookingRequestModel = new BookingRequestModel(
                firstName,
                lastName,
                Integer.parseInt(totalPrice),
                Boolean.parseBoolean(depositPaid),
                bookingDates,
                additionalNeeds
        );
        BookingUpdateResponseModel bookingResponse = restfulBooker.createBooking(bookingRequestModel);
        ContextStore.put("bookingId", bookingResponse.getBookingid().toString());
        log.success("Booking created!");
    }

    @Given("Create random booking")
    public void createRandomBooking() {
        String randomFirstName = StringUtilities.generateRandomString("Tester", 5, true, false);
        String randomLastName = StringUtilities.generateRandomString("Testing", 5, true, false);
        String randomPrice = StringUtilities.generateRandomString("", 3, false, true);
        String randomNeeds = StringUtilities.generateRandomString("Expression", 3, true, true);

        BookingRequestModel.BookingDates bookingDates = new BookingRequestModel.BookingDates(
                StringUtilities.generateRandomString("", 4, false, true) + "-" +
                        "01"
                        + "-" +
                        "01",
                StringUtilities.generateRandomString("", 4, false, true) + "-" +
                        "01"
                        + "-" +
                        "01"
        );
        BookingRequestModel bookingRequestModel = new BookingRequestModel(
                randomFirstName,
                randomLastName,
                Integer.parseInt(randomPrice),
                true,
                bookingDates,
                randomNeeds
        );
        BookingUpdateResponseModel bookingResponse = restfulBooker.createBooking(bookingRequestModel);
        ContextStore.put("bookingId", bookingResponse.getBookingid().toString());
        log.success("Booking created!");
    }

    @Given("Update the entire reservation of booking id {} with parameter:")
    public void updateBooking(String bookingId, DataTable table) {
        Map<String, String> tableMap = table.asMap();
        bookingId = contextCheck(bookingId);
        String firstName = tableMap.get("firstName");
        String lastName = tableMap.get("lastName");
        String depositPaid = tableMap.get("depositPaid");
        String totalPrice = tableMap.get("totalPrice");
        String additionalNeeds = tableMap.get("additionalNeeds");
        String checkInDate = tableMap.get("checkInDate");
        String checkOutDate = tableMap.get("checkOutDate");

        BookingRequestModel.BookingDates bookingDates = new BookingRequestModel.BookingDates(
                checkInDate,
                checkOutDate
        );
        BookingRequestModel bookingRequestModel = new BookingRequestModel(
                firstName,
                lastName,
                Integer.parseInt(totalPrice),
                Boolean.parseBoolean(depositPaid),
                bookingDates,
                additionalNeeds
        );

        RestfulBooker.Authorised.updateBooking(bookingId, bookingRequestModel);
        log.success("Booking updated!");
    }

    @Given("Update fields of booking id {} with parameter:")
    public void patchBooking(String bookingId, DataTable table) {
        Map<String, String> tableMap = table.asMap();
        bookingId = contextCheck(bookingId);
        String firstName = tableMap.get("firstName");
        String lastName = tableMap.get("lastName");
        String depositPaid = tableMap.get("depositPaid");
        boolean depositPaidValue = Boolean.parseBoolean(depositPaid);
        String totalPrice = tableMap.get("totalPrice");
        int totalPriceValue = totalPrice == null ? 0 : Integer.parseInt(totalPrice);
        String additionalNeeds = tableMap.get("additionalNeeds");
        String checkInDate = tableMap.get("checkInDate");
        String checkOutDate = tableMap.get("checkOutDate");

        BookingRequestModel.BookingDates bookingDates = new BookingRequestModel.BookingDates(
                checkInDate,
                checkOutDate
        );
        BookingRequestModel bookingRequestModel = new BookingRequestModel(
                firstName,
                lastName,
                totalPriceValue,
                depositPaidValue,
                bookingDates,
                additionalNeeds
        );
        RestfulBooker.Authorised.patchBooking(bookingId, bookingRequestModel);
        log.success("Booking updated!");
    }

    @Given("Delete booking with id {}")
    public void deleteBooking(String bookingId) {
        bookingId = contextCheck(bookingId);
        RestfulBooker.Authorised.deleteBooking(bookingId);
        log.success("Booking deleted!");
    }

    @Given("Verify the booking info with parameters:")
    public void verifyBooking(DataTable table) {
        Map<String, String> tableMap = table.asMap();

        BookingRequestModel actualBooking = ContextStore.get("getBookingResponse");

        String firstName = tableMap.get("firstName");
        String lastName = tableMap.get("lastName");
        String depositPaid = tableMap.get("depositPaid");
        String totalPrice = tableMap.get("totalPrice");
        String additionalNeeds = tableMap.get("additionalNeeds");
        String checkInDate = tableMap.get("checkInDate");
        String checkOutDate = tableMap.get("checkOutDate");

        BookingRequestModel.BookingDates bookingDates = new BookingRequestModel.BookingDates(
                checkInDate,
                checkOutDate
        );
        BookingRequestModel expectedBooking = new BookingRequestModel(
                firstName,
                lastName,
                Integer.parseInt(totalPrice),
                Boolean.parseBoolean(depositPaid),
                bookingDates,
                additionalNeeds
        );

        ReflectionUtilities.compareObjects(expectedBooking, actualBooking);
        log.success("Booking is verified!");
    }

    @Given("Verify the booking with id {} is deleted")
    public void verifyBookingDeleted(String bookingId) {
        bookingId = contextCheck(bookingId);
        try {
            restfulBooker.getBooking(bookingId);
        }
        catch (Exception e) {log.success("Verified the booking is deleted");}
    }

}
