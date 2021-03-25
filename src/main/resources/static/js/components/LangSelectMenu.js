Vue.component("", {
    template:
        '<div>' +
    <!--<iframe name="dummyframe" id="dummyframe" style="display: none;"/>-->
    '<div class="dropdown">' +
      '<button class="btn btn-secondary dropdown-toggle"' +
              ' type="button"' +
              ' id="dropdownMenuButton"' +
              ' data-toggle="dropdown"' +
              ' aria-haspopup="true"' +
              ' aria-expanded="false">' +
        'current_locale' +
      '</button>' +
      '<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">' +
        '<div>' +
          '<a href="#" class="dropdown-item" @click=setLocale(en)>En</a>' +
          '<a href="#" class="dropdown-item" @click=setLocale(ua)>Ua</a>' +
        '</div>' +
      '</div>' +
    '</div>' +
  '</div>'})

console.log("lang-select-menu loaded")
