import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

public class App {

    public static void main(String[] args) {

        //インスタンスの作成
        CSVDataHandler csvDataHandler = new CSVDataHandler();
        JSONDataHandler jsonDataHandler = new JSONDataHandler();
        
        // データハンドラーの初期値csvDataHandler
        DataHandler selectedDataHandler = csvDataHandler;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");

            //ユーザーの選択を読み取る
            String choice = reader.readLine();

            switch (choice) {
                case "1":
                    System.out.println("Current mode:");
                    selectedDataHandler = csvDataHandler;
                break;
                case "2":
                    System.out.println("Current mode:");
                    selectedDataHandler = jsonDataHandler;
                break;
                default:
                    System.out.println("Current mode:");
                    selectedDataHandler = csvDataHandler;
                break;
            }

            //パッケージのRecipeUIに渡し、displayMenuメソッドを呼び出す
            RecipeUI recipeUI = new RecipeUI(selectedDataHandler);
            recipeUI.displayMenu();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}