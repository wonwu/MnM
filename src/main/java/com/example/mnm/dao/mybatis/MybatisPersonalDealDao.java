package com.example.mnm.dao.mybatis;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.mnm.dao.PersonalDealDao;
import com.example.mnm.dao.mybatis.mapper.PersonalDealMapper;
import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.domain.Item;

@Repository
public class MybatisPersonalDealDao implements PersonalDealDao{
	
	@Autowired
	private PersonalDealMapper personalDealMapper;
	
	public List<PersonalDealItem> getAllPersonalDealItems() throws DataAccessException{
		return personalDealMapper.getPersonalDealItemList();
	}	

	public List<PersonalDealItem> getPersonalDealItemList() throws DataAccessException{
		return personalDealMapper.getPersonalDealItemList();
	}

	@Override
	public PersonalDealItem getPersonalDealItemById(String personalDealId) {
		return personalDealMapper.getPersonalDealItemById(personalDealId);
	}
	public void addPersonalDealItem(PersonalDealItem personalDealItem) throws DataAccessException{
		personalDealMapper.addPersonalDealItem(personalDealItem);
	}
	
	public void addItem(Item item) throws DataAccessException{
		personalDealMapper.addItem(item);
	}
	
	public void removeItemById(String itemId) throws DataAccessException{
		personalDealMapper.removeItemById(itemId);
	}

	@Override
	public void updatePersonalDealItem(PersonalDealItem personalDealItem) {
		personalDealMapper.updatePersonalDealItem(personalDealItem);
		
	}
	
	public void finishDealById(int userId, PersonalDealItem personalDealItem) throws DataAccessException{
		personalDealMapper.finishDealById(userId, personalDealItem);
	}

	@Override
	public List<PersonalDealItem> searchPersonalDealItemList(String word) {
		return personalDealMapper.searchPersonalDealItemList(word);
	}

	@Override
	public List<PersonalDealItem> getNewestPersonalDealItemList() {
		return personalDealMapper.getNewestPersonalDealItemList();
	}

	@Override
	public List<PersonalDealItem> getPopularPersonalDealItemList() {
		return personalDealMapper.getPopularPersonalDealItemList();
	}

	@Override
	public List<PersonalDealItem> getLowestPricePersonalDealItemList() {
		return personalDealMapper.getLowestPricePersonalDealItemList();
	}

	@Override
	public List<PersonalDealItem> getHightestPricePersonalDealItemList() {
		return personalDealMapper.getHightestPricePersonalDealItemList();
	}

	@Override
	public List<PersonalDealItem> getFourPersonalDealItemList() {
		return personalDealMapper.getFourPersonalDealItemList();
	}

	@Override
	public PersonalDealItem getPersonalDealItem(String personalDealId) {
		return personalDealMapper.getPersonalDealItem(personalDealId);
	}

	@Override
	public void removePersonalDealItem(String personalDealId) {
		personalDealMapper.removePersonalDealItem(personalDealId);
	}

	@Override
	public List<PersonalDealItem> getPersonalDealItemListById(String userId) {
		return personalDealMapper.getPersonalDealItemListById(userId);
	}

}
