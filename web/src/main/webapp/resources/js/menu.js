var menu = {
    URL: {
        menuList: function () {
            return "/menu/list";
        },
        mainMenus: function () {
            return "/menu/mainMenus";
        },
        resourceList: function () {
            return "/resource/list";
        },
        menuAdd: function () {
            return "/menu/add";
        }
    },

    initParentNodeSelect: function () {
        $.get(menu.URL.mainMenus()).success(function (response) {
            $('#parentGuid').empty();
            $('#parentGuid').append("<option value=''></option>");
            var mainMenus = response['data'];
            for (var i = 0; i < mainMenus.length; ++i) {
                $('#parentGuid').append('<option value="' + mainMenus[i].guid + '">' + mainMenus[i].menuName + '</option>');
            }
        })
    },

    initChildNodeSelect: function () {
        $.get(menu.URL.resourceList()).success(function (response) {
            $('#resourceGuid').empty();
            $('#resourceGuid').append("<option value=''></option>");
            var resources = response['data'];
            for (var j = 0; j < resources.length; ++j) {
                $('#resourceGuid').append('<option value="' + resources[j].guid + '">' +
                    '(' + resources[j].description + ')' +
                    resources[j].resource
                    + '</option>');
            }

        })
    },

    addMenu: function () {
        var parentGuid = $("#parentGuid").val();
        var resourceGuid = $("#resourceGuid").val();
        var menuName = $("#menuName").val();
        var menuIndex = $("#menuIndex").val();
        var menuType = $("#menuType").val();
        var iconClass = $("#iconClass").val();

        var menuParam = {
            parentGuid: parentGuid,
            resourceGuid: resourceGuid,
            menuName: menuName,
            menuIndex: menuIndex,
            menuType: menuType,
            iconClass: iconClass
        };//拼装成json格式
        var postUrl = menu.URL.menuAdd();

        $.post(postUrl, menuParam);
    }
}

var setting = {
    view: {
        showIcon: false,
        showLine: true
    },
    check: {
        enable: true,
        chkStyle: "checkbox"
    },
    data: {
        key: {
            name: "menuName"
        },
        simpleData: {
            enable: true,
            idKey: "guid",
            pIdKey: "parentGuid"
        }
    },
    async: {
        enable: true,
        url: menu.URL.menuList(),
        type: "get"
    },
    callback: {
        onAsyncSuccess: function (event, treeId, msg) {
            var zTree = $.fn.zTree.getZTreeObj(treeId);
            zTree.expandAll(true);
        }
    }
};

var menuTree = {
    initZtree: function () {
        $.fn.zTree.init($("#menuTree"), setting);
    }
}