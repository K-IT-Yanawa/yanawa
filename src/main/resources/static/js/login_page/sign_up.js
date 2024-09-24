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

const emailInput = document.getElementById("email-1");
const duplicateCheckEmail = document.getElementById("duplicate-check-email");
const duplicateCheckButtonEmail = document.getElementById(
    "duplicate-check-button-email"
);
//
// const nicknameInput = document.getElementById("nickname-1");
// const duplicateCheckNickname = document.getElementById(
//     "duplicate-check-nickname"
// );
// const duplicateCheckButtonNickname = document.getElementById(
//     "duplicate-check-button-nickname"
// );
//
// const mobileInput = document.getElementById("mobile-input");
// const getCodeSpan = document.getElementById("get-code-span");
// const getCodeButton = document.getElementById("get-code-button");
//
// const nameInput = document.getElementById("name-input");
// const getCodeInput = document.getElementById("get-code-input");
// const birthInput = document.getElementById("birth-1");
// const genderInput = document.getElementById("gender");
// const passwordInput = document.getElementById("password-input");
// const pwOnemoreInput = document.getElementById("pw-onemore-input");
// const finalButton = document.getElementById("final-button");
//
// **이메일 중복 확인 버튼 활성화 기능**
(function () {
    // 입력 필드의 값을 확인하고 버튼 활성화 여부를 결정하는 함수
    function updateDuplicateState() {
        if (emailInput.value.trim() !== "") {
            // 이메일 입력된 경우
            duplicateCheckEmail.classList.add("active");
            duplicateCheckEmail.disabled = false; // 버튼 활성화
            duplicateCheckButtonEmail.style.cursor = "pointer";
        } else {
            // 이메일 비어있는 경우
            duplicateCheckEmail.classList.remove("active");
            duplicateCheckEmail.disabled = true; // 버튼 비활성화
            duplicateCheckButtonEmail.style.cursor = "default";
        }
    }

    // 입력 필드의 변화가 있을 때마다 버튼 상태 업데이트
    emailInput.addEventListener("input", updateDuplicateState);
})();
//
// // **닉네임 중복 확인 버튼 활성화 기능**
// (function () {
//     // 입력 필드의 값을 확인하고 버튼 활성화 여부를 결정하는 함수
//     function updateDuplicateState() {
//         if (nicknameInput.value.trim() !== "") {
//             // 닉네임 입력된 경우
//             duplicateCheckNickname.classList.add("active");
//             duplicateCheckNickname.disabled = false; // 버튼 활성화
//             duplicateCheckButtonNickname.style.cursor = "pointer";
//         } else {
//             // 닉네임 비어있는 경우
//             duplicateCheckNickname.classList.remove("active");
//             duplicateCheckNickname.disabled = true; // 버튼 비활성화
//             duplicateCheckButtonNickname.style.cursor = "default";
//         }
//     }
//
//     // 입력 필드의 변화가 있을 때마다 버튼 상태 업데이트
//     nicknameInput.addEventListener("input", updateDuplicateState);
// })();
//
// // **인증번호 받기 버튼 활성화 기능**
// (function () {
//     // 입력 필드의 값을 확인하고 버튼 활성화 여부를 결정하는 함수
//     function updateCodeState() {
//         if (mobileInput.value.trim() !== "") {
//             getCodeButton.classList.add("active");
//             getCodeButton.disabled = false; // 버튼 활성화
//         } else {
//             getCodeButton.classList.remove("active");
//             getCodeButton.disabled = true; // 버튼 비활성화
//         }
//     }
//
//     // 입력 필드의 변화가 있을 때마다 버튼 상태 업데이트
//     mobileInput.addEventListener("input", updateCodeState);
// })();
//
// // **가입하기 버튼 활성화 기능**
// (function () {
//     // 입력 필드의 값을 확인하고 버튼 활성화 여부를 결정하는 함수
//     function updateCodeState() {
//         if (
//             emailInput.value.trim() !== "" &&
//             nameInput.value.trim() !== "" &&
//             nicknameInput.value.trim() !== "" &&
//             getCodeInput.value.trim() !== "" &&
//
//             birthInput.value.trim() !== "" &&
//             genderInput.value.trim() !== "" &&
//             passwordInput.value.trim() !== "" &&
//             pwOnemoreInput.value.trim() !== "" &&
//             [...requiredChecks][0].checked == true &&
//             [...requiredChecks][1].checked == true &&
//             [...requiredChecks][2].checked == true
//         ) {
//             finalButton.classList.add("active");
//             finalButton.disabled = false; // 버튼 활성화
//         } else {
//             finalButton.classList.remove("active");
//             finalButton.disabled = true; // 버튼 비활성화
//         }
//     }
//
//     // 입력 필드의 변화가 있을 때마다 버튼 상태 업데이트
//     emailInput.addEventListener("input", updateCodeState);
//     nameInput.addEventListener("input", updateCodeState);
//     nicknameInput.addEventListener("input", updateCodeState);
//     getCodeInput.addEventListener("input", updateCodeState);
//     birthInput.addEventListener("input", updateCodeState);
//     genderInput.addEventListener("input", updateCodeState);
//
//     passwordInput.addEventListener("input", updateCodeState);
//     pwOnemoreInput.addEventListener("input", updateCodeState);
//     inputchecks.forEach((check) => {
//         check.addEventListener("input", updateCodeState);
//     });
// })();


// document.getElementById('email').addEventListener('input', function() {
//     const emailInput = this.value;
//     const emailCheckButton = document.getElementById('duplicate-check-button-email');
//
//     // 이메일 형식 유효성 검사
//     const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
//     if (emailPattern.test(emailInput)) {
//         emailCheckButton.disabled = false;
//         document.getElementById('emailError').style.display = 'none';
//     } else {
//         emailCheckButton.disabled = true;
//         document.getElementById('emailError').style.display = 'block';
//     }
// });
//
// document.getElementById('duplicate-check-button-email').addEventListener('click', function() {
//     const emailInput = document.getElementById('email').value;
//
//     // AJAX를 사용하여 이메일 중복 확인 (서버와 통신)
//     fetch('/user/check-email?email=' + encodeURIComponent(emailInput))
//         .then(response => response.json())
//         .then(data => {
//             if (data.available) {
//                 document.getElementById('emailAvailable').style.display = 'block';
//                 document.getElementById('duplicateError').style.display = 'none';
//             } else {
//                 document.getElementById('duplicateError').style.display = 'block';
//                 document.getElementById('emailAvailable').style.display = 'none';
//             }
//         });
// });