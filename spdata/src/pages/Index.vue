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
          <q-parallax src="~assets/gente-estrangeira-feliz.jpg" :height="150" />

          <q-card-section>
            <div class="text-h6">Soluções práticas e personalizadas</div>
            <div class="text-subtitle2">Suporte completo atenciosamente, sempre ao seu lado</div>
          </q-card-section>
        </q-card>

        <div class="right-content">
          <q-card class="my-card-2">
            <q-parallax src="~assets/gente-estrangeira-feliz-2.png" :height="150" />

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
        <q-carousel
          v-model="slide"
          transition-prev="slide-right"
          transition-next="slide-left"
          swipeable
          animated
          control-color="primary"
          navigation
          padding
          arrows
          height="300px"
          class="bg-grey-1 shadow-2 rounded-borders"
        >
          <q-carousel-slide :name="1" class="column no-wrap">
            <div class="row fit justify-start items-center q-gutter-xs q-col-gutter no-wrap">
              <q-card class="carousel-card">
                <img src="~assets/sgh.jpeg" />

                <q-card-section>
                  <div class="text-h6">SGH</div>
                  <div class="text-subtitle2">Sistema de Gestão Hospitalar</div>
                </q-card-section>

                <q-card-section class="q-pt-none">Saiba mais</q-card-section>
              </q-card>
              <q-card class="carousel-card">
                <img src="~assets/sgo.jpeg" />

                <q-card-section>
                  <div class="text-h6">SGO</div>
                  <div class="text-subtitle2">Sistema de Gestão de Operadoras de Saúde</div>
                </q-card-section>

                <q-card-section class="q-pt-none">Saiba mais</q-card-section>
              </q-card>
            </div>
          </q-carousel-slide>
          <q-carousel-slide :name="2" class="column no-wrap">
            <div class="row fit justify-start items-center q-gutter-xs q-col-gutter no-wrap">
              <q-card class="carousel-card">
                <img src="~assets/sgsp.jpeg" />

                <q-card-section>
                  <div class="text-h6">SGSP</div>
                  <div class="text-subtitle2">Sistema de Gestão de Saúde Pública</div>
                </q-card-section>

                <q-card-section class="q-pt-none">Saiba mais</q-card-section>
              </q-card>
              <q-card class="carousel-card">
                <img src="~assets/pep.jpeg" />

                <q-card-section>
                  <div class="text-h6">PEP</div>
                  <div class="text-subtitle2">Prontuário Eletrônico do Paciente</div>
                </q-card-section>

                <q-card-section class="q-pt-none">Saiba mais</q-card-section>
              </q-card>
            </div>
          </q-carousel-slide>
          <q-carousel-slide :name="3" class="column no-wrap">
            <div class="row fit justify-start items-center q-gutter-xs q-col-gutter no-wrap">
              <q-card class="carousel-card">
                <img src="~assets/sgh-intelligence.jpeg" />

                <q-card-section>
                  <div class="text-h6">SGH-Intelligence</div>
                  <div class="text-subtitle2">Sistema de Gestão Hospitalar - BI</div>
                </q-card-section>

                <q-card-section class="q-pt-none">Saiba mais</q-card-section>
              </q-card>
              <q-card class="carousel-card">
                <img src="~assets/sgh-suprimentos.jpeg" />

                <q-card-section>
                  <div class="text-h6">SGH-Suprimentos</div>
                  <div class="text-subtitle2">Sistema de Gestão Hospitalar - Suprimentos</div>
                </q-card-section>

                <q-card-section class="q-pt-none">Saiba mais</q-card-section>
              </q-card>
            </div>
          </q-carousel-slide>
        </q-carousel>
      </div>

      PARALLAX COM OS CASES EM CARDS, NÃO USAR CAROUSEL
      FOOTER
    </div>
  </q-page>
</template>

<script>
window.onscroll = function() {
  scrollFunction();
};

function scrollFunction() {
  if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
    document.getElementById("header").style.height = "8vh";
  } else {
    document.getElementById("header").style.height = "14vh";
  }
}

export default {
  name: "PageIndex",
  data() {
    return {
      visible: false,
      content_2_text_body:
        "Com soluções modularizadas e adaptáveis, a SPDATA possui sistemas capazes de se adequar perfeitamente aos diversos modelos de gestão e porte da instituição de saúde.",
      slide: 1
    };
  },
  computed: {
    cardContainerClass() {
      if (this.$q.screen.gt.xs) {
        return (
          "grid-masonry grid-masonry--" + (this.$q.screen.gt.sm ? "3" : "2")
        );
      }

      return void 0;
    },

    rowsPerPageOptions() {
      if (this.$q.screen.gt.xs) {
        return this.$q.screen.gt.sm ? [3, 6, 9] : [3, 6];
      }

      return [3];
    }
  },
  watch: {
    "$q.screen.name"() {
      this.pagination.rowsPerPage = this.getItemsPerPage();
    }
  },
  methods: {
    getItemsPerPage() {
      const { screen } = this.$q;
      if (screen.lt.sm) {
        return 3;
      }
      if (screen.lt.md) {
        return 6;
      }
      return 9;
    }
  }
};
</script>
