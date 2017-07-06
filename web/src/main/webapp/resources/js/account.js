var account = {
    URL: {
        login: function () {
            return "/account/login";
        },
        register: function () {
            return "/account/register";
        }
    },
    login:function () {
        var userName = $("#loginUserName").val();
        var password = $("#loginPwd").val();

        var loginParam = {
            userName: userName,
            password: password
        };//拼装成json格式
        var postUrl = account.URL.login();

        $.post(postUrl, loginParam);
    },
    register:function () {
        var userName = $("#regName").val();
        var email = $("#regEmail").val();
        var password = $("#regPwd").val();

        var registerParam = {
            regName:userName,
            regEmail:email,
            regPwd:password
        };//拼装成json格式
        var postUrl = account.URL.register();

        $.post(postUrl, registerParam);
    }
};
