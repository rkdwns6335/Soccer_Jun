$(function(){
    $.ajax({
        type: 'GET',
        url: '../jsp/match_view.jsp', // JSP 파일 URL로 수정
        dataType: 'html', // 응답 데이터 타입을 HTML로 지정
        success: function(data){
            $('td').empty(); // 기존 테이블 내용 지우기
            $('tbody').append(data);
        },
        error: function(xhr, status, error){
            console.error("AJAX 요청 실패:");
            console.error("상태 코드:", xhr.status); // 상태 코드
            console.error("상태:", status); // 상태 문자열
            console.error("오류 메시지:", error); // 오류 메시지
            console.error("응답 텍스트:", xhr.responseText); // 응답 텍스트
        }
    });
	
	$('#btn-add').on('click', function() {
		 window.location.href = 'write.html';
	});
});