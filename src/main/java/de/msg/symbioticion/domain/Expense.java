package de.msg.symbioticion.domain;

import com.google.firebase.database.IgnoreExtraProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@IgnoreExtraProperties
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    private String group;
    private String payer;
    private String amount;
    private String timeOfExpense;
    private String description;
}
