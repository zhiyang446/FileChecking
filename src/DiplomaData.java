class DiplomaData {

    String category;
    String name;
    int total;
    int max;
    int min;

    public DiplomaData(String category, String name, int total, int max, int min) {
        this.category = category;
        this.name = name;
        this.total = total;
        this.max = max;
        this.min = min;
    }

    public String toString() {
        return "Category = "+category + ", Name = " + name + ", Total = " + total + ", Max = " + max + ", Min = " + min;
    }

}