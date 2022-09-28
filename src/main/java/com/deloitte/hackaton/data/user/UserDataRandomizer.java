package com.deloitte.hackaton.data.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.andreinc.mockneat.MockNeat;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserDataRandomizer {
    public static void getRandomUser() throws IOException {
        MockNeat mockNeat = MockNeat.threadLocal();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = mockNeat.reflect(JSONUserData.class)
                .field("firstName", mockNeat.names().firstAndMale())
                .field("lastName", mockNeat.names().last())
                .field("email", mockNeat.emails())
                .field("password", mockNeat.passwords())
                .field("country", mockNeat.countries().names().get())
                .field("city", mockNeat.cities().capitals())
                .field("address_1", mockNeat.cities().capitals())
                .field("postCode", mockNeat.regex("\\d{2}-\\d{3}"))
                .field("phoneNumber", mockNeat.regex("\\d{3}\\d{3}\\d{3}"))
                .map(gson::toJson).val();

        File file1 = new File("src\\main\\resources\\static\\registerUsers.json");
        System.out.println(file1.getAbsolutePath());

        FileWriter file = new FileWriter(file1);
        file.write("{\"users\" : ["+json+"]}");
        file.close();
    }

}
