// JSP에서 전달된 로그인 상태 및 사용자 이름
var isLoggedIn = false;
var userName = "";

function handleSession() {
    if (isLoggedIn) {
        // 세션 이름 출력
        document.getElementById("session_name").textContent = userName + "님 환영합니다";

        // 로그인 버튼을 로그아웃 버튼으로 변경
        var loginLink = document.getElementById("login_link");
        loginLink.textContent = "로그아웃";
        loginLink.href = "logout.jsp"; // 로그아웃 처리할 페이지로 변경

        // 회원가입 버튼 숨김
        document.getElementById("signup_link").style.display = "none";
    }
}

// DOMContentLoaded 이벤트가 발생하면 handleSession 함수 실행
document.addEventListener("DOMContentLoaded", handleSession);