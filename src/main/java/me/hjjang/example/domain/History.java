package me.hjjang.example.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class History {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    @CreationTimestamp
    private LocalDateTime regDt;
}
