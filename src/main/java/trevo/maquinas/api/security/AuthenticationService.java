package trevo.maquinas.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import trevo.maquinas.api.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!userRepository.existsByLogin(username)){
            throw new RuntimeException("Login inválido");
        }
        return userRepository.findByLogin(username);
    }

}
