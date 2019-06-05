package global.coda.order.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import global.coda.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByUserId(long userId);

	@Modifying
	@Query("update Order set isDelete=true where userId=:userId")
    void deactivateOrderByUserId(@Param("userId") long userId);

	Optional<Order> findByOrderIdAndIsDeleteFalse(long id);

}
