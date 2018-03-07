package com.knowledge.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.knowledge.web.dao.ReviewDao;
import com.knowledge.web.dao.UserDao;
import com.knowledge.web.domain.Review;
import com.knowledge.web.domain.User;
import com.knowledge.web.util.IPUtil;
import com.knowledge.web.util.PageInfo;
import com.knowledge.web.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

/**
 * Created by zhangfulong on 17/12/25.
 */
@Controller
@RequestMapping("/")
public class ReviewController {

    @Autowired
    private ReviewDao reviewDao;

    @RequestMapping(value = "/getReviews",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<Review> getReviews(String keywords, int pageNo, int pageSize) throws Exception {
        Page<Review> reviews = reviewDao.getReviews(pageNo, pageSize,keywords);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<Review> pageInfo = new PageInfo<Review>(reviews);
        return pageInfo;
    }

    @RequestMapping(value = "/deleteReview",method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteReview(@RequestParam(value="id") BigInteger id) throws Exception {
        reviewDao.deleteReview(id);
        return true;
    }

    @RequestMapping(value = "/insertReview",method = RequestMethod.POST)
    @ResponseBody
    public Boolean insertReview(String title,String fileSrc,Integer stateType,String operIp, BigInteger operUserId) throws Exception {
        Review review = new Review();
        review.setReviewId(BigInteger.valueOf(System.currentTimeMillis()));
        review.setDelFlag(false);
        review.setFileSrc(fileSrc);
        review.setTitle(title);
        review.setOperIp(IPUtil.Ip2Int(operIp)<0?-IPUtil.Ip2Int(operIp):IPUtil.Ip2Int(operIp));
        review.setOperUserId(operUserId);
        review.setStateType(stateType);
        review.setCreateTime(BigInteger.valueOf(TimeUtil.getCurrentTimeStamp()));
        review.setModifyTime(BigInteger.valueOf(TimeUtil.getCurrentTimeStamp()));
        reviewDao.insertReview(review);
        return true;
    }

    @RequestMapping(value = "/getReviewById",method = RequestMethod.POST)
    @ResponseBody
    public Review getReviewById(@RequestParam(value="id") BigInteger id) {
        return reviewDao.getReviewById(id);
    }


    @RequestMapping(value = "/updateReview",method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateReview(@RequestBody Review review) throws Exception {
        review.setModifyTime(BigInteger.valueOf(TimeUtil.getCurrentTimeStamp()));
        reviewDao.updateReview(review);
        return true;
    }

}
