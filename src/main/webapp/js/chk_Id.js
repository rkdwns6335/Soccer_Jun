$(document).ready(function() {
    $('#u_id').blur(function() {
        const userId = $(this).val().trim();
        
        if (userId === '') {
            $('#idDiv').html('');
            return;
        }

        $.ajax({
            url: '../jsp/checkId.jsp',  // 아이디 중복 확인을 처리할 JSP 파일
            type: 'POST',
            data: { u_id: userId },
            success: function(response) {
                // 응답으로 받은 HTML을 해당 div에 삽입
                $('#idDiv').html(response);
            },
            error: function(xhr, status, error) {
                console.log('AJAX Error: ', error);
                alert('중복 확인 중 오류가 발생했습니다.');
            }
        });
    });
});