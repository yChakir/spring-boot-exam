package org.cigma.ychakir.springbootexam.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseModel {

  @ManyToOne
  private User user;

  @ManyToOne
  private Article article;

  private Long quantity;

  private OrderStatus status;
}
