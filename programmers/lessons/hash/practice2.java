import java.util.ArrayList;

class Node{
    Character character;
    boolean isLeaf = false;
    ArrayList<Node> child = new ArrayList<Node>();

    public Node(Character character, boolean isLeaf){
        this.character = character;
        this.isLeaf = isLeaf;
    }

    public void add_child(Node node){
        this.child.add(node);
    }

    public Node findChildNode(Character character){
        for(Node node : this.child){
            if(node.character == character) return node;
        }
        return null;
    }
    public void set_leaf(){
        this.isLeaf = true;
    }
}

class Solution {

    public boolean solution(String[] phone_book) {
        Node rootNode = new Node(' ',false);

        for (String phone : phone_book) {
            Node currentNode = rootNode;
            int stringIndex = 1;
            int stringLength = phone.toCharArray().length;
            for (Character c : phone.toCharArray()){
                Node childNode = currentNode.findChildNode(c);

                if(childNode != null){
                    if(childNode.isLeaf) return false;
                    if(stringIndex==stringLength) return false;
                }

                if (childNode == null) {
                  childNode = new Node(c, false);
                  currentNode.add_child(childNode);
                }
                currentNode = childNode;
                stringIndex++;
            }
            currentNode.set_leaf();
        }

        return true;
    }
}
