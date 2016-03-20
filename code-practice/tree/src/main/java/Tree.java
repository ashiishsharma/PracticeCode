import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tree implements TreeIf{


	//Fields
	public String data;
	public List<Tree> children;

	//Constructor
	public Tree(String data) {
		this.data = data;
		children = new ArrayList<Tree>();
	}


	//-----------Methods-------------------------
	
	public void addChild(String data) {
		Tree node = getTreeNode(data);
		children.add(node);
	}


	private Tree getTreeNode(String mdata) {
		Tree node = new Tree(mdata);
		return node;
	}


	public void addChild(Tree child) {
		children.add(child);
	}


	public void addChildAt(int index, Tree child) {
		children.add(index, child);
	}

	

	public Tree getChildAt(int index) {
		return children.get(index);
	}


	public int getNumOfChildren() {
		return children.size();
	}


	public void removeAllChildren() {
		children = new ArrayList<Tree>();
	}


	public void removeChildAt(int index) {
		children.remove(index);
	}
	
	public void serialize(String fileName) throws IOException {
		File file = getFile(fileName);
		FileWriter fw = new FileWriter(file);
		fw.append(toString());
		fw.flush();
		fw.close();
		System.out.println("Serialized tree to file: " + fileName);
	}

	public void traverse() {

		System.out.println("Tree Traversal");
		System.out.println(toString());
		System.out.println();
	}
	
	public String toString() {
		
		StringBuilder stringRepresentation = new StringBuilder();
		stringRepresentation.append(getData()).toString();
		stringRepresentation.append(":[");
		
		for (Tree node : getChildren()) {
			stringRepresentation.append(node.getData().toString());
			stringRepresentation.append(",");
		}
		stringRepresentation.append( "]");
		stringRepresentation.append( "\n");
		for (Tree node : getChildren()) {
			stringRepresentation.append(node.toString());
		}

		return stringRepresentation.toString();
	}

	private File getFile(String fileName) throws IOException {
		File file = new File(fileName);
		if(!file.exists()) {
			file.createNewFile();
		}
		return file;
	}
	
	public Tree deserialize(String fileName) throws IOException {
		System.out.println("De-Serializing tree from file: " + fileName);
		File file = getFile(fileName);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		
		Tree tree = constructTree(reader);
		
		return tree;
	}
	
	private Tree constructTree(BufferedReader reader) throws IOException {
		String[] input = reader.readLine().split(":");
		Tree root = null;
		if(input.length == 2) {
		 root = new Tree(input[0]);
		 String[] child = input[1].split(",");
		 for(String ch: child) {
			 if(ch.startsWith("[")) {
				 ch = ch.substring(1);
			 }
			 if(ch.equals("]")) {
				 continue;
			 }
			root.addChild(constructTree(reader)); 
		 }
		}
		return root;
	}


	//----------- Setters and Getters------------------------
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Tree> getChildren() {
		return children;
	}

	public void setChildren(List<Tree> children) {
		this.children = children;
	}
	
	//---------Equals and Hashcode-----------
	
	public boolean equals(Tree node) {
		return node.getData().equals(getData());
	}
		 
	public int hashCode() {
		return getData().hashCode();
	}
	
}
