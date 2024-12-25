package org.model;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseModel {
  private int expense_id;
  private float amount;
  private int category_id;
  private String description;
  private Date date;
  private int user_id;
//  public int getUser_id() {
//      return user_id;
//  }
}
