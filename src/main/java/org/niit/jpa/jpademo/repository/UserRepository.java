package org.niit.jpa.jpademo.repository;

import org.niit.jpa.jpademo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public List<User> findByFirstName(String firstName);
}
