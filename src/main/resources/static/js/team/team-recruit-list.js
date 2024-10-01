// 모달 창을 열고 닫는 이벤트 리스너
document
    .querySelector(".sc-31c8ace3-1.jQKJcA.sc-227412f9-1.MeFJX.combobox-item")
    .addEventListener("click", function () {
        document.querySelector(".sc-8482e18-0.lmEuWa").style.display = "flex"; // 모달 창을 표시
    });

document
    .querySelector(".header-close button")
    .addEventListener("click", function () {
        document.querySelector(".sc-8482e18-0.lmEuWa").style.display = "none"; // 모달 창을 숨김
    });

// 지역 선택 목록을 생성 및 표시하는 기능
document
    .querySelector(
        ".sc-31c8ace3-1.jQKJcA.sc-2f90fd29-0.eCYVLr .label-container"
    )
    .addEventListener("click", function () {
        const areaList = document.querySelector(".selected-skill-area");
        areaList.innerHTML = ""; // 기존 내용을 초기화

        // "selected-skill-area" 요소를 표시
        areaList.style.display = "block";

        const regions = [
            "서울특별시",
            "부산광역시",
            "대구광역시",
            "인천광역시",
            "광주광역시",
            "대전광역시",
            "울산광역시",
            "세종특별자치시",
            "경기도",
            "강원도",
            "충청북도",
            "충청남도",
            "전라북도",
            "전라남도",
            "경상북도",
            "경상남도",
            "제주특별자치도",
        ];

        regions.forEach(function (region) {
            const listItem = document.createElement("li");
            listItem.textContent = region;
            listItem.className = "region-item"; // CSS 적용을 위한 클래스 설정
            areaList.appendChild(listItem);

            // 클릭 시 선택된 시/도 이름을 바로 .selected-value에 반영
            listItem.addEventListener("click", function () {
                document.querySelector(
                    ".sc-31c8ace3-1.jQKJcA.sc-2f90fd29-0.eCYVLr .selected-value"
                ).textContent = region;
                areaList.style.display = "none"; // 시/도 목록 숨기기

                // 기존의 시/군/구 선택 UI가 있으면 제거
                const existingSubRegionDiv =
                    document.querySelector(".sub-region-select");
                if (existingSubRegionDiv) {
                    existingSubRegionDiv.remove();
                }

                // 선택한 지역에 따라 시/군/구 선택 UI 생성
                createSubRegionSelect(region);
            });
        });
    });

