package repository;

import entity.User1;
import jpa.JpaRepository;

public class User1Repository extends JpaRepository<User1,String> {
    public User1Repository() {
        super(User1.class);
    }
}