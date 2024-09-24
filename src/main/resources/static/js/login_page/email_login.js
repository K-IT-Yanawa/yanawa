const emailInput1 = document.getElementById("email-1");
const passwordInput = document.getElementById("password");
const loginButton = document.getElementById("final-button");
const togglePassword = document.getElementById("togglePassword");
const eyeIcon = document.getElementById("eye-icon");
const eyeSlashIcon = document.getElementById("eye-slash-icon");

// **비밀번호 보기/숨기기 (눈 아이콘) 기능**
togglePassword.addEventListener("click", () => {
    // 현재 비밀번호 입력 필드의 타입을 체크하고 전환
    const type = passwordInput.type === "password" ? "text" : "password";
    passwordInput.type = type;

    // 아이콘의 표시 상태를 전환
    if (type === "password") {
        eyeIcon.classList.remove("hidden");
        eyeSlashIcon.classList.add("hidden");
    } else {
        eyeIcon.classList.add("hidden");
        eyeSlashIcon.classList.remove("hidden");
    }
});

// **로그인 버튼 활성화 기능**
(function () {
    // 입력 필드의 값을 확인하고 버튼 활성화 여부를 결정하는 함수
    function updateButtonState() {
        if (
            emailInput1.value.trim() !== "" &&
            passwordInput.value.trim() !== ""
        ) {
            // 이메일과 비밀번호가 모두 입력된 경우
            loginButton.classList.add("active");
            loginButton.disabled = false; // 버튼 활성화
        } else {
            // 이메일 또는 비밀번호가 비어있는 경우
            loginButton.classList.remove("active");
            loginButton.disabled = true; // 버튼 비활성화
        }
    }

    // 입력 필드의 변화가 있을 때마다 버튼 상태 업데이트
    emailInput1.addEventListener("input", updateButtonState);
    passwordInput.addEventListener("input", updateButtonState);
})();
