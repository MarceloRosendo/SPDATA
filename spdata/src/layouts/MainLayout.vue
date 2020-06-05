<template>
  <q-layout view="lHh Lpr lFf">
    <q-header class="bg-gradient" elevated>
      <q-toolbar></q-toolbar>
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
  }
};
</script>
