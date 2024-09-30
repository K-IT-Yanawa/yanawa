const state = {
    agree: [],
};

NodeList.prototype.slice = Array.prototype.slice;

const requiredInput1 = document.querySelector("input[name=is_above_14]");
const requiredInput2 = document.querySelector(
    "input[name=is_terms_conditions]"
);
const requiredInput3 = document.querySelector(
    "input[name=is_collect_information]"
);
const selectInput1 = document.querySelector("input[name=is_accept_event_all]");
const emailInput1 = document.querySelector(
    "input[name=accept_marketing_email]"
);
const pushInput1 = document.querySelector("input[name=accept_marketing_push]");
const smsInput1 = document.querySelector("input[name=accept_marketing_sms]");
const selectInput2 = document.querySelector(
    "input[name=is_accept_recruit_all]"
);
const emailInput2 = document.querySelector("input[name=accept_recruit_email]");
const pushInput2 = document.querySelector("input[name=accept_recruit_push]");
const smsInput2 = document.querySelector("input[name=accept_recruit_sms]");

// 전체동의 포함 네모체크박스 6개
const agreeCheckboxes = document.getElementsByClassName("agree-checkbox");
const fiveAgreeCheckboxes = [...agreeCheckboxes].slice(1); // 네모체크박스 5개

const AllagreeCheckbox = [...agreeCheckboxes].slice(0, 1);

// 체크표시 6개 (선택 동의 하위목록 6개)
const checkIconSvgs = document.getElementsByClassName("check-icon-svg");
const sixCheckIconSvgs = [...checkIconSvgs]; // 체크표시 6개 복사본

const ThreeCheckIconSvgs1 = sixCheckIconSvgs.slice(0, 3); // 선택동의1 하위목록 체크표시 3개
const ThreeCheckIconSvgs2 = sixCheckIconSvgs.slice(3, 6); // 선택동의2 하위목록 체크표시 3개

// 전체 체크 이벤트
// 1. 전체 동의(전체 체크)
const isAgreeAll = document.querySelector("input[name=is_agree_all]");

const allCheckInputs = document.querySelectorAll("input[type=checkbox]"); // 12개 체크항목(전체 포함)
const checkInputs = allCheckInputs.slice(1); // 11개 체크항목
const checkIconInputs1 = allCheckInputs.slice(5, 8); // 선택동의1 하위체크항목
const checkIconInputs2 = allCheckInputs.slice(9, 12); // 선택동의2 하위체크항목

isAgreeAll.addEventListener("change", (e) => {
    if (e.target.checked) {
        checkInputs.forEach((item, index) => {
            state.agree = [...state.agree, item.value];
            item.checked = true; // checkInputs(11개 체크항목) 모두 체크
        });
    } else {
        checkInputs.forEach((item, index) => {
            state.agree = [];
            item.checked = false; // checkInputs 모두 체크 해제
        });
    }

    if (e.target.checked) {
        //전체 동의 체크 시
        fiveAgreeCheckboxes.forEach((item, index) => {
            //5개 네모체크박스 스타일 적용(on)
            item.classList.remove("off");
            item.classList.add("on");
        });
    } else {
        //전체 동의 체크 해제 시
        fiveAgreeCheckboxes.forEach((item, index) => {
            //5개 네모체크박스 스타일 적용 해제(off)
            item.classList.remove("on");
            item.classList.add("off");
        });
    }

    if (e.target.checked) {
        //전체 동의 체크 시
        sixCheckIconSvgs.forEach((item, index) => {
            //6개 체크표시 스타일 적용(on)
            item.classList.remove("off");
            item.classList.add("on");
        });
    } else {
        //전체 동의 체크 해제 시
        sixCheckIconSvgs.forEach((item, index) => {
            //6개 체크표시 스타일 적용 해제(off)
            item.classList.remove("on");
            item.classList.add("off");
        });
    }

    if (e.target.checked) {
        AllagreeCheckbox[0].classList.remove("off");
        AllagreeCheckbox[0].classList.add("on");
    } else {
        AllagreeCheckbox[0].classList.remove("on");
        AllagreeCheckbox[0].classList.add("off");
    }
});

