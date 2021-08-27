package com.hql.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hql.model.Turn;
import lombok.*;

import java.util.Set;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DoctorDTO {

    private Long id;

    private String name;

    @JsonIgnore
    private Set<Turn> turns;
}
