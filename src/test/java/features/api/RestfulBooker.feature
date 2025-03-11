Feature: Dias

  @API-Test @SCN-RestfulBooker-01
  Scenario: Restful Booker - Ping
    * Ping the restful booker api server

  @API-Test @Authorize @SCN-RestfulBooker-02
  Scenario: Restful Booker - Create & Patch booking
    * Create booking with parameter:
      | firstName       | Egecan     |
      | lastName        | Testing    |
      | depositPaid     | true       |
      | totalPrice      | 234        |
      | checkInDate     | 2026-09-08 |
      | checkOutDate    | 2026-10-11 |
      | additionalNeeds | Watermelon |
    * Update fields of booking id CONTEXT-bookingId with parameter:
      | lastName        | Tested |
      | depositPaid     | false  |
      | additionalNeeds | Melon  |
    * Verify the booking info with parameters:
      | firstName       | Egecan     |
      | lastName        | Tested     |
      | depositPaid     | false      |
      | totalPrice      | 234        |
      | checkInDate     | 2026-09-08 |
      | checkOutDate    | 2026-10-11 |
      | additionalNeeds | Melon      |

  @API-Test @Authorize @SCN-RestfulBooker-02
  Scenario: Restful Booker - Create &  Update booking
    * Create random booking
    * Get booking with id CONTEXT-bookingId
    * Update the entire reservation of booking id CONTEXT-bookingId with parameter:
      | firstName       | Egecan      |
      | lastName        | Tested      |
      | depositPaid     | false       |
      | totalPrice      | 777         |
      | checkInDate     | 2026-08-01  |
      | checkOutDate    | 2026-08-09  |
      | additionalNeeds | Grape fruit |
    * Get booking with id CONTEXT-bookingId
    * Verify the booking info with parameters:
      | firstName       | Egecan      |
      | lastName        | Tested      |
      | depositPaid     | false       |
      | totalPrice      | 777         |
      | checkInDate     | 2026-08-01  |
      | checkOutDate    | 2026-08-09  |
      | additionalNeeds | Grape fruit |
    * Delete booking with id CONTEXT-bookingId
    * Verify the booking with id CONTEXT-bookingId is deleted

  @API-Test @SCN-RestfulBooker-03
  Scenario: Restful Booker - Get booking ids
    * Get booking ids with parameter:
      | firstName | Egecan |