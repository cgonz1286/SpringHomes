package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Home;

public interface HomeRepository extends JpaRepository<Home, Long> { }
