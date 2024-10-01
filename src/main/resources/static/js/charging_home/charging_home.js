window.onload = function () {
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
        });
    });

    const chargingButton = document.querySelector(".charging-button");

    chargingButton.addEventListener("click", () => {
        updateCodeState();
    });

    function updateCodeState() {
        let anyItemSelected = false;
        let selectedAmount = 0;

        chargeItems.forEach((item) => {
            if (item.classList.contains("on")) {
                anyItemSelected = true;
                const amountText = item.querySelector(".amount-text").innerText.replace("원", "").replace(",", "");
                selectedAmount = parseInt(amountText);
            }
        });

        if (anyItemSelected && selectedAmount > 0) {
            Bootpay.requestPayment({
                "application_id": "66c6a759a3175898bd6e499c", // 부트페이 애플리케이션 ID
                "price": selectedAmount, // 선택된 결제 금액
                "order_name": "포인트 충전", // 주문명
                "order_id": "TEST_ORDER_" + new Date().getTime(), // 고유 주문 ID
                "pg": "카카오페이", // 결제 PG사 (확인 필요)
                "method": "간편", // 결제 수단
                "user": {
                    "id": sessionUserId,            // 세션의 사용자 ID
                    "username": sessionUsername,    // 세션의 사용자 이름
                    "phone": sessionUserPhone,      // 세션의 사용자 전화번호
                    "email": sessionUserEmail       // 사용자 이메일
                },
                "extra": {
                    "open_type": "redirect", // redirect 모드 설정
                    "redirect_url": "http://localhost:10000/mainPage/main" // 결제 완료 후 리다이렉트될 URL
                }
            })
                .then(function (data) {
                    alert("결제가 완료되었습니다.");
                    console.log(data);
                    window.location.href = "/mainPage/main"; // 결제 완료 후 메인 페이지로 이동
                })
                .catch(function (error) {
                    console.error("결제 중 에러 발생:", error);
                    if (error.event === 'cancel') {
                        alert("결제가 취소되었습니다.");
                        window.location.href = "/mainPage/main"; // 결제 취소 시 메인 페이지로 이동
                    } else {
                        alert("에러가 발생했습니다: " + error.message);
                    }
                });
        } else {
            alert("충전 금액을 선택해주세요.");
        }
    }
};
