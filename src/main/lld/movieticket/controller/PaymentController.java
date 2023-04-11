package main.lld.movieticket.controller;

import main.lld.movieticket.services.BookingService;
import main.lld.movieticket.services.PaymentsService;

public class PaymentController {
    private final PaymentsService paymentsService;
    private final BookingService bookingService;

    public PaymentController(PaymentsService paymentsService, BookingService bookingService) {
        this.paymentsService = paymentsService;
        this.bookingService = bookingService;
    }

    public void paymentFailed(final String bookingId, final String user) {
        paymentsService.processPaymentFailed(bookingService.getBooking(bookingId), user);
    }

    public void paymentSuccess(final String bookingId, final String user) {
        bookingService.confirmBooking(bookingService.getBooking(bookingId), user);
    }
}
