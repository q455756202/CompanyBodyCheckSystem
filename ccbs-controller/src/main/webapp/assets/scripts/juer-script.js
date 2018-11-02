var juerVerify = {
    verify: function (verifyKey, callback) {
        let result = true;

        $('[verify-key="' + verifyKey + '"]').each(function (i, v) {
            let val = $(v).val();
            if (!val) {
                result = false;
            } else {
                let type = $(v).attr("verify-type");
                switch (type) {
                    case "number":
                        result = juerVerify.verifyNum(val);
                        break;
                    case "email":
                        result = juerVerify.verifyEmail(val);
                        break;
                    case "phone":
                        result = juerVerify.verifyPhone(val);
                        break;
                    default:
                        result = val != null;
                        break;
                }
            }
            if (!result)
                $(v).next().focus();
        });

        if (result)
            callback();

        return result;
    },

    verifyNum: function (num) {
        let str = "0123456789", test = new String(num), result = true;

        if (test.length > 0) {
            let reg = /^-?\d+$/;
            result = reg.test(test);
        }

        return result;
    },
    verifyEmail: function (email) {
        let str = email.trim(), result = false;

        if (str.length != 0) {
            let reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
            if (reg.test(str))
                result = true;
        }

        return result;
    },
    verifyPhone: function (phone) {
        let result = false;

        if (phone.length > 0) {
            let reg = /^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/;
            if (reg.test(phone))
                result = true;
        }

        return result;
    }
}

var juerCore = {
    /*
     * 为指定 win 触发一次 post 报表。
     * win: window
     * url: string
     * params: object
     */
    postWin: function (win, url, params) {
        var form = $("<form action='" + url + "' method='post'></form>");
        Object.keys(params).forEach(function (value) {
            form.append($("<input type='hidden' name='" + value + "' value='" + params[value] + "'/>"));
        });

        $(win.document).append(form);
        form.submit();
    },

    /*
     * 解析一个从服务器传回的数据，并转换为 json 对象
     * data: string
     */
    analyseMsg: function (data) {
        console.log("[DEBUG] juerCore.analyseMsg -> ", data);
        return eval("(" + data + ")");
    },

    /*
     * 设置一个父模态框的高度为内部高度
     */
    setModalHeight: function (modal) {
        var h = $("html").css("height");
        h = h.slice(0, h.length - 2);
        parent.$(modal).css("height", h - 0 + 32 + "px");
    },

    setWinToTop: function (win) {
        // 如果当前页面不是顶级窗口，则使顶级窗口发生跳转
        if (top !== window)
            top.location.href = window.location.href;
    },

    post: function (url, data, callback, expl) {
        console.log(data);
        $.ajax({
            url: url,
            type: "POST",
            data: data,
            cache: false,
            processData: false,
            contentType: false,
            success: function (data) {
                console.log("juerCore.post", data);
                if (expl)
                    data = juerCore.analyseMsg(data);
                callback(data);
            },
            error: function (data) {
                console.error(data);
            }
        });
    },

    upload: function (url, input, callback) {
        var files = input.files;
        for (var i = 0; i < files.length; i++) {
            var file = files[i];
            var formData = new FormData();
            formData.append(file.name, file);

            juerCore.post(url, formData, callback, true);
            // var xhr = new XMLHttpRequest();
            // xhr.open("post", url, true);
            // xhr.send(formData);
            // xhr.onsuccess = function (data) {
            //
            // }
        }
    }
};

