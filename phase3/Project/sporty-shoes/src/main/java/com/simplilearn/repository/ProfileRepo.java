package com.simplilearn.repository;

import com.simplilearn.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends JpaRepository<ProfileEntity,Integer> {
}