// 개별 체크 이벤트
checkInputs.forEach((item, index) => {
    item.addEventListener("change", (e) => {
        if (e.target.checked) {
            state.agree = [...state.agree, e.target.value];
        } else {
            //선택 해제 항목만 제외하고 나머지 배열 재구성 => 즉, 삭제
            //filter 함수 사용
            state.agree = state.agree.filter((value) => value !== item.value);
        }
        //개별 선택 11개 배열이 차면 전체 체크박스 체크
        if (state.agree.length == 11) {
            isAgreeAll.checked = true;
        } else {
            // 11개 미만이면 전체 체크 해제
            isAgreeAll.checked = false;
        }

        // index < 5; //네모체크박스
        // 5 <= index < 11; //체크표시

        // 필수 동의, 선택 동의 - 네모체크표시
        if (requiredInput1.checked) {
            fiveAgreeCheckboxes[0].classList.remove("off");
            fiveAgreeCheckboxes[0].classList.add("on");
        } else {
            fiveAgreeCheckboxes[0].classList.remove("on");
            fiveAgreeCheckboxes[0].classList.add("off");
        }

        if (requiredInput2.checked) {
            fiveAgreeCheckboxes[1].classList.remove("off");
            fiveAgreeCheckboxes[1].classList.add("on");
        } else {
            fiveAgreeCheckboxes[1].classList.remove("on");
            fiveAgreeCheckboxes[1].classList.add("off");
        }

        if (requiredInput3.checked) {
            fiveAgreeCheckboxes[2].classList.remove("off");
            fiveAgreeCheckboxes[2].classList.add("on");
        } else {
            fiveAgreeCheckboxes[2].classList.remove("on");
            fiveAgreeCheckboxes[2].classList.add("off");
        }

        if (selectInput1.checked) {
            fiveAgreeCheckboxes[3].classList.remove("off");
            fiveAgreeCheckboxes[3].classList.add("on");
        } else {
            fiveAgreeCheckboxes[3].classList.remove("on");
            fiveAgreeCheckboxes[3].classList.add("off");
        }

        if (selectInput2.checked) {
            fiveAgreeCheckboxes[4].classList.remove("off");
            fiveAgreeCheckboxes[4].classList.add("on");
        } else {
            fiveAgreeCheckboxes[4].classList.remove("on");
            fiveAgreeCheckboxes[4].classList.add("off");
        }

        // 선택 동의1 하위 목록 - 체크표시
        if (emailInput1.checked) {
            sixCheckIconSvgs[0].classList.remove("off");
            sixCheckIconSvgs[0].classList.add("on");
        } else {
            sixCheckIconSvgs[0].classList.remove("on");
            sixCheckIconSvgs[0].classList.add("off");
        }
        if (pushInput1.checked) {
            sixCheckIconSvgs[1].classList.remove("off");
            sixCheckIconSvgs[1].classList.add("on");
        } else {
            sixCheckIconSvgs[1].classList.remove("on");
            sixCheckIconSvgs[1].classList.add("off");
        }
        if (smsInput1.checked) {
            sixCheckIconSvgs[2].classList.remove("off");
            sixCheckIconSvgs[2].classList.add("on");
        } else {
            sixCheckIconSvgs[2].classList.remove("on");
            sixCheckIconSvgs[2].classList.add("off");
        }
        // 선택 동의2 하위 목록 - 체크표시
        if (emailInput2.checked) {
            sixCheckIconSvgs[3].classList.remove("off");
            sixCheckIconSvgs[3].classList.add("on");
        } else {
            sixCheckIconSvgs[3].classList.remove("on");
            sixCheckIconSvgs[3].classList.add("off");
        }
        if (pushInput2.checked) {
            sixCheckIconSvgs[4].classList.remove("off");
            sixCheckIconSvgs[4].classList.add("on");
        } else {
            sixCheckIconSvgs[4].classList.remove("on");
            sixCheckIconSvgs[4].classList.add("off");
        }
        if (smsInput2.checked) {
            sixCheckIconSvgs[5].classList.remove("off");
            sixCheckIconSvgs[5].classList.add("on");
        } else {
            sixCheckIconSvgs[5].classList.remove("on");
            sixCheckIconSvgs[5].classList.add("off");
        }

        // 전체 동의 - 네모체크박스
        if (state.agree.length == 11) {
            AllagreeCheckbox[0].classList.remove("off");
            AllagreeCheckbox[0].classList.add("on");
        } else {
            AllagreeCheckbox[0].classList.remove("on");
            AllagreeCheckbox[0].classList.add("off");
        }
    });
});

