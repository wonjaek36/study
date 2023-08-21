# Chapter 11. Rest API 구현

## Work Process
1. 조회 요청(GET)
    * 전체 조회: /api/articles
    * 개별 상세 조회: /api/articles/{id}
2. 생성 요청(POST)
    * 새로운 데이터(Article) 추가: /api/articles
3. 수정 요청(PATCH)
    * 주어진 데이터로 수정: /api/articles/{id}
4. 삭제 요청(DELETE)
    * 주어진 id 데이터 삭제: /api/articles/{id}

## 공통
* 클래스 어노테이션에 RestController 적용 - Rest API는 RequestBody를 리턴
```java
@RestController
public class ArticleApiController {
    // 생략 ...
```

## 조회 요청(GET)
* articleRespository에서 불러온 데이터를 반환
    * ResponseEntity로 감싸거나 불러온 데이터 그대로 반환
```java
// GET
@GetMapping("/api/articles")
public List<Article> index() {
    return articleRepository.findAll();
}

@GetMapping("/api/articles/{id}")
public Article show(@PathVariable Long id) {
    return articleRepository.findById(id).orElse(null);
}
```

## 생성 요청(POST)
* 요청과 함께 들어온 데이터를 Entity로 변환하고 추가
    * DTO에는 @RequestBody 어노테이션을 붙여야 정상적으로 전달 받을 수 있음(PATCH도 동일)
```java
// POST
@PostMapping("/api/articles")
public Article create(@RequestBody ArticleForm dto) {
    System.out.println(dto.toString());
    Article article = dto.toEntity();
    return articleRepository.save(article);
}
```

## 수정 요청(PATCH)
* 수정 요청된 id를 검색하고, 있으면 업데이트
* 일부분만 수정하는 부분을 위해서 Entity 클래스인 Article에 patch 함수 구현
```java
// PATCH
@PatchMapping("/api/articles/{id}")
public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
    Article article = dto.toEntity();

    Article target = articleRepository.findById(id).orElse(null);
    if (target == null || !id.equals(article.getId())) { 
        // 비정상 요청 (없는 데이터 or URL id와 RequestBody id 일치하지 않음)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    
    // 정상 요청
    target.patch(article);
    Article updated = articleRepository.save(target);
    return ResponseEntity.status(HttpStatus.OK).body(updated);
}
```

## 삭제 요청(DELETE)
* 삭제 요청된 id를 검색하고, 있다면 삭제
```java
@DeleteMapping("/api/articles/{id}")
public ResponseEntity<Article> delete(@PathVariable Long id) {
    Article target = articleRepository.findById(id).orElse(null);
    if (target == null) { // 비정상 요청 (없는 데이터)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    articleRepository.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).build();
}
```