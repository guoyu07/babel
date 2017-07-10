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
        var userName = $("#userName").val();
        var password = $("#password").val();

        var loginParam = {
            userName: userName,
            password: password
        };//拼装成json格式
        var postUrl = account.URL.login();

        $.post(postUrl, loginParam).success(function (resopnseData) {
            if(resopnseData["message"]=="Ok"){
                localStorage.setItem("token",resopnseData.data["token"]);
                window.location.href="/account/main";
            }
        });
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
