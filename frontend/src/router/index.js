import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/recipes',
      name: 'recipes',
      component: () => import('../components/RecipesList.vue')
    },
    {
      path: '/recipe/:id',
      name: 'recipe-details',
      component: () => import('../components/Recipe.vue')
    },
    {
      path: '/add',
      name: 'add',
      component: () => import('../components/AddRecipe.vue')
    }
  ]
})

export default router
