$(document).ready(function(){
    $('#state_button').on('click', function () {
        var target = $(this).val();
        if (target === '未完了') {
            $(this).val('完了');
            $(this).css('background-color','aqua');
        } else {
            $(this).val('未完了');
            $(this).css('background-color','lightcoral');
        }
    });
});