// 시/군/구 선택 UI를 생성하는 함수
function createSubRegionSelect(region) {
    const regionToSubRegions = {
        서울특별시: ["종로구", "중구", "용산구", "성동구", "광진구"],
        부산광역시: ["해운대구", "사하구", "남구", "동래구", "연제구"],
        대구광역시: ["중구", "동구", "서구", "남구", "북구"],
        인천광역시: ["중구", "동구", "미추홀구", "연수구", "남동구"],
        광주광역시: ["동구", "서구", "남구", "북구", "광산구"],
        대전광역시: ["동구", "중구", "서구", "유성구", "대덕구"],
        울산광역시: ["중구", "남구", "동구", "북구", "울주군"],
        세종특별자치시: ["전체"],
        경기도: ["수원시", "고양시", "용인시", "성남시", "부천시"],
        강원도: ["춘천시", "원주시", "강릉시", "동해시", "태백시"],
        충청북도: ["청주시", "충주시", "제천시", "보은군", "옥천군"],
        충청남도: ["천안시", "공주시", "보령시", "아산시", "서산시"],
        전라북도: ["전주시", "군산시", "익산시", "정읍시", "남원시"],
        전라남도: ["목포시", "여수시", "순천시", "나주시", "광양시"],
        경상북도: ["포항시", "경주시", "김천시", "안동시", "구미시"],
        경상남도: ["창원시", "진주시", "통영시", "사천시", "김해시"],
        제주특별자치도: ["제주시", "서귀포시"],
    };

    const subRegions = regionToSubRegions[region] || [];

    // 새로운 div 생성
    const subRegionDiv = document.createElement("div");
    subRegionDiv.className =
        "sc-31c8ace3-1 jQKJcA sc-2f90fd29-0 eCYVLr jobs-select sub-region-select";
    subRegionDiv.style.zIndex = "100"; // z-index 설정하여 확인 버튼보다 위에 표시되도록 설정
    subRegionDiv.style.height = "48px";

    // label-container 생성
    const labelContainer = document.createElement("div");
    labelContainer.className = "label-container";

    // placeholder 생성
    const placeholder = document.createElement("span");
    placeholder.className = "selected-value placeholder";
    placeholder.textContent = "시/군/구를 선택해주세요";

    // 화살표 아이콘 추가
    const arrowIcon = document.createElement("img");
    arrowIcon.src = "data:image/svg+xml;base64,..."; // 여기에 화살표 아이콘의 base64 데이터를 추가
    arrowIcon.className = "rotate";
    arrowIcon.width = 8;
    arrowIcon.height = 6;

    labelContainer.appendChild(placeholder);
    labelContainer.appendChild(arrowIcon);
    subRegionDiv.appendChild(labelContainer);

    // 시/군/구 리스트를 보여줄 ul 요소 생성
    const subRegionList = document.createElement("ul");
    subRegionList.className = "selected-skill-area";
    subRegionList.style.display = "none"; // 처음에는 숨김

    // 시/군/구 목록 생성
    subRegions.forEach(function (subRegion) {
        const listItem = document.createElement("li");
        listItem.textContent = subRegion;
        listItem.className = "region-item";
        subRegionList.appendChild(listItem);

        // 클릭 시 선택된 시/군/구 표시 및 리스트 숨기기
        listItem.addEventListener("click", function () {
            placeholder.textContent = subRegion;
            subRegionList.style.display = "none";
        });
    });

    subRegionDiv.appendChild(subRegionList);
    document
        .querySelector(".sc-8482e18-0.lmEuWa .content .middle")
        .appendChild(subRegionDiv);

    // 시/군/구 placeholder 클릭 시 리스트 표시
    placeholder.addEventListener("click", function () {
        subRegionList.style.display =
            subRegionList.style.display === "block" ? "none" : "block";
    });

    // 시/군/구 선택 후 확인 버튼 클릭 시 반영
    const confirmButton = document.querySelector(".sc-563f0eef-0-button.xVimo");

    const newButton = confirmButton.cloneNode(true);
    confirmButton.parentNode.replaceChild(newButton, confirmButton);

    newButton.addEventListener("click", function () {
        const selectedSubRegion = placeholder.textContent;
        document.querySelector(
            ".sc-31c8ace3-1.jQKJcA.sc-227412f9-1.MeFJX .selected-value"
        ).textContent = selectedSubRegion;
        document.querySelector(".sc-8482e18-0.lmEuWa").style.display = "none";
    });
}

// 모든 label-container를 선택
const labelContainers = document.querySelectorAll(".label-container");

// 세 번째 label-container가 스포츠 종목을 위한 것
const sportSelect = labelContainers[2]; // 세 번째 요소

// "전체"가 표시되는 요소 선택
const selectedValueElement = document.querySelector("#sportsall");

// 스포츠 종목 선택 박스에 대한 이벤트 리스너
sportSelect.addEventListener("click", function () {
    // 현재 sportSelect와 연결된 combobox-option-list만 열리도록 설정
    const sportOptionList = sportSelect.nextElementSibling;
    sportOptionList.style.display =
        sportOptionList.style.display === "block" ? "none" : "block";
});

// 선택된 항목을 추적할 변수
let selectedItem = null;

// 스포츠 종목 리스트의 각 항목에 대한 이벤트 리스너
const sportItems =
    sportSelect.nextElementSibling.querySelectorAll(".con-area li");