var juerCard = {
    testCardIndex: 0,
    testCard: function () {
        var temp = $('<div class="card mb-3"></div>');
        var header = $('<div class="card-header"></div>');
        header.append($('<span class="close" id="${date}" onclick="cardClose(this);">&times;</span>'));
        header.append($('<h3>测试页面 ' + (++juerCard.testCardIndex) + '</h3>'));
        temp.append(header);

        var body = $('<div class="card-body"></div>');
        body.append('<p class="card-text">欢迎使用一个普通的后台管理，这是一个可重复添加的测试页面。</p>');
        body.append('<p class="card-text">这是第' + juerCard.testCardIndex + '个测试页面。</p>');
        temp.append(body);

        var footer = $('<div class="card-footer text-right">From @JuerWhang</div>');
        temp.append(footer);

        $("#card-box").prepend(temp);
    },
    getCard: function (url, data) {
        $.post(url, data, function (result) {
            if (result.indexOf("div") == -1)
                toastr.error(result);
            else
                $("#card-box").prepend($.parseHTML(result, null, true));
        }, true);
    },
};

function getWeek(n) {
    var now = new Date();
    var year = now.getFullYear();
    //因为月份是从0开始的,所以获取这个月的月份数要加1才行
    var month = now.getMonth() + 1;
    var date = now.getDate();
    var day = now.getDay();
    //判断是否为周日,如果不是的话,就让今天的day-1(例如星期二就是2-1)
    if (day !== 0) {
        n = n + (day - 1);
    }
    else {
        n = n + day;
    }
    if (day) {
        //这个判断是为了解决跨年的问题
        if (month > 1) {
            month = month;
        }
        //这个判断是为了解决跨年的问题,月份是从0开始的
        else {
            year = year - 1;
            month = 12;
        }
    }
    now.setDate(now.getDate() - n);
    year = now.getFullYear();
    month = now.getMonth() + 1;
    date = now.getDate();
    return now;
}

Date.prototype.toWeek = function () {
    var arr = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
    return arr[this.getDay()];
}

$(function () {
    // 对jquery的post方法添加包装，以获取详细信息
    var oldpost = $.post;
    // a: url, b: params, c: callback, d: sourceMsg
    $.post = function (a, b, c, d) {
        console.log("[DEBUG] $.post :", arguments);
        oldpost(a, b, function (data) {
            if (!d)
                data = juerCore.analyseMsg(data);
            c(data);
        });
    }

    var oldeval = eval;
    eval = function (x) {
        if (x && x.length > 0)
            return oldeval(x);
    }

    // 初始化弹窗提示的设置
    toastr.options = {
        "closeButton": false,//是否配置关闭按钮
        "debug": false,//是否开启debug模式
        "newestOnTop": false,//新消息是否排在最上层
        "progressBar": false,//是否显示进度条
        "positionClass": "toast-bottom-right",//消息框的显示位置
        "preventDuplicates": false,//是否阻止弹出多个消息框
        "onclick": null,//点击回调函数
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": "3000",//1.5s后关闭消息框
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    };

    Date.prototype.format = function (fmt) {
        var o = {
            "M+": this.getMonth() + 1,                 //月份
            "d+": this.getDate(),                    //日
            "h+": this.getHours(),                   //小时
            "m+": this.getMinutes(),                 //分
            "s+": this.getSeconds(),                 //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds()             //毫秒
        };
        if (/(y+)/.test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        }
        for (var k in o) {
            if (new RegExp("(" + k + ")").test(fmt)) {
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            }
        }
        return fmt;
    }

    // 为 Math 添加一些 Java 风格的函数
    Math.nextUInt = function (bound) {
        return Math.round(Math.random() * bound);
    };
    Math.nextInt = function (min, max) {
        if (min >= max)
            throw "Math.nextInt -> min is gte with max!";
        else
            return Math.nextUInt(max - min) + min;
    };
    Math.nextUFloat = function (bound) {
        return Math.random() * bound;
    };
    Math.nextFloat = function (min, max) {
        if (min >= max)
            throw "Math.nextFloat -> min is gte with max!";
        else
            return Math.nextUFloat(max - min) + min;
    };

    $("#auto-bypass").attr("data-toggle", "tooltip");
    $("#auto-bypass").each(function (i, v) {
        v.attr("title", v.text());
    });
});
