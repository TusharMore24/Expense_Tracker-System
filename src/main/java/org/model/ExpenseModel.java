package org.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseModel {
  private int expense_id;
  private int user_id;
  private float amount;
  private String description;
  private String date;
  private int category_id;
 
}
