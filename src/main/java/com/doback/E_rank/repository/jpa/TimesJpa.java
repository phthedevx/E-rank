package com.doback.E_rank.repository.jpa;

import com.doback.E_rank.models.TimesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesJpa extends JpaRepository<TimesModel, Integer> {
}