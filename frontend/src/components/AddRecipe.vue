<template>
    <div class="submit-form">
        <div v-if="!submitted">
            <div class="form-group">
                <label for="title">Title</label>
                <input
                    type="text"
                    class="form-control"
                    id="title"
                    required
                    v-model="recipe.title"
                    name="title"
                />
            </div>

            <button @click="saveRecipe" class="btn btn-success">
                Submit
            </button>
        </div>

        <div v-else>
            <h4>You submitted successfully!</h4>
            <button class="btn btn-success" @click="newRecipe">Add</button>
        </div>
    </div>
</template>

<script>
import RecipeDataService from "../services/RecipeDataService";

export default {
    name: "add-recipe",
    data() {
        return {
            recipe: {
                id: null,
                title: "",
            },
        };
    },
    methods: {
        saveRecipe() {
            var data = {
                title: this.recipe.title,
            };

            RecipeDataService.create(data)
                .then((response) => {
                    this.recipe.id = response.data.id;
                    console.log(response.data);
                })
                .catch((e) => {
                    console.log(e);
                });
        },

        newRecipe() {
            this.tutorial = {};
        },
    },
};
</script>

<style>
.submit-form {
    max-width: 300px;
    margin: auto;
}
</style>
