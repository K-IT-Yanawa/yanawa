document.addEventListener("DOMContentLoaded", function () {
    const dropdown = document.querySelector(".wrap7");
    const rotateIcon = document.querySelector(".wrap8 img"); // 드롭다운 아이콘 회전
    const content23 = document.querySelector(".content23");
    const wrap11Items = document.querySelectorAll("ul.sc-86909102-1"); // 게시글을 포함한 ul 요소들
    const paginationItems = document.querySelectorAll(".wrap21 li");
    const lastPageItem = document.querySelector(".content24");
    const nextPageItem = document.querySelector(".content25");
    const itemsPerPage = 12;
    const totalPages = Math.ceil(wrap11Items.length / itemsPerPage);

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

    // 페이지네이션 초기화
    paginationItems.forEach((item, index) => {
        if (index >= 1 && index <= totalPages) {
            item.style.display = "inline-flex";
        } else if (index > totalPages && item.querySelector("a")) {
            item.style.display = "none";
        }
    });

    // 마지막 페이지 번호 갱신
    lastPageItem.querySelector("a").textContent = totalPages;

    // 게시글이 40개 이상일 경우 "..." 표시 및 마지막 페이지 번호 갱신
    if (wrap11Items.length > 40) {
        content23.style.display = "inline-flex";
        nextPageItem.style.display = "inline-flex";
        content23.insertAdjacentHTML("beforeend", `<span>${totalPages}</span>`);
    } else {
        // 게시글이 40개 미만일 경우 "..." 숨기고 ">" 버튼 표시
        content23.style.display = "none";
        nextPageItem.style.display = totalPages > 1 ? "inline-flex" : "none";
    }

    // 게시글이 12개 이하인 경우, 페이지네이션 버튼 숨기기
    if (totalPages <= 1) {
        nextPageItem.style.display = "none";
    }
});
