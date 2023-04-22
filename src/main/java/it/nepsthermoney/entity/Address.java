package it.nepsthermoney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class Address  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String number;
    private String neighborhood;
    private String city;
    private String street;
    private String province;
}
