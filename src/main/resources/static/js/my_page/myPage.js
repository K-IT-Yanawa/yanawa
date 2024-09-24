// 설정 버튼을 클릭했을 때 profile-edit 화면을 표시
document
    .querySelector(".profile-settings-btn")
    .addEventListener("click", function () {
        document.getElementById("profile-view").style.display = "none";
        document.getElementById("profile-edit").style.display = "block";
    });

// 취소 또는 저장 버튼을 클릭했을 때 profile-edit 화면을 다시 표시
document
    .querySelectorAll(".profile-edit-actions button")
    .forEach(function (button) {
        button.addEventListener("click", function () {
            document.getElementById("profile-view").style.display = "none"; // profile-view 숨김
            document.getElementById("profile-edit").style.display = "block"; // profile-edit 표시
        });
    });
// ======================================================================================
// 프로필 사진 업로드 기능
document
    .getElementById("openFilePicker")
    .addEventListener("click", function () {
        document.getElementById("fileInput").click();
    });
// ======================================================================================
// 요소들 선택
const openModalBtn = document.getElementById("openModal2"); // 모달을 여는 버튼
const modal = document.getElementById("myModal"); // 모달 요소
const closeModalBtn = document.getElementById("closeModal"); // 모달 닫기 버튼

const openModalBtn2 = document.getElementById("poneNumbermodal"); // 두 번째 모달을 여는 버튼
const modal2 = document.getElementById("myModal2"); // 두 번째 모달 요소
const closeModalBtn2 = document.getElementById("closeModal2"); // 두 번째 모달 닫기 버튼

const cancelButton = modal.querySelector(".btn-cancel"); // 취소 버튼
const saveButton = modal.querySelector(".btn-save"); // 저장 버튼

const cancelButton2 = modal2.querySelector(".btn-cancel"); // 두 번째 모달 취소 버튼
const saveButton2 = modal2.querySelector(".btn-save"); // 두 번째 모달 저장 버튼

const profileView = document.getElementById("profile-view"); // profile-view 화면
const profileEdit = document.getElementById("profile-edit"); // profile-edit 화면

// 모달 열기
openModalBtn.addEventListener("click", function () {
    modal.style.display = "block";
});

// 모달 닫기 (닫기 버튼)
closeModalBtn.addEventListener("click", function () {
    modal.style.display = "none";
});

// 모달 외부 클릭 시 모달 닫기
window.addEventListener("click", function (event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
});

// 취소 버튼 클릭 시 모달 닫고 profile-edit 화면으로 전환
cancelButton.addEventListener("click", function () {
    modal.style.display = "none";
    profileView.style.display = "none"; // profile-view 숨기기
    profileEdit.style.display = "block"; // profile-edit 보이기
});

// 저장 버튼 클릭 시 모달 닫고 profile-edit 화면으로 전환
saveButton.addEventListener("click", function (event) {
    event.preventDefault(); // 폼 기본 동작 방지
    modal.style.display = "none";
    profileView.style.display = "none"; // profile-view 숨기기
    profileEdit.style.display = "block"; // profile-edit 보이기
});

// ======================================================================================

// 두 번째 모달 열기
openModalBtn2.addEventListener("click", function () {
    modal2.style.display = "block";
});

// 두 번째 모달 닫기
closeModalBtn2.addEventListener("click", function () {
    modal2.style.display = "none";
});

// 두 번째 모달 취소 및 저장 버튼 클릭 시 모달 닫기 + profile-edit 화면 전환
cancelButton2.addEventListener("click", function () {
    modal2.style.display = "none";
    profileView.style.display = "none"; // profile-view 숨기기
    profileEdit.style.display = "block"; // profile-edit 보이기
});

saveButton2.addEventListener("click", function (event) {
    event.preventDefault();

    modal2.style.display = "none";
    profileView.style.display = "none";
    profileEdit.style.display = "block";
});

// // ======================================================================================
// 한줄 소개 요소들 선택
// 요소 선택
const editIntroBtn = document.getElementById("editIntroBtn");
const introForm = document.getElementById("introForm");
const cancelBtn = introForm.querySelector(".btn-outlined");
const saveBtn = introForm.querySelector(".btn-small");

// 한 줄 소개 버튼 클릭 시 입력 폼 보이기
editIntroBtn.addEventListener("click", function () {
    console.log("한 줄 소개 버튼 클릭");
    introForm.parentElement.style.display = "block"; // 입력 폼을 보이게 설정
});

// 취소 버튼 클릭 시 입력 폼 숨기기
cancelBtn.addEventListener("click", function (event) {
    event.preventDefault(); // 기본 동작 방지 (새로고침 방지)
    console.log("취소 버튼 클릭");
    introForm.parentElement.style.display = "none"; // 입력 폼 숨기기
    profileEdit.style.display = "block"; // profile-edit 화면 유지
    profileView.style.display = "none"; // profile-view 화면 숨기기
});

