
import "/resources/js/components/LanguageSelectMenu.js";

Vue.component("GuestHeader", {
    template:
        '<div>' +
        '      <nav class="navbar navbar-dark bg-dark">' +
        '            <a class="navbar-brand" href="/">' +
        '                <!--<img src="/public/images/logo.png" height="50px" class="d-inline-block align-top" alt="">-->\n' +
        '                <LangSelectMenu></LangSelectMenu>' +
        '            </a>' +
        '            <div class="col-10"><p> hello! </p></div>' +
        '            <!--    language select -->' +
        '            <div class="col-1"></div>' +
        '        </nav>' +
        '</div>',
})
