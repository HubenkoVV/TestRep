package model.dao.util;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class RequestBuilder {

    StringBuilder request = new StringBuilder();

    public RequestBuilder() {
        request = new StringBuilder();
    }

    public RequestBuilder insertInto(){
        request.append("insert ").append(" ").append("into ").append(" ");
        return this;
    }

    public RequestBuilder insertValues(String[]columns){
        request.append("values").append(" ").append("(");
        for (String column: columns) {
            request.append(column).append(",");
        }
        request.deleteCharAt(request.length()-1);

        request.append(")").append(" ").append("values").append(" ").append("(");

        for(int i = columns.length; i >= 0; i-- ){
            request.append("?").append(",");
        }
        request.deleteCharAt(request.length()-1);

        request.append(")") ;
        return this;
    }

    public RequestBuilder update(){
        request.append("update").append(" ");
        return this;
    }

    public RequestBuilder set(){
        request.append("set").append(" ");
        return this;
    }

    public RequestBuilder updateValues(String[]columns){
        for (String column: columns) {
            request.append(column).append("=").append("?").append(",");
        }
        request.deleteCharAt(request.length()-1);
        return this;
    }

    public RequestBuilder delete(){
        request.append("delete").append(" ");
        return this;
    }

    public RequestBuilder table(String table){
        request.append(table).append(" ");
        return this;
    }

    public RequestBuilder where(){
        request.append("where").append(" ");
        return this;
    }

    public RequestBuilder condition(String column){
        request.append(column).append("=?").append(" ");
        return this;
    }

    public RequestBuilder from(){
        request.append("from").append(" ");
        return this;
    }

    public RequestBuilder select(){
        request.append("select").append(" ").append("*").append(" ");
        return this;
    }

    public RequestBuilder leftJoin(){
        request.append("left join").append(" ");
        return this;
    }

    public RequestBuilder using(String column){
        request.append("using (").append(column).append(")").append(" ");
        return this;
    }

    public String build(){
        return request.toString();
    }
}
