package UI;

import Nodes.FamilyTree;
import Utils.Assertions;
import Utils.MatrixMath;

public class Main {

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree(4);
        System.out.println(familyTree.calcNumberOfNodes());
        runMatricesTests();
        FamilyTree largeFamilyTree = new FamilyTree(12);
        System.out.println(largeFamilyTree.calcNumberOfNodes());
    }

    private static void runMatricesTests() {
        double[][] firstMatrix = {
                new double[]{1d, 5d},
                new double[]{2d, 3d},
                new double[]{1d, 7d}
        };

        double[][] secondMatrix = {
                new double[]{1d, 2d, 3d, 7d},
                new double[]{5d, 2d, 8d, 1d}
        };

        double[][] expected = {
                new double[]{26d, 12d, 43d, 12d},
                new double[]{17d, 10d, 30d, 17d},
                new double[]{36d, 16d, 59d, 14d}
        };

        double[][] actual = MatrixMath.multiplyMatrices(firstMatrix, secondMatrix);
        System.out.println(Assertions.assertThat(actual, expected));
    }
}