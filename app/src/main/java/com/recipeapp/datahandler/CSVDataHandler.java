package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
        //ファイル内容の読み込み、出力
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // recipes.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading file:" + e.getMessage());
        }
        //読み込んだデータを返す
        return recipes;
    }

    public void writeData(Recipe recipe) throws IOException {

    }

    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }
}
