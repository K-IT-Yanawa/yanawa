document.addEventListener("DOMContentLoaded", function () {
    const dropdown = document.querySelector(".wrap7");
    const rotateIcon = document.querySelector(".rotate");
    const dropdownMenu = document.querySelector(".dropdown-menu"); // 드롭다운 메뉴
    // const pageWrap = document.getElementById("page-wrap");
    // let text = ``;


    // 드롭다운 클릭 시 class 추가 및 제거
    dropdown.addEventListener("click", function () {
        this.classList.toggle("open");
        dropdownMenu.classList.toggle("open"); // dropdownMenu의 open 클래스 토글
        rotateIcon.classList.toggle("open");
    });

    // 드롭다운 외부 클릭 시 닫기
    document.addEventListener("click", function (event) {
        if (!dropdown.contains(event.target)) {
            dropdown.classList.remove("open");
            dropdownMenu.classList.remove("open"); // dropdownMenu의 open 클래스 제거
            rotateIcon.classList.remove("open");
        }
    });

    // text = ``;
    // for(let i=0; i<pagination.pageCount; i++)


});
