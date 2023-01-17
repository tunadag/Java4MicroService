package com.tunadag.repository;

import com.tunadag.repository.entity.UserProfile;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserProfileRepository extends ElasticsearchRepository<UserProfile, String> {

    Optional<UserProfile> findOptionalByUsername(String username);
}
