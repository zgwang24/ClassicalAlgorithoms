package Tree;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTreeReverse {
	Scanner sc = new Scanner(System.in);
	public TreeNode createNode(TreeNode root){
		String val;
		val = sc.next();
		if(val.equals("#")){
			return null;
		}
		root = new TreeNode(Integer.parseInt(val));
		System.out.println("�������ݣ�" + val);
		root.left = createNode(root.left);
		root.right = createNode(root.right);
		return root;	
	}
	public void Mirror(TreeNode root){
		if(root == null){
			return ;
		}
		if(root.left == null && root.right == null){
			return ;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		Mirror(root.left);
		Mirror(root.right);
	}
	public void MirrorNotRecursive(TreeNode root){
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode temp = null;
		if(root == null){
			return ;
		}
		stack.add(root);
		while(stack.size() != 0){
			TreeNode node = stack.removeFirst();
			temp = node.left;
			node.left = node.right;
			node.right = temp;
			if(node.right != null){
				stack.add(node.right);
			}
			if(node.left != null){
				stack.add(node.left);
			}
		}
	}
	public void levelTraverse(TreeNode root){
		if(root == null){
			return ;
		}
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.add(root);
		while(stack.size() != 0){
			TreeNode node = stack.removeFirst();
			System.out.print(node.val + " ");
			if(node.left != null){
				stack.add(node.left);
			}
			if(node.right != null){
				stack.add(node.right);
			}
		}
	}
	public static void main(String[] args) {
		BinaryTreeReverse btr = new BinaryTreeReverse();
		TreeNode root = null;
		root = btr.createNode(root);
        System.out.println("ԭ�������Ĳ�α���");
        btr.levelTraverse(root);
        btr.Mirror(root);
        System.out.println("\n����ö������ľ���");
        btr.levelTraverse(root);
        /*btr.MirrorNotRecursive(root);
        System.out.println("\n����ö������ľ��񣨷ǵݹ鷽ʽ��");
        btr.levelTraverse(root);*/
	}
}
