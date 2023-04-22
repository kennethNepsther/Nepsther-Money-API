package it.nepsthermoney.execptions.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldMessages implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String field;
    private String message;
}
