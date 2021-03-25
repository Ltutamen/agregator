import "/resources/js/components/GuestHeader.js"

/*Vue.use(window.vuelidate.default)
* v-validate="{ required: true, regex: w{5, 40} }*/

Vue.component("LoginBody", {
    template:
        '<div class="main-w3layouts wrapper">' +
        '   <h1>Creative SignUp Form</h1>' +
        '   <div class="main-agileinfo">' +
        '   <div class="agileits-top">' +
        '       <form action="/register" method="post" name="registerFormDto">' +
        '           <input class="text" type="text" name="username" placeholder="Username">' +
        '           <input class="text email" type="email" name="email" placeholder="Email">' +
        '           <input class="text" type="password" name="password" placeholder="Password">' +
        '           <input class="text w3lpass" type="password" placeholder="Confirm Password" required="">' +
        '           <div class="wthree-text">' +
        '               <label class="anim">' +
        '                   <input type="checkbox" class="checkbox" required="">' +
        '                       <span>I Agree To The Terms & Conditions</span>' +
        '              </label>' +
        '              <div class="clear"> </div>' +
        '          </div>' +
        '          <input type="submit" value="SIGNUP">' +
        '      </form>' +
        '      <p>Don\'t have an Account? <a href="/login"> Login Now!</a></p>' +
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
    el: '#register-app',
    template:
        '<div>' +
        '   <GuestHeader/>' +
        '   <LoginBody/>' +
        '</div>'
})