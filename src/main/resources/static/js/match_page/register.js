// 상위 목록에 마우스를 올리면 색 변화, 떼면 원래대로
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

// 다음단계 이전단계 등록완료 버튼 가져오기
const nextButton1 = document.querySelector(".next-button-1");
const nextButton2 = document.querySelector(".next-button-2");
const beforeButton1 = document.querySelector(".before-button-1");
const beforeButton2 = document.querySelector(".before-button-2");
const finishButton = document.querySelector(".finish-button");

// 각 폼들 가져오기
const form1 = document.getElementById("form-1");
const form2 = document.getElementById("form-2");
const form3 = document.getElementById("form-3");

// 다음 버튼 클릭(Form 1 -> Form 2)
nextButton1.addEventListener("click", () => {
    if (!validateForm1()) {
        return;
    }
    form1.style.display = "none";
    form2.style.display = "block";
});

// 다음 버튼 클릭(Form 2 -> Form 3)
nextButton2.addEventListener("click", () => {
    if (!validateForm2()) {
        return;
    }
    form2.style.display = "none";
    form3.style.display = "block";
});

// Form 1 유효성 검사
function validateForm1() {
    const sportChecked = document.querySelector("input[name='sport']:checked"); // Radio button 선택 여부 확인

    let isValid = true;

    // 스포츠 종목 유효성 검사 (Radio button)
    if (!sportChecked) {
        showError("sport", "스포츠 종목을 선택해 주세요.");
        isValid = false;
    } else {
        hideError("sport");
    }

    return isValid;
}

// Form 2 유효성 검사 - 시간 및 날짜 형식 포함
function validateForm2() {
    const place = document.querySelector("select[name='place']").value;
    const localCity = document.querySelector("select[name='localCity']").value;
    const placeDetail = document.querySelector("input[name='placeDetail']").value.trim();
    const timeRegist = document.querySelector("input[name='timeRegist']");
    const timeCoordinate = document.querySelector("input[name='time-coordinate']:checked");
    const dateRegist = document.querySelector("input[name='dateRegist']");
    const dateCoordinate = document.querySelector("input[name='date-coordinate']:checked");

    let isValid = true;

    // 매칭 등록지역 유효성 검사
    if (!place) {
        showError("place", "매칭 등록지역을 선택해 주세요.");
        isValid = false;
    } else {
        hideError("place");
    }

    // 상세 지역 유효성 검사
    if (!localCity) {
        showError("localCity", "상세 지역을 선택해 주세요.");
        isValid = false;
    } else {
        hideError("localCity");
    }

    // 상세지역/장소명 유효성 검사
    if (!placeDetail) {
        showError("placeDetail", "상세지역/장소명을 입력해 주세요.");
        isValid = false;
    } else {
        hideError("placeDetail");
    }

    // 경기 시작시간 유효성 검사 (빈칸일 경우에도)
    if (!timeRegist.value.trim()) {
        showError("timeRegist", "경기 시작시간을 입력해 주세요.");
        isValid = false;
    } else if (!timeRegist.checkValidity()) {
        showError("timeRegist", "시간은 '12시' 형식으로 입력해주세요.");
        isValid = false;
    } else {
        hideError("timeRegist");
    }

    // 매칭 희망날짜 유효성 검사 (빈칸일 경우에도)
    if (!dateRegist.value.trim()) {
        showError("dateRegist", "매칭 희망날짜를 입력해 주세요.");
        isValid = false;
    } else if (!dateRegist.checkValidity()) {
        showError("dateRegist", "날짜는 'YYYY-MM-DD' 형식으로 입력해주세요.");
        isValid = false;
    } else {
        hideError("dateRegist");
    }

    // 경기 시간 조율 여부 유효성 검사
    if (!timeCoordinate) {
        showError("time-coordinate", "경기 시간 조율 여부를 선택해 주세요.");
        isValid = false;
    } else {
        hideError("time-coordinate");
    }

    // 경기 날짜 협의 여부 유효성 검사
    if (!dateCoordinate) {
        showError("date-coordinate", "경기 날짜 협의 여부를 선택해 주세요.");
        isValid = false;
    } else {
        hideError("date-coordinate");
    }

    return isValid;
}

