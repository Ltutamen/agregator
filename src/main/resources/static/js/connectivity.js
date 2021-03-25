const url = '{/page}{/call}';

const postAction = {
    post: {method: 'POST', url: url}
}

const api = Vue.resource(url, {}, postAction)

export default api;