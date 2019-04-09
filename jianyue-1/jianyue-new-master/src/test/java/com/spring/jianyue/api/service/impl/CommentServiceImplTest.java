package com.spring.jianyue.api.service.impl;

import com.spring.jianyue.api.entity.vo.CommentVO;
import com.spring.jianyue.api.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {
    @Resource
    private CommentService commentService;

    @Test
    public void selectCommentsByAId() {
        List<CommentVO> commentVOS=commentService.selectCommentsByAId(1);
        System.out.println(commentVOS);
    }
}