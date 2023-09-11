fun main() {
    val recipe = Recipe()
    recipe.addIngredient("Rice")
    recipe.addIngredient("Chicken")
    println(recipe.getIngredients())
    // here's a code breakdown
    // we create a new instance of the Recipe class and assign it to the recipe variable
    // we call the addIngredient method on the recipe variable and pass in the string "Rice"
    // we call the addIngredient method on the recipe variable and pass in the string "Chicken"
    // we call the getIngredients method on the recipe variable and print the result to the console
}

class Recipe {
    private val ingredients = mutableListOf<String>()

    fun addIngredient(name: String) {
        ingredients.add(name)
    }

    fun getIngredients(): List<String> {
        return ingredients
    }
}