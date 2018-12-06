package HashMap;

public class HashMap {
    private final static int TABLE_SIZE = 128;

    HashEntry[] table;

    HashMap() {
          table = new HashEntry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }
    
 // ----------------------------- Put / Insert -------------------------------------------
    public void put(int key, int value) {
          int hash = (key % TABLE_SIZE);
          while (table[hash] != null && table[hash].getKey() != key)
                hash = (hash + 1) % TABLE_SIZE;
          table[hash] = new HashEntry(key, value);
    }
    
// ----------------------------- Get / Print --------------------------------------
    public void get(int key) {
          int hash = (key % TABLE_SIZE);
          while (table[hash] != null && table[hash].getKey() != key)
                hash = (hash + 1) % TABLE_SIZE;
          if (table[hash] == null)
                return ;
          else
        	   System.out.println("Hash Table : \n" + "Value : " + table[hash].getValue());
               // return table[hash].getValue();
    }
    
    public int getHash (int key) {
    	
    	return 0;
    }

// ----------------------------- Main -------------------------------------------
	public static void main(String[] args) {

		HashMap o = new HashMap();
		o.put(1, 10);
		o.put(2, 20);
		o.put(3, 30);
		
		o.get(2);
		
		
		
		
	}

}
