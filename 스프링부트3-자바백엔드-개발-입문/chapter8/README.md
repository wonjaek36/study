# Chapter 8. 데이터 삭제하기

## 전체 프로세스
1. Delete 요청 핸들링 및 데이터 삭제
2. 삭제 성공 알람 띄우기

## 1. Delete 요청 핸들링 및 데이터 삭제
1. 상세 페이지(Show)에 Delete 버튼 추가 - show.mustache
2. (Article) Controller에 Delete 요청 핸들 함수 추가 - (/articles/{id}/delete)
3. DB에서 해당 데이터 불러보고, 있으면 삭제, 그리고 전체 목록 페이지로 리다이렉트

## 2. 삭제 성공 알림 띄우기
1. 전체 목록을 보면, 삭제가 성공되었음을 알 수 있지만, 데이터가 많으면 한 눈에 보이지 않기 때문에 알람을 추가
2. 데이터 삭제가 성공적으로 수행되었을 경우, 알람을 보내주기 위해서 Controller Delete 함수에 RedirectAttribute 추가 (Redirect되었을 때 Attribute를 전달하는 객체)
3. 휘발성 데이터 (한 번만 사용)를 추가하는 addFlashAttribute를 이용하여 삭제 성공 메세지 추가
4. header에서 해당 데이터 출력하도록 함 - layouts/header.mustache