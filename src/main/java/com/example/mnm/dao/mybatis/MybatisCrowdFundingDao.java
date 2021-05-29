package com.example.mnm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.mnm.dao.CrowdFundingDao;
import com.example.mnm.dao.mybatis.mapper.CrowdFundingMapper;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.FundingForm;
import com.example.mnm.domain.Item;

@Repository
public class MybatisCrowdFundingDao implements CrowdFundingDao{
	
	@Autowired CrowdFundingMapper crowdFundingMapper;

	@Override
	public List<CrowdFundingItem> getAllFundingItems() throws DataAccessException {
		return crowdFundingMapper.getAllFundingItems();
	}

	@Override
	public CrowdFundingItem getFundingItemById(String crowdFundingId) throws DataAccessException {
		return crowdFundingMapper.getFundingItemById(crowdFundingId);
	}

	@Override
	public void addFundingItem(CrowdFundingItem crowdFundingItem) throws DataAccessException {
		crowdFundingMapper.addFundingItem(crowdFundingItem);
	}
	@Override
	public void addItem(Item item) throws DataAccessException {
		crowdFundingMapper.addItem(item);
	}

	@Override
	public void removeFundingItemById(String itemId) throws DataAccessException {
		crowdFundingMapper.removeFundingItemById(itemId);
	}
	@Override
	public void removeItemById(String itemId) throws DataAccessException {
		crowdFundingMapper.removeItemById(itemId);
		
	}

	@Override
	public void updateFundingItemById(String crowdFundingId, CrowdFundingItem crowdFundingItem) throws DataAccessException {
		crowdFundingMapper.updateFundingItemById(crowdFundingId, crowdFundingItem);
	}

	@Override
	public void fund(FundingForm fundingForm) throws DataAccessException {
		crowdFundingMapper.fund(fundingForm);
	}
	@Override
	public void fund2(FundingForm fundingForm) throws DataAccessException {
		crowdFundingMapper.fund2(fundingForm);
	}
	@Override
	public void fundUpdate(FundingForm fundingForm) throws DataAccessException {
		crowdFundingMapper.fundUpdate(fundingForm);
	}
	
	@Override
	public List<CrowdFundingItem> getMyFundingItemListById(String userId) {
		return crowdFundingMapper.getMyFundingItemListById(userId);
	}

	@Override
	public void updateItemById(String itemId, Item item) throws DataAccessException {
		crowdFundingMapper.updateItemById(itemId, item);
	}

	@Override
	public List<CrowdFundingItem> getMyFundingItemsCheckoutById(String userId) throws DataAccessException {
		return crowdFundingMapper.getMyFundingItemsCheckoutById(userId);
	}

	@Override
	public List<CrowdFundingItem> getFourCrowdFundingItemList() throws DataAccessException {
		return crowdFundingMapper.getFourCrowdFundingItemList();
	}


}
