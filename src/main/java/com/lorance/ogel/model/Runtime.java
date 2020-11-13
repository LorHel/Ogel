package com.lorance.ogel.model;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;

@Data
@Setter
@Getter
public class Runtime {

    @NotNull
    private Long id;

    @NotNull
    @Size(max = 15,min = 15)
    private String machine_name;

    @NotNull
    private LocalDateTime datetime;

    @NotNull
    private Boolean isrunning;

    public void setId(long id) {
    }

    public void setMachine_name(String machine_name) {
    }

    public void setDatetime(LocalDateTime datetime) {
    }

    public void setIsRunning(boolean isrunning) {
    }
}
