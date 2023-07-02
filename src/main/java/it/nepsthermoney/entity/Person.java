package it.nepsthermoney.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
/*@Table(name = "person")*/
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private Boolean active;
    @Embedded
    private Address address;
    @JsonIgnore
    @Transient
    public boolean isInactive() {
        return !this.active;
    }


}
