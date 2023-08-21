# Chapter 12. 서비스와 트랜잭션

## Summary
1. 서비스는 컨트롤러와 레퍼지토리 사이의 계층으로 비즈니스 로직을 담당
2. 트랜잭션이란 쪼갤 수 없는 업무의 최소 단위
  * 트랜잭션 중간에 작업이 실패한다면, 트랜잭션이 발생하기 이전 상태로 되돌려야 한다(롤백).

## Service
1. Service 객체 생성 및 Annotation 추가
```java
// service/ArticleService.java
@Service
public class ArticleService {
}
```

2. (Update) ArticleController에서 비즈니스 로직 부분만 발췌
```java
// api/ArticleApiController.java
@PatchMapping("/api/articles/{id}")
public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
    Article article = dto.toEntity();
    /*** Business Logic Part ***/
    log.info("id: {}, article: {}", id, article.toString());

    Article target = articleRepository.findById(id).orElse(null);
    if (target == null || !id.equals(article.getId())) {
        log.info("Wrong Request! / id: {}, article: {}", id, article.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    target.patch(article);
    Article updated = articleRepository.save(target);
    /*** End of Business Logic Part ***/
    return ResponseEntity.status(HttpStatus.OK).body(updated);
}
```

3. (Update) 비즈니스 로직은 Service, 데이터 Request & Response는 컨트롤러
```java
// api/ArticleApiController.java
@PatchMapping("/api/articles/{id}")
public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
    Article updated = articleService.update(id, dto);
    return updated != null ?
            ResponseEntity.status(HttpStatus.OK).body(updated) :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
}

// service/ArticleService.java
public Article update(Long id, ArticleForm articleDto) {
    // Dto -> Entity
    Article article = articleDto.toEntity();
    log.info("id: {}, article: {}", id, article.toString());

    Article target = articleRepository.findById(id).orElse(null);
    if (target == null || !id.equals(article.getId())) {
        // Update할 데이터가 없다면, 에러 반환
        log.info("Wrong Request! / id: {}, article: {}", id, article.toString());
        return null;
    }
    
    // Update
    target.patch(article);
    Article updated = articleRepository.save(target);
    return updated;
}
```

## Transactional
1. Transaction 기능이 필요한 비즈니스 로직 함수에 @Transactional 어노테이션 추가
```java
// Example)
@PostMapping("/api/transaction-func")
@Transactional
public ResponseEntity<List<SomeClass>> TransactionFunc(@RequestBody List<SomeClass> Data) {
    /* Logic 생략 */
}
```
