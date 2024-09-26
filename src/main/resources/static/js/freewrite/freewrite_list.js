document.addEventListener("DOMContentLoaded", function () {
    const dropdown = document.querySelector(".wrap7");
    const rotateIcon = document.querySelector(".wrap8 img"); // 드롭다운 아이콘 회전
    const content23 = document.querySelector(".content23"); // 페이지네이션의 "..."
    const pageWrap = document.getElementById("page-wrap");
    const posts = [[${posts}]]; // 게시글 데이터
    const pagination = [[${pagination}]]; // 페이지네이션 데이터

    dropdown.addEventListener("click", function () {
        this.classList.toggle("open");
        rotateIcon.classList.toggle("open");
    });

    document.addEventListener("click", function (event) {
        if (!dropdown.contains(event.target)) {
            dropdown.classList.remove("open");
            rotateIcon.classList.remove("open");
        }
    });

    // 게시글 리스트 렌더링
    const table = document.getElementById("post-table");
    let text = ``;
    posts.forEach((post) => {
        text += `
            <tr>
                <td>${post.id}</td>
                <td>${post.memberName}</td>
                <td>${post.postTitle}</td>
                <td>${post.postReadCount}</td>
                <td>${post.createdDate}</td>
            </tr>
        `;
    });
    table.innerHTML += text;

    // 페이지네이션 렌더링
    text = ``;
    for(let i=0; i<pagination.pageCount; i++) {
        text += `<a href="/post/list?page=${i+1}">${i+1}</a>`;
    }
    pageWrap.innerHTML = text;

    // 페이지네이션 및 드롭다운 관련 스타일 적용
    if (pagination.pageCount > 5) {
        content23.style.display = "inline-flex"; // 페이지가 5개 이상이면 "..." 표시
    } else {
        content23.style.display = "none"; // 5개 이하이면 "..." 숨기기
    }
});
