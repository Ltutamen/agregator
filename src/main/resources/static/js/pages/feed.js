import "/resources/js/components/UserHeader.js"
import api from "/resources/js/connectivity.js"


Vue.component("FeedEntry", {
    props: ['title', 'text', 'media'],
    template:
        '<div class="card col-lg-8" style="max-width: 18rem;">' +
        '   <div class="card-title">' +
        '       {{title}}' +
        '   </div>' +
        '   <div class="card-text">' +
        '       {{text}}' +
        '   </div> ' +
        '</div>'
})


Vue.component("FeedBody", {
    data() {
        return {
            page: 0,
            entries: []
        }
    },

    template:
        '<div>' +
        '   <div v-for="(item, $index) in entries" :key="$index">' +
        '       <FeedEntry :text="item.text"></FeedEntry>' +
        '   </div>' +

        '   <infinite-loading @infinite="infiniteHandler"></infinite-loading>' +
        '</div>',

    methods: {
        infiniteHandler($state) {
            api
                .get({page: "feed", call: "page", feedpage: this.page})
                .then(result => {
                    if (!result.body.isEnd) {
                        this.page += 1;
                        const entries = result.body.feedEntries;

                        this.entries = this.entries.concat(entries);
                        $state.loaded();
                    } else {
                        $state.complete();
                    }
                })
        }
    }

})


const settingsApp = new Vue({
    el: '#feed-app',
    template:
        '<div class="container-fluid">' +
        '   <UserHeader/>' +
        '   <FeedBody/>' +
        '</div>',

    created: function () {
    }
})
