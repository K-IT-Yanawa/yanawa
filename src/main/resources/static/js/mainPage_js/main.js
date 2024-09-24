// "매칭" 메뉴에 마우스를 올렸을 때
// const matchingMenu = document.querySelectorAll(".main_heder_menu_bar");
// const matchingSubMenu = document.querySelectorAll(
//     ".main_heder_menu_1_menubar_1"
// );
// const matchingMenubar = document.querySelectorAll(".main_heder_menu_1_menubar");

//매칭 메뉴에 마우스가 올라갔을때 나오는 메뉴들
// matchingMenu.addEventListener("mouseenter", (e) => {
//     matchingSubMenu.classList.add("show");
//     matchingMenubar.classList.add("show");
// });
// //매칭 매뉴에 마우스가 떠났을때 사라짐
// matchingMenu.addEventListener("mouseleave", (e) => {
//     matchingSubMenu.classList.remove("show");
//     matchingMenubar.classList.remove("show");
// });
// // "더보기" 버튼에 마우스를 올렸을때 (불러오기)
// const showMoreButton = document.querySelector(".main_heder_ShowButton");
// const showMoreMenu = document.querySelector(".main_heder_ShowButton_2");
// const showMoreMenubar = document.querySelector(".main_heder_ShowButton_1");

// // 더보기에 마우스를 올렸을때
// showMoreButton.addEventListener("mouseenter", (e) => {
//     showMoreMenu.classList.add("show");
//     showMoreMenubar.classList.add("show");
// });
// // 더보기에 마우스가 떠났을때
// showMoreButton.addEventListener("mouseleave", (e) => {
//     showMoreMenu.classList.remove("show");
//     showMoreMenubar.classList.remove("show");
// });
// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
const matchingMenu = document.querySelectorAll(".main_heder_menu_bar");
const matchingMenubar = document.querySelectorAll(".main_heder_menu_1_menubar");
matchingMenu.forEach((menuItem) => {
    menuItem.addEventListener("mouseenter", () => {
        menuItem.classList.add("show");
    });

    menuItem.addEventListener("mouseleave", () => {
        menuItem.classList.remove("show");
    });
});

//----------------------------------------------------------------------------------------

const menuFontColos = document.querySelectorAll(
    ".main_heder_menu_bar, .main_heder_ShowButton"
);

// 각 메뉴 아이템에 대해 이벤트 리스너를 추가
menuFontColos.forEach((font) => {
    font.addEventListener("mouseenter", (e) => {
        // 마우스가 올라갔을 때 다른 메뉴들 색상이 변경 된다
        menuFontColos.forEach((menu) => {
            if (menu !== font) {
                menu.classList.add("main_heder_menu_bar__zwZYy");
            }
        });
    });

    // 마우스가 떠났을 때 색상
    font.addEventListener("mouseleave", (e) => {
        menuFontColos.forEach((menu) => {
            menu.classList.remove("main_heder_menu_bar__zwZYy"); // 글씨 색 변경 클래스 제거
        });
    });
});

const macthings = document.querySelectorAll(
    "main_heder_menu_1_menubar_1_1_1> a"
);

// --------------------------------------------------------------------------------------------------
// 메인 베너 (1)

const firstBanner = document.createElement("div");
const lastBanner = document.createElement("div");
const banner = document.querySelector(".container_slide_banner_1");
const buttons = document.querySelectorAll(
    ".containner_slide_banner_1_button button"
);

let tempButton = buttons[0];
let autoSlideInterval = null;
let count = 1;
let arrowCheck = true;
let buttonCheck = true;

tempButton.style.backgroundColor = "black";

firstBanner.innerHTML = ` <img
                                    src="/static/images/mainPage_img/banner_-001.png"
                                    class="main_article_banner_img"
                                />`;
banner.appendChild(firstBanner);

lastBanner.innerHTML = ` <img
                                    src="/static/images/mainPage_img/banner_-006.png"
                                    class="main_article_banner_img"
                                />`;
banner.prepend(lastBanner);

banner.style.transform = `translate(-1000px)`;

