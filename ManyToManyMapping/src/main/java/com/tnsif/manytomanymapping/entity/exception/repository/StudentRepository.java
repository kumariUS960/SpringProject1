package com.tnsif.manytomanymapping.entity.exception.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.manytomanymapping.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
