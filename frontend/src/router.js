import {createWebHistory, createRouter} from "vue-router";

const routes = [
    {
        path: "/",
        alias: "/recipes",
        name: "recipes",
        component: () => import("./components/RecipeList")
    },
    {
        path: "/recipes/:id",
        name: "recipe-details",
        component: () => import("./components/RecipeDetails")
    },
    {
        path: "/add",
        name: "add",
        component: () => import("./components/AddRecipe")
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;