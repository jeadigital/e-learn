package com.master.elearn.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Entity class representing a Payment in the system.
 */
@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    
    @Column(nullable = false)
    private String studentName;
    
    private double amount;
    private LocalDateTime paymentDate;
    private boolean success;
}
