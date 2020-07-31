import Vue from "vue";
import Notifier from './NotifyService.js'
class ContactService {
    getAssuntos(){
        return Vue.prototype.$axios.get('/assunto/listarTodos')
            .then(res => {
                console.log('sucesso', res.data)
                return res.data;
            })
            .catch(e => {
                const notifier = new Notifier()
                notifier.error(e.message)
            })
    }
}
export default ContactService;