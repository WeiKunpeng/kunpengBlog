$(function () {
    var isLoc = $('input[name="isLoc"]').val();
    var latlng = '';
    var $userName = $('#userName');
    var oldUser = $userName.val();
    //用户框失去焦点口,是否需要出现验证码
    $userName.blur(function (e) {
        e.preventDefault();
        var userName = $userName.val();
        if (!userName || oldUser === userName) {
            return false;
        }
        oldUser = userName;

        //$.ajax({
        //    url: '/account/needcaptcha',
        //    type: 'post',
        //    data: {'username': $userName.val()},
        //    dataType: 'json',
        //    success: function (data) {
        //        if (data.status) {
        //            $('.code-number').show();
        //        }
        //    }
        //})
    });

    // Ｅｎｔｅｒ提交
    $(document).keypress(function (event) {
        /* Act on the event */
        var btn = $('#clickBtn');
        if (event.which === 13 && !btn.hasClass('disabled')) {
            btn.attr('disabled', true).addClass('disabled');
            btn.trigger('click');
        }
    });

    //表单提交事件
    $('#clickBtn').click(function (e) {
        e.preventDefault();
        var self = $(this);
        self.addClass('disabled');
        var userName = $('#userName').val();
        var password = $('#password').val();
        var loginvcode = $('#loginvcode').val();
        var patt = new RegExp(/^[\w-_]+$/);
        if (!userName || !password ) {
            $('#tipPop').text('请正确填写表单信息.').addClass('active');
            self.removeClass('disabled');
            return false;
        }

        if (!patt.test(userName)) {
            $('#tipPop').text('用户名只能由字母和数字组成，不能包含其他字符和空格').addClass('active');
            self.removeClass('disabled');
            return false;
        }

        var url = '/user/login';
        if (window.location.search) {
            url = '/account/valid' + window.location.search;
        }
        var data = {"username": userName, "password": password};
        if ($('.code-number').is(':visible')) {
            data.loginvcode = loginvcode;
            data.captchaId = $('#captchaId').val()
        }

        var disable = 0;
        if (latlng || isLoc === "true" || !navigator.geolocation) {
            submit();
            return;
        }

        var ti = setTimeout(function () {
            submit();
        }, 1000);
        navigator.geolocation.getCurrentPosition(success, error, {timeout:1000});

        function error() {
            clearTimeout(ti);
            submit()
        }
        function success(position) {
            clearTimeout(ti);
            latlng = position.coords.latitude + ',' + position.coords.longitude;
            submit()
        }
        function submit() {
            if (disable === 1) {
                return;
            }
            disable = 1;
            data.latlng = latlng;
            $.ajax({
                url: url,
                type: 'post',
                data: data,
                dataType: 'json',
                success: function (ret) {
                    if (ret.code === 200) {
                        if (ret.loginTips !== '') {
                            //alert(ret.loginTips);
                        }
                        //window.location.href = ret.returnUrl;
                        window.location.href = ret.data.toString();

                    } else {
                        if (ret.code === 40001) {
                            $('.code-number').show();
                        }
                        $('#vcode').click();
                        $('#tipPop').text(ret.msg).addClass('active');
                    }
                },
                fail: function (ret) {
                    $('#tipPop').text(ret.msg).addClass('active');
                }
            }).done(function () {
                self.removeClass('disabled');
            });
        }

        return false;
    });

    // 点击任意地方隐藏提示
    $(document).click(function (e) {
        var container = $("#tipPop");

        if (!$(e.target).is('a') && container.is(':visible') && !$(e.target).is('#tipPop')
            && container.has(e.target).length === 0) {
            setTimeout(function () {
                // 弹窗隐藏
                container.removeClass('active')
                // 按钮disabled移除
                $('#clickBtn').removeClass('disabled');
            }, 500);
        }
    });
    function success(position) {
        latlng = position.coords.latitude + ',' + position.coords.longitude;
    }
    function error(PositionError) {
        if (PositionError.code === PositionError.PERMISSION_DENIED) {
            window.alert('请务必开启定位功能！')
        }
    }
    if (navigator.geolocation && isLoc === "false") {
        navigator.geolocation.getCurrentPosition(success, error);
    }
});
