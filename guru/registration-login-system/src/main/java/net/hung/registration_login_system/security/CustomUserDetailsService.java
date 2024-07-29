package net.hung.registration_login_system.security;

import net.hung.registration_login_system.entity.User;
import net.hung.registration_login_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userService.findByEmail(usernameOrEmail);
        if(user!=null){
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                    user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).toList());
        }else{
            throw new UsernameNotFoundException("Invalid email or password");
        }

    }
}
