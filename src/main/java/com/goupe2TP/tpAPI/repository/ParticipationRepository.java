package com.goupe2TP.tpAPI.repository;

import com.goupe2TP.tpAPI.model.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipationRepository extends JpaRepository <Participation , Long> {
}
