package models;

import lombok.Data;

@Data
public class BookingUpdateResponseModel {

    Integer bookingid;
    BookingRequestModel booking;

}
