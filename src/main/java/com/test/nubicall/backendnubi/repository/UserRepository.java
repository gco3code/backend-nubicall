package com.test.nubicall.backendnubi.repository;
import org.springframework.data.repository.CrudRepository;
import com.test.nubicall.backendnubi.entity.User;


public interface UserRepository extends CrudRepository<User, Long>{
	public User findByUsername(String username);
}
