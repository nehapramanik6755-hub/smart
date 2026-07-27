
package com.travelguide.demo.service;

import com.travelguide.demo.entity.Booking;
import com.travelguide.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking booking) {
        Booking existingBooking = getBookingById(id);

        existingBooking.setCustomerName(booking.getCustomerName());
        existingBooking.setCustomerEmail(booking.getCustomerEmail());
        existingBooking.setBookingType(booking.getBookingType());
        existingBooking.setItemName(booking.getItemName());
        existingBooking.setAmount(booking.getAmount());
        existingBooking.setBookingDate(booking.getBookingDate());
        existingBooking.setStatus(booking.getStatus());

        return bookingRepository.save(existingBooking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}