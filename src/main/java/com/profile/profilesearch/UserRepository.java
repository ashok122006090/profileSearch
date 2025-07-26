package com.profile.profilesearch;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE " +
            "u.firstName LIKE %:query% OR " +
            "u.lastName LIKE %:query% OR " +
            "u.email LIKE %:query% OR " +
            "u.username LIKE %:query% OR " +
            "u.ssn LIKE %:query%")
    List<User> search(String query);
}
