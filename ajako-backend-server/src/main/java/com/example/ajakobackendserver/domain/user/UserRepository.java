package com.example.ajakobackendserver.domain.user;

import com.example.ajakobackendserver.api.dto.user.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long,User> {

}
