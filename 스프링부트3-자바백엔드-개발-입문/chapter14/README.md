# Chapter 14. 댓글 엔티티와 레퍼지터리 생성

## Summary
1. Database에서 Table 간의 관계가 1:1 / 1:N / N:M 이 될 수 있음
2. Entity가 자신을 대표하는 값을 대표값(PK)라 하고, 다른 엔티티를 참조하는 값을 외래키(FK)라고 함
3. 다대일을 구성하는 방식으로 ManyToOne, JoinColumn 어노테이션 사용 (아래 참고)
4. 레퍼지토리의 메서드로 쿼리를 작성해서 실행하는 것을 네이티브 쿼리 메서드라고 함
  * @Query 어노테이션과 XML 사용 방식이 있음
5. JPA 테스트 하기 위해서 @DataJpaTest 어노테이션 이용
6. 테스트 결과 출력은 일반적으로 함수명 그대로 노출
  * 노출되는 이름을 바꾸고 싶다면, DisplayName 어노테이션 사용

## Entity 다대일 구성
* Comment는 Article에 속하는 Entity
  * DB 관점에서는 Comment는 Article을 참조하는 Entity
* 멤버 변수 Article에 다대일 관계(@OneToMany)와 외래키(@JoinColumn) 명시
```java
// 클래스 어노테이션 생략
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    // Primary Key
    private Long id;

    @ManyToOne
    @JoinColumn(name="article_id") // Foreign Key
    private Article article; // Referenced Entity

    @Column
    private String nickname;

    @Column
    private String body;
}
```
