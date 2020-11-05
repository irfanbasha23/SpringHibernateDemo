package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Panel;

@Repository
public interface PanelRepository extends CrudRepository<Panel,Long>{

	public List<Panel> findByTechStreams(String techStream);
	
	public Panel findByPanelId(Long id);
}
