package com.dmitrijkuzmin.sampleps.utils;

public class Validator {

    public static boolean isRegistrationNumberValid(String registrationNumber) {
        String registrationNumberPattern = "^[А-Я]\\d{3}[А-Я]{2}\\d{2}$";
        return registrationNumber.matches(registrationNumberPattern);
    }

    public static boolean isCertificateNumberValid(String certificateNumber) {
        String certificateNumberPattern = "^\\d{2}([А-Я]{2}|[0-9]{2})\\d{6}$";
        return certificateNumber.matches(certificateNumberPattern);
    }

    public static boolean isDriverLicenseValid(String driverLicense) {
        String driverLicensePattern = "^\\d{2}([А-Я]{2}|[0-9]{2})\\d{6}$";
        return driverLicense.matches(driverLicensePattern);
    }
}
