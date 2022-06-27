package com.cuzoffservice.domain.model.user;

import com.cuzoffservice.infrastructure.config.EmailNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	User findByPseudoId(String userId);

	User findByUserId(String userId);
	
	boolean existsByPseudoId(String pseudoId);
	
	boolean existsByUserId(String userId);

	boolean existsByEmail(String email);

	User findByEmail(String email)
	 	throws EmailNotFoundException;
}
