package com.trendy.config.security.bean;

import com.trendy.config.security.jwt.JwtUtils;
import com.trendy.entidades.cliente.Cliente;
import com.trendy.entidades.dtos.autenticacion.LoginDTO;
import com.trendy.entidades.dtos.autenticacion.LoginResponseDTO;
import com.trendy.entidades.dtos.autenticacion.RegistrationDTO;
import com.trendy.entidades.dtos.cliente.ClienteInfoDTO;
import com.trendy.mapper.ClienteMapper;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    private final JwtUtils jwtUtils;

    private final PasswordEncoder passwordEncoder;



    @Autowired
    public UserDetailsServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper, JwtUtils jwtUtils, PasswordEncoder passwordEncoder){
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
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

    public ClienteInfoDTO registerUser(RegistrationDTO registrationDTO){

        Cliente clientToRegister = clienteMapper.registrarCliente(registrationDTO);
        Cliente clientRegistered = clienteRepository.save(clientToRegister);
        return clienteMapper.clienteToClienteDTO(clientRegistered);

    }

    public LoginResponseDTO loginUser(LoginDTO loginRequest){

        String email = loginRequest.email();
        String password = loginRequest.password();

        Authentication authentication = authenticate(email, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);
        return new LoginResponseDTO(email,
                "Usuario autenticado satisfactoriamente",
                accessToken,
                true);
    }

    private Authentication authenticate(String userName, String password) {

        UserDetails userDetails = loadUserByUsername(userName);

        if(userDetails == null){
            throw new BadCredentialsException("Email o contraseña invalidos");
        }

        if(!userDetails.getUsername().equals(userName)){
            throw new BadCredentialsException("Email incorrecto");

        }

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Contraseña invalida");
        }
        return new UsernamePasswordAuthenticationToken(userName, userDetails.getPassword());

    }


}
