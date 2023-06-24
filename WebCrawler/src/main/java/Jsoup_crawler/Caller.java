package Jsoup_crawler;

//trieda na ukladanie
class Caller {
    private int deep;
    private String url;

    public Caller(int deep, String url) {
        this.deep = deep;
        this.url = url;
    }

    public int deep(){
        return this.deep;
    }

    public String url(){
        return this.url;
    }

}
