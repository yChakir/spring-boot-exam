package org.cigma.springbootexam.event;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.cigma.springbootexam.model.Order;
import org.cigma.springbootexam.model.User;

@Getter
@ToString
@AllArgsConstructor
public class InvoiceEvent {

  private User user;

  private List<Order> orders;
}