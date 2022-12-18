package com.gcu.store.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.store.StoreApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gcu.store.data.UserDataService;
import com.gcu.store.data.entity.UserEntity;
import com.gcu.store.models.UserModel;
import com.gcu.store.data.UserDataService;

@Component
public class UserBusinessService implements UserDetailsService {

    @Autowired
    UserDataService service;

    public boolean addUser(UserModel newUser) {

        // Create UserEntity from UserModel
        UserEntity entity = new UserEntity(newUser.getId(),
                newUser.getFirstName(),
                newUser.getLastName(),
                newUser.getPhoneNumber(),
                newUser.getEmail(),
                newUser.getUserName(),
                newUser.getPassword());

        // Attempt insertion of UserEntity into database with UserDataService
        // Return boolean indicating success or failure


        return service.create(entity);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Call service and return user by username
        UserEntity user = service.findByUserName(username);



        // If user found add authorities of "USER"
        if(user != null)
        {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(user.getUserName(), user.getPassword(), authorities);
        }
        else
        {
            throw new UsernameNotFoundException("Username not found");
        }
    }


}
