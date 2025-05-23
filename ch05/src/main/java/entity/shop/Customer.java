package entity.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "shop_Customer")

public class Customer {
    @Id
    private String custId;
    private String name;
    private int age;
    private String addr;
    @CreationTimestamp
    private LocalDateTime regDate;

}