// 선택 동의1 체크 이벤트
selectInput1.addEventListener("change", (e) => {
    if (e.target.checked) {
        if (
            emailInput1.checked == false &&
            pushInput1.checked == false &&
            smsInput1.checked == false
        ) {
            emailInput1.checked = true;
            state.agree = [...state.agree, emailInput1.value];
            pushInput1.checked = true;
            state.agree = [...state.agree, pushInput1.value];
            smsInput1.checked = true;
            state.agree = [...state.agree, smsInput1.value];
            if (
                emailInput1.checked == true &&
                pushInput1.checked == true &&
                smsInput1.checked == true
            ) {
                ThreeCheckIconSvgs1.forEach((icon) => {
                    icon.classList.remove("off");
                    icon.classList.add("on");
                });
            }
        }
    } else {
        // 개별체크에서 삭제
        if (
            emailInput1.checked == false &&
            pushInput1.checked == false &&
            smsInput1.checked == true
        ) {
            smsInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== smsInput1.value
            );
            if (smsInput1.checked == false) {
                ThreeCheckIconSvgs1[2].classList.remove("on");
                ThreeCheckIconSvgs1[2].classList.add("off");
            }
        } else if (
            emailInput1.checked == false &&
            pushInput1.checked == true &&
            smsInput1.checked == false
        ) {
            pushInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== pushInput1.value
            );
            if (pushInput1.checked == false) {
                ThreeCheckIconSvgs1[1].classList.remove("on");
                ThreeCheckIconSvgs1[1].classList.add("off");
            }
        } else if (
            emailInput1.checked == true &&
            pushInput1.checked == false &&
            smsInput1.checked == false
        ) {
            emailInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== emailInput1.value
            );
            if (emailInput1.checked == false) {
                ThreeCheckIconSvgs1[0].classList.remove("on");
                ThreeCheckIconSvgs1[0].classList.add("off");
            }
        } else if (
            emailInput1.checked == false &&
            pushInput1.checked == true &&
            smsInput1.checked == true
        ) {
            pushInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== pushInput1.value
            );
            smsInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== smsInput1.value
            );
            if (pushInput1.checked == false && smsInput1.checked == false) {
                ThreeCheckIconSvgs1[1].classList.remove("on");
                ThreeCheckIconSvgs1[1].classList.add("off");
                ThreeCheckIconSvgs1[2].classList.remove("on");
                ThreeCheckIconSvgs1[2].classList.add("off");
            }
        } else if (
            emailInput1.checked == true &&
            pushInput1.checked == false &&
            smsInput1.checked == true
        ) {
            emailInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== emailInput1.value
            );
            smsInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== smsInput1.value
            );
            if (emailInput1.checked == false && smsInput1.checked == false) {
                ThreeCheckIconSvgs1[0].classList.remove("on");
                ThreeCheckIconSvgs1[0].classList.add("off");
                ThreeCheckIconSvgs1[2].classList.remove("on");
                ThreeCheckIconSvgs1[2].classList.add("off");
            }
        } else if (
            emailInput1.checked == true &&
            pushInput1.checked == true &&
            smsInput1.checked == false
        ) {
            emailInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== emailInput1.value
            );
            pushInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== pushInput1.value
            );
            if (emailInput1.checked == false && pushInput1.checked == false) {
                ThreeCheckIconSvgs1[0].classList.remove("on");
                ThreeCheckIconSvgs1[0].classList.add("off");
                ThreeCheckIconSvgs1[1].classList.remove("on");
                ThreeCheckIconSvgs1[1].classList.add("off");
            }
        } else if (
            emailInput1.checked == true &&
            pushInput1.checked == true &&
            smsInput1.checked == true
        ) {
            emailInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== emailInput1.value
            );
            pushInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== pushInput1.value
            );
            smsInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== smsInput1.value
            );
            if (
                emailInput1.checked == false &&
                pushInput1.checked == false &&
                smsInput1.checked == false
            ) {
                ThreeCheckIconSvgs1.forEach((icon) => {
                    icon.classList.remove("on");
                    icon.classList.add("off");
                });
            }
        }
    }
    console.log(state.agree);
});

