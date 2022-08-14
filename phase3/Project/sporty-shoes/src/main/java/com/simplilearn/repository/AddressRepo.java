package com.simplilearn.repository;

import com.simplilearn.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity,Integer> {
}
