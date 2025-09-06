package utilities;

import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

/**
 * A utility class to generate fake data for test automation using Java Faker.
 */
public class FakeDataGenerator {
    private static final Faker faker;

    static {
        // Initialize Faker with a specific locale.
        faker = new Faker(new Locale("en-US"));
    }

    /**
     * Generates a random username.
     * @return A randomly generated username.
     */
    public String getUsername() {
        return faker.name().username();
    }

    /**
     * Generates a random password.
     * @return A randomly generated password.
     */
    public String getPassword() {
        // Generates a password between 8 and 12 characters, including uppercase,
        // numbers, and special characters.
        return faker.internet().password(8, 12, true, true, true);
    }

    /**
     * Generates a HashMap with fake data for a place order form.
     * @return A HashMap containing fake name, country, city, card, month, and year.
     */
    public HashMap<String, String> getPlaceOrderData() {
        HashMap<String, String> data = new HashMap<>();
        data.put("NAME", faker.name().fullName());
        // NOTE: The original code relied on a PropertyReader. Since that file is not
        // available, this example uses hardcoded values. You can replace these
        // with PropertyReader calls if you have that utility.
        data.put("COUNTRY", faker.address().country());
        data.put("CITY", faker.address().city());
        data.put("CARD", faker.business().creditCardNumber());
        data.put("MONTH", String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1));
        data.put("YEAR", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        return data;
    }
}
