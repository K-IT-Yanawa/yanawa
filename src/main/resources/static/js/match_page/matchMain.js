// <select> 요소 추가
const select = document.createElement("select");
select.name = "time";
select.className = "select-input";

// 기본 선택 옵션 추가
const defaultOption = document.createElement("option");
defaultOption.value = "";
// 기본 옵션 선택 불가
defaultOption.disabled = true;
// 기본적으로 선택되게 함
defaultOption.selected = true;
defaultOption.textContent = "매칭 시간 선택";
select.appendChild(defaultOption);

// 오전 시간 추가
for (let i = 1; i <= 12; i++) {
    const option = document.createElement("option");
    option.value = "오전";
    option.textContent = `오전 ${i}시`;
    select.appendChild(option);
}

// 오후 시간 추가
for (let i = 1; i <= 12; i++) {
    const option = document.createElement("option");
    option.value = "오후";
    option.textContent = `오후 ${i}시`;
    select.appendChild(option);
}
// <div class="label-container time"> 요소 아래에 <select> 추가
const container = document.querySelector(".label-container.time");
container.appendChild(select);

// 조회하기 div가져오기
const searchAll = document.querySelector(".search-all");

// 조회하기 눌렀을때 알림 + form 제출로 조회결과 제출
searchAll.addEventListener("click", () => {
    alert("조회가 완료되었습니다!");
    document.getElementById("searchForm").submit();
});

//팀명검색 돋보기 이미지 가져오기
const button = document.querySelector("button");

// 돋보기 눌렀을때 팀명 조회결과 나옴
button.addEventListener("click", () => {
    alert("팀명 검색이 완료되었습니다!");
    document.getElementById("teamForm").submit();
});

// 매칭중인팀보기 버튼 clsss 가져오기
const matchDoingButtonOn = document.querySelector(".match-doing-button.on");
const matchDoingButtonOff = document.querySelector(".match-doing-button.off");

// 매칭중인팀보기 버튼 id 가져오기
const ButtonOn = document.getElementById("button-on");
const ButtonOff = document.getElementById("button-off");

// 기존에 off버튼이 css에서 none이 되어있는거를 on버튼을 눌렀을때 off버튼 나타나게 하기
matchDoingButtonOn.addEventListener("click", () => {
    ButtonOn.style.display = "none";
    ButtonOff.style.display = "inline-block";
});
//off 버튼을 눌렀을때 on버튼 나타나게 하기
matchDoingButtonOff.addEventListener("click", () => {
    ButtonOn.style.display = "inline-block";
    ButtonOff.style.display = "none";
});

// 색 바꾸기위해 h1 id 가져옴
const colorChange = document.getElementById("color-change");

// matchMain.css 에 space-item-text 클래스 색을 가져옴
const originColor = "rgb(50, 87, 182)";

// 바꿀 색
const redColor = "red";

// 번갈아가면서 변경되기위해 사용
let color = true;

// 0.5초마다 색바뀜
setInterval(() => {
    colorChange.style.color = color ? redColor : originColor;
    color = !color;
}, 500);

// 팀 등록하기 div가져오기
const register = document.querySelector(".register-div");

// 조회하기 눌렀을때 알림 + form 제출로 조회결과 제출
register.addEventListener("click", () => {
    // 예시로 해놓은거
    alert("등록이 완료되었습니다!");
    // 위에 alert 지우고 등록하기 버튼 눌렀을때 등록 페이지로 이동하게 코드작성
});
