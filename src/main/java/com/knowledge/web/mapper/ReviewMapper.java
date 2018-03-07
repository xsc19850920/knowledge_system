package com.knowledge.web.mapper;

import com.github.pagehelper.Page;
import com.knowledge.web.domain.Review;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;

/**
 * Created by zhangfulong on 17/12/25.
 */
public interface ReviewMapper {
    Page<Review> getReviews(@Param("keywords")String keywords);
    void deleteReview(@Param("id")BigInteger id);
    void insertReview(@Param("review") Review review);
    Review getReviewById(@Param("id")BigInteger id);
    void updateReview(@Param("review") Review review);
}
