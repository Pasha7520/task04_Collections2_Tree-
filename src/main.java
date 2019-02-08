public class main {
    public static void main(String[] args) {
        MyTree<Integer,String> myTree = new MyTree<>();
        Integer i = 39;
        Integer i2 = 3;
        Integer i3 = 33;
        Integer i4 = 2;
        Integer i5 = 30;
        Integer i6 = 36;
        Integer i7 = 29;
        Integer i8 = 31;
        Integer i9 = 37;
        myTree.put(i,"Lola");
        myTree.put(i2,"Vova");
        myTree.put(i3,"Lolita");
        myTree.put(i4,"Oleg");
       myTree.put(i5,"Ivan");
       myTree.put(i6,"Ivan1");
       myTree.put(i7,"Ivan1");
       myTree.put(i8,"Ivan1");
       myTree.put(i9,"Ivan1");
        myTree.inOrder(myTree.root);
        System.out.println();
        myTree.delete(i3);


        myTree.inOrder(myTree.root);

        //System.out.println(myTree.get(i3));
    }
}
