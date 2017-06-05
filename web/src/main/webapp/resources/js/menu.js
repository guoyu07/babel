var menu = {
    //封装菜单相关的url
    URL:{
        menusUrl:function () {
            return "/menu/list";
        }
    },
    getMenus:function () {
        var menuUrl = menu.URL.menusUrl();
        $.get(menuUrl,function (result) {
            console.log(result)
        });
    }
}