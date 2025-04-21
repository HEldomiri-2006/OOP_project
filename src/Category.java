public class Category {
    private String categoryName;
    private String description;

    public Category(){}

    public Category(String categoryName, String description){
        this.categoryName = categoryName;
        this.description = description;
    }

    public void setCategoryName(String categoryName){this.categoryName = categoryName;}
    public void setDescription(String description){this.description = description;}

    public String getCategoryName(){return this.categoryName;}
    public String getDescription(){return this.description;}
}
