package com.vemser.hackaton.dbcbank.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChavePixRequest {
    private String type;
    @JsonIgnore
    private String authToken;
    private String key;
}
