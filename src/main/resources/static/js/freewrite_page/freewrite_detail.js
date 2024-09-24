document.addEventListener("DOMContentLoaded", function () {
    const commentList = document.getElementById("customCommentList");
    const prevBtn = document.getElementById("prevBtn");
    const nextBtn = document.getElementById("nextBtn");
    const pageNumDisplay = document.getElementById("pageNumDisplay"); // 페이지 번호 표시용 엘리먼트 추가
    const comments = commentList.getElementsByClassName("custom-comment-item");
    let currentPage = 0;
    const commentsPerPage = 5;
    const totalPages = Math.ceil(comments.length / commentsPerPage);

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
