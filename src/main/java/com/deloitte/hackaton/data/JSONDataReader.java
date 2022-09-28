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
        System.out.println(resource);
        if (!resource.exists()) {
            throw new InvalidArgumentException("/static/users.json file not found!");
        }
        try {
            return mapper.readValue(resource.getFile(), JSONUserList.class);
        } catch (IOException e) {
            throw new InvalidArgumentException("Can not read /static/users.json file!");
        }
    }

    public static JSONUserList readRegisterUsers() {
        var resource = getRegisterUsersFileFromClasspath();
        System.out.println(resource);
        if (!resource.exists()) {
            throw new InvalidArgumentException("/static/registerUsers.json file not found!");
        }
        try {
            return mapper.readValue(resource.getFile(), JSONUserList.class);
        } catch (IOException e) {
            throw new InvalidArgumentException("Can not read /static/registerUsers.json file!");
        }
    }



    private static Resource getUsersFileFromClasspath() {
        return new ClassPathResource("/static/users.json");
    }

    private static Resource getRegisterUsersFileFromClasspath(){
        return new ClassPathResource("/static/registerUsers.json");
    }
}