// 오류 메시지 표시 함수
function showError(field, message) {
    const error = document.querySelector(`.input-explain-error[data-field='${field}']`);
    if (error) {
        error.textContent = message;  // 에러 메시지 설정
        error.hidden = false;         // 에러 메시지 표시
    }
}

// 오류 메시지 숨김 함수
function hideError(field) {
    const error = document.querySelector(`.input-explain-error[data-field='${field}']`);
    if (error) {
        error.hidden = true;  // 에러 메시지 숨기기
    }
}








// 시/도 별로 구/군 데이터를 미리 정의
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
    강원특별자치도: [
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
    전북특별자치도: [
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

// 첫 번째 셀렉트 요소와 두 번째 셀렉트 요소 가져오기
const citySelect = document.querySelector('select[name="place"]');
const districtSelect = document.querySelector('select[name="localCity"]');

// 시/도 선택 시 구/군 목록 업데이트
citySelect.addEventListener("change", function () {
    const selectedCity = citySelect.value;
    districtSelect.innerHTML = '<option value="" disabled selected>상세 지역 선택</option>';

    if (districts[selectedCity]) {
        districts[selectedCity].forEach(function (district) {
            const option = document.createElement("option");
            option.value = district;
            option.textContent = district;
            districtSelect.appendChild(option);
        });
    }
});

// DOM이 로드된 후 자바스크립트 실행
document.addEventListener("DOMContentLoaded", function() {
    // 스포츠 종목 선택 처리
    const sportRadios = document.querySelectorAll("input[name='sport']");
    sportRadios.forEach(radio => {
        radio.addEventListener("change", (e) => {
            const selectedSport = e.target.value;
            const sportKindValue = document.querySelector("input[name='sportKindValue']");
            if (sportKindValue) {
                sportKindValue.value = selectedSport;
            }
            console.log("선택된 스포츠 종목:", selectedSport);
        });
    });

    // 지역 선택 처리
    const city = document.querySelector("select[name='place']");
    const local = document.querySelector("select[name='localCity']");

    city.addEventListener("change", (e) => {
        const selectedCity = city.value;
        local.innerHTML = `<option value="" selected>상세 지역 선택</option>`;
        if (districts[selectedCity]) {
            districts[selectedCity].forEach((district) => {
                const option = document.createElement("option");
                option.value = district;
                option.textContent = district;
                local.appendChild(option);
            });
        }
        const cityInput = document.querySelector("input[name='city']");
        if (cityInput) {
            cityInput.value = selectedCity;
        }
        console.log("선택된 값:", selectedCity);
    });

    local.addEventListener("change", (e) => {
        const selectedLocal = local.value;
        const localCityInput = document.querySelector("input[name='localCity']");
        if (localCityInput) {
            localCityInput.value = selectedLocal;
        }
        console.log("선택된 값:", selectedLocal);
    });

    // 오전/오후 선택 처리
    const choiceAmPm = document.querySelector("select[name='times']");
    choiceAmPm.addEventListener("change", (e) => {
        const selectedAmPm = choiceAmPm.value;
        const amPmInput = document.querySelector("input[name='choiceAmPm']");
        if (amPmInput) {
            amPmInput.value = selectedAmPm;
        }
        console.log("선택된 값:", selectedAmPm);
    });

    // 경기 시간 조율 여부 처리
    const timeCordinateRadios = document.querySelectorAll("input[name='time-coordinate']");
    timeCordinateRadios.forEach(radio => {
        radio.addEventListener("change", (e) => {
            const selectedTimeCordinate = e.target.value;
            const timeCordinateInput = document.querySelector("input[name='timeCordinate']");
            if (timeCordinateInput) {
                timeCordinateInput.value = selectedTimeCordinate;
            }
            console.log("경기 시간 조율 여부 선택된 값:", selectedTimeCordinate);
        });
    });

    // 경기 날짜 협의 여부 처리
    const dateCordinateRadios = document.querySelectorAll("input[name='date-coordinate']");
    dateCordinateRadios.forEach(radio => {
        radio.addEventListener("change", (e) => {
            const selectedDateCordinate = e.target.value;
            const dateCordinateInput = document.querySelector("input[name='dateCordinate']");
            if (dateCordinateInput) {
                dateCordinateInput.value = selectedDateCordinate;
            }
            console.log("경기 날짜 협의 여부 선택된 값:", selectedDateCordinate);
        });
    });

    // 등록완료 버튼 클릭 시 값 전송 처리
    document.querySelector(".finish-button").addEventListener("click", function(event) {
        event.preventDefault(); // 기본 submit 동작 방지

        // POST_TYPE을 2로 설정
        const postTypeInput = document.querySelector("input[name='postType']");
        if (postTypeInput) {
            postTypeInput.value = 2;  // 매칭 글의 POST_TYPE은 항상 2
        }

        // MATCHING_STATUS 값을 기본적으로 '매칭중'으로 설정
        const matchingStatusInput = document.querySelector("input[name='matchingStatus']");
        if (matchingStatusInput) {
            matchingStatusInput.value = '매칭중'; // 기본값 설정
        }

        // 매칭글 제목을 join-form의 hidden 필드로 복사
        const postTitleInput = document.querySelector("input[name='title']");

        // 제목이 비었을 때 경고 메시지 출력
        if (!postTitleInput || !postTitleInput.value.trim()) {
            alert("매칭글 제목을 입력해주세요.");
            return;  // 유효성 검사 실패 시 submit 중지
        }
        const hiddenPostTitleInput = document.querySelector("input[name='postTitle']");
        if (postTitleInput && hiddenPostTitleInput) {
            hiddenPostTitleInput.value = postTitleInput.value;  // 제목 필드 복사
        }

        // 매칭글 내용을 join-form의 hidden 필드로 복사
        const postContent = document.querySelector("textarea[name='postContent']");
        // 주의/요구사항이 비었을 때 경고 메시지 출력
        if (!postContent || !postContent.value.trim()) {
            alert("주의/요구사항을 입력해주세요.");
            return;  // 유효성 검사 실패 시 submit 중지
        }
        const hiddenPostContentInput = document.querySelector("input[name='postContent']");
        if (postContent && hiddenPostContentInput) {
            hiddenPostContentInput.value = postContent.value;  // 내용 필드 복사
        }

        // 경기 시간을 join-form의 hidden 필드로 복사
        const timeRegister = document.querySelector("input[name='timeRegist']");
        const hiddenTimeRegisterInput = document.querySelector("input[name='timeRegister']");
        if (timeRegister && hiddenTimeRegisterInput) {
            hiddenTimeRegisterInput.value = timeRegister.value;  // 경기 시간 복사
        }

        // 경기 날짜를 join-form의 hidden 필드로 복사
        const dateRegister = document.querySelector("input[name='dateRegist']");
        const hiddenDateRegisterInput = document.querySelector("input[name='dateRegister']");
        if (dateRegister && hiddenDateRegisterInput) {
            hiddenDateRegisterInput.value = dateRegister.value;  // 경기 날짜 복사
        }

        // 지역 상세 정보를 join-form에 복사
        const localCityDetail = document.querySelector("input[name='placeDetail']");
        const hiddenLocalCityDetailInput = document.querySelector("input[name='localCityDetail']");
        if (localCityDetail && hiddenLocalCityDetailInput) {
            hiddenLocalCityDetailInput.value = localCityDetail.value;  // 상세 지역 복사
        }

        // 필수 입력 필드 확인
        if (!postTitleInput || !postTitleInput.value.trim()) {
            showError("title", "매칭글 제목을 입력해주세요.");
            return;
        } else {
            hideError("title");
        }

        if (!postContent || !postContent.value.trim()) {
            showError("postContent", "매칭글 내용을 입력해주세요.");
            return;
        } else {
            hideError("postContent");
        }

        if (!timeRegister || !timeRegister.value.trim()) {
            showError("timeRegist", "경기 시간을 입력해주세요.");
            return;
        } else {
            hideError("timeRegist");
        }

        if (!dateRegister || !dateRegister.value.trim()) {
            showError("dateRegist", "경기 날짜를 입력해주세요.");
            return;
        } else {
            hideError("dateRegist");
        }





        // // 제목과 주의사항 확인 후 경고 메시지
        // if (!postTitleInput.value.trim() || !postContent.value.trim()) {
        //     alert("제목과 주의사항을 입력해주세요!");
        //     return;  // 유효성 검사 실패 시 submit 중지
        // }

        // 모든 값이 유효할 경우 폼 제출
        // alert("매칭 등록 완료!!");
        document.querySelector("form[name='join-form']").submit();
    });
});
