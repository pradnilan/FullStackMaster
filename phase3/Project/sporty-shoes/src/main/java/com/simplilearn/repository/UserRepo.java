package com.simplilearn.repository;


import com.simplilearn.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {

    public UserEntity findUserEntitiesByUserName(String userName);
    public UserEntity findUserEntitiesByUserId(long id);
    public UserEntity deleteUserEntityByUserId(long id);

}
