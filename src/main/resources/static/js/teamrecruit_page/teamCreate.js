// 상위 목록에 마우스 가져다대면 색변화 때면 원래대로
document.querySelectorAll(".span-step").forEach((step) => {
    const stepInfo = step.querySelector(".span-step-1");

    step.addEventListener("mouseover", () => {
        stepInfo.style.display = "block";
        step.style.backgroundColor = "gray";
    });

    step.addEventListener("mouseout", () => {
        stepInfo.style.display = "none";
        step.style.backgroundColor = "";
    });
});
// 다음단계 이전단계 등록완료 버튼 가져오가
const nextButton1 = document.querySelector(".next-button-1");
const nextButton2 = document.querySelector(".next-button-2");
const beforeButton1 = document.querySelector(".before-button-1");
const beforeButton2 = document.querySelector(".before-button-2");

// 각 폼들 가져오기
const form1 = document.getElementById("form-1");
const form2 = document.getElementById("form-2");
const form3 = document.getElementById("form-3");

const soccer = document.getElementById('soccer');
const basketball = document.getElementById('basketball');
const baseball = document.getElementById('baseball');
const badminton = document.getElementById('badminton');
const jokgu = document.getElementById('jokgu');
const sportsKindRadioValueError = document.getElementById('sportsKindRadioValue-error');

const teamName = document.getElementById('teamName'); //팀명 입력 필드 값;
const teamNameError = document.getElementById('teamName-error');

// 다음 버튼 클릭(Form 1 -> Form 2) // 유효성 검사 진행 후
nextButton1.addEventListener("click", (e) => {
    e.preventDefault();// 기본 폼 제출을 막음

    let selectedValue = null;

    // Radio 버튼 중 하나라도 선택되었는지 확인
    if (soccer.checked) {
        selectedValue = soccer.value; // 축구 radio 버튼 선택 시
    } else if (basketball.checked) {
        selectedValue = basketball.value; // 농구 radio 버튼 선택 시
    } else if (baseball.checked) {
        selectedValue = baseball.value; // 야구 radio 버튼 선택 시
    } else if (badminton.checked) {
        selectedValue = badminton.value; // 배드민턴 radio 버튼 선택 시
    } else if (jokgu.checked) {
        selectedValue = jokgu.value; // 족구 radio 버튼 선택 시
    }

    // 스포츠 종목 유효성 검사
    if (!selectedValue) {
        // 유효하지 않을 경우
        sportsKindRadioValueError.style.display = 'block'; // 경고 메시지 보이기
        // 유효할 경우
    } else {
        sportsKindRadioValueError.style.display = 'none'; // 경고 메시지 숨기
    }

    // 팀명 유효성 검사
    if (!teamName.value) {
        // 유효하지 않을 경우
        teamName.classList.add('input-error'); // 빨간 테두리 추가
        teamNameError.style.display = 'block'; // 경고 메시지 보이기
    } else {
        // 유효할 경우
        teamName.classList.remove('input-error'); // 빨간 테두리 제거
        teamNameError.style.display = 'none'; // 경고 메시지 숨기기
    }

    // 다음 단계로 이동 (Form 1 -> Form 2)
    if (selectedValue && teamName.value) {
        form1.style.display = "none";
        form2.style.display = "block";
    } else {
        alert("입력하지 않은 정보가 있습니다.")
    }
});

// 이전 버튼 클릭(Form 2 -> Form 1)
beforeButton1.addEventListener("click", () => {
    form2.style.display = "none";
    form1.style.display = "block";
});

