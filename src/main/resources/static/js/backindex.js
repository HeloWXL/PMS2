$(function () {
    // 全局变量
    var a = 0;
    var b = 0;
    var classArr = new Array("", "success", "error", "warning", "info");
    var pageNo = 1;
    var pageSize = 10;
    var pageCount = 0;

// --------------------------------------时间格式处理-------------------------------------------------

    function GMTToStr(time){
        var date = new Date(time)
        var Str=date.getFullYear() + '-' +
            (date.getMonth() + 1) + '-' +
            date.getDate() + ' ' +
            date.getHours() + ':' +
            date.getMinutes() + ':' +
            date.getSeconds()
        return Str
    }
// --------------------------------------学生管理-------------------------------------------------

    $("a[name='student']").click(function () {
        $("#student").show();
        $("#summary").hide();

    })

    $.ajax({
        url: "student/getStudentList",
        type: "post",
        dataType: "json",
        data: {"pageNo": pageNo, "pageSize": pageSize},
        cache: false,
        async: false,
        success: function (ret) {
            pageCount = ret.count;
            for (var i = 0; i < ret.list.length; i++) {
                var homeaddress;
                if(ret.list[i].studentHomeaddress==null){
                   var homeaddress = "";
                }else{
                    homeaddress = ret.list[i].studentHomeaddress;
                }

                var phone ;
                if(ret.list[i].studentPhone==null){
                    var phone = "";
                }else{
                    phone = ret.list[i].studentPhone;
                }

                $node = $("      <tr class=' "+ classArr[b++] + "'>\n" +
                    "                        <td>\n" +
                    "                            "+ret.list[i].studentNo+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                            "+ret.list[i].studentName+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                            *********\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                            "+ret.list[i].studentClass+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                            "+homeaddress+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                            "+ret.list[i].studentApartment+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                            "+phone+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                            "+ret.list[i].sutdnetSex+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                            "+ret.list[i].studentProfession+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                           "+ret.list[i].studentAge+"\n" +
                    "                        </td>\n" +
                    "                    </tr>")
                $("#student table tbody").append($node);
                if (b == 5) {
                    b = 0;
                }
            }
        }
    })
    // 分页管理-下一页
    $("#student ul li a[name='next']").click(function () {
        $("#student table tbody").empty();

        var maxpage = Math.ceil(pageCount / 10);
        if (pageNo < maxpage) {
            ++pageNo;
        } else {
            pageNo = maxpage;
            alert("已经是最后一页了")
            // layer.msg("已经是最后一页了", {time: 2500});
        }
        getstudentLit(pageNo, pageSize);

    });
    // 分页管理-上一页
    $("#student ul li a[name='prev']").click(function () {
        $("#student table tbody").empty();
        if (pageNo == 1) {
            alert("已经是第一页了")
            // layer.msg("已经是第一页了", {time: 2500});
        } else {
            pageNo--;
        }
        getstudentLit(pageNo, pageSize);
    });
    function getstudentLit(pageNo, pageSize) {
        $.ajax({
            url: "student/getStudentList",
            type: "post",
            dataType: "json",
            data: {"pageNo": pageNo, "pageSize": pageSize},
            cache: false,
            async: false,
            success: function (ret) {
                pageCount = ret.count;
                for (var i = 0; i < ret.list.length; i++) {
                    var homeaddress;
                    if(ret.list[i].studentHomeaddress==null){
                        var homeaddress = "";
                    }else{
                        homeaddress = ret.list[i].studentHomeaddress;
                    }

                    var phone ;
                    if(ret.list[i].studentPhone==null){
                        var phone = "";
                    }else{
                        phone = ret.list[i].studentPhone;
                    }

                    $node = $("      <tr class=' "+ classArr[b++] + "'>\n" +
                        "                        <td>\n" +
                        "                            "+ret.list[i].studentNo+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            "+ret.list[i].studentName+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            *********\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            "+ret.list[i].studentClass+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            "+homeaddress+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            "+ret.list[i].studentApartment+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            "+phone+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            "+ret.list[i].sutdnetSex+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            "+ret.list[i].sutdnetProfession+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                           "+ret.list[i].studentAge+"\n" +
                        "                        </td>\n" +
                        "                    </tr>")
                    $("#student table tbody").append($node);
                    if (b == 5) {
                        b = 0;
                    }
                }
            }
        })
    }

// --------------------------------------教师管理-------------------------------------------------



// --------------------------------------实习日记管理-------------------------------------------------
// --------------------------------------实习周记管理-------------------------------------------------
// --------------------------------------实习月记管理-------------------------------------------------
// --------------------------------------实习总结管理-------------------------------------------------
    $("a[name='summary']").click(function () {
        $("#summary").show();
        $("#student").hide();
        $("a[name='summary']").not(this).hide();

    })
    $.ajax({
        url: "summary/getSummaryList",
        type: "post",
        dataType: "json",
        data: {"pageNo": pageNo, "pageSize": pageSize},
        cache: false,
        async: false,
        success: function (ret) {
            pageCount = ret.count;
            for (var i = 0; i < ret.list.length; i++) {
            // <button type="button" class="btn btn-default">默认</button>
                var p ;
                if(ret.list[i].isRead==1){
                    p=$("<button type=\"button\" class=\"btn btn-primary\" name='isread'>已批阅</button>")

                }else{
                    p=$("<button type=\"button\" class=\"btn btn-warning\" name='isnotread'>未批阅</button>")
                }

                $node = $("      <tr class=' "+ classArr[b++] + "'>\n" +
                    "                        <td>\n" +
                    "                            "+ret.list[i].studentNo+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                            "+ret.list[i].studentName+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                            "+ret.list[i].studentClass+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                            "+ret.list[i].studentApartment+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                            "+ret.list[i].studentProfession+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                           "+GMTToStr(ret.list[i].summaryDatetime)+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                           "+ret.list[i].summary+"\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "                        </td>\n" +
                    "                        <td>\n" +
                    "<button type=\"button\" class=\"btn btn-info\" name='view'>查看</button>\n" +
                    "<button type=\"button\" class=\"btn btn-danger\" name='delete'>删除</button>\n" +
                    "                        </td>\n" +
                    "                    </tr>")

                $("#summary table tbody").append($node);
                $("#summary table tbody td").eq(-2).append(p)

                if (b == 5) {
                    b = 0;
                }
            }
        }
    })

    $("#summary ul li a[name='next']").click(function () {
        $("#summary table tbody").empty();

        var maxpage = Math.ceil(pageCount / 10);
        if (pageNo < maxpage) {
            ++pageNo;
        } else {
            pageNo = maxpage;
            alert("已经是最后一页了")
            // layer.msg("已经是最后一页了", {time: 2500});
        }
        getsummaryLit(pageNo, pageSize);

    });
    // 分页管理-上一页
    $("#summary ul li a[name='prev']").click(function () {
        $("#summary table tbody").empty();
        if (pageNo == 1) {
            alert("已经是第一页了")
            // layer.msg("已经是第一页了", {time: 2500});
        } else {
            pageNo--;
        }
        getsummaryLit(pageNo, pageSize);
    });
    function getsummaryLit(pageNo, pageSize){
        $.ajax({
            url: "summary/getSummaryList",
            type: "post",
            dataType: "json",
            data: {"pageNo": pageNo, "pageSize": pageSize},
            cache: false,
            async: false,
            success: function (ret) {
                pageCount = ret.count;
                for (var i = 0; i < ret.list.length; i++) {
                    var p ;
                    if(ret.list[i].isRead==1){
                        p=$("<button type=\"button\" class=\"btn btn-primary\" name='delete'>已批阅</button>")

                    }else{
                        p=$("<button type=\"button\" class=\"btn btn-warning\" name='delete'>未批阅</button>")
                    }

                    $node = $("      <tr class=' "+ classArr[b++] + "'>\n" +
                        "                        <td>\n" +
                        "                            "+ret.list[i].studentNo+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            "+ret.list[i].studentName+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            "+ret.list[i].studentClass+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            "+ret.list[i].studentApartment+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                            "+ret.list[i].studentProfession+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                           "+ret.list[i].summaryDatetime+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +
                        "                           "+ret.list[i].summary+"\n" +
                        "                        </td>\n" +
                        "                        <td>\n" +

                        "                        </td>\n" +
                        "                        <td>\n" +
                        "<button type=\"button\" class=\"btn btn-info\" name='view'>查看</button>\n" +
                        "<button type=\"button\" class=\"btn btn-danger\" name='delete'>删除</button>\n" +
                        "                        </td>\n" +
                        "                    </tr>")
                    $("#summary table tbody").append($node);
                    $("#summary table tbody td").eq(-2).append(p)
                    if (b == 5) {
                        b = 0;
                    }
                }
            }
        })
    }




})