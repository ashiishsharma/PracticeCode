package com.ashish.exception;

public class NonEmptyParkingSlotReturned extends RuntimeException {
    public NonEmptyParkingSlotReturned(String message) {
        super(message);
    }
}
