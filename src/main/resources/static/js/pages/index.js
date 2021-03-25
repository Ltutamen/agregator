import "/resources/js/components/GuestHeader.js"

Vue.component('IndexPageBody', {
    template:
        '<div class="main-w3layouts wrapper">' +
        '   <h1>Aggregator app</h1>' +
        '   <div class="main-agileinfo">' +
        '           <div class="agileits-top">' +
        '               <a class="btn btn-primary btn-lg btn-block" type="button" href="/login">Login</a>' +
        '               <a class="btn btn-secondary btn-lg btn-block" type="button" href="/register">Register</a>' +
        '           </div>' +
        '   </div>' +
        '       <!-- copyright -->' +
        '       <div class="colorlibcopy-agile">' +
        '           <p>© 2018 Colorlib Signup Form. All rights reserved | Design by <a href="https://colorlib.com/" target="_blank">Colorlib</a></p>' +
        '       </div>' +
        '       <!-- //copyright -->' +
        '       <ul class="colorlib-bubbles" style="height: 100%" >' +
        '           <li/>' +
        '<li/>' +
        '<li/>' +
        '<li/>' +
        '<li/>' +
        '<li/>' +
        '<li/>' +
        '<li/>' +
        '<li/>' +
        '<li/>' +
        '       </ul>' +
        '</div>'
})


const indexApp = new Vue({
    el: '#index-app',
    template:
        '<div>' +
        '   <GuestHeader/>' +
        '   <IndexPageBody/>' +
        '</div>'
})