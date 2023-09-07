package com.example.firstproject.entity;

import com.example.firstproject.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="article_id")
    private Article article;

    @Column
    private String nickname;

    @Column
    private String body;

    public static Comment createComment(CommentDto commentDto, Article article) {
        // 예외 발생
        // 1. id가 이미 있는 이유 -> 댓글 생성 전에 id가 있으면 안됨
        if (commentDto.getId() != null)
            throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id가 없어야 합니다.");
        // 2. 게시글과 부모 게시글의 id가 다른 경우
        if (!commentDto.getArticleId().equals(article.getId()))
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘 못 됐습니다.");
        return new Comment(
                null,
                article,
                commentDto.getNickname(),
                commentDto.getBody());
    }

    public void patch(CommentDto commentDto) {
        // 예외 발생
        if (this.id != commentDto.getId())
            throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력되었습니다.");
        // 객체 갱신
        if (commentDto.getNickname() != null)
            this.nickname = commentDto.getNickname();
        if (commentDto.getBody() != null)
            this.body = commentDto.getBody();
    }
}
