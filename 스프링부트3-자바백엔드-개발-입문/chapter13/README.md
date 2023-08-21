# Chapter 13. 테스트 코드 작성하기

## 전체 프로세스
1. ServiceTest Class 생성 및 @SpringBootTest 어노테이션 할당
2. Service Class 의존성 주입 (필드 주입)
3. @Test 함수 정의
  * expected값과 service의 결과 값이 같도록 테스트 함수 구현
4. DB의 값을 바꾸는 함수는 @Transactional 어노테이션 할당
  * 다른 Test 케이스에 영향이 갈 수 있기 때문