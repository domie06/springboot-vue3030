<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">


<head>
    <%@ include file="../../static/head.jsp" %>
    <!-- font-awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">


    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <!-- layui -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
</head>
<style>

</style>
<body>




    <%--  新增入入入入入入入入入入入入入入入 新增盘点 --%>
    <div class="modal fade" id="pandianOrderListModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <%-- 模态框标题--%>
                <div class="modal-header">
                    <h5 class="modal-title" id="pandianOrderListModalTitle">列表</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <%-- 模态框内容 --%>
                <div class="modal-body">
                    <div class="col-sm-12">
                        <%-- 当前表 --%>
                        <label class="col-sm-10 bbbbbb">
                            操作人
                            <select id="yuangongSelect" name="yuangongSelect"
                                    class="selectpicker form-control"  data-live-search="true"
                                    title="请选择" data-header="请选择" data-size="5">
                            </select>
                        </label>
                        <%-- 详情表 --%>
                        <label class="col-sm-10">
                            商品
                            <select id="goodsSelect" name="goodsSelect"
                                    class="selectpicker form-control"  data-live-search="true"
                                    title="请选择" data-header="请选择" data-size="5">
                            </select>
                        </label>
                        <input type="hidden" id="pandianOrderListFlag">
                        <label class="col-sm-1">
                            <button onclick="addPandianOrderList()" type="button" class="btn btn-success 新增">添加</button>
                        </label>
                    </div>
                    <label class="col-sm-5">
                        盘点名:<input type="text" id="pandianOrderName" class="form-control" placeholder="盘点名">
                    </label>
                    <%-- 列表 --%>
                    <table id="pandianOrderTable" class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th >商品名字</th>
                            <th >商品种类</th>
                            <th >商品数量</th>
                            <th >单位</th>
                            <th >单价</th>
                            <%--<th >盘点前数量</th>--%>
                            <th >盘点数量</th>
                            <th >操作</th>
                        </tr>
                        </thead>
                        <tbody id="pandianOrderListTableTbody">
                        </tbody>
                    </table>
                </div>
                <%-- 模态框按钮 --%>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" onclick="submitPandianOrderList()" class="btn btn-primary">提交</button>
                </div>
            </div>
        </div>
    </div>


    <%--  列表查看 --%>
    <div class="modal fade" id="showPandianOrderListModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <%-- 模态框标题--%>
                <div class="modal-header">
                    <h5 class="modal-title" id="modal-list-title">查看列表</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <%-- 模态框内容 --%>
                <div class="modal-body">
                    <div class="col-sm-12">
                        <%-- 当前表 --%>
                        <label class="col-sm-5">
                            员工姓名
                            <input id="yuangongName" name="yuangongName" class="form-control"
                                   placeholder="员工姓名" readonly>
                        </label>
                        <%-- 详情表 --%>
                        <%--<label class="col-sm-10">--%>
                            <%--盘点详情--%>
                            <%--<select id="goodsSelect" name="goodsSelect"--%>
                                    <%--class="selectpicker form-control"  data-live-search="true"--%>
                                    <%--title="请选择" data-header="请选择" data-size="5">--%>
                            <%--</select>--%>
                        <%--</label>--%>
                        <%--<label class="col-sm-1">--%>
                            <%--<button onclick="addShowPandianOrderList()" type="button" class="btn btn-success 新增">添加</button>--%>
                        <%--</label>--%>
                    </div>
                    <table id="inOutTableList" class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th >商品名字</th>
                            <th >商品种类</th>
                            <th >商品数量</th>
                            <th >单位</th>
                            <th >单价</th>
                            <%--<th >是否删除</th>--%>
                            <th >盘点前数量</th>
                            <th >盘点数量</th>
                            <th >操作</th>

                        </tr>
                        </thead>
                        <tbody id="showPandianOrderListTableTbody">
                        </tbody>
                    </table>
                </div>
                <%-- 模态框按钮 --%>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <%--<button type="button" onclick="submitInOutGoods()" class="btn btn-primary">提交</button>--%>
                </div>
            </div>
        </div>
    </div>



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
                        <h3 class="block-title">盘点管理</h3>
                    </div>
                    <div class="col-md-6">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">
                                <a href="${pageContext.request.contextPath}/index.jsp">
                                    <span class="ti-home"></span>
                                </a>
                            </li>
                            <li class="breadcrumb-item">盘点管理</li>
                            <li class="breadcrumb-item active">盘点列表</li>
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
                            <h3 class="widget-title">盘点列表</h3>
                            <div class="table-responsive mb-3">
                                <div class="col-sm-12">
                                                                                                             
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        盘点名
                                        <div class="layui-input-inline">
                                            <input type="text" id="pandianOrderNameSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="盘点名" aria-controls="tableId">
                                        </div>
                                    </div>
                                     
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        盘点时间
                                        <div class="layui-input-inline">
                                            <input type="datetime-local" id="insertTimeStartSearch" style="width: 190px;" class="form-control form-control-sm"
                                                   placeholder="开始" aria-controls="tableId">
                                        </div>
                                    </div>
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        <div class="layui-input-inline">
                                            <input type="datetime-local" id="insertTimeEndSearch" style="width: 190px;" class="form-control form-control-sm"
                                                   placeholder="结束" aria-controls="tableId">
                                        </div>
                                    </div>
                                                                        
                                                                                                         
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        员工姓名
                                        <div class="layui-input-inline">
                                            <input type="text" id="yuangongNameSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="员工姓名" aria-controls="tableId">
                                        </div>
                                    </div>
                                                     
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        员工手机号
                                        <div class="layui-input-inline">
                                            <input type="text" id="yuangongPhoneSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="员工手机号" aria-controls="tableId">
                                        </div>
                                    </div>
                                                     
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        员工身份证号
                                        <div class="layui-input-inline">
                                            <input type="text" id="yuangongIdNumberSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="员工身份证号" aria-controls="tableId">
                                        </div>
                                    </div>
                                                                                                        
                                    <div class="layui-inline" style="margin-left: 30px;margin-bottom: 10px;">
                                        <button onclick="search()" type="button" class="btn btn-primary">查询</button>
                                        <%--<button onclick="add()" type="button" class="btn btn-success 新增">添加</button>--%>
                                        <button onclick="outPandianOrderList()" type="button" class="btn btn-success 新增">盘点</button>
                                        <button onclick="graph()" type="button" class="btn btn-success 报表">报表</button>
                                        <button onclick="deleteMore()" type="button" class="btn btn-danger 删除">批量删除</button>
                                    </div>
                                </div>
                                <table id="tableId" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th class="no-sort" style="min-width: 35px;">
                                            <div class="custom-control custom-checkbox">
                                                <input class="custom-control-input" type="checkbox" id="select-all"
                                                       onclick="chooseAll()">
                                                <label class="custom-control-label" for="select-all"></label>
                                            </div>
                                        </th>

                                        <th >员工姓名</th>
                                        <th >员工手机号</th>
                                        <th >员工身份证号</th>
                                        <th >员工照片</th>

                                        <th >盘点名</th>
                                        <th >盘点时间</th>
                                        <th >备注</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="thisTbody">
                                    </tbody>
                                </table>
                                <div class="col-md-6 col-sm-3">
                                    <div class="dataTables_length" id="tableId_length">

                                        <select name="tableId_length" aria-controls="tableId" id="selectPageSize"
                                                onchange="changePageSize()">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select>
                                        条 每页

                                    </div>
                                </div>
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination justify-content-end">
                                        <li class="page-item" id="tableId_previous" onclick="pageNumChange('pre')">
                                            <a class="page-link" href="#" tabindex="-1">上一页</a>
                                        </li>

                                        <li class="page-item" id="tableId_next" onclick="pageNumChange('next')">
                                            <a class="page-link" href="#">下一页</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
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
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
    <script>

        <%@ include file="../../utils/menu.jsp"%>
        <%@ include file="../../static/setMenu.js"%>
        <%@ include file="../../utils/baseUrl.jsp"%>
        <%@ include file="../../static/getRoleButtons.js"%>
        <%@ include file="../../static/crossBtnControl.js"%>
        var tableName = "pandianOrder";
        var pageType = "list";
        var searchForm = {key: ""};
        var pageIndex = 1;
        var pageSize = 10;
        var totalPage = 0;
        var dataList = [];
        var sortColumn = '';
        var sortOrder = '';
        var ids = [];
        var checkAll = false;

        var id = null;//查看详情中的订单id
