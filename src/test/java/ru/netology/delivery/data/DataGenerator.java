package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Generated;
import lombok.Value;
import lombok.val;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    private DataGenerator() {
    }
    private static Faker faker;
    static void setUpsadasd(){ faker = new Faker(new Locale("ru")); }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));;
        return date;
    }

    public static String generateCity(String locale) {
        Random random = new Random();
        String [] cites = {"Волгоград","Вологда","Калуга","Иваново","Курган","Астрахань","Благовещенск"};
        String city = cites[random.nextInt(8)];
        return city;
    }

    public static String generateName(String locale) {
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity("ru"),generateName("ru"),generatePhone("ru"));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
