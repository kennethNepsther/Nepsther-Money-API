package it.nepsthermoney.entity.dto.request;

import it.nepsthermoney.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    @NotBlank(message = "Must add person name")
    @Size(min = 3,max= 30, message = "Must contain a maximum of 30 characters")
    String name;
    @NotNull(message = "Must add person status")
    private Boolean active;
    private Address address;
}
