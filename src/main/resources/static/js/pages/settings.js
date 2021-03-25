import "/resources/js/connectivity.js"


Vue.component("KeyDescriptionCard", {
    props: ['keyDescription'],
    template:
        '<div class="well">' +
        '   <p>' +
        '       <span>Present key, actions: {{this.keyDescription}}</span>' +
        '       <button type="button" class="btn btn-warning" @click="onDeleteClick">Delete</button>' +
        '   </p>' +
        '</div>',

    methods:{
        onDeleteClick: function (keyId) {
            console.log("attempt to delete: " + this.keyDescription.id);
            api
                .post({path: "delete", body: this.keyDescription.id})
                .then(response => {
                    //  todo error callback
                })
        }
    }
})

Vue.component("SiteSettingsCard", {
    props: ['siteData'],
    template:
        '<div class="card text-white border-dark bg-primary" style="width: 18rem;">' +
        '    <img class="card-img-top img-fluid" :src="siteData.siteDescription.logoUrl" alt=siteData/>' +
        '     <div class="card-body">' +
        '         <h5 class="card-title">{{siteData.siteDescription.name}}</h5>' +
        '         <div class="card-text">' +
        '           <p v-for="keyDescription in siteData.keyDescriptions" :key="keyDescription.id">' +
        '               <KeyDescriptionCard :keyDescription="keyDescription"/>' +
        '           </p>' +
        '            <a :href=siteData.siteDescription.loginUrl class="btn btn-primary">login {{siteData.siteDescription.name}} </a>' +
        '        </div>' +
        '   </div>' +
        '</div>'
})

Vue.component("SettingsBody", {
    data: function () {
        return {siteDescriptions: []}},
    template:
        '<div>' +
        '<div class="card-group">' +
        '   <SiteSettingsCard v-for="site in siteDescriptions[0]" :key="site.name" :siteData="site"/>' +
        '</div>' +
        '</div>',

    created: function () {
        api
            .get({call: "pagedata"})
            .then(result => {
                this.siteDescriptions.push(result.body.keyDefinitions)
            })
    }

})


const settingsApp = new Vue({
    el: '#settings-app',
    template:
        '<div class="container-fluid">' +
        '   <UserHeader/>' +
        '   <SettingsBody/>' +
        '</div>'
})
