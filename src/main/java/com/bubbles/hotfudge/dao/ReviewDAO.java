package com.bubbles.hotfudge.dao;

import java.util.List;

import com.bubbles.hotfudge.exceptions.HotFudgeDAOException;
import com.bubbles.hotfudge.model.Review;

public interface ReviewDAO {
	public void add(Review review) throws HotFudgeDAOException;
	public List<Review> findAll(int sundaeId);
	public int getCount();
}
