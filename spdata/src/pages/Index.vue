<template>
  <q-page class="flex flex-center">
    <div class="logoInternalContainer">
      <img class="animated" alt="SPDATA logo" src="~assets/logo.png" />
    </div>

    <div class="contact">
      <q-btn icon="local_phone" color="primary" text-color="white" round></q-btn>
    </div>

    <div class="content">
      <div class="primary-view">
        <q-card class="my-card-1">
          <q-parallax src="https://cdn.quasar.dev/img/parallax1.jpg" :height="150" />

          <q-card-section>
            <div class="text-h6">Soluções práticas e personalizadas</div>
            <div class="text-subtitle2">Suporte completo atenciosamente, sempre ao seu lado</div>
          </q-card-section>
        </q-card>

        <div class="right-content">
          <q-card class="my-card-2">
            <q-parallax src="https://cdn.quasar.dev/img/parallax1.jpg" :height="150" />

            <q-card-section>
              <div class="text-h6 justify-end">Uma marca que tem muito de você</div>
              <div class="text-subtitle2 justify-end">Soluções integradas em saúde</div>
            </q-card-section>
          </q-card>
        </div>
      </div>

      <div class="second-view">
        <div class="second-header">
          <div class="text-h6 justify-center font-color-2">Sistemas de gestão para saúde</div>
        </div>

        <div class="content-2">
          <q-card class="my-card">
            <q-img src="~assets/professionalism.png" basic>
              <div class="absolute-bottom text-h6">Solicite uma demonstração</div>
            </q-img>

            <q-card-section>{{ content_2_text_body }}</q-card-section>
          </q-card>
        </div>
      </div>

      <div class="thirdy-view">
        <q-table
          grid
          :card-container-class="cardContainerClass"
          title="Treats"
          :data="data"
          :columns="columns"
          row-key="name"
          hide-header
        >
          <template v-slot:item="props">
            <div class="q-pa-xs col-xs-12 col-sm-6 col-md-4">
              <q-card>
                <q-card-section class="text-center">
                  <strong>{{ props.row.name }}</strong>
                </q-card-section>
                <q-separator />
                <q-card-section
                  class="flex flex-center"
                  :style="{ fontSize: props.row.calories + 'px' }"
                >
                  <div>{{ props.row.calories }} g</div>
                </q-card-section>
              </q-card>
            </div>
          </template>
        </q-table>
      </div>
    </div>
  </q-page>
</template>

<script>
const deserts = [
  "SGH",
  "SGO",
  "SGSP",
  "PEP",
  "SGH-Intelligence",
  "SGH-Suprimentos"
];

const data = []

deserts.forEach(name => {
  for (let i = 0; i < 24; i++) {
    data.push({ name: name + ' (' + i + ')', calories: 20 + Math.ceil(50 * Math.random()) })
  }
})

data.sort(() => (-1 + Math.floor(3 * Math.random())))

export default {
  name: "PageIndex",
  data() {
    return {
      visible: false,
      content_2_text_body:
        "Com soluções modularizadas e adaptáveis, a SPDATA possui sistemas capazes de se adequar perfeitamente aos diversos modelos de gestão e porte da instituição de saúde.",
        filter: '',
        pagination: {
        page: 1,
        rowsPerPage: this.getItemsPerPage()
      },
      columns: [
        { name: 'name', label: 'Name', field: 'name' },
        { name: 'calories', label: 'Calories (g)', field: 'calories' }
      ],
      data
    };
  },
  computed: {
    cardContainerClass () {
      if (this.$q.screen.gt.xs) {
        return 'grid-masonry grid-masonry--' + (this.$q.screen.gt.sm ? '3' : '2')
      }

      return void 0
    },

    rowsPerPageOptions () {
      if (this.$q.screen.gt.xs) {
        return this.$q.screen.gt.sm ? [ 3, 6, 9 ] : [ 3, 6 ]
      }

      return [ 3 ]
    }
  },
  watch: {
    '$q.screen.name' () {
      this.pagination.rowsPerPage = this.getItemsPerPage()
    }
  },
   methods: {
    getItemsPerPage () {
      const { screen } = this.$q
      if (screen.lt.sm) {
        return 3
      }
      if (screen.lt.md) {
        return 6
      }
      return 9
    }
  }
};
</script>
