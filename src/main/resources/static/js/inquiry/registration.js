// 제출 버튼을 가져옴
const submitButton = document.querySelector(".submit-btn");

// 제출하기 버튼 눌렀을 때 실행되는 것
submitButton.addEventListener("click", () => {
    alert("문의가 제출 되었습니다! 빠른시일내에 답변 드리겠습니다!");
});

// 파일을 업로드할 input태그 클래스 가져옴
document.querySelector(".file-input").addEventListener("change", (event) => {
    // 이벤트 발생시켜 지금 파일을 fileList로 정의
    const fileList = event.target.files;
    // 업로드한 파일을 ul 태그 안에 가져오기위해 ul class가져옴
    const uploadPool = document.querySelector(".upload-pool");

    // ul 안에 값 초기화
    uploadPool.innerHTML = "";

    // 가져온 파일 길이만큼 반복
    for (let i = 0; i < fileList.length; i++) {
        // 안에 li 태그 생성
        const listItem = document.createElement("li");
        // 그 li 태그 클래스이름 지정
        listItem.className = "upload-item";

        // 가져온 파일 링크(파일) 가져올수 있게 a태그 생성
        const linkItem = document.createElement("a");

        // 그 안에 반복해 가져온 파일의 이름을 text로 뿌림
        linkItem.textContent = fileList[i].name;

        // 리스트 아이템 다음 자식에 링크아이템 생성
        listItem.appendChild(linkItem);

        // 업로드한 ul태그 다음 자식에 리스트아이템 생성
        uploadPool.appendChild(listItem);
    }
});
