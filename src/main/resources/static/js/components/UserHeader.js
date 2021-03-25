import api from "/resources/js/connectivity.js"


Vue.component("UserHeader", {
    data: function () {
        return {userdata: ''}
    },
    template: `
        <body th:fragment="user-header">
        <nav class="navbar navbar-dark bg-primary">
            <a class="navbar-brand" href="/">
                <!--<img src="/public/images/logo.png" height="50px" class="d-inline-block align-top" alt="">-->
              <span>Welcome, {{this.userdata}}</span> 
            </a>

            <div class="col-3" th:inline="text"><!--
                <span th:text="#{sentence.logged-as}"/>
                <span th:text="#{username}"/>
                -->
            </div>

            <div class="col-5"></div>

            <!--    language select -->
            <div class="col-1">
                <div th:include="~{headers.html::locale-menu}"/>
            </div>
            <!--  logout    -->
            <div class="col-1">
                <form action="#" th:action="@{/logout}" method="POST">
                    <button class="btn btn-info" type="submit">
                        <span th:text="#{word.logout}"/>
                    </button>
                </form>
            </div>
        </nav>
    </body>`,
    created: function () {
        api
            .get({page: "api", call: "userheaderdata"})
            .then(result => {
                this.userdata = result.body.username
            })
    }
})