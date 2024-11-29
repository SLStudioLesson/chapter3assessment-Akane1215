package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    private String filePath;

    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    public String getMode() {
        return "CSV";
    }

    public ArrayList<Recipe> readData() throws IOException {
        //ArrayListでレシピデータをリスト化
        ArrayList<Recipe> recipes = new ArrayList<>();
        //ファイル内容の読み込み
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                // レシピ名を取得
                String recipeName = parts[0];

                // //ingredientsリストを作成
                ArrayList<String> ingredients = new ArrayList<>();
                //parts[1]以降をリストに追加
                // for (int i = 1; i < parts.length; i++) {
                //     ingredients.add(new Ingredient(parts[i]));
                // }
                // recipes.add(new Recipe(recipeName, ingredients));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading file:" + e.getMessage());
        }
        //読み込んだデータを返す
        return recipes;
    }

    public void writeData(Recipe recipe) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            
            // //新しいレシピの追加
            ArrayList<Recipe> newRecipes = new ArrayList<>();
            newRecipes.add(recipe);

            // writer.write();
            writer.newLine();
            System.out.println("Recipe added successfully.");
        } catch (IOException e) {
            System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }

    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }
}
