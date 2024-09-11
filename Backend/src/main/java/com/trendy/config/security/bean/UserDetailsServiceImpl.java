package com.trendy.config.security.bean;

import com.trendy.config.security.jwt.JwtUtils;
import com.trendy.entidades.cliente.Cliente;
import com.trendy.entidades.dtos.autenticacion.LoginRequestDTO;
import com.trendy.entidades.dtos.autenticacion.LoginResponseDTO;
import com.trendy.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ClienteRepository clienteRepository;

    private final JwtUtils jwtUtils;


    @Autowired
    public UserDetailsServiceImpl(ClienteRepository clienteRepository, JwtUtils jwtUtils){
        this.clienteRepository = clienteRepository;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Cliente cliente = clienteRepository.findClienteByAutenticacionEmail(email)
                .orElseThrow( () -> new UsernameNotFoundException("El email " + email + " no existe"));

        return new User(
                cliente.getAutenticacion().getEmail(),
                cliente.getAutenticacion().getPassword(),
                true, // isEnabled
                true, // isAccountNonExpired
                true, // isCredentialsNonExpired
                true, // isAccountNonLocked
                new ArrayList<>() // Lista vacia de autoridades ya que no se usa en la aplicación
        );

    }

    public LoginResponseDTO loginUser(LoginRequestDTO loginRequest){

        String email = loginRequest.email();
        String password = loginRequest.password();

        Authentication authentication = authenticate(email, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);
        return new LoginResponseDTO(email,
                "User logged sucessfully",
                accessToken,
                true);
    }

    private Authentication authenticate(String userName, String password) {

        UserDetails userDetails = loadUserByUsername(userName);

        if(userDetails == null){
            throw new BadCredentialsException("Invalid username or password");
        }

        if(!password.equals(userDetails.getPassword())){
            throw new BadCredentialsException("Invalid password");
        }
        return new UsernamePasswordAuthenticationToken(userName, userDetails.getPassword());

    }

    //!passwordEncoder.matches(

}
