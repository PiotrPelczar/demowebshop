package com.deloitte.hackaton.data.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class JSONUserList {

    @JsonProperty("users")
    private List<JSONUserData> users;

}
