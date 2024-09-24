const chargeSelectLists = document.querySelectorAll(".charge-select-list-li");
const chargeItems = document.querySelectorAll(".charge-item");

chargeSelectLists.forEach((chargeSelectList, i) => {
    chargeSelectList.addEventListener("click", (e) => {
        const clickedIndex = i;

        chargeItems.forEach((item, index) => {
            if (index !== clickedIndex) {
                item.classList.remove("on");
            }
        });

        chargeItems[clickedIndex].classList.toggle("on");

        console.log(chargeItems[clickedIndex].classList.contains("on"));
    });
});

const chargingButton = document.querySelector(".charging-button");

chargingButton.addEventListener("click", () => {
    // 버튼 클릭 시 상태 확인
    updateCodeState();
});

function updateCodeState() {
    let anyItemSelected = false;

    // chargeItems에서 "on" 클래스를 가진 항목이 있는지 확인
    chargeItems.forEach((item) => {
        if (item.classList.contains("on")) {
            anyItemSelected = true;
        }
    });

    // 선택된 항목이 있으면 결제 페이지로 이동
    if (anyItemSelected) {
        alert("결제 페이지로 이동합니다.");
    } else {
        alert("충전금액을 선택해주세요.");
    }
}
