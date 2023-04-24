package it.nepsthermoney.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import it.nepsthermoney.enums.ReleaseType;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Table(name = "releases")
public class Release implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;
    private BigDecimal value;
    private String observation;
    @Enumerated(EnumType.STRING)
    private ReleaseType type;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;


}
