package Dog;

public class Dog {
    private  int size;
    private String name;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void bark(){
        if (size>60){
            System.out.println("Гаф-гаф");
        } else if (size>14){
            System.out.println("Вуф-вуф");
        } else {
            System.out.println("Тяф-тяф");
        }

    }


}
