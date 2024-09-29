// ** test를 위해 사용하는 곳 **

// const message = document.getElementById("email-span");
// const emailInput = document.getElementById("email");

// //********************************************** */
// // 이메일 형식 검증을 위한 정규 표현식
// const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

// // keydown 이벤트 리스너 추가
// emailInput.addEventListener("keydown", (e) => {
//     validateEmail(e.target);
// });

// // 포커스 이벤트 리스너 추가
// emailInput.addEventListener("focus", (e) => {
//     e.target.classList.remove("invalid", "valid");
//     e.target.style.border = "1px solid #0066ff"; // 포커스 시 파란 테두리
//     message.classList.remove("show"); // 메시지 숨깁니다.
// });

// // 블러 이벤트 리스너 추가
// emailInput.addEventListener("blur", (e) => {
//     validateEmail(e.target);
//     e.target.style.border = emailPattern.test(e.target.value)
//         ? "1px solid rgba(112, 115, 124, 0.22)" // 기본 테두리
//         : "1px solid rgb(255, 66, 66)"; // 오류 발생 시 빨간 테두리
// });

// // 이메일 검증 함수
// function validateEmail(inputElement) {
//     const emailValue = inputElement.target.value;

//     if (emailValue === "") {
//         inputElement.classList.remove("invalid", "valid");
//         message.classList.remove("show"); // 입력 필드가 비어 있을 때 메시지 숨김
//     } else if (emailPattern.test(emailValue)) {
//         inputElement.classList.remove("invalid");
//         inputElement.classList.add("valid");
//         message.classList.remove("show"); // 이메일 형식이 유효할 때 메시지 숨깁니다.
//     } else {
//         inputElement.classList.remove("valid");
//         inputElement.classList.add("invalid");
//         message.classList.add("show"); // 이메일 형식이 유효하지 않을 때 메시지 표시
//     }
// }

// // 블러 이벤트 리스너 추가
// emailInput.addEventListener("blur", (e) => {
//     // 이메일 입력 여부 검증
//     if (e.target.value) {
//         // e.classList.add("valid"); //valid: 파란색
//         // e.classList.remove("invalid");
//         e.style.border = "1px solid rgba(112, 115, 124, 0.22)"; // 기본 테두리
//         message.classList.remove("show"); // 메시지 숨김
//     } else {
//         // e.classList.add("invalid"); //invalid: 빨간색
//         // e.classList.remove("valid");
//         // e.style.border = "1px solid rgba(112, 115, 124, 0.22)"; // 입력 안했을 시 발생 시 빨간 테두리
//         message.classList.add("show"); // 메시지 표시
//     }
// });

// const emailInput1 = document.getElementById("email-1");

// // **이메일 입력 시 이벤트(+ 오류 메시지 없음)

// emailInput1.addEventListener("focus", (e) => {
//     e.target.style.border = "1px solid #0066ff"; // 포커스 시 파란색 테두리
// });
// emailInput1.addEventListener("blur", (e) => {
//     if (emailInput1.value.trim() === "") {
//         e.target.style.border = "1px solid rgba(112, 115, 124, 0.22)"; // 비어있는 경우 기본 색상
//     } else {
//         e.target.style.border = "1px solid rgba(112, 115, 124, 0.22)"; // 비어있지 않은 경우 기본 색상
//     }
// });

// // **이메일 입력 시 이벤트(+ 오류 메시지 기능구현)
// const emailInput2 = document.getElementById("email-2");
// const message = document.getElementById("email-span");

// // keydown 이벤트 리스너 추가
// emailInput2.addEventListener("input", (e) => {
//     console.log(e);

//     // 이메일 입력 여부 검증
//     if (e.target.value) {
//         e.target.classList.remove("invalid");
//         e.target.classList.add("valid");
//         message.classList.remove("show"); // 메시지 숨김
//     } else {
//         e.target.classList.remove("valid");
//         e.target.classList.add("invalid");
//         message.classList.add("show"); // 메시지 표시
//     }
// });

// // **비밀번호 포커스 시 파란색 테두리
// const passwordInput = document.getElementById("password");

// passwordInput.addEventListener("focus", (e) => {
//     e.target.style.border = "1px solid #0066ff"; // 포커스 시 파란색 테두리
// });
// passwordInput.addEventListener("blur", (e) => {
//     if (passwordInput.value.trim() === "") {
//         e.target.style.border = "1px solid rgba(112, 115, 124, 0.22)"; // 비어있는 경우 기본 색상
//     } else {
//         e.target.style.border = "1px solid rgba(112, 115, 124, 0.22)"; // 비어있지 않은 경우 기본 색상
//     }
// });
