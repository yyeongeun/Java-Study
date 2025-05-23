package sub1;

import entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaTest {

    public static void main(String[] args) {

        // 등록
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-unit"); // xml 설정 unit 이름
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 시작
        em.getTransaction().begin();

        Student student = new Student();
        student.setStudent_id(1);
        student.setName("김유신");
        student.setBirth("1992-02-02");
        student.setMajor("영문과");
        student.setEmail("kim@gmail.com");

        em.persist(student); // 테이블 저장

        // 조회
        Student student1 = em.find(Student.class, 1);
        System.out.println(student1);

        // 전체조회(JPQL 사용)
        System.out.println("============== 전체조회 ==============");
        List<Student> students = em.createQuery("select s from Student s", Student.class).getResultList();
        for (Student s : students) {
            System.out.println(s);
        }

        // 트랜잭션 확인
        em.getTransaction().commit();

        // 자원해제
        em.close();
        emf.close();
    }
}