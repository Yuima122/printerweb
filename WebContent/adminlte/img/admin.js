$(document).ready(
function (){
    $("#img1").click(
        function () {
            $("#appear").slideDown(500);

        }
    )
    }
);
//增加div上的叉，并设置鼠标经过变色
$(document).ready(
		function() {
			
	    $("#yc").mouseover(
	        function () {
	            $("#yc").attr("src","../img/深叉.png");
	            
	        }
	    )}
		
	);
$(document).ready(
		function() {
			
	    $("#yc").mouseout(
	        function () {
	            $("#yc").attr("src","../img/叉.png");
	            
	        }
	    )}
		
	);
//点击叉使悬浮框返回
$(document).ready(
	    function () {
	        $("#yc").click(
	            function () {
	                $("#appear").slideUp("500");

	            }
	        )

	    }
	)

