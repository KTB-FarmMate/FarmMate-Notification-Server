package com.farmmate.notification.crop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmmate.notification.crop.entity.Crop;

public interface CropRepository extends JpaRepository<Crop, Integer> {
}
