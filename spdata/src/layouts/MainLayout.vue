<template>
  <q-layout view="lHh Lpr lFf">
    <q-header class="bg-gradient" elevated>
      <q-toolbar>
        <div class="logo-2-basis">
          <img src="~assets/logo2.png" alt="logotipo spdata" />
        </div>

        <q-list class="links-header">
          <q-item class="link-header" clickable @click="redirect('Home')">Home</q-item>
          <q-item class="link-header" clickable @click="redirect('Empresa')">Empresa</q-item>
          <q-item class="link-header" clickable @click="redirect('Solucoes')">Soluções</q-item>
          <q-item class="link-header" clickable @click="redirect('Modulos')">Módulos</q-item>
          <q-item class="link-header" clickable @click="redirect('Servicos')">Serviços</q-item>
          <q-item class="link-header" clickable @click="redirect('Cursos')">Cursos</q-item>
          <q-item class="link-header" clickable @click="redirect('Portarias')">Portarias</q-item>
          <q-item class="link-header" clickable @click="redirect('Blog')">Blog</q-item>
          <q-item class="link-header" clickable @click="redirect('Contato')">Contato</q-item>
        </q-list>
      </q-toolbar>
    </q-header>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
export default {
  name: "MainLayout",

  data() {
    return {
      leftDrawerOpen: false
    };
  },
  methods:{
    redirect(page){

    }
  }
};
</script>
