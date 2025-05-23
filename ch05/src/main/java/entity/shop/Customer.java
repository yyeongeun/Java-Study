package entity.shop;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "shop_Customer")

public class Customer {
    @Id
    private String custId;
    private String name;
    private int age;
    private String addr;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "")
    private List<OrderItem> orderItems = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime regDate;

}
