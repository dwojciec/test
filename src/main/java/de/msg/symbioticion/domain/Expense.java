package de.msg.symbioticion.domain;

import com.google.firebase.database.IgnoreExtraProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@IgnoreExtraProperties
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
  private BigDecimal amount;
  private LocalDateTime timeOfExpense;
  private String description;
  private String tag;
}
