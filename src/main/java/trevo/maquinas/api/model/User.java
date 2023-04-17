package trevo.maquinas.api.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import trevo.maquinas.api.dto.ProfileEnum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String password;
    private String login;
    @Enumerated(EnumType.STRING)
    private ProfileEnum profile;
    private String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));


    public User(User dados) {
        this.name = dados.name;
        this.password = dados.password;
        this.date = dados.date;
        this.login = dados.login;
        this.profile = dados.profile;
    }

    public void update(User dados) {
        if (dados.name != null) {
            this.name = dados.name;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + profile.toString()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