sportItems.forEach(function (item) {
    item.addEventListener("click", function () {
        // 이전에 선택된 항목이 있다면 선택 해제
        if (selectedItem) {
            selectedItem.classList.remove("selected");
            const img = selectedItem.querySelector("img");
            if (img) {
                img.remove();
            }
        }

        // 현재 선택된 항목 업데이트 및 체크 아이콘 표시
        item.classList.add("selected");
        selectedItem = item;

        const img = document.createElement("img");
        img.src =
            "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDI1LjEuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPgo8c3ZnIHZlcnNpb249IjEuMSIgaWQ9IkxheWVyXzEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IgoJIHZpZXdCb3g9IjAgMCAxMiAxMiIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgMTIgMTI7IiB4bWw6c3BhY2U9InByZXNlcnZlIj4KPHN0eWxlIHR5cGU9InRleHQvY3NzIj4KCS5zdDB7ZmlsbDogIzMzNjZmZn0KCS5zdDB7ZmlsbC1ydWxlOmV2ZW5vZGQ7Y2xpcC1ydWxlOmV2ZW5vZGQ7fQoJLnN0MXtmaWx0ZXI6dXJsKCNBZG9iZV9PcGFjaXR5TWFza0ZpbHRlcik7fQoJLnN0MntmaWxsLXJ1bGU6ZXZlbm9kZDtjbGlwLXJ1bGU6ZXZlbm9kZDtmaWxsOiNGRkZGRkY7fQoJLnN0M3ttYXNrOnVybCgjbWFzay0yXzFfKTt9Cjwvc3R5bGU+CjxnIGlkPSJfeDJEX2ljb24iPgoJPGcgaWQ9Ikljb24tX3gyRl8tRml0LV94MkZfLXNlbGVjdGVkIiB0cmFuc2Zvcm09InRyYW5zbGF0ZSgwLjAwMDAwMCwgMi4wMDAwMDApIj4KCQk8ZyBpZD0iaWNvbl9zZWxlY3RlZCI+CgkJCTxwYXRoIGlkPSJwYXRoLTFfMV8iIGNsYXNzPSJzdDAiIGQ9Ik01LDhDNC43LDgsNC41LDcuOSw0LjMsNy43bC00LTMuOWMtMC40LTAuNC0wLjQtMSwwLTEuNGMwLjQtMC40LDEtMC40LDEuNCwwTDUsNS42bDUuMy01LjMKCQkJCWMwLjQtMC40LDEtMC40LDEuNCwwYzAuNCwwLjQsMC40LDEsMCwxLjRsLTYsNkM1LjUsNy45LDUuMiw4LDUsOCIvPgoJCTwvZz4KCQk8ZGVmcz4KCQkJPGZpbHRlciBpZD0iQWRvYmVfT3BhY2l0eU1hc2tGaWx0ZXIiIGZpbHRlclVuaXRzPSJ1c2VyU3BhY2VPblVzZSI+CgkJCQk8ZmVDb2xvck1hdHJpeCAgdHlwZT0ibWF0cml4IiB2YWx1ZXM9IjEgMCAwIDAgMCAgMCAxIDAgMCAwICAwIDAgMSAwIDAgIDAgMCAwIDEgMCIvPgoJCQk8L2ZpbHRlcj4KCQk8L2RlZnM+CgkJPG1hc2sgbWFza1VuaXRzPSJ1c2VyU3BhY2VPblVzZSIgaWQ9Im1hc2stMl8xXyI+CgkJCTxnIGNsYXNzPSJzdDEiPgoJCQkJPHBhdGggaWQ9InBhdGgtMV8yXyIgY2xhc3M9InN0MiIgZD0iTTUsOEM0LjcsOCw0LjUsNy45LDQuMyw3LjdsLTQtMy45Yy0wLjQtMC40LTAuNC0xLDAtMS40YzAuNC0wLjQsMS0wLjQsMS40LDBMNSw1LjZsNS4zLTUuMwoJCQkJCWMwLjQtMC40LDEtMC40LDEuNCwwYzAuNCwwLjQsMC40LDEsMCwxLjRsLTYsNkM1LjUsNy45LDUuMiw4LDUsOCIvPgoJCQk8L2c+CgkJPC9tYXNrPgoJCTxnIGlkPSJHcm91cCIgY2xhc3M9InN0MyI+CgkJPC9nPgoJPC9nPgo8L2c+Cjwvc3ZnPgo="; // 체크 아이콘 이미지
        img.width = 12;
        img.height = 12;
        item.appendChild(img);

        // 선택한 항목을 "전체" 자리로 업데이트
        selectedValueElement.textContent = item.textContent;

        // 목록 닫기
        sportSelect.nextElementSibling.style.display = "none";
    });
});

