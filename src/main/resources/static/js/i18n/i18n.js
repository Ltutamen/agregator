import Vue from 'vue'
import VueI18n from 'vue-i18n'

Vue.use(VueI18n);

export const i18n = new VueI18n({
    locale: 'ua',
    fallbackLocale: 'en',
    messages: {
        en: {
            helloWorld: 'Hello, Wold!',
        },
        ua: {
            helloWorld: 'Привіт, Світ!'
        }
    }
})