package com.lorance.ogel.model;


import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Production {

    @NotNull
    private Long id;

    @NotNull
    @Size(max = 15,min = 15)
    private String machine_name;

    @NotNull
    @Size(max = 16,min = 5)
    private String variable_name;

    @NotNull
    private LocalDateTime datetime_from;

    @NotNull
    private LocalDateTime datetime_to;

    @NotNull
    private Integer value;


    public void setId(long id) {
    }

    public void setMachine_name(String machine_name) {
    }

    public void setVariable_name(String variable_name) {
    }

    public void setValue(int value) {
    }

    public void setDatetime_from(LocalDateTime datetime_from) {
    }

    public void setDatetime_to(LocalDateTime datetime_to) {
    }
}