emailInput1.addEventListener("change", (e) => {
    if (e.target.checked) {
        if (
            selectInput1.checked == false &&
            pushInput1.checked == false &&
            smsInput1.checked == false
        ) {
            selectInput1.checked = true;
            state.agree = [...state.agree, selectInput1.value];
            if (selectInput1.checked) {
                fiveAgreeCheckboxes[3].classList.remove("off");
                fiveAgreeCheckboxes[3].classList.add("on");
            }
        }
    } else {
        if (
            selectInput1.checked == true &&
            pushInput1.checked == false &&
            smsInput1.checked == false
        ) {
            selectInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== selectInput1.value
            );
            if (selectInput1.checked == false) {
                fiveAgreeCheckboxes[3].classList.remove("on");
                fiveAgreeCheckboxes[3].classList.add("off");
            }
        }
    }
});
pushInput1.addEventListener("change", (e) => {
    if (e.target.checked) {
        if (
            selectInput1.checked == false &&
            emailInput1.checked == false &&
            smsInput1.checked == false
        ) {
            selectInput1.checked = true;
            state.agree = [...state.agree, selectInput1.value];
            if (selectInput1.checked) {
                fiveAgreeCheckboxes[3].classList.remove("off");
                fiveAgreeCheckboxes[3].classList.add("on");
            }
        }
    } else {
        if (
            selectInput1.checked == true &&
            emailInput1.checked == false &&
            smsInput1.checked == false
        ) {
            selectInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== selectInput1.value
            );
            if (selectInput1.checked == false) {
                fiveAgreeCheckboxes[3].classList.remove("on");
                fiveAgreeCheckboxes[3].classList.add("off");
            }
        }
    }
});

smsInput1.addEventListener("change", (e) => {
    if (e.target.checked) {
        if (
            selectInput1.checked == false &&
            emailInput1.checked == false &&
            pushInput1.checked == false
        ) {
            selectInput1.checked = true;
            state.agree = [...state.agree, selectInput1.value];
            if (selectInput1.checked) {
                fiveAgreeCheckboxes[3].classList.remove("off");
                fiveAgreeCheckboxes[3].classList.add("on");
            }
        }
    } else {
        if (
            selectInput1.checked == true &&
            emailInput1.checked == false &&
            pushInput1.checked == false
        ) {
            selectInput1.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== selectInput1.value
            );
            if (selectInput1.checked == false) {
                fiveAgreeCheckboxes[3].classList.remove("on");
                fiveAgreeCheckboxes[3].classList.add("off");
            }
        }
    }
});