// 지역을 선택했을 때 동구 등의 이름을 추가하는 예시 코드
document.querySelectorAll(".region-item").forEach(function (item) {
    item.addEventListener("click", function () {
        const selectedSkillArea = document.querySelector(
            ".selected-skill-area"
        );
        selectedSkillArea.querySelector(".selected-skill").textContent =
            item.textContent;
        selectedSkillArea.style.display = "block"; // 지역 선택 후 표시
    });
});

// 확인 버튼 클릭 시 모달 창 닫기 및 선택된 지역 이름 반영
document.querySelectorAll(".region-item").forEach(function (item) {
    item.addEventListener("click", function () {
        const selectedRegion = item.textContent;
        const selectedSkillArea = document.querySelector(
            ".selected-skill-area"
        );
        selectedSkillArea.querySelector(".selected-skill").textContent =
            selectedRegion;
        selectedSkillArea.style.display = "block";

        // 기존 이벤트 리스너 제거 후 새로 추가
        const confirmButton = document.querySelector(
            ".sc-563f0eef-0-button.xVimo"
        );
        const newButton = confirmButton.cloneNode(true);
        confirmButton.parentNode.replaceChild(newButton, confirmButton);

        newButton.addEventListener("click", function () {
            document.querySelector(
                ".sc-31c8ace3-1.jQKJcA.sc-227412f9-1.MeFJX .selected-value"
            ).textContent = selectedRegion;
            selectedSkillArea.style.display = "none";
            document.querySelector(".sc-8482e18-0.lmEuWa").style.display =
                "none";
        });
    });
});
// 초기화 버튼 기능 추가
document
    .querySelector(".refresh button")
    .addEventListener("click", function () {
        // 지역명을 초기 상태로 되돌리기
        document.querySelector(".selected-value.placeholder").textContent =
            "지역을 선택해주세요";

        // 선택된 항목들을 초기화 및 리스트 숨김 처리
        const areaList = document.querySelector(".selected-skill-area");
        areaList.innerHTML = "";
        areaList.style.display = "none"; // 목록 숨김

        // 기존의 시/군/구 선택 UI가 있으면 제거
        const existingSubRegionDiv =
            document.querySelector(".sub-region-select");
        if (existingSubRegionDiv) {
            existingSubRegionDiv.remove();
        }
    });

// 확인 버튼 클릭 시 모달 창 닫기
document
    .querySelector(".sc-563f0eef-0-button.xVimo")
    .addEventListener("click", function () {
        document.querySelector(".sc-8482e18-0.lmEuWa").style.display = "none"; // 모달 창을 숨김
    });
