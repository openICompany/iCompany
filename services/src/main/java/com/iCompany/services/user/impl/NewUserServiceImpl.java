package com.iCompany.services.user.impl;

import com.iCompany.entities.user.User;
import com.iCompany.entities.user.UserType;
import com.iCompany.repositories.user.UserRepository;
import com.iCompany.services.user.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lukasz on 23.03.16.
 */
@Service
public class NewUserServiceImpl implements NewUserService {

    @Autowired
    UserRepository userRepository;

    public void saveTestUser() {
        User user = new User();
        user.setName("Lukasz");
        user.setSurname("Franczuk");
        user.setEmail("luk.franczuk@gmail.com");
        user.setPassword("blablabla");
        user.setUserType(UserType.ADMINISTRATOR);
        userRepository.saveAndFlush(user);
    }
}