// 시/도 별로 구/군 데이터를 미리 정의합니다.
const districts = {
    서울특별시: [
        "강남구",
        "강동구",
        "강북구",
        "강서구",
        "관악구",
        "광진구",
        "구로구",
        "금천구",
        "노원구",
        "도봉구",
        "동대문구",
        "동작구",
        "마포구",
        "서대문구",
        "서초구",
        "성동구",
        "성북구",
        "송파구",
        "양천구",
        "영등포구",
        "용산구",
        "은평구",
        "종로구",
        "중구",
        "중랑구",
    ],
    부산광역시: [
        "강서구",
        "금정구",
        "남구",
        "동구",
        "동래구",
        "부산진구",
        "북구",
        "사상구",
        "사하구",
        "서구",
        "수영구",
        "연제구",
        "영도구",
        "중구",
        "해운대구",
        "기장군",
    ],
    대구광역시: [
        "중구",
        "동구",
        "서구",
        "남구",
        "북구",
        "수성구",
        "달서구",
        "달성군",
    ],
    인천광역시: [
        "중구",
        "동구",
        "미추홀구",
        "연수구",
        "남동구",
        "부평구",
        "계양구",
        "서구",
        "강화군",
        "옹진군",
    ],
    광주광역시: ["동구", "서구", "남구", "북구", "광산구"],
    대전광역시: ["동구", "중구", "서구", "유성구", "대덕구"],
    울산광역시: ["중구", "남구", "동구", "북구", "울주군"],
    세종특별자치시: [
        "가람동",
        "도담동",
        "새롬동",
        "어진동",
        "연서면",
        "연동면",
        "전의면",
        "전동면",
        "도래면",
        "불은면",
    ],
    경기도: [
        "수원시",
        "성남시",
        "의정부시",
        "안양시",
        "부천시",
        "광명시",
        "평택시",
        "동두천시",
        "안산시",
        "고양시",
        "과천시",
        "구리시",
        "남양주시",
        "오산시",
        "시흥시",
        "군포시",
        "의왕시",
        "하남시",
        "용인시",
        "파주시",
        "이천시",
        "안성시",
        "김포시",
        "화성시",
        "광주시",
        "양주시",
        "포천시",
        "여주시",
        "연천군",
        "가평군",
        "양평군",
    ],
    강원도: [
        "춘천시",
        "원주시",
        "강릉시",
        "동해시",
        "태백시",
        "속초시",
        "삼척시",
        "홍천군",
        "횡성군",
        "영월군",
        "평창군",
        "정선군",
        "철원군",
        "화천군",
        "양구군",
        "인제군",
        "고성군",
        "양양군",
    ],
    충청북도: [
        "청주시",
        "충주시",
        "제천시",
        "보은군",
        "옥천군",
        "영동군",
        "진천군",
        "괴산군",
        "음성군",
        "단양군",
    ],
    충청남도: [
        "천안시",
        "공주시",
        "보령시",
        "아산시",
        "서산시",
        "논산시",
        "계룡시",
        "당진시",
        "금산군",
        "부여군",
        "서천군",
        "청양군",
        "홍성군",
        "예산군",
        "태안군",
    ],
    전라북도: [
        "전주시",
        "군산시",
        "익산시",
        "정읍시",
        "남원시",
        "김제시",
        "완주군",
        "진안군",
        "무주군",
        "장수군",
        "임실군",
        "순창군",
        "고창군",
        "부안군",
    ],
    전라남도: [
        "목포시",
        "여수시",
        "순천시",
        "나주시",
        "광양시",
        "담양군",
        "곡성군",
        "구례군",
        "고흥군",
        "보성군",
        "화순군",
        "장흥군",
        "강진군",
        "해남군",
        "영암군",
        "무안군",
        "함평군",
        "영광군",
        "장성군",
        "완도군",
        "진도군",
        "신안군",
    ],
    경상북도: [
        "포항시",
        "경주시",
        "김천시",
        "안동시",
        "구미시",
        "영주시",
        "영천시",
        "상주시",
        "문경시",
        "경산시",
        "군위군",
        "의성군",
        "청송군",
        "영양군",
        "영덕군",
        "청도군",
        "고령군",
        "성주군",
        "칠곡군",
        "예천군",
        "봉화군",
        "울진군",
        "울릉군",
    ],
    경상남도: [
        "창원시",
        "진주시",
        "통영시",
        "사천시",
        "김해시",
        "밀양시",
        "거제시",
        "양산시",
        "의령군",
        "함안군",
        "창녕군",
        "고성군",
        "남해군",
        "하동군",
        "산청군",
        "함양군",
        "거창군",
        "합천군",
    ],
    제주특별자치도: ["제주시", "서귀포시"],
};

const city = document.getElementById("city");
const local = document.getElementById("localCity");
const cityError = document.getElementById('city-error');
const detailedArea = document.getElementById('detailedArea');
const detailedAreaError = document.getElementById('detailedArea-error');
const teamActivityTime = document.getElementById('teamActivityTime');
const teamActivityTimeError = document.getElementById('teamActivityTime-error');
const ageRange = document.getElementById('ageRange');
const ageRangeError = document.getElementById('ageRange-error');

city.addEventListener("change", (e) => {
    let text = `<option value="" selected>상세 지역 선택</option>`;
    console.log(districts[city.value]);
    districts[city.value].forEach((district) => {
        text += `
            <option value="${district}">${district}</option>
        `
    });
    local.innerHTML = text;
} )

// 다음 버튼 클릭(Form 2 -> Form 3) // 유효성 검사 진행 후
nextButton2.addEventListener("click", (e) => {
    e.preventDefault();// 기본 폼 제출을 막음

    // 상세주소 유효성 검사
    if (!local.value) {
        // 유효하지 않을 경우
        local.classList.add('input-error'); // 빨간 테두리 추가
        cityError.style.display = 'block'; // 경고 메시지 보이기
    } else {
        // 유효할 경우
        local.classList.remove('input-error'); // 빨간 테두리 제거
        cityError.style.display = 'none'; // 경고 메시지 숨기기
    }

    // 상세주소 유효성 검사
    if (!detailedArea.value) {
        // 유효하지 않을 경우
        detailedArea.classList.add('input-error'); // 빨간 테두리 추가
        detailedAreaError.style.display = 'block'; // 경고 메시지 보이기
    } else {
        // 유효할 경우
        detailedArea.classList.remove('input-error'); // 빨간 테두리 제거
        detailedAreaError.style.display = 'none'; // 경고 메시지 숨기기
    }

    // 팀 활동시간 유효성 검사
    if (!teamActivityTime.value) {
        // 유효하지 않을 경우
        teamActivityTime.classList.add('input-error'); // 빨간 테두리 추가
        teamActivityTimeError.style.display = 'block'; // 경고 메시지 보이기
    } else {
        // 유효할 경우
        teamActivityTime.classList.remove('input-error'); // 빨간 테두리 제거
        teamActivityTimeError.style.display = 'none'; // 경고 메시지 숨기기
    }

    // 나이대 유효성 검사
    if (!ageRange.value) {
        // 유효하지 않을 경우
        ageRange.classList.add('input-error'); // 빨간 테두리 추가
        ageRangeError.style.display = 'block'; // 경고 메시지 보이기
    } else {
        // 유효할 경우
        ageRange.classList.remove('input-error'); // 빨간 테두리 제거
        ageRangeError.style.display = 'none'; // 경고 메시지 숨기기
    }

    // 다음 단계로 이동 (Form 1 -> Form 2)
    if (local.value && detailedArea.value &&
        teamActivityTime.value && ageRange.value) {
        form2.style.display = "none";
        form3.style.display = "block";
    } else {
        alert("입력하지 않은 정보가 있습니다.")
    }
});

// 이전 버튼 클릭 (Form 3 -> Form 2)
beforeButton2.addEventListener("click", () => {
    form3.style.display = "none";
    form2.style.display = "block";
});



