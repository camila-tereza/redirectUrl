package com.onboarding.redirectUrl.repository;

import com.onboarding.redirectUrl.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    List<Url> findByName(String name);

}
