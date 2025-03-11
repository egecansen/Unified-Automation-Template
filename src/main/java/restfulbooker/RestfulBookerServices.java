package restfulbooker;
import models.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import static restfulbooker.RestfulBookerAPI.*;

public interface RestfulBookerServices {

    interface Authorized {
        String BASE_URL = RestfulBookerAPI.BASE_URL;

        @PUT(BOOKING_SUFFIX + ID_SUFFIX)
        Call<BookingRequestModel> updateBooking(
                @Path("id") String bookingId,
                @Body BookingRequestModel bookingRequestModel
        );

        @PATCH(BOOKING_SUFFIX + ID_SUFFIX)
        Call<BookingRequestModel> patchBooking(
                @Path("id") String bookingId,
                @Body BookingRequestModel bookingRequestModel
        );

        @DELETE(BOOKING_SUFFIX + ID_SUFFIX)
        Call<ResponseBody> deleteBooking(
                @Path("id") String bookingId
        );
    }

    String BASE_URL = RestfulBookerAPI.BASE_URL;

    @POST(AUTH_SUFFIX)
    Call<TokenResponseModel> generateToken(
            @Body AuthRequestModel authRequestModel
    );

    @GET(PING_SUFFIX)
    Call<ResponseBody> ping();

    @GET(BOOKING_SUFFIX)
    Call<Object[]> getBookingIds(
            @Query("firstname") String firstname,
            @Query("lastname") String lastname,
            @Query("checkin") String checkin,
            @Query("checkout") String checkout
    );

    @GET(BOOKING_SUFFIX + ID_SUFFIX)
    Call<BookingRequestModel> getBooking(
            @Path("id") String bookingId
    );

    @POST(BOOKING_SUFFIX)
    Call<BookingUpdateResponseModel> createBooking(
            @Body BookingRequestModel bookingRequestModel
    );

}
