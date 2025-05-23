package sub4;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor // 생성자
@Data // getter, setter, toString

// 단일 책임 원칙에 위배되는 클래스
class User {
    private String username;
    private String email;
}

class UserRepository {
    public void changePassword(String newPassword) {
        // 비밀번호 변경 로직
        System.out.println("Change password");
    }
    public void saveUser() {
        // 사용자 정보를 데이터베이스에 저장하는 로직
        System.out.println("Save user");
    }
}

class EmailService {
    public void sendEmail() {
        // 사용자에게 인증 이메일을 보내는 로직
        System.out.println("Send email");
    }
}

public class Ex1_SRP {

    public static void main(String[] args) {

        EmailService emailService = new EmailService();
        emailService.sendEmail();

        UserRepository userRepository = new UserRepository();
        userRepository.saveUser();
        userRepository.changePassword("1234");
    }
}