// 当前表关联
        var yuangongOptions = [];
        var yuangong = null;
        // 详情表的关联
        var goodsOptions = [];
        var goods = null;



        <!-- 级联表的级联字典表 -->

        <!-- 本表的级联字段表 -->

        function init() {
            // 满足条件渲染提醒接口
        }

        // 改变每页记录条数
        function changePageSize() {
            var selection = document.getElementById('selectPageSize');
            var index = selection.selectedIndex;
            pageSize = selection.options[index].value;
            getDataList();
        }



        // 查询
        function search() {
            searchForm = {key: ""};

        <!-- 级联表的级联字典表 -->
                                         
                            //员工姓名
            var yuangongNameSearchInput = $('#yuangongNameSearch');
            if( yuangongNameSearchInput != null){
                if (yuangongNameSearchInput.val() != null && yuangongNameSearchInput.val() != '') {
                    searchForm.yuangongName = $('#yuangongNameSearch').val();
                }
            }
                     
                            //员工手机号
            var yuangongPhoneSearchInput = $('#yuangongPhoneSearch');
            if( yuangongPhoneSearchInput != null){
                if (yuangongPhoneSearchInput.val() != null && yuangongPhoneSearchInput.val() != '') {
                    searchForm.yuangongPhone = $('#yuangongPhoneSearch').val();
                }
            }
                     
                            //员工身份证号
            var yuangongIdNumberSearchInput = $('#yuangongIdNumberSearch');
            if( yuangongIdNumberSearchInput != null){
                if (yuangongIdNumberSearchInput.val() != null && yuangongIdNumberSearchInput.val() != '') {
                    searchForm.yuangongIdNumber = $('#yuangongIdNumberSearch').val();
                }
            }
                                            <!-- 本表的查询条件 -->

             
            //盘点名
            var pandianOrderNameSearchInput = $('#pandianOrderNameSearch');
            if( pandianOrderNameSearchInput != null){
                if (pandianOrderNameSearchInput.val() != null && pandianOrderNameSearchInput.val() != '') {
                    searchForm.pandianOrderName = $('#pandianOrderNameSearch').val();
                }
            }
     
            var insertTimeStartSearch = $('#insertTimeStartSearch');
            if( insertTimeStartSearch != null){
                if (insertTimeStartSearch.val() != null && insertTimeStartSearch.val() != '') {
                    searchForm.insertTimeStart = $('#insertTimeStartSearch').val();
                }
            }
            var insertTimeEndSearch = $('#insertTimeEndSearch');
            if( insertTimeEndSearch != null){
                if (insertTimeEndSearch.val() != null && insertTimeEndSearch.val() != '') {
                    searchForm.insertTimeEnd = $('#insertTimeEndSearch').val();
                }
            }
                    getDataList();
        }

        // 获取数据列表
        function getDataList() {
            http("pandianOrder/page", "GET", {
                page: pageIndex,
                limit: pageSize,
                sort: sortColumn,
                order: sortOrder,
                //本表的
                pandianOrderName: searchForm.pandianOrderName,
                insertTimeStart: searchForm.insertTimeStart,
                insertTimeEnd: searchForm.insertTimeEnd,
            //级联表的
                yuangongName: searchForm.yuangongName,
                yuangongPhone: searchForm.yuangongPhone,
                yuangongIdNumber: searchForm.yuangongIdNumber,


            }, (res) => {
                if(res.code == 0) {
                    clear();
                    $("#thisTbody").html("");
                    dataList = res.data.list;
                    totalPage = res.data.totalPage;
                    for (var i = 0; i < dataList.length; i++) { //遍历一下表格数据  
                        var trow = setDataRow(dataList[i], i); //定义一个方法,返回tr数据 
                        $('#thisTbody').append(trow);
                    }
                    pagination(); //渲染翻页组件
                    getRoleButtons();// 权限按钮控制
                }
            });
        }

        // 渲染表格数据
        function setDataRow(item, number) {
            //创建行 
            var row = document.createElement('tr');
            row.setAttribute('class', 'useOnce');
            //创建勾选框
            var checkbox = document.createElement('td');
            var checkboxDiv = document.createElement('div');
            checkboxDiv.setAttribute("class", "custom-control custom-checkbox");
            var checkboxInput = document.createElement('input');
            checkboxInput.setAttribute("class", "custom-control-input");
            checkboxInput.setAttribute("type", "checkbox");
            checkboxInput.setAttribute('name', 'chk');
            checkboxInput.setAttribute('value', item.id);
            checkboxInput.setAttribute("id", number);
            checkboxDiv.appendChild(checkboxInput);
            var checkboxLabel = document.createElement('label');
            checkboxLabel.setAttribute("class", "custom-control-label");
            checkboxLabel.setAttribute("for", number);
            checkboxDiv.appendChild(checkboxLabel);
            checkbox.appendChild(checkboxDiv);
            row.appendChild(checkbox)


                    //员工姓名
            var yuangongNameCell = document.createElement('td');
            yuangongNameCell.innerHTML = item.yuangongName;
            row.appendChild(yuangongNameCell);


                    //员工手机号
            var yuangongPhoneCell = document.createElement('td');
            yuangongPhoneCell.innerHTML = item.yuangongPhone;
            row.appendChild(yuangongPhoneCell);


                    //员工身份证号
            var yuangongIdNumberCell = document.createElement('td');
            yuangongIdNumberCell.innerHTML = item.yuangongIdNumber;
            row.appendChild(yuangongIdNumberCell);


                //员工照片
            var yuangongPhotoCell = document.createElement('td');
            var yuangongPhotoImg = document.createElement('img');
            var yuangongPhotoImgValue = item.yuangongPhoto;
            if(yuangongPhotoImgValue !=null && yuangongPhotoImgValue !='' && yuangongPhotoImgValue !='null'){
                    yuangongPhotoImg.setAttribute('src', yuangongPhotoImgValue);
                    yuangongPhotoImg.setAttribute('height', 100);
                    yuangongPhotoImg.setAttribute('width', 100);
                    yuangongPhotoCell.appendChild(yuangongPhotoImg);
            }else{
                    yuangongPhotoCell.innerHTML = "暂无图片";
            }
            row.appendChild(yuangongPhotoCell);



            //盘点名
            var pandianOrderNameCell = document.createElement('td');
            pandianOrderNameCell.innerHTML = item.pandianOrderName;
            row.appendChild(pandianOrderNameCell);


            //盘点时间
            var insertTimeCell = document.createElement('td');
            insertTimeCell.innerHTML = item.insertTime;
            row.appendChild(insertTimeCell);


                //备注
            var pandianOrderContentCell = document.createElement('td');
            //如果图文详情包含图片
            if (item.pandianOrderContent && item.pandianOrderContent.indexOf('img') != -1) {
                //暂时只考虑图片+文字 和 文字+图片的情况
                var beginIndex = item.pandianOrderContent.indexOf('<img');
                var endIndex = item.pandianOrderContent.indexOf('>');
                    pandianOrderContentCell.innerHTML = item.pandianOrderContent.substring(beginIndex, endIndex + 1).replace("img", "img width='100' height='100'");
            } else {
                if (item.pandianOrderContent != null && item.pandianOrderContent != "" && item.pandianOrderContent.length >= 11) {
                        pandianOrderContentCell.innerHTML = item.pandianOrderContent.substring(0, 10) + "...";
                } else {
                        pandianOrderContentCell.innerHTML = item.pandianOrderContent;
                }
            }
            row.appendChild(pandianOrderContentCell);



            //每行按钮
            var btnGroup = document.createElement('td');

            //详情按钮
            var detailBtn = document.createElement('button');
            var detailAttr = "detail(" + item.id + ')';
            detailBtn.setAttribute("type", "button");
            detailBtn.setAttribute("class", "btn btn-info btn-sm 查看");
            detailBtn.setAttribute("onclick", detailAttr);
            detailBtn.innerHTML = "查看";
            btnGroup.appendChild(detailBtn);

            //查看列表详情
            var detailListBtn = document.createElement('button');
            var detailListAttr = "getId(" + item.id+')';
            detailListBtn.setAttribute("type", "button");
            detailListBtn.setAttribute("class", "btn btn-info btn-sm 查看");
            detailListBtn.setAttribute("onclick", detailListAttr);
            detailListBtn.innerHTML = "查看列表详情";
            btnGroup.appendChild(detailListBtn);

            //修改按钮
            var editBtn = document.createElement('button');
            var editAttr = 'edit(' + item.id + ')';
            editBtn.setAttribute("type", "button");
            editBtn.setAttribute("class", "btn btn-warning btn-sm 修改");
            editBtn.setAttribute("onclick", editAttr);
            editBtn.innerHTML = "修改";
            btnGroup.appendChild(editBtn);

            //删除按钮
            var deleteBtn = document.createElement('button');
            var deleteAttr = 'remove(' + item.id + ')';
            deleteBtn.setAttribute("type", "button");
            deleteBtn.setAttribute("class", "btn btn-danger btn-sm 删除");
            deleteBtn.setAttribute("onclick", deleteAttr);
            deleteBtn.innerHTML = "删除";
            btnGroup.appendChild(deleteBtn);
            row.appendChild(btnGroup);

            return row;
    }


        // 翻页
        function pageNumChange(val) {
            if (val == 'pre') {
                pageIndex--;
            } else if (val == 'next') {
                pageIndex++;
            } else {
                pageIndex = val;
            }
            getDataList();
        }

        // 下载
        function download(url) {
            window.open(url);
        }
        // 打开新窗口播放媒体
        function mediaPlay(url){
            window.open(url);
        }

        // 渲染翻页组件
        function pagination() {
            var beginIndex = pageIndex;
            var endIndex = pageIndex;
            var point = 4;
            //计算页码
            for (var i = 0; i < 3; i++) {
                if (endIndex == totalPage) {
                    break;
                }
                endIndex++;
                point--;
            }
            for (var i = 0; i < 3; i++) {
                if (beginIndex == 1) {
                    break;
                }
                beginIndex--;
                point--;
            }
            if (point > 0) {
                while (point > 0) {
                    if (endIndex == totalPage) {
                        break;
                    }
                    endIndex++;
                    point--;
                }
                while (point > 0) {
                    if (beginIndex == 1) {
                        break;
                    }
                    beginIndex--;
                    point--
                }
            }
            // 是否显示 前一页 按钮
            if (pageIndex > 1) {
                $('#tableId_previous').show();
            } else {
                $('#tableId_previous').hide();
            }
            // 渲染页码按钮
            for (var i = beginIndex; i <= endIndex; i++) {
                var pageNum = document.createElement('li');
                pageNum.setAttribute('onclick', "pageNumChange(" + i + ")");
                if (pageIndex == i) {
                    pageNum.setAttribute('class', 'paginate_button page-item active useOnce');
                } else {
                    pageNum.setAttribute('class', 'paginate_button page-item useOnce');
                }
                var pageHref = document.createElement('a');
                pageHref.setAttribute('class', 'page-link');
                pageHref.setAttribute('href', '#');
                pageHref.setAttribute('aria-controls', 'tableId');
                pageHref.setAttribute('data-dt-idx', i);
                pageHref.setAttribute('tabindex', 0);
                pageHref.innerHTML = i;
                pageNum.appendChild(pageHref);
                $('#tableId_next').before(pageNum);
            }
            // 是否显示 下一页 按钮
            if (pageIndex < totalPage) {
                $('#tableId_next').show();
                $('#tableId_next a').attr('data-dt-idx', endIndex + 1);
            } else {
                $('#tableId_next').hide();
            }
            var pageNumInfo = "当前第 " + pageIndex + " 页，共 " + totalPage + " 页";
            $('#tableId_info').html(pageNumInfo);
        }

        // 跳转到指定页
        function toThatPage() {
            //var index = document.getElementById('pageIndexInput').value;
            if (index < 0 || index > totalPage) {
                alert('请输入正确的页码');
            } else {
                pageNumChange(index);
            }
        }

        // 全选/全不选
        function chooseAll() {
            checkAll = !checkAll;
            var boxs = document.getElementsByName("chk");
            for (var i = 0; i < boxs.length; i++) {
                boxs[i].checked = checkAll;
            }
        }

        // 批量删除
        function deleteMore() {
            ids = []
            var boxs = document.getElementsByName("chk");
            for (var i = 0; i < boxs.length; i++) {
                if (boxs[i].checked) {
                    ids.push(boxs[i].value)
                }
            }
            if (ids.length == 0) {
                alert('请勾选要删除的记录');
            } else {
                remove(ids);
            }
        }

        // 删除
        function remove(id) {
            var mymessage = confirm("真的要删除吗？");
            if (mymessage == true) {
                var paramArray = [];
                if (id == ids) {
                    paramArray = id;
                } else {
                    paramArray.push(id);
                }
                httpJson("pandianOrder/delete", "POST", paramArray, (res) => {
                    if(res.code == 0){
                        getDataList();
                        alert('删除成功');
                    }
                });
            } else {
                alert("已取消操作");
            }
        }

        // 用户登出
        <%@ include file="../../static/logout.jsp"%>

        //修改
        function edit(id) {
            window.sessionStorage.setItem('updateId', id)
            window.location.href = "add-or-update.jsp"
        }

        //清除会重复渲染的节点
        function clear() {
            var elements = document.getElementsByClassName('useOnce');
            for (var i = elements.length - 1; i >= 0; i--) {
                elements[i].parentNode.removeChild(elements[i]);
            }
        }

        //添加
        function add() {
            window.sessionStorage.setItem("addpandianOrder", "addpandianOrder");
            window.location.href = "add-or-update.jsp"
        }

        //报表
        function graph() {
            window.location.href = "graph.jsp"
        }

        // 查看详情
        function detail(id) {
            window.sessionStorage.setItem("updateId", id);
            window.location.href = "info.jsp";
        }

    //填充级联表搜索下拉框
                                         
                     
                     
                                        
    //填充本表搜索下拉框
             
     
        
    //查询级联表搜索条件所有列表

    //查询当前表搜索条件所有列表













        // 新增入入入入入入入入入入入入入入入 新增盘点

        //盘点
        function outPandianOrderList() {
            document.getElementById("pandianOrderListModalTitle").innerHTML = "盘点列表";
            $("#pandianOrderListFlag").val(2);
            $('#pandianOrderListModal').modal('show');
        }
        //入入入入入入入入入入入入入入入
        function inPandianOrderList() {
            document.getElementById("pandianOrderListModalTitle").innerHTML = "入入入入入入入入入入入入入入入列表";
            $("#pandianOrderListFlag").val(1);
            $('#pandianOrderListModal').modal('show');

        }

        // 模态框打开
        $('#pandianOrderListModal').on('show.bs.modal', function () {

            // 当前表
            yuangongSelect();
            initializationYuangongSelect();
            // 详情表
            goodsSelect();
            initializationGoodsSelect();
            if(window.sessionStorage.getItem('role') == '员工'){
                $(".bbbbbb").remove();
            }
            $(".selectpicker" ).selectpicker('refresh');
        });
        // 模态框关闭
        $('#pandianOrderListModal').on('hide.bs.modal', function () {
            $("#pandianOrderListModalTitle").val("")
            $("#pandianOrderListFlag").val(0);
            $("#pandianOrderName").val("");
            $("#pandianOrderListTableTbody").html("");
            // 当前表
            $("#yuangongSelect").empty();
            // 详情表
            $("#goodsSelect").empty();
            $(".selectpicker" ).selectpicker('refresh');
        });

        // 当前表
            // 模态框的 操作人初始化和查询
        function yuangongSelect() {
            http("yuangong/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    yuangongOptions = res.data.list;
                }
            });
        }
        function initializationYuangongSelect() {
            var yuangongSelect = document.getElementById('yuangongSelect');
            if(yuangongSelect != null && yuangongOptions != null  && yuangongOptions.length > 0 ) {
                for (var i = 0; i < yuangongOptions.length; i++) {
                        yuangongSelect.add(new Option(yuangongOptions[i].yuangongName, yuangongOptions[i].id));
                }
            }
            $("#yuangongSelect").change(function(e) {
                var id = e.target.value;
                http("yuangong/info/"+id, "GET", {}, (res) => {
                    if(res.code == 0){
                        yuangong = res.data;
                    }
                });
            });
        }

        // 详情表
            // 模态框的 商品初始化和查询
        function goodsSelect() {
            http("goods/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    goodsOptions = res.data.list;
                }
            });
        }
        function initializationGoodsSelect() {
            var goodsSelect = document.getElementById('goodsSelect');
            if(goodsSelect != null && goodsOptions != null  && goodsOptions.length > 0 ) {
                for (var i = 0; i < goodsOptions.length; i++) {
                    goodsSelect.add(new Option(goodsOptions[i].goodsName, goodsOptions[i].id));
                }
            }
            $("#goodsSelect").change(function(e) {
                var id = e.target.value;
                http("goods/info/"+id, "GET", {}, (res) => {
                    if(res.code == 0){
                        goods = res.data;
                    }
                });
            });
        }

        // 模态框的添加按钮
        function addPandianOrderList() {
            var id = document.getElementById("goodsSelect").options[document.getElementById("goodsSelect").selectedIndex].value;//获取当前选择项的值.
            if(id ==null || id=="" || id<=0){
                alert("请选择盘点详情");
                return;
            }
            if( $("#rowId"+id).val() == null ){
                http("goods/info/"+id, "GET", {}, (res) => {
                    if(res.code == 0){
                        var span =  setPandianOrderListDataRow(res.data);
                        $('#pandianOrderListTableTbody').append(span);
                        chickPandianOrderNumber(1,id);
                    }else{
                        alert("添加盘点详情失败,请联系管理员查看日志详情");
                        return;
                    }
                });
            }else{
                alert("您已经添加过此盘点详情");
            }
        }

        // 添加盘点详情到待提交列表
        function setPandianOrderListDataRow(item) {
            //创建行 
            var row = document.createElement('tr');
            row.setAttribute("id", "rowId"+item.id);

                //商品名字  
            var goodsNameCell = document.createElement('td');
            goodsNameCell.innerHTML = item.goodsName;
            row.appendChild(goodsNameCell);

                //商品种类   
            var goodsTypesCell = document.createElement('td');
            goodsTypesCell.innerHTML = item.goodsValue;
            row.appendChild(goodsTypesCell);

                //商品数量   
            var goodsNumberCell = document.createElement('td');
            goodsNumberCell.setAttribute("id","td"+item.id);
            goodsNumberCell.innerHTML = item.goodsNumber;
            row.appendChild(goodsNumberCell);

                //单位
            var danweiCell = document.createElement('td');
            danweiCell.innerHTML = item.danwei;
            row.appendChild(danweiCell);

                //单价  
            var danjiaCell = document.createElement('td');
            danjiaCell.setAttribute("id","danjiatd"+item.id);
            danjiaCell.innerHTML = item.danjia;
            row.appendChild(danjiaCell);

                //是否删除
            // var flagCell = document.createElement('td');
            // flagCell.innerHTML = item.flag;
            // row.appendChild(flagCell);
            //
            //     //盘点前数量
            // var goodsQianNumberCell = document.createElement('td');
            // goodsQianNumberCell.innerHTML = item.goodsQianNumber;
            // row.appendChild(goodsQianNumberCell);

            //操作数量
            var pandianOrderListNumberCell = document.createElement('input');
            pandianOrderListNumberCell.setAttribute("id", "inputNumbertd"+item.id);
            pandianOrderListNumberCell.setAttribute("name", "inputNumber");
            pandianOrderListNumberCell.setAttribute("value", 1);
            pandianOrderListNumberCell.setAttribute("class", "form-control");
            pandianOrderListNumberCell.setAttribute("onchange", "chickPandianOrderNumber(this.value,"+item.id+")");
            row.appendChild(pandianOrderListNumberCell);

            //每行按钮
            var btnGroup = document.createElement('td');
            //删除按钮
            var deleteBtn = document.createElement('button');
            deleteBtn.setAttribute("type", "button");
            deleteBtn.setAttribute("class", "btn btn-danger btn-sm 删除");
            deleteBtn.setAttribute("onclick","removeSelectPandianOrderOne("+item.id+")");
            deleteBtn.innerHTML = "删除";
            btnGroup.appendChild(deleteBtn);

            row.appendChild(btnGroup);

            return row;
        }

        function chickPandianOrderNumber(this_val,id){
            // var this_val = e.value || 0;
            if(this_val == 0){
                $("#inputNumbertd"+id).val(1);
                alert("数量为0无意义");
                return false;
            }
            var reg=/^[0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只能输入正整数数字");
                return false;
            }
            var tdid = "#td"+id;
            var number = $(tdid).text();
            if(number==null || number==""){
                alert("商品数量不正确,请进入商品中修改该商品数量");
                return false;
            }
        }

        function removeSelectPandianOrderOne(id) {
            var rowId = "#rowId"+ id;
            $(rowId).remove();

        }

        // 提交操作
        function submitPandianOrderList() {
            var pandianOrderName = $("#pandianOrderName").val();
            if(pandianOrderName ==null || pandianOrderName == "" || pandianOrderName=="null"){
                alert("请输入要生成的盘点名");
                return false;
            }

            var elementsByName = document.getElementsByName("inputNumber"); // 获取当前模态框表格中输入的input值
            var flag=false;// 用于判断是否有输入为空或者0这种无意义参数情况
            let map = {};//map就是传到后台的值,key:id value:数字
            for (var i = 0; i < elementsByName.length; i++) { //遍历一下表格数据  
                var value = elementsByName[i].value;
                if(value ==null || value =="" ||  value =="null" || value == 0){
                    flag=true;
                }else{
                    var id = parseInt(elementsByName[i].id.replace("inputNumbertd",""));
                    map[id]=parseInt(value);
                }
            }
            if(flag){
                alert("数量中有空或者为0情况");
                return false;
            }

            var flag = parseInt($("#pandianOrderListFlag").val());
            var urlParam=null;



            var msg=null;
            if(flag==1){
                urlParam="inPandianOrderList";
                msg="入入入入入入入入入入入入入入入成功";
            }else if(flag==2){
                urlParam="outPandianOrderList";
                msg="盘点成功";
            }else{
                alert("未知错误,请联系管理员");
                return false;
            }
            if(map == null || Object.keys(map).length==0){
                alert("不允许添加空值");
                return false;
            }

            var yuangongId_1 =null;
            if($("#yuangongSelect").val()!= null){
                yuangongId_1 = $('#yuangongSelect option:selected').val();
            }
            httpJson("pandianOrder/" + urlParam, "POST", {
                map : map,
                pandianOrderName : pandianOrderName,
                // 当前表表关联
                yuangongId : yuangongId_1,//把操作人传过去
        }, (res) => {
                if(res.code == 0){
                    alert(msg);
                    $('#pandianOrderListModal').modal('hide');
                    getDataList();
                }else{
                    alert(res.msg);
                }
            });
        }







        //列表查看
        // 获取选择的列表的id
        function getId(thisId) {
            if(thisId == null || thisId=="" || thisId=="null"){
                alert("未知错误,请联系管理员处理");
                return;
            }
            id=thisId;
            $('#showPandianOrderListModal').modal('show');
        }

        //模态框打开的时候会执行这个里面的东西
        $('#showPandianOrderListModal').on('show.bs.modal', function () {
            //清理表格内容,防止重复回显
            $("#showPandianOrderListTableTbody").html("");
            if(id ==null){
                alert("获取当前列id错误,请联系管理员处理");
                $('#showPandianOrderListModal').modal('hide');
                return;
            }
            // 当前表
            yuangongSelect();//查询列表
            initializationYuangongSelect();//列表赋值
            //详情表
            goodsSelect();//查询列表
            initializationGoodsSelect();//列表赋值
            $(".selectpicker" ).selectpicker('refresh');//刷新赋值,否则下拉框还是原来的内容
            showPandianOrderList();//查询数据列表
        });
        //模态框关闭的时候会执行这个里面的东西
        $('#showPandianOrderListModal').on('hide.bs.modal', function () {
            $("#showPandianOrderListTableTbody").html("");
            id=null;

                // 当前表
            $("#yuangongSelect").empty();//置位空,下次打开模态框再重新查,
            $("#yuangongName").val("");
                //详情表
            $("#goodsSelect").empty();//置位空,下次打开模态框再重新查,
            $(".selectpicker" ).selectpicker('refresh');//刷新赋值,否则下拉框还是原来的内容
            getDataList();
        });

        // 查询所有数据
        function showPandianOrderList() {

            // 当前表的级联表 id定义
            var yuangongId = "";
            // 查询当前数据详情
            http("pandianOrder/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                // 当前表的级联表id赋值
                yuangongId = res.data.yuangongId;
                }
            });

            // 查询当前表级联表的数据
            if(yuangongId != null && yuangongId != "" && yuangongId != "null"){
                http("yuangong/info/"+yuangongId, "GET", {}, (res) => {
                    if(res.code == 0){
                        yuangong = res.data;
                        $("#yuangongName").val(yuangong.yuangongName);
                    }
                });
            }


            //查询列表详情
            http("pandianOrderList/page", "GET", {
                page: 1,
                limit: 100,
                pandianOrderId: id,
            }, (res) => {
                if(res.code == 0){
                    var list = res.data.list;
                    $("#showPandianOrderListTableTbody").html("");
                    for (var i = 0; i < list.length; i++) { //遍历一下表格数据  
                        var trow = setShowPandianOrderListDataRow(list[i]); //在 setShowPandianOrderListDataRow 中拼接数据,然后返回再追加到列表中
                        $('#showPandianOrderListTableTbody').append(trow);
                    }
                }else{
                    alert("查询列表错误,请联系管理员处理");
                    $('#showPandianOrderListModal').modal('hide');
                    return;
                }
            });
        }

        // 列表回显
        function setShowPandianOrderListDataRow(item) {
            //创建行 
            var row = document.createElement('tr');


                //商品名字  
            var goodsNameCell = document.createElement('td');
            goodsNameCell.innerHTML = item.goodsName;
            row.appendChild(goodsNameCell);

                //商品种类   
            var goodsTypesCell = document.createElement('td');
            goodsTypesCell.innerHTML = item.goodsValue;
            row.appendChild(goodsTypesCell);

                //商品数量   
            var goodsNumberCell = document.createElement('td');
            goodsNumberCell.setAttribute("id","td"+item.id);
            goodsNumberCell.innerHTML = item.goodsNumber;
            row.appendChild(goodsNumberCell);

                //单位
            var danweiCell = document.createElement('td');
            danweiCell.innerHTML = item.danwei;
            row.appendChild(danweiCell);

                //单价  
            var danjiaCell = document.createElement('td');
            danjiaCell.innerHTML = item.danjia;
            row.appendChild(danjiaCell);

            //     //是否删除
            // var flagCell = document.createElement('td');
            // flagCell.innerHTML = item.flag;
            // row.appendChild(flagCell);

                //盘点前数量   
            var goodsQianNumberCell = document.createElement('td');
            goodsQianNumberCell.innerHTML = item.goodsQianNumber;
            row.appendChild(goodsQianNumberCell);

                //盘点后数量   
            var pandianOrderListNumberCell = document.createElement('td');
            pandianOrderListNumberCell.innerHTML = item.pandianOrderListNumber;
            row.appendChild(pandianOrderListNumberCell);

            //操作数量
            // var pandianOrderListNumberCell = document.createElement('td');
            //     pandianOrderListNumberCell.innerHTML = item.pandianOrderListNumber;
            // row.appendChild(pandianOrderListNumberCell);


            //每行按钮
            var btnGroup = document.createElement('td');

            if(window.sessionStorage.getItem('role') == '管理员'){
                //删除按钮
                var deleteBtn = document.createElement('button');
                deleteBtn.setAttribute("type", "button");
                deleteBtn.setAttribute("class", "btn btn-danger btn-sm 删除");
                deleteBtn.setAttribute("onclick","removeShowPandianOrderListOne("+item.id+")");
                deleteBtn.innerHTML = "删除";
                btnGroup.appendChild(deleteBtn);
            }

            row.appendChild(btnGroup);

            return row;
        }

        // 删除
        function removeShowPandianOrderListOne(id) {
            var mymessage = confirm("真的要删除吗？");
            if (mymessage == true) {
                var paramArray = [];
                paramArray.push(id);
                httpJson("pandianOrderList/delete", "POST",paramArray, (res) => {
                    if(res.code == 0){
                    alert('删除成功');
                    showPandianOrderList();
                }else{
                    alert(res.msg);
                }
            });
            } else {
                alert("已取消操作");
            }
        }

        //新增
        function addShowPandianOrderList() {
            var paramArray = {};
            paramArray["pandianOrderId"]=id;// 当前表的id
            var goodsId = $('#goodsSelect option:selected').val();//选中的值
            if(goodsId == null || goodsId == "" || goodsId =="null"){
                alert("不能添加空值");
                return;
            }
            paramArray["goodsId"]=goodsId; //添加的id
            httpJson("pandianOrderList/save", "POST", paramArray, (res) => {
                if(res.code == 0){
                    alert('新增成功');
                    showPandianOrderList();
                }else{
                    alert(res.msg);
                }
            });
        }



        $(document).ready(function () {
            //激活翻页按钮
            $('#tableId_previous').attr('class', 'paginate_button page-item previous')
            $('#tableId_next').attr('class', 'paginate_button page-item next')
            //隐藏原生搜索框
            $('#tableId_filter').hide()
            //设置右上角用户名
            $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
            //设置项目名
            $('.sidebar-header h3 a').html(projectName)
            setMenu();
            init();

            //查询级联表的搜索下拉框

            //查询当前表的搜索下拉框
            getDataList();

        //级联表的下拉框赋值
                                                 
                         
                         
                                                
        //当前表的下拉框赋值
                                     
             
                        
        <%@ include file="../../static/myInfo.js"%>
    });
</script>
</body>

</html>