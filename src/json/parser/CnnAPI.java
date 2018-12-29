package json.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import databases.ConnectToSqlDB;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
class CNNApi {

    public static void main(String[] args) throws Exception {
        String sURL = "https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=0d9e35dfa3c140aab8bf9cdd70df957f";
        NewsDataModel news = null;
        List<NewsDataModel> list1 = new ArrayList<>();
        URL url1 = new URL(sURL);
        URLConnection request = url1.openConnection();
        request.connect();
        JsonArray jsonArray = null;
        JsonObject rootObj = null;
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        if (root instanceof JsonObject) {
            rootObj = root.getAsJsonObject();
        } else if (root instanceof JsonArray) {
            jsonArray =  root.getAsJsonArray();
        }

        //if root is an Json object
        if(jsonArray==null)
            jsonArray= rootObj.getAsJsonArray("articles");

        //initialize field to construct HeadlineNews ogject
        String  source = null;
        String  author = null;
        String title = null;
        String description = null;
        String url = null ;
        String urlToImage = null ;
        String publishedAt = null ;
        String  content = null;


        for (int i = 0; i < jsonArray.size()-1; i++) {
            try {
                JsonObject jsonobject = jsonArray.get(i).getAsJsonObject();

                source= jsonobject.get("source").toString();
                author= jsonobject.get("author").toString();
                title = jsonobject.get("title").toString();
                description = jsonobject.get("description").toString();
                url= jsonobject.get("url").toString();
                urlToImage= jsonobject.get("urlToImage").toString();
                publishedAt = jsonobject.get("publishedAt").toString();
                content = jsonobject.get("content").toString();

                //Object of HeadlineNews
                news = new NewsDataModel(source,author,title,description,url,urlToImage,publishedAt,content);
                list1.add(news);


            }catch(Exception ex){

            }
        }
        //Storing to Database
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        connectToSqlDB.insertDataFromStringToSqlTable(list1,"CNN","News");
        try {
            List<String> dbnews = connectToSqlDB.readDataBase("CNN", "News");
        }catch(Exception e){
            System.out.println(e);
        }
        //Print to the console.
        for(NewsDataModel entry:list1){
            System.out.println("News Title:" +entry.getTitle());
            System.out.println("News Description: " + entry.getDescription());
            System.out.println("News Content: "+ entry.getContent());
            System.out.println("News url"+ entry.getUrl());
            System.out.println("News UrlToImage"+ entry.getUrlToImage());
            System.out.println("News PublishedAt"+ entry.getPublishedAt());
            System.out.println("News Content"+ entry.getContent());

        }
    }

}