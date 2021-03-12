package org.cigma.ychakir.springbootexam.repository;

import java.util.List;
import java.util.Optional;
import org.cigma.ychakir.springbootexam.model.Order;
import org.cigma.ychakir.springbootexam.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  boolean existsByArticleId(Long articleId);

  List<Order> findAllByUserIdAndStatusIn(Long userId, List<OrderStatus> status);

  Optional<Order> findFirstByArticleIdAndStatusIn(Long articleId, List<OrderStatus> status);
}