// 저장 버튼 클릭 시 입력 폼 숨기기 및 화면 전환
saveBtn.addEventListener("click", function (event) {
    event.preventDefault(); // 기본 동작 방지 (새로고침 방지)
    console.log("저장 버튼 클릭");
    introForm.parentElement.style.display = "none"; // 입력 폼 숨기기
    profileEdit.style.display = "block"; // profile-edit 화면 유지
    profileView.style.display = "none"; // profile-view 화면 숨기기
});
// =====================================================================================
<<<<<<< HEAD
=======
const editIntroBtn4 = document.getElementById("editIntroBtn4");
const introForm4 = document.getElementById("introForm4");
const cancelBtn4 = document.getElementById("cancelBtn4");
const saveBtn4 = document.getElementById("saveBtn4");

// "선호하는 포지션을 입력해주세요" 버튼 클릭 시 입력 폼 보이기
editIntroBtn4.addEventListener("click", function (event) {
    event.preventDefault(); // 기본 동작 방지
    introForm4.closest("li").style.display = "block"; // li 폼 보이기
});

// 취소 버튼 클릭 시 입력 폼 숨기기
cancelBtn4.addEventListener("click", function (event) {
    event.preventDefault(); // 기본 동작 방지
    introForm4.closest("li").style.display = "none"; // 입력 폼 숨기기
    profileEdit.style.display = "block"; // profile-edit 화면 유지
    profileView.style.display = "none"; // profile-view 화면 숨기기
});

// 저장 버튼 클릭 시 입력 폼 숨기기
saveBtn4.addEventListener("click", function (event) {
    event.preventDefault(); // 기본 동작 방지
    introForm4.closest("li").style.display = "none"; // 입력 폼 숨기기
    profileEdit.style.display = "block"; // profile-edit 화면 유지
    profileView.style.display = "none"; // profile-view 화면 숨기기
});




// =====================================================================================
>>>>>>> 7f318cfe218b61a06e15c2301ab7f94d75b427d3
// 선호하는 포지션
// 요소 선택
const editIntroBtn2 = document.getElementById("editIntroBtn2");
const introForm2 = document.getElementById("introForm2");
const cancelBtn2 = document.getElementById("cancelBtn2");
const saveBtn2 = document.getElementById("saveBtn2");

// "선호하는 포지션을 입력해주세요" 버튼 클릭 시 입력 폼 보이기
editIntroBtn2.addEventListener("click", function (event) {
    event.preventDefault(); // 기본 동작 방지
    introForm2.closest("li").style.display = "block"; // li 폼 보이기
});

// 취소 버튼 클릭 시 입력 폼 숨기기
cancelBtn2.addEventListener("click", function (event) {
    event.preventDefault(); // 기본 동작 방지
    introForm2.closest("li").style.display = "none"; // 입력 폼 숨기기
    profileEdit.style.display = "block"; // profile-edit 화면 유지
    profileView.style.display = "none"; // profile-view 화면 숨기기
});

// 저장 버튼 클릭 시 입력 폼 숨기기
saveBtn2.addEventListener("click", function (event) {
    event.preventDefault(); // 기본 동작 방지
    introForm2.closest("li").style.display = "none"; // 입력 폼 숨기기
    profileEdit.style.display = "block"; // profile-edit 화면 유지
    profileView.style.display = "none"; // profile-view 화면 숨기기
});

// =====================================================================================
// 운동 경력
const editIntroBtn3 = document.getElementById("editIntroBtn3");
const introForm3 = document.getElementById("introForm3");
const cancelBtn3 = document.getElementById("cancelBtn3");
const saveBtn3 = document.getElementById("saveBtn3");

// "선호하는 포지션을 입력해주세요" 버튼 클릭 시 입력 폼 보이기
editIntroBtn3.addEventListener("click", function (event) {
    event.preventDefault(); // 기본 동작 방지
    introForm3.closest("li").style.display = "block"; // li 폼 보이기
});

// 취소 버튼 클릭 시 입력 폼 숨기기
cancelBtn3.addEventListener("click", function (event) {
    event.preventDefault(); // 기본 동작 방지
    introForm3.closest("li").style.display = "none"; // 입력 폼 숨기기
    profileEdit.style.display = "block"; // profile-edit 화면 유지
    profileView.style.display = "none"; // profile-view 화면 숨기기
});

// 저장 버튼 클릭 시 입력 폼 숨기기
saveBtn3.addEventListener("click", function (event) {
    event.preventDefault(); // 기본 동작 방지
    introForm3.closest("li").style.display = "none"; // 입력 폼 숨기기
    profileEdit.style.display = "block"; // profile-edit 화면 유지
    profileView.style.display = "none"; // profile-view 화면 숨기기
});
// =====================================================================================
// 중복 확인 버튼 활성화 로직
// const nicknameInput1 = document.getElementById("nickname-input-1");
// const checkDuplicateButton1 = document.getElementById(
//     "check-duplicate-button-1"
// );

// nicknameInput1.addEventListener("input", function () {
//     if (nicknameInput1.value.length > 0) {
//         checkDuplicateButton1.disabled = false; // 입력 시 버튼 활성화
//     } else {
//         checkDuplicateButton1.disabled = true; // 입력 없을 시 버튼 비활성화
//     }
// });
