import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/auth',
      name: 'Authorization',
      component: () => import("@/views/Auth.vue")
    },
    {
      path: '/ca',
      name: 'CA',
      component: () => import("@/views/CheckAccount.vue")
    }
  ]
})

export default router
