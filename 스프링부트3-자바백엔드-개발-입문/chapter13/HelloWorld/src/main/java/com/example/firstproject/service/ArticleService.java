package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm articleDto) {
        Article article = articleDto.toEntity();
        if (article.getId() != null) {
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm articleDto) {
        Article article = articleDto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());

        Article target = articleRepository.findById(id).orElse(null);
        if (target == null || !id.equals(article.getId())) {
            log.info("Wrong Request! / id: {}, article: {}", id, article.toString());
            return null;
        }
        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;
    }

    public Article delete(Long id) {
        Article target = articleRepository.findById(id).orElse(null);
        if (target == null) {
            return null;
        }
        articleRepository.delete(target);
        return target;
    }

    public List<Article> createArticles(List<ArticleForm> dtoList) {
        List<Article> articles = dtoList.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());
        articles.stream().forEach(
                article -> articleRepository.save(article));
        // 강제 예외 발생
        articleRepository.findById(-1L)
                .orElseThrow(() -> new IllegalArgumentException("결제 실패"));
        return articles;
    }
}