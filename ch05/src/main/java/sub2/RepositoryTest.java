package sub2;

import entity.User1;
import repository.User1Repository;

public class RepositoryTest {

    public static void main(String[] args) {

        User1Repository user1Repo = new User1Repository();

        //저장
        User1 user1 = new User1();
        user1.setId("a102");
        user1.setUsername("김유신");
        user1.setAge("23");
        user1.setEmail("a101@gmail.com");

        user1Repo.save(user1);

    }

}
