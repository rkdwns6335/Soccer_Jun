$(document).ready(function() {
    $('#submit').submit(function(event) {
        // 기본 폼 제출을 막습니다.
        event.preventDefault();

        // 입력 필드에서 값을 가져옵니다.
        const b_title = $('#b_title').val().trim();
        const b_name = $('#b_name').val().trim();
        const b_content = $('#b_content').val().trim();

        // 폼 검증
        if (b_title === '') {
            alert('제목을 입력해주세요.');
            $('#b_title').focus();
            return;
        }
        if (b_name === '') {
            alert('작성자를 입력해주세요.');
            $('#b_name').focus();
            return;
        }
        if (b_content === '') {
            alert('내용을 입력해주세요.');
            $('#b_content').focus();
            return;
        }
        // 폼 데이터 준비
        const formData = $(this).serialize();

        // AJAX 요청
        $.ajax({
            url: '../jsp/write.jsp', // 서버로 데이터를 전송할 JSP 파일의 URL
            type: 'POST',
            data: formData,
            success: function(response) {
                // 성공적으로 응답을 받은 경우
                if ($.trim(response) === 'success') {
                    alert('글이 성공적으로 등록되었습니다.');
                    // 필요에 따라 리다이렉트하거나 추가 작업을 수행할 수 있습니다.
                    window.location.href = '../html/match.html';
                } else {
                    alert('글 등록 실패');
                }
            },
            error: function(xhr, status, error) {
                // AJAX 요청 실패 시 처리
                console.error('AJAX Error:', error);
                alert('서버 오류가 발생했습니다. 나중에 다시 시도해 주세요.');
            }
        });
    });
});