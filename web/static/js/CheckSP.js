/**
 * Created by wlw on 15-3-7.
 */

var doAjax = function ($this, url) {
    var id=$this.closest('tr').find('.spid').val();
    $.ajax({
        data:{
            screeningProgramId:id
        },
        dataType:'json',
        url:url,
        success:function(data){
            if(data['result']=='succcess')
            {
                comfirm(data['message']);
                $this.closest('tr').remove();
            }else{
                alert(data['message']);
            }
        },
        error:function(){
            alert("网络有问题请稍后再试");
        }
    });
};

$(document).ready(function () {
    $('.accept').click(function () {
        doAjax($(this), "acceptScreeningProgram");
    });

    $('.refuse').click(function () {
        doAjax($(this), "refuseScreeningProgram");
    });
});
