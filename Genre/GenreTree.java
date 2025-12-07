public class GenreTree {
    GenreNode root;

    private GenreNode insert(GenreNode node, String g) {
        if (node == null) return new GenreNode(g);
        if (g.compareToIgnoreCase(node.genre) < 0)
            node.left = insert(node.left, g);
        else if (g.compareToIgnoreCase(node.genre) > 0)
            node.right = insert(node.right, g);
        return node;
    }

    public void tambahGenre(String g) {
        if (!cariGenre(g)) {
            root = insert(root, g);
        }
    }

    
}