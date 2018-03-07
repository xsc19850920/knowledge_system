package com.knowledge.web.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.knowledge.web.domain.Review;
import com.knowledge.web.domain.User;
import com.knowledge.web.mapper.ReviewMapper;
import com.knowledge.web.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class ReviewDao {

    @Autowired
    private ReviewMapper reviewMapper;
    public Page<Review> getReviews(int pageNo, int pageSize, String keywords) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        return reviewMapper.getReviews(keywords);
    }


    public void deleteReview(BigInteger id) throws Exception {
        reviewMapper.deleteReview(id);
    }

    public void insertReview(Review review){
        reviewMapper.insertReview(review);
    }

    public Review getReviewById(BigInteger id){
        return reviewMapper.getReviewById(id);
    }

    public void updateReview(Review review){
        reviewMapper.updateReview(review);
    }
}
