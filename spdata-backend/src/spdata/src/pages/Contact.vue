<template>
  <div class="q-pa-md">
    <q-form @submit="onSubmit" @reset="onReset" class="q-gutter-md">
      <div class="flex item-container">
        <q-input
          class="row item"
          filled
          v-model="nome"
          label="Nome"
          hint="Nome e sobrenome"
          lazy-rules
          :rules="[ val => val && val.length > 0 || 'Por favor, preencha com seu nome']"
        />

        <div>
          <q-input
            class="row item"
            filled
            v-model="email"
            label="Email"
            hint="Exemplo: darth@vader.com.br"
            lazy-rules
            :rules="[ val => val && val.length > 0 || 'Por favor, preencha com seu email']"
          />
        </div>
      </div>
      <div class="flex item-container">
        <q-input
          filled
          class="row item"
          v-model="confirmacao_email"
          label="Confirmação do email"
          hint="Exemplo: darth@vader.com.br"
          lazy-rules
          :rules="[ val => val && val.length > 0 || 'Por favor, confirme seu email']"
        />
        <q-input
          filled
          class="row item"
          v-model="telefone"
          label="Phone"
          mask="(##) ##### - ####"
          hint="Exemplo: (33) 3333 - 3333"
        />
      </div>
      <div class="flex item-container">
        <q-input
          filled
          class="row item"
          v-model="empresa"
          label="Empresa"
          hint="Nome da empresa em que você trabalha"
          lazy-rules
          :rules="[ val => val && val.length > 0 || 'Por favor, preencha com sua empresa']"
        />

        <q-input
          filled
          class="row item"
          v-model="empresa"
          label="Cargo"
          hint="O cargo que você ocupa, ex: enfermeiro"
          lazy-rules
          :rules="[ val => val && val.length > 0 || 'Por favor, preencha com seu cargo']"
        />
      </div>
      <q-select class="row item" filled v-model="assunto" :options="options" label="Assunto" />
      <q-input class="message" v-model="mensagem" filled type="textarea" />

      <div>
        <q-btn label="Enviar" type="submit" color="primary" />
        <q-btn label="Limpar campos" type="reset" color="primary" flat class="q-ml-sm" />
      </div>
    </q-form>
  </div>
</template>

<script>
import contactService from '../scripts/Contact'

export default {
  data() {
    return {
      nome: null,
      email: null,
      confirmacao_email: null,
      telefone: null,
      empresa: null,
      cargo: null,
      endereco: null,
      assunto: null,
      mensagem: null,
      options: ["Google", "Facebook", "Twitter", "Apple", "Oracle"],
      contactService: new contactService()
    };
  },
  methods: {
    onSubmit() {},
    onReset() {
      this.nome = null;
      this.email = null;
      this.confirmacao_email = null;
      this.telefone = null;
      this.empresa = null;
      this.cargo = null;
      this.endereco = null;
      this.assunto = null;
      this.mensagem = null;
    }
  },
  mounted(){
      this.contactService.getAssuntos(res=>{
          console.log('mamão com açucar', res)
      })
  }
};
</script>

<style>
</style>