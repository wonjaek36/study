# Chapter 15. 댓글 컨트롤러와 서비스 만들기

## Summary
1. Article 컨트롤러와 서비스를 만드는 것과 마찬가지 방식으로 개발
2. Comment는 Article과 연결되어있기 때문에, 그 점을 고려하여 개발
  * 예를 들어, Comment 생성 때, URL과 RequestBody의 ArticleId가 다르다면, 업데이트 방지한다. (아래 예제 참고)

## Examples
```java
// CommentService.java
@Transactional
public CommentDto create(Long articleId, CommentDto commentDto) {
    // 1. 게시글 조회 및 예외 발생
    Article article = articleRepository.findById(articleId).orElseThrow(
            () -> new IllegalArgumentException("댓글 생성 실패! " + "대상 게시글이 없습니다."));
    // 2. 댓글 엔티티 생성
    Comment comment = Comment.createComment(commentDto, article);
    // 3. 댓글 엔티티를 DB에 생성
    Comment created = commentRepository.save(comment);
    // 4. DTO로 변환해 반환
    return CommentDto.createCommentDto(created);
}
```