package trevo.maquinas.api.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import trevo.maquinas.api.model.User;
import trevo.maquinas.api.repository.UserRepository;
import trevo.maquinas.api.response.ResponseModelMessage;
import trevo.maquinas.api.response.ResponseModelObject;
import trevo.maquinas.api.response.ResponseModelToken;
import trevo.maquinas.api.security.AuthenticationDTO;
import trevo.maquinas.api.security.TokenService;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenService tokenService;

    public ResponseEntity<?> register(@RequestBody @Valid User dto) {
        if (userRepository.existsByLogin(dto.getLogin())){
            return new ResponseEntity<>(new ResponseModelMessage("Usuário já existe"), HttpStatus.BAD_REQUEST);
        }
        dto.setPassword(encoder.encode(dto.getPassword()));
        User user = new User(dto);
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseModelObject("Usuário cadastrado", user), HttpStatus.OK);
    }

    public ResponseEntity<?> list() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(new ResponseModelMessage("Lista de usuários está vazia"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseModelObject("Lista de usuários", users), HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(new ResponseModelMessage("Usuário foi deletado"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseModelMessage("Usuário  não encontrado"), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid User dados) {
        User user = userRepository.findById(id).orElse(null);
        if (userRepository.existsByLogin(dados.getName())) {
            return new ResponseEntity<>(new ResponseModelMessage("Usuário com nome " + dados.getName() + " já existe"), HttpStatus.BAD_REQUEST);
        }
        if (!userRepository.existsById(id) || user == null) {
            return new ResponseEntity<>(new ResponseModelMessage("Usuário não encontrado"), HttpStatus.BAD_REQUEST);
        }
        user.update(dados);
        if (dados.getPassword() != null) {
            dados.setPassword(encoder.encode(dados.getPassword()));
        }
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseModelObject("Usuário atualizado", user), HttpStatus.OK);
    }

    public ResponseEntity<?> token(@RequestBody @Valid AuthenticationDTO dto) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        Authentication authentication = manager.authenticate(token);
        return new ResponseEntity<>(new ResponseModelToken(tokenService.token((User) authentication.getPrincipal())), HttpStatus.OK);
    }
}
