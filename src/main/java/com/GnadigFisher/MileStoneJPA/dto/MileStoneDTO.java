package com.GnadigFisher.MileStoneJPA.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MileStoneDTO {
    @NotNull
    private String date;
    @NotNull
    @Length(min = 6)
    private String name;

    @Length(max = 317)
    private String comment;

}
