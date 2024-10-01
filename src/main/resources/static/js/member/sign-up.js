// 전체 동의, 필수 동의 3개, 선택 동의 2개
const inputAgrees = document.querySelectorAll(
    "input[type=checkbox].input-agree"
);

// 전체 동의
const checkAll = document.querySelector("input[type=checkbox].input-agree-all");

// 필수 동의 3개
const requiredChecks = document.querySelectorAll(
    "input[type=checkbox].input-required"
);

// 필수 동의 3개, 선택 동의 2개
const inputCheckboxes = document.querySelectorAll(
    "input[type=checkbox].input-checkbox"
);

//선택 동의1
const choice1CheckAll = document.querySelector(
    "input[type=checkbox].input-agree-choice-1"
);

// 선택 동의2
const choice2CheckAll = document.querySelector(
    "input[type=checkbox].input-agree-choice-2"
);

// 선택 동의1의 하위 목록(체크) 3개
const choice1Checks = document.querySelectorAll(
    "div.agree-select-1 input[type=checkbox]"
);

// 선택 동의2의 하위 목록(체크) 3개
const choice2Checks = document.querySelectorAll(
    "div.agree-select-2 input[type=checkbox]"
);

// 모든 input[type=checkbox]
const inputchecks = document.querySelectorAll(
    "input[type=checkbox].input-check"
); //(전체 동의, 필수 동의 3개, 선택 동의 2개, 선택 동의의 하위 목록(3개씩)

// 하위 input[type=checkbox]
const inputIcons = document.querySelectorAll(
    "input[type=checkbox].check-icon-svg"
); //선택 동의 안의 하위 목록(3개씩) (총 6개)

//checked 했을 때 체크박스에 스타일 적용시키기 위해
//모든 체크박스 스타일
const checkStyle = document.querySelectorAll(".check-style");
//필수 동의 3개, 선택 동의 2개 체크박스 스타일
const checkbox5Style = document.querySelectorAll(".checkbox5-style");

const inputchecks11 = [...inputchecks].slice(1);

checkAll.addEventListener("click", (e) => {
    const isChecked = e.target.checked;
    inputchecks.forEach((checkbox, i) => {
        checkbox.checked = isChecked;
        checkStyle[i].classList.toggle("on", isChecked);
    });
});

// 필수 동의 및 선택 동의 체크박스 상태 업데이트
inputCheckboxes.forEach((inputCheck, i) => {
    inputCheck.addEventListener("click", (e) => {
        const allChecked = inputCheck.checked;
        checkAll.checked = allChecked;
        checkbox5Style[i].classList.toggle("on", allChecked);
    });
});

// 선택 동의 체크 시 해당 선택 동의의 하위 체크 목록 체크
const updateSubChecks = (choiceCheck, subChecks) => {
    choiceCheck.addEventListener("click", (e) => {
        const isChecked = e.target.checked;
        choiceCheck.previousElementSibling.classList.toggle("on", isChecked);
        subChecks.forEach((subCheck) => {
            subCheck.checked = isChecked;
            subCheck.nextElementSibling.firstElementChild.classList.toggle(
                "on",
                subCheck.checked
            );
        });
    });
};

// 선택 동의1의 하위 체크 목록 체크
updateSubChecks(choice1CheckAll, choice1Checks);

// 선택 동의2의 하위 체크 목록 체크
updateSubChecks(choice2CheckAll, choice2Checks);

// 선택 동의의 하위 체크 목록 중 하나 이상 체크 시 선택 동의 체크박스 체크
const updateChoiceCheck = (choiceCheck, subChecks) => {
    subChecks.forEach((subCheck) => {
        subCheck.addEventListener("click", () => {
            const isChecked = [...subChecks].some((check) => check.checked);
            choiceCheck.checked = isChecked;
            subCheck.nextElementSibling.firstElementChild.classList.toggle(
                "on",
                subCheck.checked
            );
            choiceCheck.previousElementSibling.classList.toggle(
                "on",
                isChecked
            );
        });
    });
};

// 선택 동의1의 하위 체크 목록 체크 상태 업데이트
updateChoiceCheck(choice1CheckAll, choice1Checks);

// 선택 동의2의 하위 체크 목록 체크 상태 업데이트
updateChoiceCheck(choice2CheckAll, choice2Checks);

// 전체 체크박스 상태 업데이트
inputchecks11.forEach((inputCheck) => {
    inputCheck.addEventListener("click", () => {
        checkAll.checked =
            inputchecks11.filter((inputCheck) => inputCheck.checked).length ===
            11;
        checkStyle[0].classList.toggle("on", checkAll.checked);
    });
});


