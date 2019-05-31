package com.hit.springboot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

  private static Map<String, Boolean> paymentRepo = new HashMap<>();

  @RequestMapping(value = "/payments", method = RequestMethod.POST)
  public ResponseEntity<Object> createProduct(@RequestBody Payment payment) {
    Boolean cardflag = false;
    Boolean dateflag = false;
    Boolean cvvflag = false;
    if (payment.getCreditCardNumber() != null && payment.getCreditCardNumber().length() == 16) {
      cardflag = true;
    }
    if (payment.getExpiryDate() != null) {
      int month = Integer.parseInt(payment.getExpiryDate().split("/")[1]);
      int year = Integer.parseInt(payment.getExpiryDate().split("/")[0]);
      System.out.println("month :: "+month);
      System.out.println("year :: "+year);
      int totalMonth = (year * 12) + month;
      totalMonth++; // next month needed
      int nextMonth = totalMonth % 12;
      int yearOfNextMonth = totalMonth / 12;
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
      simpleDateFormat.setLenient(false);
      Date expiry = new Date();
      try {
        expiry = simpleDateFormat.parse(nextMonth + "/" + yearOfNextMonth);
        System.out.println(new Date());
      } catch (ParseException e) {
        e.printStackTrace();
      }
      dateflag = !expiry.before(new Date());
    }
    if (payment.getCvvNumber() != null && payment.getCvvNumber().length() == 3) {
      cvvflag = true;
    }
    paymentRepo.put("cardFlag", cardflag);
    paymentRepo.put("dateflag", dateflag);
    paymentRepo.put("cvvflag", cvvflag);
    return new ResponseEntity<>(paymentRepo, HttpStatus.OK);
  }
}
