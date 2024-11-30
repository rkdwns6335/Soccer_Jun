$(document).ready(function() {
    $('#login').submit(function(event) {
        // 기본 폼 제출을 막습니다.
        event.preventDefault();

        // 입력 필드에서 값을 가져옵니다.
        const userId = $('#u_id').val().trim();
        const userPw = $('#u_pw').val().trim();

        // 폼 검증
        if (userId === '') {
            alert('아이디를 입력해주세요.');
            $('#u_id').focus();
            return;
        }
        if (userPw === '') {
            alert('비밀번호를 입력해주세요.');
            $('#u_pw').focus();
            return;
        }

		$.ajax({
		    url: '../jsp/login.jsp',
		    type: 'POST',
		    data: {
		        u_id: userId,
		        u_pw: userPw
		    },
		    dataType: 'html', // 서버에서 텍스트 응답을 받을 것으로 기대
		    success: function(response) {
		        if ($.trim(response) === 'success') {
		            alert('로그인이 성공적으로 완료되었습니다.');
		            window.location.href = '/index.html';
		        } else if ($.trim(response).startsWith('error:')) {
		            alert('서버 오류가 발생했습니다: ' + response.substring(6));
		        } else {
		            alert('로그인이 실패하였습니다.');
		        }
		    },
		    error: function(xhr, status, error) {
		        console.log('AJAX Error: ', error);
		        alert('AJAX 요청 중 오류가 발생했습니다.');
		    }
		});
    });
});