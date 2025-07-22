package com.telusko.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.exception.TouristNotFoundException;
import com.telusko.model.Tourist;
import com.telusko.repo.ITouristRepo;

@Service
public class TouristService implements ITouristService
{

	private ITouristRepo repo;
	
	
	@Autowired
	public void setRepo(ITouristRepo repo) {
		this.repo = repo;
	}

	@Override
	public String registerTourist(Tourist tourist) 
	{
		Tourist tr = repo.save(tourist);
		return "Tourist is saved with Id "+tr.getId();
	}

	@Override
	public Tourist fetchTouristById(Integer id) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else throw new TouristNotFoundException("Tourist with given id not found");
		
	}

	@Override
	public List<Tourist> fetchAllTouristInfo() {
		return repo.findAll();
	}

	@Override
	public String updateTouristInfo(Tourist tourist) {
		Optional<Tourist> optional = repo.findById(tourist.getId());
		if(optional.isPresent())
		{
			repo.save(tourist);
			return "Tourist info saved successfully";
		}
		else throw new TouristNotFoundException("Tourist with given id does not exist");
			
	}

	@Override
	public String updateTheTouristBudget(Integer id, Double budget) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent())
		{
			Tourist tourist = optional.get();
			tourist.setBudget(budget);
			repo.save(tourist);
			return "Tourist data saved successfully";
		}
		else throw new TouristNotFoundException("Tourist with given id does not exist");
	}

	@Override
	public String deleteTouristInfoById(Integer id) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent())
		{
		repo.deleteById(id);
		return "Tourist data deleted successfully";
		}
		else throw new TouristNotFoundException("Tourist with given data not exist");
	}

}
