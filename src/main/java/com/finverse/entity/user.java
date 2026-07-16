package com.finverse.entity;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.finverse.enums.AccountStatus;
import com.finverse.enums.Gender;
import com.finverse.enums.Role;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class user {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
private String fullName;
@Column(nullable = false, unique = true)
private String email;
@Column(nullable = false)
private String password;
@Column(nullable = false, unique = true, length = 10)
private String mobileNumber;
@Enumerated(EnumType.STRING)
private Role role;
@Enumerated(EnumType.STRING)
private AccountStatus status;
@Enumerated(EnumType.STRING)
private Gender gender;
@CreationTimestamp
private LocalDateTime createdAt;

@UpdateTimestamp
private LocalDateTime updatedAt;
}
