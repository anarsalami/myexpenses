package com.boraji.tutorial.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.UserDetailsDao;
import com.boraji.tutorial.spring.model.Authorities;
import com.boraji.tutorial.spring.model.User;
import java.util.Iterator;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDetailsDao.findUserByUsername(username);
        UserBuilder builder = null;
        if (user != null) {

            builder = org.springframework.security.core.userdetails.User.withUsername(username);

            builder.disabled(!user.isEnabled());
            builder.password(user.getPassword());
            
            String[] authoritiesArr = getAuthorityArr(user.getAuthorities());
            builder.authorities(authoritiesArr);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

    public static String[] getAuthorityArr(Set<Authorities> authorities) {

        String[] authoritiesArr = new String[authorities.size()];
        Iterator<Authorities> iter = authorities.iterator();
        int i = 0;
        while (iter.hasNext()) {
            Authorities a = iter.next();
            authoritiesArr[i] = a.getAuthority();
            i++;
        }

        return authoritiesArr;
    }
}
