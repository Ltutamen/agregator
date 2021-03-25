Vue.component('locale-menu', {
    template:
        '<body th:fragment="locale-menu">' +
        '    <!--<iframe name="dummyframe" id="dummyframe" style="display: none;"/>-->' +
        '        <div class="dropdown">' +
        '            <button class="btn btn-secondary dropdown-toggle"' +
        '                    type="button"' +
        '                    id="dropdownMenuButton"' +
        '                    data-toggle="dropdown"' +
        '                    aria-haspopup="true"' +
        '                    aria-expanded="false"' +
        '                    th:text="${current_locale}"' +
        '            />' +
        '            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">' +
        '                <div th:each="locale : ${locales}">' +
        '                    <form method="post" th:action="@{${#httpServletRequest.requestURI} + \'?lang=\' + ${locale.toJavaLocale().toString()}}">' +
        '                        <input type="submit"' +
        '                               class="dropdown-item"' +
        '                               th:value="${locale}"' +
        '                        />' +
        '                    </form>' +
        '                </div>' +
        '            </div>' +
        '        </div>' +
        '    </body>'
})

Vue.component('header-guest', {
    template:
        ' <!--    This header doesn\'t contain user-specific data  -->' +
        '    <body th:fragment="guest-header">\n' +
        '        <nav class="navbar navbar-dark bg-primary">' +
        '            <a class="navbar-brand" th:href="@{/}">' +
        '                <!--<img src="/public/images/logo.png" height="50px" class="d-inline-block align-top" alt="">-->\n' +
        '                <span th:text="#{word.application-name}"/>' +
        '            </a>' +
        '            <div class="col-10"></div>' +
        '            <!--    language select -->' +
        '            <div class="col-1">' +
        '                <locale-menu/>' +
        '            </div>' +
        '        </nav>' +
        '    </body>'
})

Vue.component('header-user', {
    template:
        '<body th:fragment="user-header">' +
        '        <nav class="navbar navbar-dark bg-primary">' +
        '            <a class="navbar-brand" th:href="@{/}">' +
        '                <!--<img src="/public/images/logo.png" height="50px" class="d-inline-block align-top" alt="">-->' +
        '                <span th:text="#{word.application-name}"/>' +
        '            </a>' +
        '            <div class="col-3" th:inline="text">' +
        '                <span th:text="#{sentence.logged-as}"/>' +
        '                <span th:text="${username}"/>' +
        '            </div>' +
        '            <div class="col-5"></div>' +
        '            <!--    language select -->' +
        '            <div class="col-1">' +
        '                <locale-menu/>' +
        '            </div>' +
        '            <!--  logout    -->' +
        '            <div class="col-1">' +
        '                <form action="#" th:action="@{/logout}" method="POST">' +
        '                    <button class="btn btn-info" type="submit">' +
        '                        <span th:text="#{word.logout}"/>' +
        '                    </button>' +
        '                </form>' +
        '            </div>' +
        '        </nav>' +
        '    </body>'
})