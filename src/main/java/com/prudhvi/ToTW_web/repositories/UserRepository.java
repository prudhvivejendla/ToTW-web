package com.prudhvi.ToTW_web.repositories;

import com.prudhvi.ToTW_web.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Author, Long> {
}
