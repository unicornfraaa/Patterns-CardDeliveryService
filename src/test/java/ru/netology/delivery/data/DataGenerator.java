package ru.netology.delivery.data;
import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {


    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        LocalDate possibleDate = LocalDate.now().plusDays(shift);
        String date = possibleDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }
        public static String generateCity() {
            String[] validCities = {"Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала", "Магас", "Нальчик", "Элиста", "Черкесск", "Петрозаводск",
                    "Сыктывкар", "Симферополь", "Йошкар-Ола", "Саранск", "Якутск", "Владикавказ", "Казань", "Кызыл", "Ижевск", "Абакан", "Грозный",
                    "Чебоксары", "Барнаул", "Чита", "Петропавловск-Камчатский", "Краснодар", "Красноярск", "Пермь", "Владивосток", "Ставрополь", "Хабаровск",
                    "Благовещенск", "Архангельск", "Астрахань", "Белгород", "Брянск", "Владимир", "Волгоград", "Вологда", "Воронеж", "Иваново", "Иркутск",
                    "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Курган", "Курск", "Липецк", "Магадан", "Красногорск", "Мурманск",
                    "Нижний Новгород", "Великий Новгород", "Новосибирск", "Омск", "Оренбург", "Орёл", "Пенза", "Псков", "Ростов-на-Дону", "Рязань",
                    "Самара", "Саратов", "Южно-Сахалинск", "Екатеринбург", "Смоленск", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Ульяновск", "Челябинск",
                    "Ярославль", "Москва", "Санкт-Петербург", "Севастополь", "Биробиджан", "Нарьян-Мар", "Ханты-Мансийск", "Анадырь", "Салехард"};
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < validCities.length; i++) {
                list.add(validCities[i]);
            }
            Random rnd = new Random();
            return list.get(rnd.nextInt(validCities.length));
        }

        public static String generateName(String locale) {
            // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
            Faker faker = new Faker(new Locale(locale));
            String name = faker.name().fullName();
            return name;
        }
        public static String generatePhone(String locale) {
            // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
            // использовать Faker
            Faker faker = new Faker(new Locale(locale));
            String phone = faker.phoneNumber().phoneNumber();
            return phone;
        }
        public static class Registration {
            private Registration() {
            }
            public static UserInfo generateUser(String locale) {
                // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
                // generateName(locale), generatePhone(locale)
                return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
            }
        }

        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }
    }