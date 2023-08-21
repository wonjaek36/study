# Chapter 10. Rest API와 JSON

## 1. Rest API
* Rest API(Representational State Transfer API)는 서버의 자원을 클라이언트 종류에 관계 없이 사용할 수 있도록 하는 설계 방식
* 일반적으로 Rest API 방식에서는 HTTP의 요청에 대한 응답으로 서버의 자원을 반환
* 서버는 클라이언트의 요청에 화면(View)이 아닌 데이터를 반환하며, 데이터의 타입은 JSON을 주로 사용
* 참고) API(Application Programming Interface)란 클라이언트와 서버 간에 미리 정해놓은 약속입니다. API를 통해 서버는 클라이언트에게 (서버의) 자원을 어떻게 사용할 것 인지 정해줍니다.

## 2. Rest API Method
1. GET: 데이터 조회
2. POST: 데이터 생성
3. DELETE: 데이터 삭제
4. PATCH: 데이터 변경(오브젝트의 일부 데이터만 변경할 때 주로 사용)
5. PUT: 데이터 변경(오프젝트의 모든 데이터를 전달되는 값으로 변경, 만약 없다면 새로 생성)

참고: 일반적으로 사용(권고)하는 방식일 뿐, 절대적인 것은 아님

## 3. HTTP 상태 코드
| 상태코드 | 설명 |
|---|---|
| 1XX | 요청 수신하여 처리 중 |
| 2XX | 요청 정상 처리 |
| 3XX | 추가 행동(작업) 요청 |
| 4XX | 클라이언트 요청이 잘 못 되어 서버가 작업할 수 없음 |
| 5XX | 서버 내부에 에러가 발생하여 클라이언트 요청 수행 불가 |

더 자세한 정보는 [MDN 문서](https://developer.mozilla.org/ko/docs/Web/HTTP/Status#%EB%A6%AC%EB%8B%A4%EC%9D%B4%EB%A0%89%EC%85%98_%EB%A9%94%EC%8B%9C%EC%A7%80)에서 확인

## 4. HTTP Request Test Chrome Plugins
* [Talend API Test](https://chrome.google.com/webstore/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm/related)