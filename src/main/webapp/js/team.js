$(document).ready(function() {
    $('#content a').click(function(event) {
        event.preventDefault(); // 기본 링크 동작 방지
        const teamId = $(this).find('img').attr('id'); // 링크 내 이미지의 id 속성에서 team_id 가져오기
        if (teamId) {
            window.location.href = 'team_view.html?team_id=' + encodeURIComponent(teamId);
        }
    });
});