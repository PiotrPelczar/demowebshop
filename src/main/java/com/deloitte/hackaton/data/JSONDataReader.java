package com.deloitte.hackaton.data;

import com.deloitte.hackaton.data.user.JSONUserList;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.var;
import org.openqa.selenium.InvalidArgumentException;
import org.springframework.core.io.*;

import java.io.IOException;



public class JSONDataReader {

    private static final ObjectMapper mapper = new ObjectMapper();


    public static JSONUserList readUsers() {
        var resource = getUsersFileFromClasspath();
        if (!resource.exists()) {
            throw new InvalidArgumentException("/static/users.json file not found!");
        }
        try {
            return mapper.readValue(resource.getFile(), JSONUserList.class);
        } catch (IOException e) {
            throw new InvalidArgumentException("Can not read /static/users.json file!");
        }
    }


    private static Resource getUsersFileFromClasspath() {
        return new ClassPathResource("/static/users.json");
    }
}