document.addEventListener("DOMContentLoaded", function () {
    const labelContainer = document.getElementById("labelContainer");
    const optionList = document.getElementById("optionList");

    // labelContainer의 위치와 크기를 기준으로 optionList의 위치를 설정하는 함수
    function setPosition() {
        const rect = labelContainer.getBoundingClientRect();
        optionList.style.top = rect.bottom + "px"; // labelContainer의 아래쪽에 위치
        optionList.style.left = rect.left + "px"; // labelContainer의 왼쪽에 맞춤
        optionList.style.width = rect.width + "px"; // labelContainer의 너비에 맞춤
    }

    // labelContainer 클릭 시 옵션 리스트 표시
    labelContainer.addEventListener("click", function () {
        setPosition(); // 클릭할 때마다 위치를 재설정
        optionList.classList.toggle("open"); // 옵션 리스트 표시/숨기기
    });

    // 클릭 외부를 클릭했을 때 옵션 리스트 숨기기
    document.addEventListener("click", function (event) {
        if (
            !labelContainer.contains(event.target) &&
            !optionList.contains(event.target)
        ) {
            optionList.classList.remove("open");
        }
    });
});

document.addEventListener("DOMContentLoaded", function () {
    const labelContainer2 = document.getElementById("labelContainer2");
    const optionList2 = document.getElementById("optionList2");
    const listItems = optionList2.querySelectorAll("li");

    // '최신 업데이트 순' 항목은 기본적으로 선택된 상태로 설정
    let selectedOption = optionList2.querySelector("li.selected");

    // li 항목 클릭 시 체크 상태 변경
    listItems.forEach(function (item) {
        item.addEventListener("click", function () {
            // 기존 선택된 항목에서 selected 클래스 제거
            if (selectedOption) {
                selectedOption.classList.remove("selected");
            }

            // 클릭한 항목에 selected 클래스 추가
            this.classList.add("selected");
            selectedOption = this;

            // 선택한 항목의 텍스트를 label-container의 selected-value에 반영
            labelContainer2.querySelector(".selected-value").textContent =
                this.textContent.trim();
        });
    });

    // labelContainer 클릭 시 옵션 리스트 표시/숨기기
    labelContainer2.addEventListener("click", function () {
        optionList2.style.display =
            optionList2.style.display === "block" ? "none" : "block";
    });

    // 클릭 외부를 클릭했을 때 옵션 리스트 숨기기
    document.addEventListener("click", function (event) {
        if (
            !labelContainer2.contains(event.target) &&
            !optionList2.contains(event.target)
        ) {
            optionList2.style.display = "none";
        }
    });
});
// 남은 시간을 계산하고 표시하는 함수
function updateRemainingTime() {
    // 종료일을 지정 (예: 2024년 9월 10일 23:59:59로 설정)
    const endDate = new Date("2024-09-10T23:59:59");

    // 현재 시간
    const now = new Date();

    // 종료일까지 남은 시간을 밀리초 단위로 계산
    const timeDifference = endDate - now;

    // 시간이 이미 지나면 타이머를 멈추고 종료 메시지 표시
    if (timeDifference <= 0) {
        document.getElementById("remainingtime").textContent =
            "남은 시간: 종료됨";
        clearInterval(timer); // 타이머 멈춤
        return;
    }

    // 남은 시간에서 일, 시간, 분, 초 계산
    const days = Math.floor(timeDifference / (1000 * 60 * 60 * 24)); // 남은 일수 계산
    const hours = Math.floor(
        (timeDifference % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)
    ); // 남은 시간 계산
    const minutes = Math.floor(
        (timeDifference % (1000 * 60 * 60)) / (1000 * 60)
    ); // 남은 분 계산
    const seconds = Math.floor((timeDifference % (1000 * 60)) / 1000); // 남은 초 계산

    // '남은 시간' 요소에 일, 시간, 분, 초 표시
    document.getElementById(
        "remainingtime"
    ).textContent = `남은 시간: ${days}일 ${hours}시간 ${minutes}분 ${seconds}초`;
}

// 매 1초마다 남은 시간을 업데이트
const timer = setInterval(updateRemainingTime, 1000);

// 페이지 로드 후 즉시 남은 시간 계산 및 표시
updateRemainingTime();
