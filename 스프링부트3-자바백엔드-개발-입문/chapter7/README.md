# Chapter 7. 게시글 수정하기

## Work Process
1. Edit 페이지로 기존 데이터 불러오기
2. 데이터 수정하고 DB에 반영
3. 데이터 상세 페이지로 Redirect

### Edit 페이지로 기존 데이터 불러오기
1. Edit 페이지 추가 - edit.mustache
2. 데이터 상세 페이지에서 Edit 페이지 버튼 추가 - show.mustache
3. 컨트롤러(ArticleController)에서 edit 페이지 요청 수신 (/articles/{id}/update)
4. DB(JPA - Repository)에서 해당 데이터 불러오고 edit 페이지로 모델 전달

### Edit 페이지에서 수정
1. 사용자가 수정하고 폼 데이터를 전달하고 나면,
2. 컨트롤러(ArticleController)에서 수정 요청 수신 (/articles/update) / Form DTO로 데이터 수신
3. DB 업데이트하고 상세 페이지(show)로 리다이렉트