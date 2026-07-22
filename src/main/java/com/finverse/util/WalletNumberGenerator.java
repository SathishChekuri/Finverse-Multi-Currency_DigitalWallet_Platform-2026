package com.finverse.util;

import java.time.Year;
import java.util.UUID;

public class WalletNumberGenerator {

    public static String generate() {

        String year = String.valueOf(Year.now().getValue());

        String random = UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 8)
                .toUpperCase();

        return "FV" + year + random;
    }
}