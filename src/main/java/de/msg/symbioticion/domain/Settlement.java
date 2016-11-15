package de.msg.symbioticion.domain;

import com.google.firebase.database.IgnoreExtraProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@IgnoreExtraProperties
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Settlement {
    private String amount;
    private String recipient;
    private String sender;
    private String description;
}
