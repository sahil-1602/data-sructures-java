package hashMap;


public class HashMap {
    
    int size = 2;
    Node[] keyMap = starter();

    public int hash(String key){
        int total = 0;
        int WEIRD_PRIME = 31;
        for(int i = 0; i < Math.min(key.length(), 100); i++){
            int value = Character.codePointAt(key, i) - 96;
            total = (total * WEIRD_PRIME + value) % size;
        }
        return total;
    }

    public void set(String key, String value){
        int index = hash(key);
        Node toAdd = new Node(key, value);
        if(keyMap[index].key == ""){
           keyMap[index] = toAdd;
           return;
        }
        Node current = keyMap[index];
        while(current.next != null){
            current = current.next;
        }
        current.next = toAdd;
    }

    public void get(String key){
        int index = hash(key);
        if(keyMap[index].key == key){
            System.out.println(keyMap[index].value);
            return;
        }
        Node current = keyMap[index];
        while(current.key != key){
            current = current.next;
        }
        System.out.println(current.value);
    }

    Node[] starter(){
        Node[] keyMap = new Node[size];
        Node current = new Node("empty", "empty");
        for(int i = 0; i < keyMap.length; i++){
            keyMap[i] = current;
            keyMap[i].key = "";
            keyMap[i].value = "";
            keyMap[i].next = null;
        }
        return keyMap;
    }

    class Node{
        String key;
        String value;
        Node next;
        Node(String key, String value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
