import "/resources/js/components/GuestHeader.js"

Vue.component("RegisterBody", {
    template:
        '<div class="main-w3layouts wrapper">' +
        '   <h1>Creative Login Form</h1>' +
        '   <div class="main-agileinfo">' +
        '   <div class="agileits-top">' +
        '       <form action="/login" method="post">' +
        '           <input class="text btn btn-success btn-lg btn-block w-100" type="text" name="username" placeholder="Username" required="true">' +
        '           <input class="text btn btn-success btn-lg btn-block w-100" type="password" name="password" placeholder="Password" required="true">' +
        '           <input class="btn btn-primary btn-lg btn-block" type="submit" value="SIGNUP">' +
        '      </form>' +
        '      <p>Don\'t have an Account? <a href="/register"> Register Now!</a></p>' +
        '  </div>' +
        '</div>' +
        '       <!-- copyright -->' +
        '       <div class="colorlibcopy-agile">' +
        '           <p>© 2018 Colorlib Signup Form. All rights reserved | Design by <a href="https://colorlib.com/" target="_blank">Colorlib</a></p>' +
        '       </div>' +
        '       <!-- //copyright -->' +
        '       <ul class="colorlib-bubbles">' +
        '       <li></li>' +
        '       <li></li>' +
        '       <li></li>' +
        '       <li></li>' +
        '       <li></li>' +
        '       <li></li>' +
        '       <li></li>' +
        '       <li></li>' +
        '       <li></li>' +
        '       <li></li>' +
        '   </ul>' +
        '</div>'
})

const indexApp = new Vue({
    el: '#login-app',
    template:
        '<div>' +
        '   <GuestHeader/>' +
        '   <RegisterBody/>' +
        '</div>'
})