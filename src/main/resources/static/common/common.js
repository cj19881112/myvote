function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=")
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1
            c_end = document.cookie.indexOf(";", c_start)
            if (c_end == -1) c_end = document.cookie.length
            return unescape(document.cookie.substring(c_start, c_end))
        }
    }
    return ""
}

function registWebsocket (obj) {
    $.get('/sign', function (data) {
        if (data.success) {
            obj.ws = new ReconnectingWebSocket("ws://" + window.location.host + "/ws");
            obj.ws.onmessage = function (evt) {
                // 收到服务器信息，刷新数据
                obj.loadData();
            };
            obj.loadData();
            setInterval(function () {
                obj.ws.send("ping")
            }, 1000)
        } else {
            alert('连接服务器失败，请刷新重试')
        }
    })
}

function pollData(obj) {
    setInterval(function () {
        obj.loadData()
    }, 2000)
}

var M = {
    mask: function () {
        var spinner = $('.spinner')
        if (!spinner || spinner.length == 0) {
            $('body').append('<div class="spinner" style="display: none">' +
                '        <div>' +
                '            <div class="cube1"></div>' +
                '            <div class="cube2"></div>' +
                '        </div>' +
                '    </div>')
        }
        $('.spinner').show()
    },
    
    unmask: function () {
        $('.spinner').hide()
    }
}

$(document).ajaxStop(function() {
    M.unmask();
})