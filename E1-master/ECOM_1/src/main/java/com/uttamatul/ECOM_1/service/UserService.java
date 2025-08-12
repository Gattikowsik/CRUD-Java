package com.uttamatul.ECOM_1.service;

import com.uttamatul.ECOM_1.entity.User;
import com.uttamatul.ECOM_1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService
{
//    @Autowired
//    private UserRepository userRepository;
    //or
    private final UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getOneUser(Long Id)
    {
        return  userRepository.findById(Id);
    }

    public void saveAUser(User user)
    {
        userRepository.save(user);
    }

    public Boolean upadetAUser(Long id, User updateduser)
    {
        Optional<User> existinguser =  getOneUser(id);
        if(existinguser!=null)
        {
            existinguser.get().setFname(updateduser.getFname());
            existinguser.get().setLname(updateduser.getLname());
            existinguser.get().setEmail(updateduser.getEmail());
            existinguser.get().setPassword(updateduser.getPassword());
            existinguser.get().setPhone(updateduser.getPhone());
                if(existinguser.get().getAddress() != null) {
                    existinguser.get().getAddress().setStreet(updateduser.getAddress().getStreet());
                    existinguser.get().getAddress().setCity(updateduser.getAddress().getCity());
                    existinguser.get().getAddress().setState(updateduser.getAddress().getState());
                    existinguser.get().getAddress().setCountry(updateduser.getAddress().getCountry());
                    existinguser.get().getAddress().setZipCode(updateduser.getAddress().getZipCode());
                }
            userRepository.save(existinguser.get());
        return true;
        }
        return false;
    }
    public Boolean deleteAUser(Long id)
    {
        Optional<User> existinguser =  getOneUser(id);
        if(existinguser!=null)
        {
            userRepository.delete(existinguser.get());
            return true;
        }
        return false;
    }
}
