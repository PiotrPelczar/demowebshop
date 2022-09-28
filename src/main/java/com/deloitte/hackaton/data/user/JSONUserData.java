package com.deloitte.hackaton.data.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JSONUserData {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("country")
    private String country;

    @JsonProperty("city")
    private String city;

    @JsonProperty("address_1")
    private String address_1;

    @JsonProperty("postCode")
    private String postCode;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @Override
    public String toString() {
        return "JSONUserData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", passwordInput='" + password + '\'' +
                '}';
    }
}
