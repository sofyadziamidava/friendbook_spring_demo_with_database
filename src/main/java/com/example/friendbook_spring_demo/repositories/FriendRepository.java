package com.example.friendbook_spring_demo.repositories;

import com.example.friendbook_spring_demo.models.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendRepository extends CrudRepository<Friend, Long> {
    List<Friend> findByName(String name);
    List<Friend> findByAdress(String adress);
    List<Friend> findByPhoneNumber(String phoneNumber);
}
