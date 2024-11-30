$(document).ready(function() {
    $('#join').submit(function(event) {
        // 기본 폼 제출을 막습니다.
        event.preventDefault();

        // 입력 필드에서 값을 가져옵니다.
        const userId = $('#u_id').val().trim();
        const userPw = $('#u_pw').val().trim();
        const userName = $('#u_name').val().trim();
        const userAddr = $('#u_addr').val().trim();
        const userPhone = $('#u_phone').val().trim();

        // 모든 오류 메시지를 초기화
        $('#idDiv').text('');
        $('#pwdDiv').text('');
        $('#nameDiv').text('');
        $('#addrDiv').text('');
        $('#phoneDiv').text('');

        // 빈 입력 필드를 체크하고 오류 메시지를 각 필드 아래에 표시
        if (userId === '') {
            $('#idDiv').text('아이디를 입력해주세요.').css('color', 'red');
            $('#u_id').focus();
            return;
        }
        if (userPw === '') {
            $('#pwdDiv').text('비밀번호를 입력해주세요.').css('color', 'red');
            $('#u_pw').focus();
            return;
        }
        if (userName === '') {
            $('#nameDiv').text('이름을 입력해주세요.').css('color', 'red');
            $('#u_name').focus();
            return;
        }
        if (userAddr === '') {
            $('#addrDiv').text('주소를 입력해주세요.').css('color', 'red');
            $('#u_addr').focus();
            return;
        }
        if (userPhone === '') {
            $('#phoneDiv').text('전화번호를 입력해주세요.').css('color', 'red');
            $('#u_phone').focus();
            return;
        }

        // 폼이 유효한 경우 서버로 폼 데이터를 제출합니다.
        this.submit();
    });
});
