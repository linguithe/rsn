<template>
    <div v-if="currentRecipe" class="edit-form">
        <h4>Recipe</h4>
        <form>
            <div class="form-group">
                <label for="title">Title</label>
                <input
                    type="text"
                    class="form-control"
                    id="title"
                    v-model="currentRecipe.title"
                />
            </div>
        </form>

        <button class="badge badge-danger mr-2" @click="deleteRecipe">
            Delete
        </button>

        <button
            type="submit"
            class="badge badge-success"
            @click="updateRecipe"
        >
            Update
        </button>
        <p>{{ message }}</p>
    </div>

    <div v-else>
        <br />
        <p>Please click on a recipe...</p>
    </div>
</template>

<script>
import RecipeDataService from "../services/RecipeDataService";

export default {
    name: "recipe-details",
    data() {
        return {
            currentRecipe: null,
            message: "",
        };
    },
    methods: {
        getRecipe(id) {
            RecipeDataService.get(id)
                .then((response) => {
                    this.currentRecipe = response.data;
                    console.log(response.data);
                })
                .catch((e) => {
                    console.log(e);
                });
        },

        updateRecipe() {
            RecipeDataService.update(
                this.currentRecipe.id,
                this.currentRecipe
            )
                .then((response) => {
                    console.log(response.data);
                    this.message = "The recipe was updated successfully!";
                })
                .catch((e) => {
                    console.log(e);
                });
        },

        deleteRecipe() {
            RecipeDataService.delete(this.currentRecipe.id)
                .then((response) => {
                    console.log(response.data);
                    this.$router.push({ name: "recipes" });
                })
                .catch((e) => {
                    console.log(e);
                });
        },
    },
    mounted() {
        this.message = "";
        this.getRecipe(this.$route.params.id);
    },
};
</script>

<style>
.edit-form {
    max-width: 300px;
    margin: auto;
}
</style>
