package net.codejava;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RedisExample implements CommandLineRunner {

    public static final String ACCOUNT_SID = "AC82459ba83a804bfa09f7a8827dc06663";

    public static final String AUTH_TOKEN = "c31f9deb066935c4d1bf1f672ed32fef";

    public static final String TWILIO_TO_NUMBER = "+84983840617";

    public static final String TWILIO_FROM_NUMBER = "+15163448031";

    public static int ranNo = 0;

    public static String getOTP(int len) {
        String otp = "";
        for (int i = 0; i < len; i++) {
            ranNo = new Random().nextInt(9);
            otp = otp.concat(Integer.toString(ranNo));
        }
        return otp;
    }
    @Autowired
    private RedisTemplate template;


    @Override
    public void run(String... args) throws Exception {
        template.opsForValue().set("username", getOTP(6));
    }
    public static void main(String[] args) {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new PhoneNumber(TWILIO_TO_NUMBER),
                        new PhoneNumber(TWILIO_FROM_NUMBER),
                        getOTP(6))
                .create();
    }


}
