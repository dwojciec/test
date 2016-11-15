package de.msg.symbioticion.domain;

import com.google.firebase.database.IgnoreExtraProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@IgnoreExtraProperties
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
  private String name;
  private String description;
  private List<User> users;
}
