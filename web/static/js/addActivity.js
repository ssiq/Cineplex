/**
 * Created by wlw on 15-3-13.
 */

var id=-1;

var generate_one = function () {
    id+=1;
    return "<tr>" +
        '<td><input type="text" name="activityDetailList['+id+'].question" /></td>' +
        '<td><input type="text" name="activityDetailList['+id+'].answer"/></td>' +
        '</tr>';
};

$(document).ready(function () {
    $('#add').click(function () {
        $(this).closest('tr').before(generate_one());
    });
});
