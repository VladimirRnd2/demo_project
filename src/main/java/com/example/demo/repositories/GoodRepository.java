package com.example.demo.repositories;

import com.example.demo.models.dao.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodRepository extends JpaRepository<GoodEntity, Long> {
}
