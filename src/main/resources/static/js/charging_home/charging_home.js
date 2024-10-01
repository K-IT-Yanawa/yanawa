const chargeSelectLists = document.querySelectorAll(".charge-select-list-li");
const chargeItems = document.querySelectorAll(".charge-item");

chargeSelectLists.forEach((chargeSelectList, i) => {
    chargeSelectList.addEventListener("click", () => {
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
    // 버튼 클릭 시 상태 확인 및 결제 로직 호출
    updateCodeState();
});

function updateCodeState() {
    let anyItemSelected = false;
    let selectedAmount = 0;

    // chargeItems에서 "on" 클래스를 가진 항목이 있는지 확인 및 금액 설정
    chargeItems.forEach((item) => {
        if (item.classList.contains("on")) {
            anyItemSelected = true;
            const amountText = item.querySelector(".amount-text").innerText.replace("원", "").replace(",", "");
            selectedAmount = parseInt(amountText);
        }
    });

    // 선택된 항목이 있으면 결제 페이지로 이동 및 결제 요청
    if (anyItemSelected && selectedAmount > 0) {
        alert("결제 페이지로 이동합니다.");

        // 부트페이 결제 요청 로직 추가
        Bootpay.request({
            "application_id": "발급받은 애플리케이션 ID", // 부트페이 애플리케이션 ID
            "price": selectedAmount, // 선택된 결제 금액
            "order_name": "포인트 충전", // 주문명
            "order_id": "TEST_ORDER_" + new Date().getTime(), // 고유 주문 ID
            "pg": "kakao", // 결제 PG사
            "method": "카드", // 결제 수단
            "user": {
                "id": "user123",
                "username": "사용자이름",
                "phone": "01012345678",
                "email": "test@test.com"
            },
            "items": [
                {
                    "id": "item_id",
                    "name": "포인트 충전",
                    "qty": 1,
                    "price": selectedAmount
                }
            ],
            "extra": {
                "open_type": "iframe",
                "card_quota": "0,2,3",
                "escrow": false
            }
        }).error(function (data) {
            alert("에러가 발생했습니다.");
            console.log(data);
        }).cancel(function (data) {
            alert("결제가 취소되었습니다.");
            console.log(data);
        }).ready(function (data) {
            console.log("가상계좌가 발급되었습니다.", data);
        }).confirm(function (data) {
            console.log("결제가 승인되었습니다. 가맹점에서는 결제를 승인 처리해주세요.", data);
            var enable = true; // 가맹점에서 재고 수량 확인 후 true 또는 false 설정
            if (enable) {
                Bootpay.transactionConfirm(data); // 결제 승인
            } else {
                Bootpay.removePaymentWindow(); // 결제 창 닫기
            }
        }).close(function (data) {
            console.log("결제창이 닫혔습니다.", data);
        }).done(function (data) {
            alert("결제가 완료되었습니다.");
            console.log(data);
        });
    } else {
        alert("충전 금액을 선택해주세요.");
    }
}
