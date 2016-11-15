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
  private BigDecimal amount;
  private User receiver;
  private User sender;
  private String description;
}
