package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingRequestModel {

    String firstname;
    String lastname;
    Integer totalprice;
    Boolean depositpaid;
    BookingDates bookingdates;
    String additionalneeds;

    @Data
    @AllArgsConstructor
    public static class BookingDates {
        String checkin;
        String checkout;
    }
}
