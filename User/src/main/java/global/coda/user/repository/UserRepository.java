package global.coda.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import global.coda.user.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Modifying
	@Query("update User set isActive=false where userId=:id")
	void deactivateUser(@Param("id")long id);

	Optional<User> findByUserIdAndIsActiveTrue(long id);

}
