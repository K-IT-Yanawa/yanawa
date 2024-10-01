// 메뉴 hover 시 동작
const matchingMenu = document.querySelectorAll(".main_heder_menu_bar");
matchingMenu.forEach((menuItem) => {
    menuItem.addEventListener("mouseenter", () => {
        menuItem.classList.add("show");
    });

    menuItem.addEventListener("mouseleave", () => {
        menuItem.classList.remove("show");
    });
});

// 메뉴 글씨 색상 변경
const menuFontColors = document.querySelectorAll(".main_heder_menu_bar, .main_heder_ShowButton");

menuFontColors.forEach((font) => {
    font.addEventListener("mouseenter", () => {
        menuFontColors.forEach((menu) => {
            if (menu !== font) {
                menu.classList.add("main_heder_menu_bar__zwZYy");
            }
        });
    });

    font.addEventListener("mouseleave", () => {
        menuFontColors.forEach((menu) => {
            menu.classList.remove("main_heder_menu_bar__zwZYy");
        });
    });
});

// 슬라이드 배너 (1)
const banner = document.querySelector(".container_slide_banner_1");
const buttons = document.querySelectorAll(".containner_slide_banner_1_button button");
let tempButton = buttons[0];
let autoSlideInterval = null;
let count = 1;

tempButton.style.backgroundColor = "black";

const firstBanner = document.createElement("div");
const lastBanner = document.createElement("div");

firstBanner.innerHTML = '<img src="/images/mainPage_img/banner_-001.png" class="main_article_banner_img" />';
lastBanner.innerHTML = '<img src="/images/mainPage_img/banner_-006.png" class="main_article_banner_img" />';

banner.appendChild(firstBanner);
banner.prepend(lastBanner);

banner.style.transform = 'translate(-1000px)';

const autoSlide = () => {
    count++;
    banner.style.transition = 'transform 0.7s';
    banner.style.transform = `translate(-${1000 * count}px)`;

    if (count === 7) {
        setTimeout(() => {
            banner.style.transition = 'transform 0s';
            banner.style.transform = 'translate(-950px)';
        }, 500);
        count = 1;
    }

    tempButton.style.backgroundColor = "white";
    buttons[count - 1].style.backgroundColor = "black";
    tempButton = buttons[count - 1];
};

autoSlideInterval = setInterval(autoSlide, 2000);

buttons.forEach((button, i) => {
    button.addEventListener("click", () => {
        clearInterval(autoSlideInterval);

        tempButton.style.backgroundColor = "white";
        count = i + 1;

        banner.style.transition = 'transform 0.5s';
        banner.style.transform = `translate(-${1000 * count}px)`;

        buttons[i].style.backgroundColor = "black";
        tempButton = buttons[i];

        autoSlideInterval = setInterval(autoSlide, 2000);
    });
});

// 카드 배너 슬라이드 공통 함수
const setupCardBanner = (containerSelector, bannerSelector, arrowLeftSelector, arrowRightSelector) => {
    const cardBannerContainer = document.querySelector(containerSelector);
    const cardBanners = document.querySelectorAll(bannerSelector);
    const arrows = document.querySelectorAll(`${arrowLeftSelector}, ${arrowRightSelector}`);
    let count = 0;
    let arrowCheck = true;

    function moveSlide(offset) {
        const bannerWidth = cardBanners[0].offsetWidth + 5;
        count += offset;

        if (count < 0) {
            count = 0;
            return;
        } else if (count >= cardBanners.length - 3) {
            count = cardBanners.length - 3;
            return;
        }

        cardBannerContainer.style.transition = 'transform 0.5s';
        cardBannerContainer.style.transform = `translateX(-${bannerWidth * count}px)`;
    }

    arrows.forEach((arrow) => {
        arrow.addEventListener("click", (e) => {
            if (!arrowCheck) return;
            arrowCheck = false;

            let arrowType = e.target.closest("button").classList.contains(arrowLeftSelector.substring(1))
                ? "left"
                : "right";

            if (arrowType === "left") {
                moveSlide(-1);
            } else {
                moveSlide(1);
            }

            setTimeout(() => {
                arrowCheck = true;
            }, 500);
        });
    });
};

// 카드 배너 슬라이드 설정
setupCardBanner(".main_section_container_cardBanner1_banner_1", ".main_section_cardBanner_1_img", ".button_left", ".button_right");
setupCardBanner(".main_section_container_cardBanner2_banner_2", ".main_section_section_2_img", ".button_left2", ".button_right2");
setupCardBanner(".main_section_banner_4_banner_1", ".main_section_section_4_img", ".button_left3", ".button_right3");
setupCardBanner(".main_section_banner_5_banner_1", ".main_section_section_5_img", ".button_left4", ".button_right4");

//---------------------------------------------------------------------------------------------------------
//메인페이지 서버작업

// 로그아웃 버튼
const logoutButton = document.querySelector("#logout");

logoutButton.addEventListener("click", () => {
    // 로그아웃 요청 및 알림 (fetch 사용)
    // fetch("/member/logout")
    //     .then(() => {
    //         alert("로그아웃 되었습니다.");
    //         window.location.href = "/member/main"; // 메인 페이지로 이동
    //     })
    //     .catch((error) => {
    //         console.error("로그아웃 중 오류 발생:", error);
    //     });


    // 로그아웃 요청 및 페이지 이동 (location.href 사용)
    alert("로그아웃 되었습니다."); // 알림 표시
    window.location.href = "/member/main"; // 메인페이지로 이동
});

// 회원가입/로그인버튼
const loginHomePageButton = document.querySelector(".main_heder_login_job_login_");

// 위의 버튼 누를시 로그인페이지로 이동
loginHomePageButton.addEventListener("click",()=>{
    window.location.href="/member/login"
});

