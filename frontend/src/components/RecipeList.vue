<template>
    <div class="list row">
        <div class="col-md-8">
            <div class="input-group mb-3">
                <input
                    type="text"
                    class="form-control"
                    placeholder="Search by title"
                    v-model="title"
                />
                <div class="input-group-append">
                    <button
                        class="btn btn-outline-secondary"
                        type="button"
                        @click="searchTitle"
                    >
                        Search
                    </button>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <h4>Recipes List</h4>
            <ul class="list-group">
                <li
                    class="list-group-item"
                    :class="{ active: index == currentIndex }"
                    v-for="(recipe, index) in recipes"
                    :key="index"
                    @click="setActiveRecipes(recipe, index)"
                >
                    {{ recipe.title }}
                </li>
            </ul>

            <button
                class="m-3 btn btn-sm btn-danger"
                @click="removeAllRecipes"
            >
                Remove All
            </button>
        </div>
        <div class="col-md-6">
            <div v-if="currentRecipe">
                <h4>Recipe</h4>
                <div>
                    <label><strong>Title:</strong></label>
                    {{ currentRecipe.title }}
                </div>

                <router-link
                    :to="'/recipes/' + currentRecipe.id"
                    class="badge badge-warning"
                    >Edit</router-link
                >
            </div>
            <div v-else>
                <br />
                <p>Please click on a recipe...</p>
            </div>
        </div>
    </div>
</template>

<script>
import RecipeDataService from "../services/RecipeDataService";

export default {
    name: "recipe-list",
    data() {
        return {
            recipes: [],
            currentRecipe: null,
            currentIndex: -1,
            title: "",
        };
    },
    methods: {
        retrieveRecipes() {
            RecipeDataService.getAll()
                .then((response) => {
                    this.recipes = response.data;
                    console.log(response.data);
                })
                .catch((e) => {
                    console.log(e);
                });
        },

        refreshList() {
            this.retrieveRecipes();
            this.currentRecipe = null;
            this.currentIndex = -1;
        },

        setActiveRecipe(recipe, index) {
            this.currentRecipe = recipe;
            this.currentIndex = recipe ? index : -1;
        },

        removeAllRecipes() {
            RecipeDataService.deleteAll()
                .then((response) => {
                    console.log(response.data);
                    this.refreshList();
                })
                .catch((e) => {
                    console.log(e);
                });
        },

        searchTitle() {
            RecipeDataService.findByTitle(this.title)
                .then((response) => {
                    this.recipes = response.data;
                    this.setActiveRecipe(null);
                    console.log(response.data);
                })
                .catch((e) => {
                    console.log(e);
                });
        },
    },
    mounted() {
        this.retrieveRecipes();
    },
};
</script>

<style>
.list {
    text-align: left;
    max-width: 750px;
    margin: auto;
}
</style>
