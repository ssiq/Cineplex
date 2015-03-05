/**
 * Created by wlw on 15-3-5.
 */

var generate_action = function (id) {
    var action_list=['member_login', 'waiter_login', 'manager_login'];
    return action_list[id];
};

var do_change = function (id) {
    $('#login_form').attr('action', generate_action(id));
};

$(document).ready(function(){
    var $identity = $('#identity');
    do_change($identity.val());
    $identity.change(function () {
        do_change($(this).val());
    });
});