package com.vemser.hackaton.dbcbank.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDadosSociaisRequest {
    private String gender;
    private String selfDeclaredRace;
    @JsonProperty("isPcd")
    private boolean pcd;
    private String pcdDescription;
    private String educationalLevel;
    private String occupation;
    private String monthlyIncome;
    private String jobExperience;
    private String workType;
}