const autoSlide = () => {
    count++;
    banner.style.transition = `transform 0.7s`;
    banner.style.transform = `translate(-${1000 * count}px)`;
    if (count == 7) {
        setTimeout(() => {
            banner.style.transition = `transform 0s`;
            banner.style.transform = `translate(-950px)`;
        }, 500);
        count = 1;
    }

    tempButton.style.backgroundColor = "white";
    buttons[count - 1].style.backgroundColor = "black";
    tempButton = buttons[count - 1];
};

autoSlideInterval = setInterval(autoSlide, 2000);

buttons.forEach((button, i) => {
    button.addEventListener("click", (e) => {
        if (!buttonCheck) {
            return;
        }
        clearInterval(autoSlideInterval);

        tempButton.style.backgroundColor = "white";
        count = i + 1;

        banner.style.transition = `transform 0.5s`;
        banner.style.transform = `translate(-${1400 * count}px)`;

        buttons[i].style.backgroundColor = "black";
        tempButton = buttons[i];

        autoSlideInterval = setInterval(autoSlide, 1000);
        setTimeout(() => {
            buttonCheck = true;
        }, 500);
    });
});
// --------------------------------------------------------------------------------------
// 카드 배너 (1)

// 카드배너 (1)
const cardBannerContainer = document.querySelector(
    ".main_section_container_cardBanner1_banner_1"
);
const cardBanners = document.querySelectorAll(".main_section_cardBanner_1_img");
const arrows = document.querySelectorAll(".button_left, .button_right"); // 좌우 버튼을 배열로 가져옵니다.
let count1 = 0;
let arrowCheck1 = true;

function moveSlide(offset) {
    const bannerWidth = cardBanners[0].offsetWidth + 20;
    count1 += offset;

    if (count1 < 0) {
        count1 = 0;
        return;
    } else if (count1 >= cardBanners.length - 3) {
        count1 = cardBanners.length - 3;
        return;
    }

    cardBannerContainer.style.transition = `transform 0.5s`;
    cardBannerContainer.style.transform = `translateX(-${
        bannerWidth * count1
    }px)`;
}

arrows.forEach((arrow) => {
    arrow.addEventListener("click", (e) => {
        if (!arrowCheck1) return;
        arrowCheck1 = false;

        let arrowType = e.target
            .closest("button")
            .classList.contains("button_left")
            ? "left"
            : "right";

        if (arrowType === "left") {
            moveSlide(-1);
        } else {
            moveSlide(1);
        }

        setTimeout(() => {
            arrowCheck1 = true;
        }, 500);
    });
});

// -----------------------------------------------------
//카드배너 (2)
const cardBannerContainer2 = document.querySelector(
    ".main_section_container_cardBanner2_banner_2"
);
const cardBanners2 = document.querySelectorAll(".main_section_section_2_img");
const arrows2 = document.querySelectorAll(".button_left2, .button_right2");
let arrowCheck2 = true;
let count2 = 0;

function moveSlide2(offset) {
    const bannerWidth = cardBanners2[0].offsetWidth + 20;
    count2 += offset;

    if (count2 < 0) {
        count2 = 0;
        return;
    } else if (count2 >= cardBanners2.length - 3) {
        count2 = cardBanners2.length - 3;
        return;
    }

    cardBannerContainer2.style.transition = `transform 0.5s`;
    cardBannerContainer2.style.transform = `translateX(-${
        bannerWidth * count2
    }px)`;
}

arrows2.forEach((arrow2) => {
    arrow2.addEventListener("click", (e) => {
        if (!arrowCheck2) return;
        arrowCheck2 = false;

        let arrowType = e.target
            .closest("button")
            .classList.contains("button_left2")
            ? "left"
            : "right";

        if (arrowType === "left") {
            moveSlide2(-1);
        } else {
            moveSlide2(1);
        }

        setTimeout(() => {
            arrowCheck2 = true;
        }, 500);
    });
});

// --------------------------------------------------------------------
// 카드배너 3

// 카드배너 (3)
const cardBannerContainer3 = document.querySelector(
    ".main_section_banner_4_banner_1"
);
const cardBanners3 = document.querySelectorAll(".main_section_section_4_img");
const arrows3 = document.querySelectorAll(".button_left3, .button_right3");
let count3 = 0;
let arrowCheck3 = true;

