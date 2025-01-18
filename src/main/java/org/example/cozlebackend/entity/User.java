package org.example.cozlebackend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @ColumnDefault("0")
    @Column(name = "tier")
    private Integer tier;

    @ColumnDefault("0")
    @Column(name = "exp")
    private Integer exp;

    @ColumnDefault("0")
    @Column(name = "coin")
    private Integer coin;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        //TODO: 만료 확인 로직
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //TODO: 잠금 확인 로직
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //TODO: 패스워드 만료 확인 로직
        return true;
    }

    @Override
    public boolean isEnabled() {
        //TODO: 계정 사용 가능 확인 로직
        return true;
    }
}