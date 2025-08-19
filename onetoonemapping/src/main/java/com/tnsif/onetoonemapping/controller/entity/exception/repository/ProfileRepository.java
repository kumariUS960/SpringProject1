package com.tnsif.onetoonemapping.controller.entity.exception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tnsif.onetoonemapping.controller.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
