document.addEventListener("DOMContentLoaded", function () {
    const commentList = document.getElementById("customCommentList");
    const prevBtn = document.getElementById("prevBtn");
    const nextBtn = document.getElementById("nextBtn");
    const pageNumDisplay = document.getElementById("pageNumDisplay"); // 페이지 번호 표시용 엘리먼트 추가
    const comments = commentList.getElementsByClassName("custom-comment-item");
    const commentTextArea = document.getElementById("commentTextArea");
    const charCountDisplay = document.getElementById("comment-char-count");
    let currentPage = 0;
    const commentsPerPage = 5;
    const totalPages = Math.ceil(comments.length / commentsPerPage);

    commentTextArea.addEventListener("input", function () {
        const currentLength = commentTextArea.value.length;
        charCountDisplay.textContent = `${currentLength}/200`;
    });

    function updateButtonStyles() {
        if (currentPage === 0) {
            prevBtn.disabled = true;
            prevBtn.style.backgroundColor = "#ccc"; // 비활성화 색상
        } else {
            prevBtn.disabled = false;
            prevBtn.style.backgroundColor = ""; // 기본 색상으로 복구
        }

        if (currentPage === totalPages - 1) {
            nextBtn.disabled = true;
            nextBtn.style.backgroundColor = "#ccc"; // 비활성화 색상
        } else {
            nextBtn.disabled = false;
            nextBtn.style.backgroundColor = ""; // 기본 색상으로 복구
        }
    }

    function showComments() {
        for (let i = 0; i < comments.length; i++) {
            comments[i].style.display = "none";
        }
        const start = currentPage * commentsPerPage;
        const end = Math.min(start + commentsPerPage, comments.length);
        for (let i = start; i < end; i++) {
            comments[i].style.display = "block";
        }
        updateButtonStyles();

        // 페이지 번호 표시
        pageNumDisplay.innerText = currentPage + 1;
    }

    prevBtn.addEventListener("click", function () {
        if (currentPage > 0) {
            currentPage--;
            showComments();
        }
    });

    nextBtn.addEventListener("click", function () {
        if ((currentPage + 1) * commentsPerPage < comments.length) {
            currentPage++;
            showComments();
        }
    });

    showComments(); // 초기 페이지의 댓글만 표시


});
// document.querySelector('.comment-submit-button').addEventListener('click', function (event) {
//     event.preventDefault();
//
//     const replyContent = document.getElementById('commentTextArea').value;
//     const postId = document.querySelector('input[name="postId"]').value;
//     const memberId = document.querySelector('input[name="memberId"]').value;
//
//     if (!replyContent) {
//         alert('댓글을 입력해주세요.');
//         return;
//     }
//
//     const newComment = `
//         <li class="custom-comment-item">
//             <div class="custom-comment-content">
//                 <div class="custom-comment-meta">
//                     <div class="custom-comment-author-wrap">
//                         <div class="custom-comment-image-container">
//                             <img src="https://graph.facebook.com/1250712788378615/picture?height=300&width=300" alt="사용자 이미지" class="custom-comment-image" />
//                         </div>
//                         <div class="custom-comment-author">새로운 닉네임</div>
//                     </div>
//                 </div>
//                 <div class="custom-comment-body">
//                     <h3 class="custom-comment-text">${replyContent}</h3>
//                     <div class="custom-comment-time">방금 전</div>
//                 </div>
//             </div>
//         </li>
//     `;
//
//     document.getElementById('customCommentList').insertAdjacentHTML('beforeend', newComment);
//
//     document.getElementById('commentTextArea').value = '';  // 댓글 입력창 초기화
//     document.getElementById('comment-char-count').textContent = '0/200';
//});
