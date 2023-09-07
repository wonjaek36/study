# Chapter 19. 댓글 삭제하기

## Summary
* 삭제 버튼 추가
* querySelectorAll로 모든 삭제버튼을 설정하고, 클릭시 삭제 요청 전달

## Example
```javascript
// 모든 버튼 select
const commentDeleteBtns = document.querySelectorAll(".comment-delete-btn");

// for Each로 각 버튼 별 Click Listener 추가
commentDeleteBtns.forEach((btn) => {
    btn.addEventListener("click", (event) => {
    	// event target 받고
        const commentDeleteBtn = event.target;
        // button의 id 값
        const commentId = commentDeleteBtn.getAttribute("data-comment-id");
        // ...

        const url = `/api/comments/${commentId}`;
        fetch(url, {
            method: "DELETE"
        }).then(response => {
        	// 실패 처리
        	// 성공 처리 
        })
    });
});
```