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
private boolean cari(GenreNode node, String g) {
        if (node == null) return false;
        if (node.genre.equalsIgnoreCase(g)) return true;
        if (g.compareToIgnoreCase(node.genre) < 0) return cari(node.left, g);
        return cari(node.right, g);
    }

    public boolean cariGenre(String g) {
        return cari(root, g);
    }

    public void inorder() {
        System.out.println("Daftar Genre (A-Z):");
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(GenreNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println("   • " + node.genre);
            inorderTraversal(node.right);
        }
    }
    

}
