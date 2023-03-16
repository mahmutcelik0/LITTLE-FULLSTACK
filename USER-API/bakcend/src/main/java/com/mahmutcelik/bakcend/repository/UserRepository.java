package com.mahmutcelik.bakcend.repository;

import com.mahmutcelik.bakcend.model.User;
import jakarta.transaction.Transactional;
import org.hibernate.TransientObjectException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    @Query("select count(u)>0 from User u WHERE u.name =?1 AND u.email=?2 AND u.domain =?3 AND u.experience =?4")
    boolean existsControl(String username,String email,String domain,Integer experience);

    @Query("select u from User u WHERE u.email =?1")
    Optional<User> findByEmail(String email);

    @Modifying
    @Transactional
    @Query("delete from User u WHERE u.email =?1")
    void deleteByEmail(String email);
}