// 선택 동의2 체크 이벤트
selectInput2.addEventListener("change", (e) => {
    if (e.target.checked) {
        if (
            emailInput2.checked == false &&
            pushInput2.checked == false &&
            smsInput2.checked == false
        ) {
            emailInput2.checked = true;
            state.agree = [...state.agree, emailInput2.value];
            pushInput2.checked = true;
            state.agree = [...state.agree, pushInput2.value];
            smsInput2.checked = true;
            state.agree = [...state.agree, smsInput2.value];
            if (
                emailInput2.checked == true &&
                pushInput2.checked == true &&
                smsInput2.checked == true
            ) {
                ThreeCheckIconSvgs2.forEach((icon) => {
                    icon.classList.remove("off");
                    icon.classList.add("on");
                });
            }
        }
    } else {
        // 개별체크에서 삭제
        if (
            emailInput2.checked == false &&
            pushInput2.checked == false &&
            smsInput2.checked == true
        ) {
            smsInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== smsInput2.value
            );
            if (smsInput2.checked == false) {
                ThreeCheckIconSvgs2[2].classList.remove("on");
                ThreeCheckIconSvgs2[2].classList.add("off");
            }
        } else if (
            emailInput2.checked == false &&
            pushInput2.checked == true &&
            smsInput2.checked == false
        ) {
            pushInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== pushInput2.value
            );
            if (pushInput2.checked == false) {
                ThreeCheckIconSvgs2[1].classList.remove("on");
                ThreeCheckIconSvgs2[1].classList.add("off");
            }
        } else if (
            emailInput2.checked == true &&
            pushInput2.checked == false &&
            smsInput2.checked == false
        ) {
            emailInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== emailInput2.value
            );
            if (emailInput2.checked == false) {
                ThreeCheckIconSvgs2[0].classList.remove("on");
                ThreeCheckIconSvgs2[0].classList.add("off");
            }
        } else if (
            emailInput2.checked == false &&
            pushInput2.checked == true &&
            smsInput2.checked == true
        ) {
            pushInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== pushInput2.value
            );
            smsInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== smsInput2.value
            );
            if (pushInput2.checked == false && smsInput2.checked == false) {
                ThreeCheckIconSvgs2[1].classList.remove("on");
                ThreeCheckIconSvgs2[1].classList.add("off");
                ThreeCheckIconSvgs2[2].classList.remove("on");
                ThreeCheckIconSvgs2[2].classList.add("off");
            }
        } else if (
            emailInput2.checked == true &&
            pushInput2.checked == false &&
            smsInput2.checked == true
        ) {
            emailInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== emailInput2.value
            );
            smsInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== smsInput2.value
            );
            if (emailInput2.checked == false && smsInput2.checked == false) {
                ThreeCheckIconSvgs2[0].classList.remove("on");
                ThreeCheckIconSvgs2[0].classList.add("off");
                ThreeCheckIconSvgs2[2].classList.remove("on");
                ThreeCheckIconSvgs2[2].classList.add("off");
            }
        } else if (
            emailInput2.checked == true &&
            pushInput2.checked == true &&
            smsInput2.checked == false
        ) {
            emailInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== emailInput2.value
            );
            pushInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== pushInput2.value
            );
            if (emailInput2.checked == false && pushInput2.checked == false) {
                ThreeCheckIconSvgs2[0].classList.remove("on");
                ThreeCheckIconSvgs2[0].classList.add("off");
                ThreeCheckIconSvgs2[1].classList.remove("on");
                ThreeCheckIconSvgs2[1].classList.add("off");
            }
        } else if (
            emailInput2.checked == true &&
            pushInput2.checked == true &&
            smsInput2.checked == true
        ) {
            emailInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== emailInput2.value
            );
            pushInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== pushInput2.value
            );
            smsInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== smsInput2.value
            );
            if (
                emailInput2.checked == false &&
                pushInput2.checked == false &&
                smsInput2.checked == false
            ) {
                ThreeCheckIconSvgs2.forEach((icon) => {
                    icon.classList.remove("on");
                    icon.classList.add("off");
                });
            }
        }
    }
    console.log(state.agree);
});

emailInput2.addEventListener("change", (e) => {
    if (e.target.checked) {
        if (
            selectInput2.checked == false &&
            pushInput2.checked == false &&
            smsInput2.checked == false
        ) {
            selectInput2.checked = true;
            state.agree = [...state.agree, selectInput2.value];
            if (selectInput2.checked) {
                fiveAgreeCheckboxes[4].classList.remove("off");
                fiveAgreeCheckboxes[4].classList.add("on");
            }
        }
    } //
    else {
        if (
            selectInput2.checked == true &&
            pushInput2.checked == false &&
            smsInput2.checked == false
        ) {
            selectInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== selectInput2.value
            );
            if (selectInput2.checked == false) {
                fiveAgreeCheckboxes[4].classList.remove("on");
                fiveAgreeCheckboxes[4].classList.add("off");
            }
        }
    }
});
pushInput2.addEventListener("change", (e) => {
    if (e.target.checked) {
        if (
            selectInput2.checked == false &&
            emailInput2.checked == false &&
            smsInput2.checked == false
        ) {
            selectInput2.checked = true;
            state.agree = [...state.agree, selectInput2.value];
            if (selectInput2.checked) {
                fiveAgreeCheckboxes[4].classList.remove("off");
                fiveAgreeCheckboxes[4].classList.add("on");
            }
        }
    } else {
        if (
            selectInput2.checked == true &&
            emailInput2.checked == false &&
            smsInput2.checked == false
        ) {
            selectInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== selectInput2.value
            );
            if (selectInput2.checked == false) {
                fiveAgreeCheckboxes[4].classList.remove("on");
                fiveAgreeCheckboxes[4].classList.add("off");
            }
        }
    }
});

