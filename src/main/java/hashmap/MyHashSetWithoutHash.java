package hashmap;

class MyHashSetWithoutHash {
    Integer key;
    MyHashSetWithoutHash next;

    /** Initialize your data structure here. */
    public MyHashSetWithoutHash() {
    }

    public void add(int key) {
        if (this.next == null) {
            this.key=key;
            this.next = new MyHashSetWithoutHash();
        }
        if(!this.contains(key)) {
            MyHashSetWithoutHash temp = this;
            while(temp.next!= null) {
                temp=temp.next;
            }
            temp.key=key;
            temp.next=new MyHashSetWithoutHash();
        }
    }

    public void remove(int key) {
        if(this.next == null) {
            return;
        }
        if (this.key == key) {
            this.key=this.next.key;
            this.next=this.next.next;
        }
        if(this.contains(key)) {
            MyHashSetWithoutHash temp = this;
            MyHashSetWithoutHash preRemove = this;
            while(temp.key!= key) {
                preRemove=temp;
                temp=temp.next;
            }
            preRemove.next=temp.next;

        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        MyHashSetWithoutHash temp = this;
        while(temp.key!=null) {
            if(temp.key == key) {
                return true;
            } else {
                temp=temp.next;
            }
        }
        return false;
    }
}
