package com.ducanh.demojpa.service;

import com.ducanh.demojpa.configuration.CustomUserDetail;
import com.ducanh.demojpa.entity.Users;
import com.ducanh.demojpa.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService {
    @Autowired
    private IUsersRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1.
        //Call our repository to work with db
        Users user = userRepository.findByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException(username);
            //2. return custom user details
        else return new CustomUserDetail(user);
    }

    @Override
    public Users getUserById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void createUser(Users newUser)
    {
        userRepository.save(newUser);
    }

    @Override
    public Users getUserByUserName(String username)
    {
        return userRepository.findByUsername(username);
    }
}
