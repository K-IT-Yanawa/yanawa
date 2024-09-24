document.addEventListener("DOMContentLoaded", function () {
    const titleInput = document.getElementById("content7");
    const descriptionInput = document.getElementById("content13");
    const charCountElement = document.getElementById("char-count");
    const maxLength = 45;

    titleInput.addEventListener("input", function () {
        const currentLength = titleInput.value.length;
        charCountElement.textContent = `${currentLength}/${maxLength}`;

        // 제목 글자 수 초과 시 제한(이미 만들어놔서 지우지않음)
        if (currentLength > maxLength) {
            titleInput.value = titleInput.value.slice(0, maxLength);
            charCountElement.textContent = `${maxLength}/${maxLength}`;
            alert("제목은 최대 45자까지 입력 가능합니다.");
        }

        // 타이핑 시 테두리 복원
        if (titleInput.classList.contains("error")) {
            titleInput.classList.remove("error");
            titleInput.style.borderColor = "#e1e3e8";
        }
    });

    descriptionInput.addEventListener("input", function () {
        // 타이핑 시 테두리 복원
        if (descriptionInput.classList.contains("error")) {
            descriptionInput.classList.remove("error");
            descriptionInput.style.borderColor = "#e1e3e8";
        }
    });

    // 폼 제출 시 내용이 없으면 빨간 테두리 적용
    const form = document.querySelector("form");
    form.addEventListener("submit", function (e) {
        let hasError = false;

        if (titleInput.value.trim() === "") {
            e.preventDefault();
            titleInput.classList.add("error");
            titleInput.style.borderColor = "red";
            hasError = true;
        }

        if (descriptionInput.value.trim() === "") {
            e.preventDefault();
            descriptionInput.classList.add("error");
            descriptionInput.style.borderColor = "red";
            hasError = true;
        }

        if (hasError) {
            alert("모든 필드를 작성해주세요.");
        }
    });
});
