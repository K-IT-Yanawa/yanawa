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

//모든 input태그에 값이 입력되면 가입하기 버튼 활성화
document.addEventListener('DOMContentLoaded', () => {
    const finalButton = document.getElementById('final-button');
    const inputFields = document.querySelectorAll('#email-login input');
    // 로그인 실패시 뜨는 메세지
    const loginFailedMsg = document.querySelector(".login-failed");

    // 모든 input 필드에 값이 입력되었는지 확인하는 함수
    function checkInputs() {
        let allFilled = true;

        inputFields.forEach(input => {
            if (input.value.trim() === "") {
                allFilled = false;
            }
        });

        if (allFilled) {
            finalButton.classList.add("active");
            finalButton.disabled = false; // 버튼 활성화
        } else {
            finalButton.classList.remove("active");
            finalButton.disabled = true; // 버튼 비활성화
        }
    }

    // 각 input 필드에 입력 이벤트 추가 (input 이벤트)
    inputFields.forEach(input => {
        input.addEventListener('input', checkInputs);
    });

    // 페이지 로드 시 입력 상태를 확인
    checkInputs();

    // 로그인 실패시 실패메시지 생성
    if(status){
        loginFailedMsg.style.display="block";
    }
});

//회원가입 페이지로 이동
const signUpBackButton = document.getElementById("signupBackButton");

signUpBackButton.addEventListener("click",()=>{
//     /member/signup 으로 이동
    window.location.href="/member/signup";
});

// 카카오 로그인
function kakaoLogin() {
    //개인 clientId 로 수정
    const clientId = '4759c67a8c35dab21cbdb77f0bb159ad';
    //개인 redirectUri 로 수정
    const redirectUri = 'http://localhost:10000/kakao/login';
    //kakaoService.getKakaoAccessToken에서 받아온것
    const responseType = 'code';

    const afterKakaoLoginMyPage = `https://kauth.kakao.com/oauth/authorize?client_id=${clientId}&redirect_uri=${encodeURIComponent(redirectUri)}&response_type=${responseType}`;

    // 카카오 로그인후에 마이페이지로 이동
    window.location.href = afterKakaoLoginMyPage;
}



