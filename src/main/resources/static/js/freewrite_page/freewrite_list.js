document.addEventListener("DOMContentLoaded", function () {
    const dropdown = document.querySelector(".wrap7");
    const rotateIcon = document.querySelector(".rotate");
    const dropdownMenu = document.querySelector(".dropdown-menu"); // 드롭다운 메뉴
    const selectedValue = document.querySelector(".selected-value"); // 선택된 값 표시 엘리먼트

    // URL에서 파라미터 값을 가져오는 함수
    function getParameterByName(name) {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get(name);
    }

    // order 파라미터 확인
    const order = getParameterByName('order');

    // 파라미터 값이 'popular'이면 텍스트를 '조회수 높은 순'으로 변경
    if (order === 'popular') {
        selectedValue.textContent = "조회수 높은 순";
    } else {
        selectedValue.textContent = "최신 업데이트 순";
    }

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


});