function moveSlide3(offset) {
    const bannerWidth = cardBanners3[0].offsetWidth + 5;
    count3 += offset;

    if (count3 < 0) {
        count3 = 0;
        return;
    } else if (count3 >= cardBanners3.length - 3) {
        count3 = cardBanners3.length - 3;
        return;
    }

    cardBannerContainer3.style.transition = `transform 0.5s`;
    cardBannerContainer3.style.transform = `translateX(-${
        bannerWidth * count3
    }px)`;
}

arrows3.forEach((arrow3) => {
    arrow3.addEventListener("click", (e) => {
        if (!arrowCheck3) return;
        arrowCheck3 = false;

        let arrowType = e.target
            .closest("button")
            .classList.contains("button_left3")
            ? "left"
            : "right";

        if (arrowType === "left") {
            moveSlide3(-1);
        } else {
            moveSlide3(1);
        }

        setTimeout(() => {
            arrowCheck3 = true;
        }, 400);
    });
});

// ------------------------------------------------
// 카드배너 (4)
const cardBannerContainer4 = document.querySelector(
    ".main_section_banner_5_banner_1"
);
const cardBanners4 = document.querySelectorAll(".main_section_section_5_img");
const arrows4 = document.querySelectorAll(".button_left4, .button_right4");
let count4 = 0;
let arrowCheck4 = true;

function moveSlide4(offset) {
    const bannerWidth = cardBanners4[0].offsetWidth + 5;
    count4 += offset;

    if (count4 < 0) {
        count4 = 0;
        return;
    } else if (count4 >= cardBanners4.length - 3) {
        count4 = cardBanners4.length - 3;
        return;
    }

    cardBannerContainer4.style.transition = `transform 0.5s`;
    cardBannerContainer4.style.transform = `translateX(-${
        bannerWidth * count4
    }px)`;
}

arrows4.forEach((arrow4) => {
    arrow4.addEventListener("click", (e) => {
        if (!arrowCheck4) return;
        arrowCheck4 = false;

        let arrowType = e.target
            .closest("button")
            .classList.contains("button_left4")
            ? "left"
            : "right";

        if (arrowType === "left") {
            moveSlide4(-1);
        } else {
            moveSlide4(1);
        }

        setTimeout(() => {
            arrowCheck4 = true;
        }, 400);
    });
});
// const cardBannerContainer4 = document.querySelector(
//     ".main_section_banner_5_banner_1"
// );
// const cardBanners4 = document.querySelectorAll(".main_section_section_5_img");
// const arrows4 = document.querySelectorAll(".button_left4, .button_right4");
// let count4 = 0;
// let arrowCheck4 = true;

// function moveSlide4(offset) {
//     const bannerWidth = cardBanners4[0].offsetWidth + 20;
//     count4 += offset;

//     if (count4 < 0) {
//         count4 = 0;
//         return;
//     } else if (count4 >= cardBanners4.length - 3) {
//         count4 = cardBanners4.length - 3;
//         return;
//     }

//     // 슬라이드를 즉시 이동
//     cardBannerContainer4.style.transition = `transform 0s`;
//     cardBannerContainer4.style.transform = `translateX(-${
//         bannerWidth * count4
//     }px)`;

//     // 약간의 지연 시간을 주어 "뚝뚝" 넘어가는 느낌을 줌
//     setTimeout(() => {
//         cardBannerContainer4.style.transition = `transform 0s`; // 애니메이션 없이 이동
//     }, 100); // 지연 시간을 조절 가능 (ms 단위)
// }

// arrows4.forEach((arrow4) => {
//     arrow4.addEventListener("click", (e) => {
//         if (!arrowCheck4) return;
//         arrowCheck4 = false;

//         let arrowType = e.target
//             .closest("button")
//             .classList.contains("button_left4")
//             ? "left"
//             : "right";

//         if (arrowType === "left") {
//             moveSlide4(-1);
//         } else {
//             moveSlide4(1);
//         }

//         setTimeout(() => {
//             arrowCheck4 = true;
//         }, 500);
//     });
// });
