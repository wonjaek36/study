# Chapter 9. CRUD와 SQL 정리

## ID 자동생성을 DB가 하도록 수정
1. Entity Article에서 Long ID에 데코레이터 @GeneratedValue(strategy = GenerationType.IDENTITY) 추가
2. 위 데코레이터 추가하면, Database에서 ID를 자동으로 추가

데이터베이스는 패스