smsInput2.addEventListener("change", (e) => {
    if (e.target.checked) {
        if (
            selectInput2.checked == false &&
            emailInput2.checked == false &&
            pushInput2.checked == false
        ) {
            selectInput2.checked = true;
            state.agree = [...state.agree, selectInput2.value];
            if (selectInput2.checked) {
                fiveAgreeCheckboxes[4].classList.remove("off");
                fiveAgreeCheckboxes[4].classList.add("on");
            }
        }
    } else {
        if (
            selectInput2.checked == true &&
            emailInput2.checked == false &&
            pushInput2.checked == false
        ) {
            selectInput2.checked = false;
            state.agree = state.agree.filter(
                (value) => value !== selectInput2.value
            );
            if (selectInput2.checked == false) {
                fiveAgreeCheckboxes[4].classList.remove("on");
                fiveAgreeCheckboxes[4].classList.add("off");
            }
        }
    }
});

const requiredCheckboxes = document.querySelectorAll(
    ".agree-div-five .agree-div .input-style-agree"
);

const emailInput = document.getElementById("email-1");
const duplicateCheck = document.getElementById("duplicate-check");
const duplicateCheckButton = document.getElementById("duplicate-check-button");

// **이메일 중복 확인 버튼 활성화 기능**
(function () {
    // 입력 필드의 값을 확인하고 버튼 활성화 여부를 결정하는 함수
    function updateDuplicateState() {
        if (emailInput.value.trim() !== "") {
            // 이메일 입력된 경우
            duplicateCheck.classList.add("active");
            duplicateCheck.disabled = false; // 버튼 활성화
            duplicateCheckButton.style.cursor = "pointer";
        } else {
            // 이메일 비어있는 경우
            duplicateCheck.classList.remove("active");
            duplicateCheck.disabled = true; // 버튼 비활성화
            duplicateCheckButton.style.cursor = "default";
        }
    }

    // 입력 필드의 변화가 있을 때마다 버튼 상태 업데이트
    emailInput.addEventListener("input", updateDuplicateState);
})();

const mobileInput = document.getElementById("mobile-input");
const getCodeSpan = document.getElementById("get-code-span");
const getCodeButton = document.getElementById("get-code-button");

// **인증번호 받기 버튼 활성화 기능**
(function () {
    // 입력 필드의 값을 확인하고 버튼 활성화 여부를 결정하는 함수
    function updateCodeState() {
        if (mobileInput.value.trim() !== "") {
            getCodeButton.classList.add("active");
            getCodeButton.disabled = false; // 버튼 활성화
        } else {
            getCodeButton.classList.remove("active");
            getCodeButton.disabled = true; // 버튼 비활성화
        }
    }

    // 입력 필드의 변화가 있을 때마다 버튼 상태 업데이트
    mobileInput.addEventListener("input", updateCodeState);
})();

const nameInput = document.getElementById("name-input");
const getCodeInput = document.getElementById("get-code-input");
const passwordInput = document.getElementById("password-input");
const pwOnemoreInput = document.getElementById("pw-onemore-input");
const finalButton = document.getElementById("final-button");

// **가입하기 버튼 활성화 기능**
(function () {
    // 입력 필드의 값을 확인하고 버튼 활성화 여부를 결정하는 함수
    function updateCodeState() {
        if (
            emailInput.value.trim() !== "" &&
            nameInput.value.trim() !== "" &&
            getCodeInput.value.trim() !== "" &&
            passwordInput.value.trim() !== "" &&
            pwOnemoreInput.value.trim() !== ""
        ) {
            finalButton.classList.add("active");
            finalButton.disabled = false; // 버튼 활성화
        } else {
            finalButton.classList.remove("active");
            finalButton.disabled = true; // 버튼 비활성화
        }
    }

    // 입력 필드의 변화가 있을 때마다 버튼 상태 업데이트
    emailInput.addEventListener("input", updateCodeState);
    nameInput.addEventListener("input", updateCodeState);
    getCodeInput.addEventListener("input", updateCodeState);
    passwordInput.addEventListener("input", updateCodeState);
    pwOnemoreInput.addEventListener("input", updateCodeState);
})();
