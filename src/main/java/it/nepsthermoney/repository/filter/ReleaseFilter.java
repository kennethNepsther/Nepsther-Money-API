package it.nepsthermoney.repository.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseFilter implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDateOf;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDateUntil;
}

