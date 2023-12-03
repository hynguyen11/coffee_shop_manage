	package com.cafeshopmanage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeshopmanage.entity.Position;
import com.cafeshopmanage.model.PositionModel;
import com.cafeshopmanage.repository.PositionRepository;
import com.cafeshopmanage.utils.MapperUtils;

@Service
public class PositionService {

	@Autowired
	 PositionRepository  positionRepository;

	public List<PositionModel> getAllPosition() {
		List<PositionModel> listPositionModel = new ArrayList<>();
		List<Position> listPosition = positionRepository.findAll();
		for (Position position : listPosition) {
			PositionModel positionModel = new PositionModel();
			MapperUtils.map(position, positionModel);
			listPositionModel.add(positionModel);
		}
		return listPositionModel;
	}
	
	public PositionModel getPosition(Integer id) {
		Optional<Position> position = positionRepository.findById(id);
		if (position.isPresent()) {
			PositionModel model = new PositionModel();
			MapperUtils.map(position.get(), model);
			return model;
		}
		return new PositionModel();
	}
	
	public void createUpdatePosition(PositionModel positionModel) {
		Position position = null;
		if (positionModel.getId() != null) {
			Optional<Position> positionEntity = positionRepository.findById(positionModel.getId());
			if (positionEntity.isPresent()) {
				position = positionEntity.get();
			}
		}
		if (position == null) {
			position = new Position();
		}

		MapperUtils.map(positionModel, position);
		positionRepository.save(position);
	}

	public void deletePosition(PositionModel positionModel) {
		positionRepository.deleteById(positionModel.getId());
	}
}
