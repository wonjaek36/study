package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        // 1. 예상 데이터
        Article data1 = new Article(1L, "title1", "content1");
        Article data2 = new Article(2L, "title2", "content2");
        Article data3 = new Article(3L, "title3", "content3");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(data1, data2, data3));
        // 2. 실제 데이터
        List<Article> articles = articleService.index();
        // 3. 비교 및 검증
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_성공_존재하는_id_입력() {
        // 1. 예상 데이터
        Long id = 1L;
        Article expected = new Article(1L, "title1", "content1");
        // 2. 실제 데이터
        Article article = articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_실패_존재하지_않는_id_입력() {
        // 1. 예상 데이터
        Long id = -1L;
        Article expected = null;
        // 2. 실제 데이터
        Article article = articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void create_성공_title_content_존재() {
        // 1. 예상 데이터
        String title = "title4";
        String content = "content4";
        Article expected = new Article(4L, title, content);
        // 2. 실제 데이터
        ArticleForm articleForm = new ArticleForm(null, title, content);
        Article article = articleService.create(articleForm);
        // 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_실패_id가_포함된_dto() {
        // 1. 예상 데이터
        Long id = 4L;
        String title = "title4";
        String content = "content4";
        Article expected = null;
        // 2. 실제 데이터
        ArticleForm articleForm = new ArticleForm(id, title, content);
        Article article = articleService.create(articleForm);
        // 3. 비교 및 검증
        assertEquals(expected, article);
    }
}