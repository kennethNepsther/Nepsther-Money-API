package it.nepsthermoney.entity.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import it.nepsthermoney.entity.Category;
import it.nepsthermoney.entity.Person;
import it.nepsthermoney.enums.ReleaseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseDto {
    @NotBlank(message = "Must add category name")
    @Size(min = 3,max= 30, message = "Must contain a maximum of 30 characters")
    private String description;
    @NotNull(message = "Due Date is required ")
    private LocalDate dueDate;
    @NotNull(message = "paymentDate is required ")
    private LocalDate paymentDate;
    @NotNull(message = "value is required ")
    private BigDecimal value;
    private String observation;
    @NotNull(message = "value is required ")
    private ReleaseType type;
    @NotNull(message = "person is required ")
    private Person person;
    @NotNull(message = "category is required ")
    private Category category;
}
