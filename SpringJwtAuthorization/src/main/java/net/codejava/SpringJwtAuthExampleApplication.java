package net.codejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class SpringJwtAuthExampleApplication {
    public static final String URL = "http://149.28.22.160:8080/auth/realms/Nam-Long/protocol/openid-connect/token";

	static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
		SpringApplication.run(SpringJwtAuthExampleApplication.class, args);
		System.out.println(getOTP(6));

    }
	public static int ranNo = 0;
	public static String getOTP(int len) {
		// Use for loop to iterate 4 times and generate random OTP
		String otp = "";
		for (int i = 0; i < len; i++) {
			// Generate random digit within 0-9
			ranNo = new Random().nextInt(9);
			otp  = otp .concat(Integer.toString(ranNo));
		}
		// Return the generated OTP
		return otp ;
	}
}
