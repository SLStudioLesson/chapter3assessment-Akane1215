package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }
    
    public void displayMenu() {
        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    private void displayRecipes() {
        try {
            ArrayList<Recipe> recipes = dataHandler.readData();

            if (recipes != null) {
                System.out.println("Recipes:");
                System.out.println("-----------------");

                for (Recipe recipe : recipes) {
                    System.out.println("Recipe Name:" + recipe.getName());

                    // 材料を取得、材料名をgetName()で渡す
                    String ingredientsList = "";
                    for (int i = 0; i < recipe.getIngredients().size(); i++) {
                        Ingredient ingredient = recipe.getIngredients().get(i);
                        ingredientsList += ingredient.getName();
                    }

                    System.out.println("Main Ingredients:" + ingredientsList);
                    System.out.println("----------------");
                }
            } else {
                System.out.println("No recipes available.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewRecipe() throws IOException{
        try {
            System.out.println("Enter recipe name: ");
            String recipeName = reader.readLine();

            //ingredientsのリストを追加
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            
            // doneと入力されるまで処理が継続
            while (true) {
                System.out.print("Enter ingredients (type 'done' when finished): ");
                String input = reader.readLine();
                if ("done".equals(input)) {
                    break;
                }
                // 入力された材料をリストに追加
                ingredients.add(new Ingredient(input));
            }
            // 入力された情報をもとに新しいレシピを作成
            Recipe recipe = new Recipe(recipeName, ingredients);
            // データを保存
            dataHandler.writeData(recipe);

            } catch (IOException e) {
            System.out.println("Failed to add new recipe: 例外のメッセージ");
        }
    }
}
