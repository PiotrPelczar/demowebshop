package com.deloitte.hackaton.data.user;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JSONInvalidEmails {

    @JsonProperty("emails")
    private String emails;

}