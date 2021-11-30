package UI;

import Nodes.FamilyTree;
import Utils.TestMatrixMath;

public class Main {

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree(4);
        int depth4Tree = familyTree.calcNumberOfNodes();
        System.out.println(depth4Tree);
        TestMatrixMath tmm = new TestMatrixMath();
        tmm.runMatricesTests();
        FamilyTree largeFamilyTree = new FamilyTree(12);
        int depth12Tree = largeFamilyTree.calcNumberOfNodes();
        System.out.println(depth12Tree);
    }

}