package restfulbooker;

import api_assured.*;
import context.ContextStore;
import models.*;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class RestfulBooker extends ApiUtilities {

    static RestfulBookerServices restfulBooker = new ServiceGenerator(
            new Headers.Builder()
                    .add("Accept", "*/*").build()
    ).setRequestLogging(true).generate(RestfulBookerServices.class);

    public static TokenResponseModel generateToken(AuthRequestModel authRequestModel) {
        log.info("Generating Auth token...");
        Call<TokenResponseModel> postAuthCall = restfulBooker.generateToken(authRequestModel);
        return perform(postAuthCall, true, true);
    }

    public String ping() {
        log.info("Pinging..." );
        Call<ResponseBody> pingCall = restfulBooker.ping();
        return perform(pingCall, true, true).toString();
    }

    public Object[] getBookingIds(String firstName, String lastName, String checkInDate, String checkOutDate) {
        log.info("Getting the booking ids..." );
        Call<Object[]> getBookingIds = restfulBooker.getBookingIds(firstName, lastName, checkInDate, checkOutDate);
        return perform(getBookingIds, true, true);
    }

    public BookingRequestModel getBooking(String bookingId) {
        log.info("Getting the booking..." );
        Call<BookingRequestModel> getBookingCall = restfulBooker.getBooking(bookingId);
        return perform(getBookingCall, false, true);
    }

    public BookingUpdateResponseModel createBooking(BookingRequestModel bookingRequest) {
        log.info("Creating the booking..." );
        Call<BookingUpdateResponseModel> createBookingCall = restfulBooker.createBooking(bookingRequest);
        return perform(createBookingCall, true, true);
    }

    public static class Authorised {
        static RestfulBookerServices.Authorized restfulBookerAuthorized = new ServiceGenerator(
                new Headers.Builder()
                        .add("Accept", "*/*")
                        .add("Cookie", "token=" + ContextStore.get("authToken").toString())
                        .build()
        ).generate(RestfulBookerServices.Authorized.class);

        public static BookingRequestModel updateBooking(String bookingId, BookingRequestModel bookingRequestModel) {
            log.info("Updating the entire booking..." );
            Call<BookingRequestModel> putBookingCall = restfulBookerAuthorized.updateBooking(bookingId, bookingRequestModel);
            return perform(putBookingCall, true, true);
        }

        public static BookingRequestModel patchBooking(String bookingId, BookingRequestModel bookingRequestModel) {
            log.info("Updating the booking fields..." );
            Call<BookingRequestModel> patchBookingCall = restfulBookerAuthorized.patchBooking(bookingId, bookingRequestModel);
            return perform(patchBookingCall, true, true);
        }

        public static String deleteBooking(String bookingId) {
            log.info("Deleting the booking..." );
            Call<ResponseBody> deleteBookingCall = restfulBookerAuthorized.deleteBooking(bookingId);
            return perform(deleteBookingCall, true, true).toString();
        }
    }

}
