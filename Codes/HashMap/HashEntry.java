package HashMap;

public class HashEntry {
    private int key;
    private int value;

    HashEntry(int key, int value) {
          this.key = key;
          this.value = value;
    }     

    public int getKey() {
    	  System.out.println("Key : " + key);
          return key;
    }

    public int getValue() {
    	  System.out.println("Value : " + value + "\n");
          return value;
    }
}