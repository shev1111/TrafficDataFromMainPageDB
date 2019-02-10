package model;

public class Template {
    private String category;
    private String info;
    private String name;
    private String url;
    private String image;

    public Template() {
    }

    public Template(String info, String name, String url, String image) {
        this.info = info;
        this.name = name;
        this.url = url;
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Template{" +
                "category='" + category + '\'' +
                ", info='" + info + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
