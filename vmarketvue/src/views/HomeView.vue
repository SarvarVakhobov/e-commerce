<template>
  <div class="home">
    <section class="hero is-medium is-dark mb-6">
      <div class="hero-body has-text-centered">
        <p class="title mb-6">
          Welcome to V-Market
        </p>
        <p class="subtitle">
          The best vertual market ever
        </p>
      </div>
    </section>
    <div class="columns is-multiline">
      <div class="column is-12 has-text-centered">
        <h class="is-size-2 has-text-centered">Latested products</h>
      </div>
      <ProductBox v-for="product in latestProducts" v-bind:key="product.id" v-bind:product="product" />
    </div>
  </div>
</template>

<script>
import axios from 'axios'

import ProductBox from '@/components/ProductBox.vue'
import Product from './Product.vue'

export default {
  name: 'Home',
  data() {
    return {
      latestProducts: []
    }
  },
  components: {
    ProductBox,
    Product,
  },
  mounted(){
    this.getLatestProducts()
  },
  methods: {
    async getLatestProducts() {
      this.$store.commit('setIsLoading', true)
      
      await axios
      .get('/api/v1/latest-products/')
      .then(response => {
        this.latestProducts = response.data

        document.title = 'Home | V-Market'
      })
      .catch(error => {
        console.log(error)
      })
      this.$store.commit('setIsLoading', false)
    }
  }
}
</script>
