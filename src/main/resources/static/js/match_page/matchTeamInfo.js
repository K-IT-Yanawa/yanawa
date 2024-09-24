// 등록된 팀 목록보기 div가져오기
const mainBack = document.querySelector(".back-button");

// 등록된 팀 목록보기 눌렀을때 알림 + mainPage로 이동
mainBack.addEventListener("click", () => {
    // 예시로 해놓은거
    alert("메인페이지로 이동되었습니다!");
    // 위에 alert 지우고 등록된 팀 목록보기 버튼 눌렀을때 매칭 메인페이지로 이동하게 코드작성
});

// 마우스 올렸을때 배경색 바꾸기위해 버튼 class가져오기
const btnBackgroundColor = document.querySelector(".back-button");

// 마우스를 버튼 위로 가져갔을 때 색바뀜
btnBackgroundColor.addEventListener("mouseover", function () {
    btnBackgroundColor.style.backgroundColor = "rgb(192,192,192)";
});

// 마우스를 버튼에서 뗐을 때 원래색으로 돌아옴
btnBackgroundColor.addEventListener("mouseout", function () {
    btnBackgroundColor.style.backgroundColor = "";
});

// -------------------------------------------------------------------

// .sider-1안에 있는 신청하기버튼
const applyButton = document.querySelector(".side-match-btn");

// .sider-2안에 있는 x 이미지(신청하기 닫기)
const applyCloseButton = document.querySelector(".apply-close-btn");

// .sider-2안에 있는 신청완료 버튼누르기 (신청완료됨)
const applyCompleteButton = document.querySelector(".apply-complete-btn");

// 신청하기와 유사한 추천매칭팀 div
const sideDiv1 = document.querySelector(".sider-1");

// 신청하기 신청상세 div
const sideDiv2 = document.querySelector(".sider-2");

// 신청완료시 신청완료 완료 됬다는 div
const sideDiv3 = document.querySelector(".sider-3");

// 신청하기 버튼누르면 신청 div나옴 페이지이동 X
applyButton.addEventListener("click", () => {
    sideDiv1.style.display = "none";
    sideDiv2.style.display = "block";
});

// x 이미지 누르면 초기화면 나옴 페이지이동 X
applyCloseButton.addEventListener("click", () => {
    sideDiv1.style.display = "block";
    sideDiv2.style.display = "none";
});

// 신청완료 버튼 누를시 신청완료 div나옴 페이지이동 X
applyCompleteButton.addEventListener("click", () => {
    // 매칭신청완료시 알림 뜸 (서버관리배우면 여기는 수정)
    alert("매칭 신청완료!");
    sideDiv2.style.display = "none";
    sideDiv3.style.display = "block";
});

// 팀 정보보기 버튼
const teamInfoButton = document.querySelector(".team-ifo-btn");

// 버튼 누를시 팀 정보 상세페이지로 이동 (추후에 변동)
teamInfoButton.addEventListener("click", () => {
    alert("팀정보를 불러옵니다.");
});
