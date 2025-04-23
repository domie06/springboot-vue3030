<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑盘点详情</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">盘点详情管理</li>
                        <li class="breadcrumb-item active">编辑盘点详情</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">盘点详情信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6 aaaaaa goods">
                                        <label>商品</label>
                                        <div>
                                            <select id="goodsSelect" name="goodsSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 goods">
                                        <label>商品名字</label>
                                        <input id="goodsName" name="goodsName" class="form-control"
                                               placeholder="商品名字" readonly>
                                    </div>
                                    <div class="form-group col-md-6 goods">
                                        <label>商品种类</label>
                                        <input id="goodsValue" name="goodsValue" class="form-control"
                                               placeholder="商品种类" readonly>
                                    </div>
                                    <div class="form-group col-md-6 goods">
                                        <label>商品数量</label>
                                        <input id="goodsNumber" name="goodsNumber" class="form-control"
                                               placeholder="商品数量" readonly>
                                    </div>
                                    <div class="form-group col-md-6 goods">
                                        <label>商品图片</label>
                                        <img id="goodsPhotoImg" src="" width="100" height="100">
                                    </div>
                                    <div class="form-group col-md-6 goods">
                                        <label>单位</label>
                                        <input id="danwei" name="danwei" class="form-control"
                                               placeholder="单位" readonly>
                                    </div>
                                    <div class="form-group col-md-6 goods">
                                        <label>单价</label>
                                        <input id="danjia" name="danjia" class="form-control"
                                               placeholder="单价" readonly>
                                    </div>
                                    <div class="form-group col-md-6 aaaaaa pandian_order">
                                        <label>盘点</label>
                                        <div>
                                            <select id="pandianOrderSelect" name="pandianOrderSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 pandian_order">
                                        <label>盘点名</label>
                                        <input id="pandianOrderName" name="pandianOrderName" class="form-control"
                                               placeholder="盘点名" readonly>
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="pandianOrderId" name="pandianOrderId" type="hidden">
                                <input id="goodsId" name="goodsId" type="hidden">
                                    <div class="form-group col-md-6">
                                        <label>盘点前数量</label>
                                        <input id="goodsQianNumber" name="goodsQianNumber" class="form-control"
                                               onchange="goodsQianNumberChickValue(this)"  placeholder="盘点前数量">
                                    </div>

                                    <div class="form-group col-md-6">
                                        <label>盘点后数量</label>
                                        <input id="pandianOrderListNumber" name="pandianOrderListNumber" class="form-control"
                                               onchange="pandianOrderListNumberChickValue(this)"  placeholder="盘点后数量">
                                    </div>

                                    <div class="form-group col-md-12 mb-3">
                                        <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                        <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                    </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "pandianOrderList";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
        <!-- 级联表的下拉框数组 -->
    var goodsOptions = [];
    var pandianOrderOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
            if(window.sessionStorage.getItem('role') != '盘点'){//当前登录用户不为这个
                if($("#pandianOrderId") !=null){
                    var pandianOrderId = $("#pandianOrderId").val();
                    if(pandianOrderId == null || pandianOrderId =='' || pandianOrderId == 'null'){
                        alert("盘点不能为空");
                        return;
                    }
                }
            }
            if(window.sessionStorage.getItem('role') != '商品'){//当前登录用户不为这个
                if($("#goodsId") !=null){
                    var goodsId = $("#goodsId").val();
                    if(goodsId == null || goodsId =='' || goodsId == 'null'){
                        alert("商品不能为空");
                        return;
                    }
                }
            }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';

            }
            httpJson("pandianOrderList/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addpandianOrderList');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        <!-- 查询级联表的所有列表 -->
        function goodsSelect() {
            //填充下拉框选项
            http("goods/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    goodsOptions = res.data.list;
                }
            });
        }

        function goodsSelectOne(id) {
            http("goods/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                goodsShowImg();
                goodsShowVideo();
                goodsDataBind();
            }
        });
        }
        function pandianOrderSelect() {
            //填充下拉框选项
            http("pandianOrder/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    pandianOrderOptions = res.data.list;
                }
            });
        }

        function pandianOrderSelectOne(id) {
            http("pandianOrder/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                pandianOrderShowImg();
                pandianOrderShowVideo();
                pandianOrderDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->

        function initializationgoodsSelect() {
            var goodsSelect = document.getElementById('goodsSelect');
            if(goodsSelect != null && goodsOptions != null  && goodsOptions.length > 0 ) {
                for (var i = 0; i < goodsOptions.length; i++) {
                        goodsSelect.add(new Option(goodsOptions[i].goodsName, goodsOptions[i].id));
                }

                $("#goodsSelect").change(function(e) {
                        goodsSelectOne(e.target.value);
                });
            }

        }

        function initializationpandianOrderSelect() {
            var pandianOrderSelect = document.getElementById('pandianOrderSelect');
            if(pandianOrderSelect != null && pandianOrderOptions != null  && pandianOrderOptions.length > 0 ) {
                for (var i = 0; i < pandianOrderOptions.length; i++) {
                        pandianOrderSelect.add(new Option(pandianOrderOptions[i].pandianOrderName, pandianOrderOptions[i].id));
                }

                $("#pandianOrderSelect").change(function(e) {
                        pandianOrderSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->
        <!--  级联表的下拉框回显  -->
            var goodsSelect = document.getElementById("goodsSelect");
            if(goodsSelect != null && goodsOptions != null  && goodsOptions.length > 0 ) {
                for (var i = 0; i < goodsOptions.length; i++) {
                    if (goodsOptions[i].id == ruleForm.goodsId) {//下拉框value对比,如果一致就赋值汉字
                        goodsSelect.options[i+1].selected = true;
                        $("#goodsSelect" ).selectpicker('refresh');
                    }
                }
            }
            var pandianOrderSelect = document.getElementById("pandianOrderSelect");
            if(pandianOrderSelect != null && pandianOrderOptions != null  && pandianOrderOptions.length > 0 ) {
                for (var i = 0; i < pandianOrderOptions.length; i++) {
                    if (pandianOrderOptions[i].id == ruleForm.pandianOrderId) {//下拉框value对比,如果一致就赋值汉字
                        pandianOrderSelect.options[i+1].selected = true;
                        $("#pandianOrderSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
    }
    //数字检查
        <!-- 当前表的数字检查 -->
        function goodsQianNumberChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }
        function pandianOrderListNumberChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addpandianOrderList');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                pandianOrderId: "required",
                goodsId: "required",
                goodsQianNumber: "required",
                pandianOrderListNumber: "required",
                insertTime: "required",
            },
            messages: {
                pandianOrderId: "盘点不能为空",
                goodsId: "商品不能为空",
                goodsQianNumber: "盘点前数量不能为空",
                pandianOrderListNumber: "盘点后数量不能为空",
                insertTime: "插入时间不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addpandianOrderList = window.sessionStorage.getItem("addpandianOrderList");
        if (addpandianOrderList != null && addpandianOrderList != "" && addpandianOrderList != "null") {
            //注册表单验证
            $(validform());
            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("pandianOrderList/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 设置视频src
                    showVideo();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
            laydate.render({
                elem: '#insertTime-input'
                ,type: 'datetime'
            });
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        goodsDataBind();
        pandianOrderDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#pandianOrderId").val(ruleForm.pandianOrderId);
        $("#goodsId").val(ruleForm.goodsId);
        $("#goodsQianNumber").val(ruleForm.goodsQianNumber);
        $("#pandianOrderListNumber").val(ruleForm.pandianOrderListNumber);
        $("#insertTime-input").val(ruleForm.insertTime);

    }
    <!--  级联表的数据回显  -->
    function goodsDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#goodsId").val(ruleForm.id);

        $("#goodsName").val(ruleForm.goodsName);
        $("#goodsValue").val(ruleForm.goodsValue);
        $("#goodsNumber").val(ruleForm.goodsNumber);
        $("#danwei").val(ruleForm.danwei);
        $("#danjia").val(ruleForm.danjia);
        $("#goodsContent").val(ruleForm.goodsContent);
        $("#flag").val(ruleForm.flag);
    }

    function pandianOrderDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#pandianOrderId").val(ruleForm.id);

        $("#yuangongId").val(ruleForm.yuangongId);
        $("#pandianOrderName").val(ruleForm.pandianOrderName);
        $("#insertTime").val(ruleForm.insertTime);
        $("#pandianOrderContent").val(ruleForm.pandianOrderContent);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        goodsShowImg();
        pandianOrderShowImg();
    }


    <!--  级联表的图片  -->

    function goodsShowImg() {
        $("#goodsPhotoImg").attr("src",ruleForm.goodsPhoto);
    }


    function pandianOrderShowImg() {
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        goodsShowVideo();
        pandianOrderShowVideo();
    }


    <!--  级联表的视频  -->

    function goodsShowVideo() {
        $("#goodsPhotoV").attr("src",ruleForm.goodsPhoto);
    }

    function pandianOrderShowVideo() {
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            goodsSelect();
            pandianOrderSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            <!--  初始化级联表的下拉框  -->
            initializationgoodsSelect();
            initializationpandianOrderSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
        window.sessionStorage.removeItem('addpandianOrderList');
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') == '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events: none;');
        }
		else if (window.sessionStorage.getItem('role') == '员工') {
            // $(".aaaaaa").remove();
            $(".yuangong").remove();//删除当前用户的信息
        }
        else{
            // alert("未知情况.......");
            // var replyContentUeditor = UE.getEditor('replyContentEditor');
            // replyContentUeditor.ready(function () {
            //     replyContentUeditor.setDisabled('fullscreen');
            // });
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>