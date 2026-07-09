package com.resumelens.backend.repository;

import com.resumelens.backend.entity.Resume;
import com.resumelens.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {

    List<Resume> findByUserOrderByUploadedAtDesc(User user);

}