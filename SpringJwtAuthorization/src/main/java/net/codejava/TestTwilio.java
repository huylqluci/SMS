package net.codejava;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.Random;

public class TestTwilio {

    public static final String ACCOUNT_SID = "AC82459ba83a804bfa09f7a8827dc06663";

    public static final String AUTH_TOKEN = "c31f9deb066935c4d1bf1f672ed32fef";

    public static final String TWILIO_TO_NUMBER = "+84983840617";

    public static final String TWILIO_FROM_NUMBER = "+15163448031";

    public static int ranNo = 0;

    public static String getOTP(int len) {
        // Use for loop to iterate 4 times and generate random OTP
        String otp = "";
        for (int i = 0; i < len; i++) {
            // Generate random digit within 0-9
            ranNo = new Random().nextInt(9);
            otp = otp.concat(Integer.toString(ranNo));
        }
        // Return the generated OTP
        return otp;
    }

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new PhoneNumber(TWILIO_TO_NUMBER),
                        new PhoneNumber(TWILIO_FROM_NUMBER),
                        "Luci smart city - Sample Twilio SMS using Java")
                .create();
    }
}

