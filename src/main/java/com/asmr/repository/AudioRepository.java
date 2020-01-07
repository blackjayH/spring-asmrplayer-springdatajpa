package com.asmr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asmr.vo.AudioVO;

@Repository
public interface AudioRepository extends JpaRepository<AudioVO, String>, AudioRepositoryCustom {

}