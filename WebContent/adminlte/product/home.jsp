<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<!-- 五分钟自动刷新 -->
<!--  <meta http-equiv="refresh" content="300">-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>订单列表</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/adminlte/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/adminlte/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/adminlte/bower_components/Ionicons/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/adminlte/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/adminlte/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect. -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/adminlte/dist/css/skins/skin-red-light.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/adminlte/css/admin.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <!-- <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-red-light sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <jsp:include page="../header.jsp"></jsp:include>
  
  <!-- Sidebar -->
  <jsp:include page="../sidebar.jsp"></jsp:include>


  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        订单管理
        <small>欢迎使用优印堂后台管理系统</small>
      </h1>
      <ol class="breadcrumb">
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">
      <div id="choose">
      <ul>
      <li>
       <span>序列号:</span> <input type="text" value="输入框">
       <span>用户手机号码:</span> <input type="text" value="输入框">
       </li>
       <li>
      <span style="padding-left:14px;">备注:</span> <input type="text" value="输入框">
       <span style="padding-left:55px;">时间:</span> <input type="text" value="输入框">
       </li>
       <li>
       <button id="choose-but">查询</button>
       </li>
      </ul>
      </div>

      <div class="box">
        <div class="box-header">
          <div id="title" class="pull-left" style="font-size=18px">订单列表</div>
        
        </div>
        <!-- /.box-header -->
        <div class="box-body">
          <table id="list" class="table table-bordered table-striped">
            <thead>
            <tr>
              <th class="list-th">序列号</th>
              <th class="list-th">用户手机号码</th>
              <th class="list-th">备注</th>
              <th class="list-th">时间</th>
              <th class="list-th">查看</th>
             
             
            </tr>
            </thead>
            <tbody>
             <tr>
                 
                  <td class="tb-td">1</td>
                  <td class="tb-td">2</td>
                  <td class="tb-td">3</td>
                  <td class="tb-td">4</td>
                  <td id="img1-align"class="tb-td"><button class="img1"><img src="${pageContext.request.contextPath}/adminlte/img/查找.png"></button></td>
                 
                  
                 
                </tr>
                <tr>
                 
                  <td class="tb-td">1</td>
                  <td class="tb-td">2</td>
                  <td class="tb-td">3</td>
                  <td class="tb-td">4</td>
                  <td id="img1-align"class="tb-td"><button class="img1"><img src="${pageContext.request.contextPath}/adminlte/img/查找.png"></button></td>
                 
                  
                 
                </tr>
                <tr>
                 
                  <td class="tb-td">1</td>
                  <td class="tb-td">2</td>
                  <td class="tb-td">3</td>
                  <td class="tb-td">4</td>
                  <td id="img1-align"class="tb-td"><button class="img1"><img src="${pageContext.request.contextPath}/adminlte/img/查找.png"></button></td>
                 
                  
                 
                </tr>
            </tbody>
            
           <!-- 
            <tbody id="tb">
                <c:forEach items="${orders}" var="product">
                <tr>
                 
                  <td class="tb-td">${product.orderid}</td>
                  <td class="tb-td">${product.tele }</td>
                  <td class="tb-td">${product.other }</td>
                  <td class="tb-td">${product.time }</td>
                  <td id="img1-align"class="tb-td"><button class="img1"><img src="${pageContext.request.contextPath}/adminlte/img/查找.png"></button></td>
                 
                  
                 
                </tr>
               </c:forEach>
            </tbody>
            -->
          
           
          </table>
        </div>
       
        <!-- /.box-body -->
      </div>
      <div id="appear">
        <img id="yc" src="${pageContext.request.contextPath}/adminlte/img/深叉.png">
        <span>这是测试字句</span>
        </div>

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- footer -->
  <jsp:include page="../footer.jsp"></jsp:include>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- REQUIRED JS SCRIPTS -->
<jsp:include page="../scripts.jsp"></jsp:include>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
<!-- page script -->
<script src="${pageContext.request.contextPath}/adminlte/js/admin.js"></script>
<script>
function del(obj,id) {  
    $.ajax({url: "../bg/adminComplete.action?id="+id});
    var i = obj.parentNode.parentNode.rowIndex-1; 
    
    document.getElementById('tb').deleteRow(i);

    
}  
var id;
var num= document.getElementById('tb').getElementsByTagName('tr')[ document.getElementById('tb').getElementsByTagName('tr').length-1].getElementsByTagName('td')[0].innerHTML;

id=window.setInterval(function(){$.ajax({
    url: "../bg/update.action?num="+num,
    type: "GET",
  
    
    dataType : "json",
    success: function(data) {
    	
    	  if(data.flag=="1"){window.clearInterval(id);$('#title').text("订单列表 (您有新的订单哦，请刷新查看)")};
      
    }
   
  });},1000*5);

    $(function () {
        $('#list').DataTable({
            'paging': true,
            'lengthChange': true,
            'searching': false,
            'ordering': false,
            'info': false,
            'autoWidth': false
        })
    })
</script>
</body>
</html>