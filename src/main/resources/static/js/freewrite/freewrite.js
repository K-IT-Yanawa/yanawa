document.addEventListener("DOMContentLoaded", function () {
    const titleInput = document.getElementById("content7");
    const descriptionInput = document.getElementById("content13");
    const charCountElement = document.getElementById("char-count");
    const maxLength = 45;
    const categoryInput = document.getElementById("editSportKind");
    const filePathInput = document.getElementById("content17"); // 파일 경로

    // 제목 입력 시 글자 수 카운트
    titleInput.addEventListener("input", function () {
        const currentLength = titleInput.value.length;
        charCountElement.textContent = `${currentLength}/${maxLength}`;

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

    // 내용 입력 시 테두리 복원
    descriptionInput.addEventListener("input", function () {
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
            return; // 오류가 있을 경우 서버로 데이터를 전송하지 않음
        }

        // 서버에 전달할 데이터 수집
        const postData = {
            category: categoryInput.value,
            title: titleInput.value,
            content: descriptionInput.value,
            filePath: filePathInput.value // 아직 파일 경로는 사용하지 않음 (예시)
        };

        // 데이터 서버로 전송
        fetch('/post/write', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(postData)
        })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                alert('글 작성이 성공적으로 완료되었습니다.');

                // 성공 시 /freewrite/list 페이지로 리다이렉션
                window.location.href = '/freewrite/list';
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('글 작성 중 오류가 발생했습니다.');
            });

        e.preventDefault(); // 폼의 기본 제출 동작을 중단
    });
});