// 회원가입 이메일 부분
document.getElementById('duplicate-check-button-email').addEventListener('click', ()=> {
    const email = document.getElementById('email').value;
    const resultDiv = document.getElementById('email-check-result');

    // 이메일이 비어있을 때
    if (!email.trim()) {
        resultDiv.innerHTML = "<p class='error-message'>이메일을 입력해주세요.</p>";
        return;
    }

    // 이메일 형식 유효성 검사
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        resultDiv.innerHTML = "<p class='error-message'>올바른 이메일 형식으로 입력해 주세요.</p>";
        return;
    }

    // 이메일 형식이 올바를 때 중복 검사 진행
    fetch(`/member/check-email-duplicate?email=${email}`)
        .then(response => response.json())
        .then(data => {
            if (data.duplicate) {
                resultDiv.innerHTML = "<p class='error-message'>중복된 이메일입니다.</p>";
            } else {
                resultDiv.innerHTML = "<p class='available-message'>가입이 가능한 이메일입니다.</p>";
            }
        })
});

// 회원가입 닉네임 부분
document.getElementById('duplicate-check-button-nickname').addEventListener('click', ()=> {
    const nickname = document.getElementById('nickname').value;
    const resultNickNameDiv = document.getElementById('nickname-check-result');

    // 닉네임이 비어있을 때
    if (!nickname.trim()) {
        resultNickNameDiv.innerHTML = "<p class='error-message'>닉네임을 입력해주세요.</p>";
        return;
    }

    // 닉네임 유효성 검사
    const nicknamePattern = /^[가-힣a-zA-Z0-9]+$/;
    if (!nicknamePattern.test(nickname)) {
        resultNickNameDiv.innerHTML = "<p class='error-message'>한글, 영어, 숫자만 입력해주세요.</p>";
        return;
    }

    // 닉네임 형식이 올바를 때 중복 검사 진행
    fetch(`/member/check-nickname-duplicate?nickname=${nickname}`)
        .then(response => response.json())
        .then(data => {
            if (data.duplicate) {
                resultNickNameDiv.innerHTML = "<p class='error-message'>중복된 닉네임입니다.</p>";
            } else {
                resultNickNameDiv.innerHTML = "<p class='available-message'>사용 가능한 닉네임입니다.</p>";
            }
        })
});

// 회원가입 생년월일 부분
document.getElementById('birth').addEventListener('input', function () {
    const birthInput = document.getElementById('birth').value;
    const birthErrorDiv = document.getElementById('birth-check-result');

    // 입력한 숫자가 8자리가 아닐때
    if (birthInput.length < 8) {
        birthErrorDiv.innerHTML = "<p class='error-message'>8자리로 입력해주세요.</p>";
        return;
    }

    // 입력한 생년월일중 앞 4자리만 추출
    const birthYear = parseInt(birthInput.substring(0, 4));
    const currentYear = new Date().getFullYear();

    // 2004년생까지 가입되게 유효성검사
    if (birthYear > currentYear || birthYear > 2004) {
        birthErrorDiv.innerHTML = "<p class='error-message'>성인만 회원가입이 가능합니다.</p>";
    } else {
        // 유효한 입력일 경우 에러 메시지 제거
        birthErrorDiv.innerHTML = "";
    }
});

//  회원가입중 비밀번호 부분
document.getElementById('password-input').addEventListener('input', checkPasswordMatch);
document.getElementById('pw-onemore-input').addEventListener('input', checkPasswordMatch);

function checkPasswordMatch() {
    const password = document.getElementById('password-input').value;
    const passwordConfirm = document.getElementById('pw-onemore-input').value;
    const passwordErrorDiv = document.getElementById('password-check-result');

    // 비밀번호가 일치할 때
    if (password === passwordConfirm && password.length > 0) {
        passwordErrorDiv.innerHTML = "<p class='available-message'>비밀번호가 일치합니다.</p>";
    }
    // 비밀번호가 일치하지 않을 때
    else if (passwordConfirm.length > 0) {
        passwordErrorDiv.innerHTML = "<p class='error-message'>비밀번호가 일치하지 않습니다.</p>";
    }
    // 비밀번호 확인란이 비어있을 때
    else {
        passwordErrorDiv.innerHTML = "<p class='error-message'>비밀번호를 입력해주세요.</p>"; // 메시지 초기화
    }
}

//모든 input태그에 값이 입력되면 가입하기 버튼 활성화
document.addEventListener('DOMContentLoaded', ()=> {
    const finalButton = document.getElementById('final-button');
    const inputFields = document.querySelectorAll('#signupForm input');

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
});

// 로고 이미지 누를시 메인화면으로 이동
const mainPageLogo =document.querySelector(".yanawa-logo");

mainPageLogo.addEventListener('click',()=>{
    window.location.href="/member/main"
});