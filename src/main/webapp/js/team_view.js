$(document).ready(function() {
    // URL에서 team_id 파라미터를 추출합니다.
    const urlParams = new URLSearchParams(window.location.search);
    const teamId = urlParams.get('team_id');

    // teamId 값을 콘솔에 출력합니다 (디버깅용)
    console.log('Extracted team_id:', teamId);

    if (teamId) {
        // AJAX 요청을 통해 팀 정보를 가져옵니다.
        $.ajax({
            url: '../jsp/team_view.jsp', // 서버로 요청할 JSP 파일
            type: 'POST',
            data: { team_id: teamId },
            success: function(response) {
                // 응답이 success인 경우
                if (response.startsWith("success")) {
                    // 응답에서 HTML 콘텐츠 추출
                    const content = response.substring(response.indexOf("<!--") + 4, response.indexOf("-->"));
                    $('#team-info').html(content);
                } else {
                    $('#team-info').html('<p>팀 정보를 가져오는 데 실패했습니다.</p>');
                }
            },
            error: function(xhr, status, error) {
                console.error('AJAX Error:', error);
                $('#team-info').html('<p>서버 오류가 발생했습니다. 나중에 다시 시도해 주세요.</p>');
            }
        });
    } else {
        $('#team-info').html('<p>팀 ID가 제공되지 않았습니다.</p>');
    }
});
