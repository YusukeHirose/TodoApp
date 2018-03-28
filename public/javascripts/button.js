$(document).ready(function(){
    $(document).on('click', '#state_button', function () {
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


