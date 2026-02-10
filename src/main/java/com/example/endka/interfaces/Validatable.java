package com.example.endka.interfaces;

public interface Validatable {

    void validate();

    default boolean isValid() {
        try {
            validate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static void log(String msg) {
        System.out.println("[VALIDATION] " + msg);
    }
}
