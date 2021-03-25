<template>
  <div id="index">
    <a href="#" @click="setLocale('en')">en</a>
    <a href="#" @click="setLocale('ua')">ua</a>
  </div>
  <div>
    works!
  </div>
</template>

<script>
import HeaderGuest from 'components/'
import {i18n} from "./i18n/i18n";

const vue = new Vue({
  el: 'app',
  components: { i18n },
  template: '<Index/>'
});

console.log("aaa")
</script>
